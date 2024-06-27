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
package caraas.module.submodels.insights;

import caraas.connection.ConnectedDevices;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.Duration;
import javax.xml.namespace.QName;
import javax.xml.datatype.Duration;
import org.eclipse.basyx.vab.exception.provider.ProviderException;
import org.eclipse.basyx.vab.protocol.opcua.types.NodeId;
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

}
