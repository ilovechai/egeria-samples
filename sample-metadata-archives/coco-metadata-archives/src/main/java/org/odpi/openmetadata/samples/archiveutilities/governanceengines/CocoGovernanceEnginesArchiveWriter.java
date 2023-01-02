/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.samples.archiveutilities.governanceengines;

import org.odpi.openmetadata.adapters.connectors.discoveryservices.CSVDiscoveryServiceProvider;
import org.odpi.openmetadata.adapters.connectors.governanceactions.provisioning.MoveCopyFileGovernanceActionProvider;
import org.odpi.openmetadata.adapters.connectors.governanceactions.remediation.OriginSeekerGovernanceActionProvider;
import org.odpi.openmetadata.adapters.connectors.governanceactions.remediation.ZonePublisherGovernanceActionProvider;
import org.odpi.openmetadata.adapters.connectors.governanceactions.watchdog.GenericFolderWatchdogGovernanceActionProvider;
import org.odpi.openmetadata.samples.archiveutilities.combo.CocoBaseArchiveWriter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * CocoGovernanceEnginesArchiveWriter creates a physical open metadata archive file containing the governance engine definitions
 * needed by Coco Pharmaceuticals.
 */
public class CocoGovernanceEnginesArchiveWriter extends CocoBaseArchiveWriter
{
    private static final String archiveFileName = "CocoGovernanceEngineDefinitionsArchive.json";

    /*
     * This is the header information for the archive.
     */
    private static final String                  archiveGUID        = "9cbd2b33-e80f-4df2-adc6-d859ebff4c34";
    private static final String                  archiveName        = "CocoGovernanceEngineDefinitions";
    private static final String                  archiveDescription = "Governance Engines for Coco Pharmaceuticals.";

    /*
     * Specific values for initializing TypeDefs
     */
    private static final String GOVERNANCE_ACTION_ENGINE_TYPE_NAME  = "GovernanceActionEngine";
    private static final String GOVERNANCE_ACTION_SERVICE_TYPE_NAME = "GovernanceActionService";

    private static final String OPEN_DISCOVERY_ENGINE_TYPE_NAME  = "OpenDiscoveryEngine";
    private static final String OPEN_DISCOVERY_SERVICE_TYPE_NAME = "OpenDiscoveryService";

    /**
     * Default constructor initializes the archive.
     */
    public CocoGovernanceEnginesArchiveWriter()
    {
        super(archiveGUID,
              archiveName,
              archiveDescription,
              new Date(),
              archiveFileName,
              null);
    }


    /**
     * Create an entity for the FileProvisioner governance engine.
     *
     * @return unique identifier for the governance engine
     */
    private String getFileProvisioningEngine()
    {
        final String governanceEngineName        = "FileProvisioning";
        final String governanceEngineDisplayName = "File Provisioning Governance Action Engine";
        final String governanceEngineDescription = "Copies, moves or deletes a file on request.";

        return archiveHelper.addGovernanceEngine(GOVERNANCE_ACTION_ENGINE_TYPE_NAME,
                                                 governanceEngineName,
                                                 governanceEngineDisplayName,
                                                 governanceEngineDescription,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null);
    }


    /**
     * Create an entity for the AssetGovernance governance engine.
     *
     * @return unique identifier for the governance engine
     */
    private String getAssetGovernanceEngine()
    {
        final String assetGovernanceEngineName        = "AssetGovernance";
        final String assetGovernanceEngineDisplayName = "AssetGovernance Governance Action Engine";
        final String assetGovernanceEngineDescription = "Monitors, validates and enriches metadata relating to assets.";

        return archiveHelper.addGovernanceEngine(GOVERNANCE_ACTION_ENGINE_TYPE_NAME,
                                                 assetGovernanceEngineName,
                                                 assetGovernanceEngineDisplayName,
                                                 assetGovernanceEngineDescription,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null);
    }


    /**
     * Create an entity for the AssetDiscovery governance engine.
     *
     * @return unique identifier for the governance engine
     */
    private String getAssetDiscoveryEngine()
    {
        final String assetDiscoveryEngineName        = "AssetDiscovery";
        final String assetDiscoveryEngineDisplayName = "AssetDiscovery Open Discovery Engine";
        final String assetDiscoveryEngineDescription = "Extracts metadata about a digital resource and attach it to its asset description.";

        return archiveHelper.addGovernanceEngine(OPEN_DISCOVERY_ENGINE_TYPE_NAME,
                                                 assetDiscoveryEngineName,
                                                 assetDiscoveryEngineDisplayName,
                                                 assetDiscoveryEngineDescription,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null);
    }


    /**
     * Create an entity for the AssetQuality governance engine.
     *
     * @return unique identifier for the governance engine
     */
    private String getAssetQualityEngine()
    {
        final String assetQualityEngineName        = "AssetQuality";
        final String assetQualityEngineDisplayName = "AssetQuality Open Discovery Engine";
        final String assetQualityEngineDescription = "Assess the quality of a digital resource identified by the asset in the request.";

        return archiveHelper.addGovernanceEngine(OPEN_DISCOVERY_ENGINE_TYPE_NAME,
                                                 assetQualityEngineName,
                                                 assetQualityEngineDisplayName,
                                                 assetQualityEngineDescription,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null,
                                                 null);
    }


    /**
     * Create an entity for the FileProvisioning governance action service.
     *
     * @return unique identifier for the governance engine
     */
    private String getFileProvisioningGovernanceActionService()
    {
        final String governanceServiceName        = "file-provisioning-governance-action-service";
        final String governanceServiceDisplayName = "File {move, copy, delete} Governance Action Service";
        final String governanceServiceDescription = "Works with files.  The request type defines which action is taken.  " +
                                                               "The request parameters define the source file and destination, along with lineage options";
        final String ftpGovernanceServiceProviderClassName = MoveCopyFileGovernanceActionProvider.class.getName();

        return archiveHelper.addGovernanceService(GOVERNANCE_ACTION_SERVICE_TYPE_NAME,
                                                  ftpGovernanceServiceProviderClassName,
                                                  null,
                                                  governanceServiceName,
                                                  governanceServiceDisplayName,
                                                  governanceServiceDescription,
                                                  null,
                                                  null);
    }


    /**
     * Create an entity for the generic watchdog governance action service.
     *
     * @return unique identifier for the governance engine
     */
    private String getWatchdogGovernanceActionService()
    {
        final String governanceServiceName = "new-measurements-watchdog-governance-action-service";
        final String governanceServiceDisplayName = "New Measurements Watchdog Governance Action Service";
        final String governanceServiceDescription = "Initiates a governance action process when a new weekly measurements file arrives.";
        final String governanceServiceProviderClassName = GenericFolderWatchdogGovernanceActionProvider.class.getName();

        return archiveHelper.addGovernanceService(GOVERNANCE_ACTION_SERVICE_TYPE_NAME,
                                                  governanceServiceProviderClassName,
                                                  null,
                                                  governanceServiceName,
                                                  governanceServiceDisplayName,
                                                  governanceServiceDescription,
                                                  null,
                                                  null);
    }


    /**
     * Add a governance service that walks backwards through an asset's lineage to find an origin classification.  If found, the same origin is added
     * to the asset.
     *
     * @return unique identifier fo the governance service
     */
    private String getZonePublisherGovernanceActionService()
    {
        final String governanceServiceName = "zone-publisher-governance-action-service";
        final String governanceServiceDisplayName = "Update Asset's Zone Membership Governance Action Service";
        final String governanceServiceDescription = "Set up the zone membership for one or more assets supplied as action targets.";
        final String governanceServiceProviderClassName = ZonePublisherGovernanceActionProvider.class.getName();

        return archiveHelper.addGovernanceService(GOVERNANCE_ACTION_SERVICE_TYPE_NAME,
                                                  governanceServiceProviderClassName,
                                                  null,
                                                  governanceServiceName,
                                                  governanceServiceDisplayName,
                                                  governanceServiceDescription,
                                                  null,
                                                  null);
    }


    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @return unique identifier fo the governance service
     */
    private String getOriginSeekerGovernanceActionService()
    {
        final String governanceServiceName = "origin-seeker-governance-action-service";
        final String governanceServiceDisplayName = "Locate and Set Origin Governance Action Service";
        final String governanceServiceDescription = "Navigates back through the lineage relationships to locate the origin classification(s) from the source(s) and sets it on the requested asset if the origin is unique.";
        final String governanceServiceProviderClassName = OriginSeekerGovernanceActionProvider.class.getName();

        return archiveHelper.addGovernanceService(GOVERNANCE_ACTION_SERVICE_TYPE_NAME,
                                                  governanceServiceProviderClassName,
                                                  null,
                                                  governanceServiceName,
                                                  governanceServiceDisplayName,
                                                  governanceServiceDescription,
                                                  null,
                                                  null);
    }


    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addFTPFileRequestType(String governanceEngineGUID,
                                       String governanceServiceGUID)
    {
        final String governanceRequestType = "simulate-ftp";
        final String serviceRequestType = "copy-file";
        final String noLineagePropertyName = "noLineage";

        Map<String, String> requestParameters = new HashMap<>();

        requestParameters.put(noLineagePropertyName, "");

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceRequestType, serviceRequestType, requestParameters, governanceServiceGUID);
    }


    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addWatchNestedInFolderRequestType(String governanceEngineGUID,
                                                   String governanceServiceGUID)
    {
        final String governanceRequestType = "watch-for-new-files";
        final String serviceRequestType = "watch-nested-in-folder";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceRequestType, serviceRequestType, null, governanceServiceGUID);
    }


    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addCopyFileRequestType(String governanceEngineGUID,
                                        String governanceServiceGUID)
    {
        final String governanceRequestType = "copy-file";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceRequestType, null, null, governanceServiceGUID);
    }



    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addMoveFileRequestType(String governanceEngineGUID,
                                        String governanceServiceGUID)
    {
        final String governanceRequestType = "move-file";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceRequestType, null, null, governanceServiceGUID);
    }



    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addDeleteFileRequestType(String governanceEngineGUID,
                                          String governanceServiceGUID)
    {
        final String governanceRequestType = "delete-file";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceRequestType, null, null, governanceServiceGUID);
    }


    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addSeekOriginRequestType(String governanceEngineGUID,
                                          String governanceServiceGUID)
    {
        final String governanceServiceRequestType = "seek-origin";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceServiceRequestType, null, null, governanceServiceGUID);
    }



    /**
     * Set up the request type that links the governance engine to the governance service.
     *
     * @param governanceEngineGUID unique identifier of the governance engine
     * @param governanceServiceGUID unique identifier of the governance service
     */
    private void addSetZoneMembershipRequestType(String governanceEngineGUID,
                                                 String governanceServiceGUID)
    {
        final String governanceServiceRequestType = "set-zone-membership";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, governanceServiceRequestType, null, null, governanceServiceGUID);
    }


    /**
     * Create an entity for the CSV Asset Discovery governance service.
     *
     * @return unique identifier for the governance engine
     */
    private String getCSVAssetDiscoveryService()
    {
        final String discoveryServiceName = "csv-asset-discovery-service";
        final String discoveryServiceDisplayName = "CSV Asset Discovery Service";
        final String discoveryServiceDescription = "Discovers columns for CSV Files.";
        final String discoveryServiceProviderClassName = CSVDiscoveryServiceProvider.class.getName();

        return archiveHelper.addGovernanceService(OPEN_DISCOVERY_SERVICE_TYPE_NAME,
                                                  discoveryServiceProviderClassName,
                                                  null,
                                                  discoveryServiceName,
                                                  discoveryServiceDisplayName,
                                                  discoveryServiceDescription,
                                                  null,
                                                  null);
    }


    private void addSmallCSVRequestType(String governanceEngineGUID,
                                        String governanceServiceGUID)
    {
        final String discoveryServiceRequestType = "small-csv";

        archiveHelper.addSupportedGovernanceService(governanceEngineGUID, discoveryServiceRequestType, null, null, governanceServiceGUID);
    }


    /**
     * Add the content to the archive builder.
     */
    public void getArchiveContent()
    {
        /*
         * Create governance services
         */
        String fileProvisionerGUID = this.getFileProvisioningGovernanceActionService();
        String watchDogServiceGUID = this.getWatchdogGovernanceActionService();
        String originSeekerGUID = this.getOriginSeekerGovernanceActionService();
        String zonePublisherGUID = this.getZonePublisherGovernanceActionService();
        String csvDiscoveryGUID = this.getCSVAssetDiscoveryService();

        String fileProvisioningEngineGUID = this.getFileProvisioningEngine();

        this.addCopyFileRequestType(fileProvisioningEngineGUID, fileProvisionerGUID);
        this.addMoveFileRequestType(fileProvisioningEngineGUID, fileProvisionerGUID);
        this.addDeleteFileRequestType(fileProvisioningEngineGUID, fileProvisionerGUID);

        String assetGovernanceEngineGUID = this.getAssetGovernanceEngine();

        this.addFTPFileRequestType(assetGovernanceEngineGUID, fileProvisionerGUID);
        this.addWatchNestedInFolderRequestType(assetGovernanceEngineGUID, watchDogServiceGUID);
        this.addSeekOriginRequestType(assetGovernanceEngineGUID, originSeekerGUID);
        this.addSetZoneMembershipRequestType(assetGovernanceEngineGUID, zonePublisherGUID);
        this.addMoveFileRequestType(assetGovernanceEngineGUID, fileProvisionerGUID);
        this.addDeleteFileRequestType(assetGovernanceEngineGUID, fileProvisionerGUID);

        String assetDiscoveryEngineGUID = this.getAssetDiscoveryEngine();

        this.addSmallCSVRequestType(assetDiscoveryEngineGUID, csvDiscoveryGUID);

        String assetQualityEngineGUID = this.getAssetQualityEngine();
        // todo add services when they written

    }

    /**
     * Generates and writes out an open metadata archive for Coco Pharmaceuticals governance engines.
     */
    public void writeOpenMetadataArchive()
    {
        try
        {
            System.out.println("Writing to file: " + archiveFileName);

            super.writeOpenMetadataArchive(archiveFileName, this.getOpenMetadataArchive());
        }
        catch (Exception error)
        {
            System.out.println("error is " + error);
        }
    }
}
