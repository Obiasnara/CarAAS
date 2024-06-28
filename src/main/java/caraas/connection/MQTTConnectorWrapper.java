package caraas.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
// Pair
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public final class MQTTConnectorWrapper {

    private static final MQTTConnectorWrapper INSTANCE;

    static {
        try {
            INSTANCE = new MQTTConnectorWrapper();
        } catch (Exception e) {
            throw new RuntimeException("Error creating Singleton instance", e);
        }
    }

    public static MQTTConnectorWrapper getInstance() {
        return INSTANCE;
    }


    /**
     * Constructor. Initializes the endpoint of the MQTT Connector.
     * 
     * @param endpoint The endpoint of the MQTT Connector.
     */

    int qos;
    String broker;
    String clientId;     
    MemoryPersistence persistence;
    MqttClient sampleClient;
    MqttConnectOptions connOpts;
    
    // Save channel and last value
    private final Map<String, Pair<String, Long>> subscribedChannels = new HashMap<>();


    private MQTTConnectorWrapper() {

        qos          = 2;
        broker       = "tcp://157.245.38.231:1883";
        clientId     = "JavaSample";
        persistence = new MemoryPersistence();    
        try {
            sampleClient = new MqttClient(broker, clientId, persistence);
            connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            int tries = 0;
            while (!sampleClient.isConnected()) {
                try {
                    tries++;
                    connect();
                } catch (MqttException e) {
                    System.out.println("Connection failed, retrying in 5 seconds...");
                    if(tries > 3){
                        System.out.println("Multiple connection attempts failed, maybe the broker is down?");
                    }
                    // We will try to connect again in 5 seconds
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
            sampleClient.setCallback(new MqttCallback() {
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    onMessage(topic, new String(message.getPayload()));
                }
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost because: "+cause);
                }
            });
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
       
    }

    private void connect() throws MqttException {
        sampleClient.connect(connOpts);
    }

    public void onMessage(String topic, String content) {
        // Decode the JSON Dumped message using JSON-simple
        System.out.println("Message received: "+content + " from topic "+topic);
        String channel = topic;
        if (subscribedChannels.containsKey(channel)) {
            Pair<String, Long> pair = subscribedChannels.get(channel);
            pair.setKey(content);
            pair.setValue(System.currentTimeMillis());
            MongoDbWrapper.getInstance().insert(channel, pair);
        } 


    }

    public void publish(String topic, String content, int qos) {
        System.out.println("Publishing message: "+content);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        try {
            sampleClient.publish(topic, message);
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Message published");
    }

    public void subscribe(String topic, int qos) {
        System.out.println("Subscribing to topic \""+topic+"\"");
        try {
            sampleClient.subscribe(topic, qos);
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Subscribed");
    }

    public String readValue(String path) {
        // Print the function name that called this method
        String channel = path + "/" + Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("Reading value from channel "+channel);
        // Check if the channel is already subscribed
        if (!subscribedChannels.containsKey(channel)) {
            System.out.println("Channel not subscribed, subscribing...");
            subscribe(channel, qos);
            subscribedChannels.put(channel, new Pair<>("", System.currentTimeMillis()));
        }
        return subscribedChannels.get(channel).getKey();
    }

    public void writeValue(String path, String value) {
        String channel = path;
        System.out.println("Writing value \""+value+"\" to channel \""+channel+"\"");
        publish(channel, value, qos);
    }

    public Map<String, Pair<String, Long>> getSubscribedChannels() {
        return subscribedChannels;
    }

    @Override
    public String toString() {
        return "MQTTConnectorWrapper [endpoint=" + broker + "]";
    }

    
}
