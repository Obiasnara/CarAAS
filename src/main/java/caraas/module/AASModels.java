/*******************************************************************************
 * Copyright (c) 2024 DFKI.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     DFKI - Tapanta Bhanja <tapanta.bhanja@dfki.de>
 *******************************************************************************/
package caraas.module;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.basyx.aas.metamodel.api.parts.asset.AssetKind;
import org.eclipse.basyx.aas.metamodel.map.AssetAdministrationShell;
import org.eclipse.basyx.aas.metamodel.map.parts.Asset;
import org.eclipse.basyx.submodel.metamodel.api.identifier.IdentifierType;
import com.festo.aas.p4m.connection.SubmodelWrapper;

import caraas.module.submodels.vehicle_ontology_thing.Vehicle_Ontology_Thing; 
import caraas.module.submodels.sensor.Sensor; 
import caraas.module.submodels.act_of_observation.Act_Of_Observation; 
import caraas.module.submodels.measurement_value.Measurement_Value; 
import caraas.module.submodels.quality.Quality; 
import caraas.module.submodels.result_visualisation.Result_Visualisation; 
import caraas.module.submodels.insights.Insights; 

/**
 * Contains the major components of the AAS Model.
 * 
 * <p>
 * 'AAS Model' - includes the AAS itself the assets and the submodels. 
 * 
 * <p>
 * This class creates and exposes the AAS itself as well as its asset, concept descriptions and submodels. 
 * 
 * @author DFKI
 *
 */ 
public class AASModels { 

	/** The asset represented by this AAS. */
	public final Asset asset;
	
	/** The AAS object itself. */
	public final AssetAdministrationShell aas;
	
	/** Holds all concept descriptions. */
	public final ConceptDescriptions conceptDescriptions;

	/** List of Submodels. **/
	public final Set<SubmodelWrapper> listSubmodels = new HashSet<>();
	
		/** The submodel 'Vehicle_Ontology_Thing'. */ 
	public final SubmodelWrapper Vehicle_Ontology_Thing;
	
	/** The submodel 'Sensor'. */ 
	public final SubmodelWrapper Sensor;
	
	/** The submodel 'Act_Of_Observation'. */ 
	public final SubmodelWrapper Act_Of_Observation;
	
	/** The submodel 'Measurement_Value'. */ 
	public final SubmodelWrapper Measurement_Value;
	
	/** The submodel 'Quality'. */ 
	public final SubmodelWrapper Quality;
	
	/** The submodel 'Result_Visualisation'. */ 
	public final SubmodelWrapper Result_Visualisation;
	
	/** The submodel 'Insights'. */ 
	public final SubmodelWrapper Insights;
	
	
	/**
	 * Constructor Method.
	 * Creates all components of this AAS model and stores references to them in fields. 
	 */
	public AASModels() {
		
		Settings settings = AASServer.getSettings();	
		String assetIdShort = settings.assetName.get();
		URI assetId = settings.assetUri.get();			
		String aasIdShort = settings.aasName.get();
		URI aasId = settings.aasUri.get();
		
		
		aas = createAas(aasIdShort, aasId);
		
		asset = createAsset(assetIdShort, assetId);
		aas.setAsset(asset);
		
		conceptDescriptions = new ConceptDescriptions();
		aas.setConceptDictionary(Arrays.asList(conceptDescriptions));
		
		Vehicle_Ontology_Thing = new SubmodelWrapper(new Vehicle_Ontology_Thing());
		aas.addSubmodel(Vehicle_Ontology_Thing.getSubmodel());
		listSubmodels.add(Vehicle_Ontology_Thing); 
		Sensor = new SubmodelWrapper(new Sensor());
		aas.addSubmodel(Sensor.getSubmodel());
		listSubmodels.add(Sensor); 
		Act_Of_Observation = new SubmodelWrapper(new Act_Of_Observation());
		aas.addSubmodel(Act_Of_Observation.getSubmodel());
		listSubmodels.add(Act_Of_Observation); 
		Measurement_Value = new SubmodelWrapper(new Measurement_Value());
		aas.addSubmodel(Measurement_Value.getSubmodel());
		listSubmodels.add(Measurement_Value); 
		Quality = new SubmodelWrapper(new Quality());
		aas.addSubmodel(Quality.getSubmodel());
		listSubmodels.add(Quality); 
		Result_Visualisation = new SubmodelWrapper(new Result_Visualisation());
		aas.addSubmodel(Result_Visualisation.getSubmodel());
		listSubmodels.add(Result_Visualisation); 
		Insights = new SubmodelWrapper(new Insights());
		aas.addSubmodel(Insights.getSubmodel());
		listSubmodels.add(Insights); 
	}
	
	/**
	 * Creates an asset object with the given idShort and id. 
	 * 
	 * @param idShort	The asset's idShort. 
	 * @param id		The asset's globally unique id. Must be an IRI. (i.e., an URI)
	 * 
	 * @return			The created asset. 
	 */
	private Asset createAsset(String idShort, URI id) {
		
		Asset asset = new Asset();
		asset.setAssetKind(AssetKind.INSTANCE);
		asset.setIdShort(idShort);
		asset.setIdentification(IdentifierType.IRI, id.toString());
		
		return asset;
		
	}
	
	/**
	 * Creates an AAS object with the given idShort and id. 
	 * 
	 * @param idShort	The AAS' idShort.
	 * @param id		The AAS' globally unique id. Must be an IRI (i.e., an URI)
	 * 
	 * @return			The created AAS.
	 */
	private AssetAdministrationShell createAas(String idShort, URI id) {
		AssetAdministrationShell aas = new AssetAdministrationShell();
		aas.setIdShort(idShort);
		aas.setIdentification(IdentifierType.IRI, id.toString());
		
		return aas;
	}
	
	
	public Set<SubmodelWrapper> getSubmodels() {
		return listSubmodels;
	}

}
