/**
 * Copyright (c) 2022 CEA LIST and others.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 *   SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *  	CEA LIST - Initial API and implementation
 */
package caraas.module.submodels.measurement_value;

import caraas.connection.ConnectedDevices;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.io.FileReader;
import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;
import javax.xml.datatype.Duration;
import org.eclipse.basyx.vab.exception.provider.ProviderException;
import org.eclipse.basyx.vab.protocol.opcua.types.NodeId;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.eclipse.basyx.submodel.metamodel.api.submodelelement.ISubmodelElement;
import org.eclipse.basyx.submodel.metamodel.api.reference.enums.KeyType;
import org.eclipse.basyx.submodel.metamodel.map.reference.Key;
import org.eclipse.basyx.submodel.metamodel.map.reference.Reference;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.dataelement.property.Property;

public class DynamicElementsWorkspace {
	private ConnectedDevices connectedDevices;

	public DynamicElementsWorkspace(ConnectedDevices connectedDevices) {
		this.connectedDevices = connectedDevices;
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void Engines_Values_ChangeRotationSpeeds(Integer Left_Front_Engine_RPM, Integer Left_Back_Engine_RPM,
			Integer Right_Front_Engine_RPM, Integer Right_Back_Engine_RPM) {
		//connectedDevices.mqtt_endpoint.writeValue(
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void Ultrasonic_Values_ToggleSensor() {
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void Video_Values_ToggleCamera() {
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void Video_Values_SetCameraProperties(Integer frameRate, Integer resolutionHeight, Integer resolutionWidth,
			Integer samplingRate) {
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void Video_Values_ToggleFocusCycle() {
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void Video_Values_AskRecognition(String recognitionParameters) {
	}

	/**
		 * [Note:] The method signature, if populated with parameters, are the 
		 * Input and InOutput parameters assigned by the user to the Operation. 
		 * 
		 * Papyrus4Manufacturing handles InOutput parameters as Input Parameters.  
		 * 
		 * Please under no circumstances change/modify this method's Signature 
		 * and the return statement. 
		 * 
		 * After this methods behaviour has been defined, please use the following 
		 * code line (as an example) to assign the output variable of this Operation its value, 
		 * if and only if an OutputVariable is defined for this Operation. 
		 * 
		 * Submodel1.out1_operation2_Output.setValue(<<Value Instance>>);
		 *  
		 */
	public void CPU_Values_KillProcess(Integer processID) {
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Measurement_Value_Battery_Values() {
		List<ISubmodelElement> Battery_Values = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);
		
		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			Battery_Values.add(new Property("Time", System.currentTimeMillis()));
			Battery_Values.add(new Property("Left_IDR", jsonObject.get("Left_IDR").getAsFloat()));
			Battery_Values.add(new Property("Right_IDR", jsonObject.get("Right_IDR").getAsFloat()));
			Battery_Values.add(new Property("Power", jsonObject.get("Power").getAsFloat()));
		} else {
			Battery_Values.add(new Property("Time", System.currentTimeMillis()));
			Battery_Values.add(new Property("Left_IDR", 0.0));
			Battery_Values.add(new Property("Right_IDR", 0.0));
			Battery_Values.add(new Property("Power", 0.0));
		}
		return Battery_Values;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Measurement_Value_Engines_Values() {
		List<ISubmodelElement> Engines_Values = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);
		
		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			Engines_Values.add(new Property("Time", System.currentTimeMillis()));
			Engines_Values.add(new Property("Left_Front_Engine_Value", jsonObject.get("Left_Front_Engine_Value").getAsInt()));
			Engines_Values.add(new Property("Left_Back_Engine_Value", jsonObject.get("Left_Back_Engine_Value").getAsInt()));
			Engines_Values.add(new Property("Right_Front_Engine_Value", jsonObject.get("Right_Front_Engine_Value").getAsInt()));
			Engines_Values.add(new Property("Right_Back_Engine_Value", jsonObject.get("Right_Back_Engine_Value").getAsInt()));
		} else {
			Engines_Values.add(new Property("Time", System.currentTimeMillis()));
			Engines_Values.add(new Property("Left_Front_Engine_Value", 0));
			Engines_Values.add(new Property("Left_Back_Engine_Value", 0));
			Engines_Values.add(new Property("Right_Front_Engine_Value", 0));
			Engines_Values.add(new Property("Right_Back_Engine_Value", 0));
		}
		return Engines_Values;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Engines_Values_LeftFrontEngineValues() {
		List<ISubmodelElement> LeftFrontEngineValues = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);
		
		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			LeftFrontEngineValues.add(new Property("Left_Front_Engine_Value", jsonObject.get("Left_Front_Engine_Value").getAsInt()));
		} else {
			LeftFrontEngineValues.add(new Property("Left_Front_Engine_Value", 0));
		}

		return LeftFrontEngineValues;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Engines_Values_LeftBackEngineValues() {
		List<ISubmodelElement> LeftBackEngineValues = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);
		
		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			LeftBackEngineValues.add(new Property("Left_Back_Engine_Value", jsonObject.get("Left_Back_Engine_Value").getAsInt()));
		} else {
			LeftBackEngineValues.add(new Property("Left_Back_Engine_Value", 0));
		}

		return LeftBackEngineValues;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Engines_Values_RightFrontEngineValues() {
		List<ISubmodelElement> RightFrontEngineValues = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);

		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			RightFrontEngineValues.add(new Property("Right_Front_Engine_Value", jsonObject.get("Right_Front_Engine_Value").getAsInt()));
		} else {
			RightFrontEngineValues.add(new Property("Right_Front_Engine_Value", 0));
		}
		return RightFrontEngineValues;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Engines_Values_RightBackEngineValues() {
		List<ISubmodelElement> RightBackEngineValues = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);

		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			RightBackEngineValues.add(new Property("Right_Back_Engine_Value", jsonObject.get("Right_Back_Engine_Value").getAsInt()));
		} else {
			RightBackEngineValues.add(new Property("Right_Back_Engine_Value", 0));
		}
		return RightBackEngineValues;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Measurement_Value_Ultrasonic_Values() {
		List<ISubmodelElement> Ultrasonic_Values = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here.
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);
		
		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			Ultrasonic_Values.add(new Property("Time", System.currentTimeMillis()));
			Ultrasonic_Values.add(new Property("Distance", jsonObject.get("Distance").getAsInt()));
		} else {
			Ultrasonic_Values.add(new Property("Time", System.currentTimeMillis()));
			Ultrasonic_Values.add(new Property("Distance", 0));
		}
		return Ultrasonic_Values;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		* 
		*/
	public Collection<ISubmodelElement> get_Measurement_Value_Video_Values() {
		List<ISubmodelElement> Video_Values = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here. 
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);

		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			Video_Values.add(new Property("Time", System.currentTimeMillis()));
			Video_Values.add(new Property("Video_Rtmp_Url", jsonObject.get("Video_Rtmp_Url").getAsString()));
		} else {
			Video_Values.add(new Property("Time", System.currentTimeMillis()));
			Video_Values.add(new Property("Video_Rtmp_Url", ""));
		}
		return Video_Values;
	}

	/**
		* Please under no circumstances change/modify this method's Signature 
		* and the return statement. 
		*           "pids": pids,
        *            "most_cpu_intensive_processes": most_cpu_intensive_processes, # "most_cpu_intensive_processes": "pid", "name", "cpu_percent
        *            "cpu_percent": cpu_percent,
        *            "cpu_stats": cpu_stats,
        *            "cpu_freq": cpu_freq,
        *            "getloadavg": getloadavg,
        *            "virtual_memory": virtual_memory,
        *            "swap_memory": swap_memory,
        *            "disk_usage": disk_usage,
        *            "disk_partitions": disk_partitions,
        *            "disk_io_counters": disk_io_counters,
        *            "net_io_counters": net_io_counters,
        *            "boot_time": boot_time,
        *            "users": users,
        *            "sensors_temperatures": sensors_temperatures,
        *            "sensors_fans": sensors_fans
		*/
	public Collection<ISubmodelElement> get_Measurement_Value_CPU_Values() {
		List<ISubmodelElement> CPU_Values = new LinkedList<>();
		// Work with your Dynamic SubModelElementCollection here.
		String[] channel = this.getClass().getPackageName().split("\\.");
		String value = connectedDevices.mqtt_endpoint.readValue(channel[channel.length - 1]);

		if(!value.isEmpty() ) {
			JsonObject jsonObject = ConnectedDevices.JsonObject.fromJson(value, JsonObject.class);
			
			try{
				CPU_Values.add(new Property("Time", System.currentTimeMillis()));
				CPU_Values.add(new Property("pids", jsonObject.get("pids").getAsJsonArray().toString()));
				CPU_Values.add(new Property("most_cpu_intensive_processes", jsonObject.get("most_cpu_intensive_processes").getAsJsonArray().toString()));
				CPU_Values.add(new Property("cpu_percent", jsonObject.get("cpu_percent").getAsFloat()));
				CPU_Values.add(new Property("cpu_stats", jsonObject.get("cpu_stats").getAsJsonArray().toString()));
				CPU_Values.add(new Property("cpu_freq", jsonObject.get("cpu_freq").getAsJsonArray().toString()));
				CPU_Values.add(new Property("getloadavg", jsonObject.get("getloadavg").getAsJsonArray().toString()));
				CPU_Values.add(new Property("virtual_memory", jsonObject.get("virtual_memory").getAsJsonArray().toString()));
				CPU_Values.add(new Property("swap_memory", jsonObject.get("swap_memory").getAsJsonArray().toString()));
				CPU_Values.add(new Property("disk_usage", jsonObject.get("disk_usage").getAsJsonArray().toString()));
				CPU_Values.add(new Property("disk_partitions", jsonObject.get("disk_partitions").getAsJsonArray().toString()));
				CPU_Values.add(new Property("disk_io_counters", jsonObject.get("disk_io_counters").getAsJsonArray().toString()));
				CPU_Values.add(new Property("net_io_counters", jsonObject.get("net_io_counters").getAsJsonArray().toString()));
				CPU_Values.add(new Property("boot_time", jsonObject.get("boot_time").getAsInt()));
				CPU_Values.add(new Property("users", jsonObject.get("users").getAsJsonArray().toString()));
				CPU_Values.add(new Property("sensors_temperatures", jsonObject.get("sensors_temperatures").getAsJsonArray().toString()));
				CPU_Values.add(new Property("sensors_fans", jsonObject.get("sensors_fans").getAsJsonArray().toString()));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in parsing CPU values");
			}

		} else {
			CPU_Values.add(new Property("Time", System.currentTimeMillis()));
			CPU_Values.add(new Property("pids", ""));
			CPU_Values.add(new Property("most_cpu_intensive_processes", ""));
			CPU_Values.add(new Property("cpu_percent", "0.0"));
			CPU_Values.add(new Property("cpu_stats", ""));
			CPU_Values.add(new Property("cpu_freq", ""));
			CPU_Values.add(new Property("getloadavg", ""));
			CPU_Values.add(new Property("virtual_memory", ""));
			CPU_Values.add(new Property("swap_memory", ""));
			CPU_Values.add(new Property("disk_usage", ""));
			CPU_Values.add(new Property("disk_partitions", ""));
			CPU_Values.add(new Property("disk_io_counters", ""));
			CPU_Values.add(new Property("net_io_counters", ""));
			CPU_Values.add(new Property("boot_time", ""));
			CPU_Values.add(new Property("users", ""));
			CPU_Values.add(new Property("sensors_temperatures", ""));
			CPU_Values.add(new Property("sensors_fans", ""));
		}
		return CPU_Values;
	}

}
