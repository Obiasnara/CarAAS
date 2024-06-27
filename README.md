# Welcome to CarAAS!

This project contains all required files to run your AAS server.

# Running
To run the AAS without modifications, please right-click on **AASServer.java** in *caraas.module* package and choose **Run As -> Java Application**. Then, you will see when the server is ready to be accessed on: **http://127.0.0.1:5555/aas/**

Another option could also be to cut the **AASServer.launch** created in the projectFolder and paste
it in the following path - {PATH to eclipse-workspace}\.metadata\.plugins\org.eclipse.debug.core\.launches
If the **AASServer.launch** is pasted in the above PATH, a direct click on the green play button in the eclipse
workspace will launch the AAS. Note: the AAS Folder must be selected before clicking on the green play button.
The AAS Server provides a REST interface. You can see the list of commands [here](https://app.swaggerhub.com/apis/BaSyx/basyx_submodel_http_rest_api/v1#/).
Using the interface, you can invoke operations and/or get property values.
# Files

## Sub Models

The project contains the following submodels:

 - Vehicle_Ontology_Thing (URL to access: *[http://127.0.0.1:5555/aas/submodels/Vehicle_Ontology_Thing](http://127.0.0.1:5555/aas/submodels/Vehicle_Ontology_Thing)*)
 - Sensor (URL to access: *[http://127.0.0.1:5555/aas/submodels/Sensor](http://127.0.0.1:5555/aas/submodels/Sensor)*)
 - Act_Of_Observation (URL to access: *[http://127.0.0.1:5555/aas/submodels/Act_Of_Observation](http://127.0.0.1:5555/aas/submodels/Act_Of_Observation)*)
 - Measurement_Value (URL to access: *[http://127.0.0.1:5555/aas/submodels/Measurement_Value](http://127.0.0.1:5555/aas/submodels/Measurement_Value)*)
 - Quality (URL to access: *[http://127.0.0.1:5555/aas/submodels/Quality](http://127.0.0.1:5555/aas/submodels/Quality)*)
 - Result_Visualisation (URL to access: *[http://127.0.0.1:5555/aas/submodels/Result_Visualisation](http://127.0.0.1:5555/aas/submodels/Result_Visualisation)*)
 - Insights (URL to access: *[http://127.0.0.1:5555/aas/submodels/Insights](http://127.0.0.1:5555/aas/submodels/Insights)*)

You can find them inside *caraas.module.submodel* package.
You can edit these files to tweak properties and operations. You may need to refer to [Basyx Documentation](https://app.swaggerhub.com/apis/BaSyx/basyx_submodel_http_rest_api/v1#/) to work with those files manually.

Example illustrations of formats to make REST API Calls:
#- POST Call Format (AAS Operations):

		-	In case, AAS Operation is added to a SubModelElementCollection:
			http://{host}/aas/submodels/{submodelName}/submodel/submodelElements/{submodelCollectionName}/{OperationName}/invoke	

		- 	In case, AAS Operation is not added to a SubModelElementCollection:
			http://{host}/aas/submodels/{submodelName}/submodel/submodelElements/{OperationName}/invoke 

# Example - POST Call Format (AAS Operations): An Operation with two Input Variables[Operand1 and Operand2] 
		-	{
    		"requestId": "{{$timestamp}}",
    		"inputArguments": [
        		{
            		"modelType": {
                		"name": "OperationVariable"
            		},
            		"value": {
                		"idShort": "Operand1",
                		"modelType": {
                    		"name": "Property"
                		},
                		"kind": "Template",
                		"valueType": "Integer",
                		"value": 30
            		}
        		},
        		{
            		"modelType": {
                		"name": "OperationVariable"
            		},
            		"value": {
                		"idShort": "Operand2",
                		"modelType": {
                    		"name": "Property"
                		},
                		"kind": "Template",
                		"valueType": "Integer",
                		"value": 50
            		}
        		}
    		],
    		"inoutputArguments": [],
    		"timeout": 5000
			}


#- GET Call Format (AAS Properties): 

		- 	In case, AAS Properties is added to a SubModelElementCollection: 
			http://{host}/aas/submodels/{submodelIdShort}/submodel/submodelElements/{SubModelElementsCollectionName}/{propertyIdShort}/value 

		- 	In case, AAS Properties is not added to a SubModelElementCollection: 
			http://{host}/aas/submodels/{submodelIdShort}/submodel/submodelElements/{propertyIdShort}/value
#- PUT Call Format (AAS Properties): 

		-	In case, AAS Properties is added to a SubModelElementCollection: 
			http://{host}/aas/submodels/{submodelIdShort}/submodel/submodelElements/{SubModelElementsCollectionName}/{propertyIdShort}/value 

		- In case, AAS Properties is not added to a SubModelElementCollection: 
			http://{host}/aas/submodels/{submodelIdShort}/submodel/submodelElements/{propertyIdShort}/value 

## Link

If you linked two AAS projects, you can see pre-created methods to access remote API calls inside *caraas.module.submodel.link* package. You can use these methods using static calls.

