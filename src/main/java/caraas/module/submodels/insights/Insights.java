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
package caraas.module.submodels.insights;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import java.math.BigInteger; 

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;

import caraas.connection.ConnectedDevices;
//import caraas.connection.DataCrawler;
import caraas.module.AASServer;
import caraas.module.ConceptDescriptions;
import caraas.connection.OpcUaVariable;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.operation.Operation;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.SubmodelElementCollection;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.dataelement.property.valuetype.ValueType;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.dataelement.File;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.dataelement.property.Property;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.dataelement.MultiLanguageProperty;
import org.eclipse.basyx.submodel.metamodel.map.qualifier.LangStrings;
import org.eclipse.basyx.submodel.metamodel.map.reference.Key; 
import org.eclipse.basyx.submodel.metamodel.map.reference.Reference; 
import org.eclipse.basyx.submodel.metamodel.api.reference.IKey;
import org.eclipse.basyx.submodel.metamodel.api.reference.enums.KeyElements; 
import org.eclipse.basyx.submodel.metamodel.api.reference.enums.KeyType; 
import org.eclipse.basyx.submodel.metamodel.api.identifier.IdentifierType;
import org.eclipse.basyx.submodel.metamodel.api.qualifier.haskind.ModelingKind;
import org.eclipse.basyx.submodel.metamodel.api.submodelelement.ISubmodelElement;
import org.eclipse.basyx.submodel.metamodel.map.Submodel;
import org.eclipse.basyx.submodel.metamodel.map.submodelelement.operation.OperationVariable;
import com.festo.aas.p4m.connection.ValueDelegate; 
import org.eclipse.basyx.vab.protocol.opcua.types.NodeId;
import org.eclipse.basyx.vab.protocol.opcua.types.UnsignedShort;
import com.festo.aas.p4m.connection.ConnectedProperty;

/**
 * 
 * @author DFKI
 * 
 * Do not edit this file for changing operation behaviours. 
 */

public class Insights extends Submodel {

	/**
	 * This field variable holds all configured connectors to the asset. 
	 * Use these connectors to communicate with your asset.
	 */
	private ConnectedDevices connectedDevices;

	private ConceptDescriptions conceptDescriptions;

	/**
     * This class contains all user-provided code for operations.
     */
	private final DynamicElementsWorkspace dew; 

	 /**
     * This class contains all user-provided code for value delegates.
     */

	 /**
     * The following contains the declaration of the operation variables as field variables so that they can be accessed in their true sense.
     */


	public Insights() {

		try {
			connectedDevices = new ConnectedDevices();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		
		dew = new DynamicElementsWorkspace(connectedDevices);
		conceptDescriptions = new ConceptDescriptions();

		setIdShort("Insights");
		setIdentification(IdentifierType.IRI, AASServer.getSettings().SUBMODEL_INSIGHTS_IRI.get().toString()); 
		setKind(ModelingKind.TEMPLATE); 
		List<IKey> insightsKeys= new ArrayList<IKey>();
		Reference InsightsRef = new Reference(insightsKeys);
		setSemanticId(InsightsRef); 
 
	}
	
}

