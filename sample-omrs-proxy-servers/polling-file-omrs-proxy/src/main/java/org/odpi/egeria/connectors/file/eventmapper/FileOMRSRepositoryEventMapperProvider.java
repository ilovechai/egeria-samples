/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.file.eventmapper;

import org.odpi.openmetadata.frameworks.connectors.properties.beans.ConnectorType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnectorProviderBase;

/**
 * In the Open Connector Framework (OCF), a ConnectorProvider is a factory for a specific type of connector.
 * The ApacheAtlasOMRSRepositoryEventMapperProvider is the connector provider for the ApacheAtlasOMRSRepositoryEventMapperProvider.
 * It extends OMRSRepositoryEventMapperProviderBase which in turn extends the OCF ConnectorProviderBase.
 * ConnectorProviderBase supports the creation of connector instances.
 *
 * The ApacheAtlasOMRSRepositoryEventMapperProvider must initialize ConnectorProviderBase with the Java class
 * name of the OMRS Connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public class FileOMRSRepositoryEventMapperProvider extends OMRSRepositoryConnectorProviderBase {

    static final String CONNECTOR_TYPE_GUID = "09dcef5f-94e6-44da-8d3c-1f299daa4221";
    static final String CONNECTOR_TYPE_NAME = "OMRS Sample File Event Mapper Connector";
    static final String CONNECTOR_TYPE_DESC = "OMRS Sample File Event Mapper Connector that polls for content.";

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * OMRS Connector implementation.
     */
    public FileOMRSRepositoryEventMapperProvider() {
        Class<?> connectorClass = FileOMRSRepositoryEventMapper.class;
        super.setConnectorClassName(connectorClass.getName());
        ConnectorType connectorType = new ConnectorType();
        connectorType.setType(ConnectorType.getConnectorTypeType());
        connectorType.setGUID(CONNECTOR_TYPE_GUID);
        connectorType.setQualifiedName(CONNECTOR_TYPE_NAME);
        connectorType.setDisplayName(CONNECTOR_TYPE_NAME);
        connectorType.setDescription(CONNECTOR_TYPE_DESC);
        connectorType.setConnectorProviderClassName(this.getClass().getName());
        super.setConnectorTypeProperties(connectorType);
    }

}
