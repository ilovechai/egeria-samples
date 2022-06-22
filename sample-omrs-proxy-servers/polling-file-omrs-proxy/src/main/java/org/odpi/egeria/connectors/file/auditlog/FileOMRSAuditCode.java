/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.file.auditlog;

import org.odpi.openmetadata.frameworks.auditlog.messagesets.AuditLogMessageDefinition;
import org.odpi.openmetadata.frameworks.auditlog.messagesets.AuditLogMessageSet;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditLogRecordSeverity;

/**
 * The FileOMRSAuditCode is used to define the message content for the OMRS Audit Log.
 *
 * The 5 fields in the enum are:
 * <ul>
 *     <li>Log Message Id - to uniquely identify the message</li>
 *     <li>Severity - is this an event, decision, action, error or exception</li>
 *     <li>Log Message Text - includes placeholder to allow additional values to be captured</li>
 *     <li>Additional Information - further parameters and data relating to the audit message (optional)</li>
 *     <li>SystemAction - describes the result of the situation</li>
 *     <li>UserAction - describes how a user should correct the situation</li>
 * </ul>
 */
public enum FileOMRSAuditCode implements AuditLogMessageSet {

    REPOSITORY_SERVICE_STARTING("OMRS-FILE-REPOSITORY-0001",
            OMRSAuditLogRecordSeverity.INFO,
            "Sample file repository proxy is starting a new server instance",
            "The local server has started up a new instance of the Sample file repository proxy.",
            "No action is required.  This is part of the normal operation of the service."),
    CONNECTING_TO_FOLDER("OMRS-FILE-REPOSITORY-0002",
                         OMRSAuditLogRecordSeverity.INFO,
                         "Sample file repository proxy is attempting to connect to Sample file repository proxy at {0}",
                         "The local server is attempting to connect to the Sample file repository proxy server.",
                         "No action is required.  This is part of the normal operation of the service."),
    CONNECTED_TO_ATLAS("OMRS-FILE-REPOSITORY-0003",
            OMRSAuditLogRecordSeverity.INFO,
            "Sample file repository proxy has successfully connected to Sample file repository proxy at {0}",
            "The local server has successfully connected to the Sample file repository proxy server.",
            "No action is required.  This is part of the normal operation of the service."),
    REPOSITORY_SERVICE_STARTED("OMRS-FILE-REPOSITORY-0004",
            OMRSAuditLogRecordSeverity.INFO,
            "Sample file repository proxy has started a new instance for server {0}",
            "The local server has completed startup of a new instance.",
            "No action is required.  This is part of the normal operation of the service."),
    REPOSITORY_SERVICE_SHUTDOWN("OMRS-FILE-REPOSITORY-0005",
            OMRSAuditLogRecordSeverity.INFO,
            "Sample file repository proxy has shutdown its instance for server {0}",
            "The local server has requested shut down of an Sample file repository proxy instance.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_INITIALIZING("OMRS-FILE-REPOSITORY-0006",
            OMRSAuditLogRecordSeverity.INFO,
            "The Sample file repository proxy event mapper is initializing",
            "The local server has started up a new instance of the Sample file repository proxy event mapper.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_INITIALIZED("OMRS-FILE-REPOSITORY-0007",
            OMRSAuditLogRecordSeverity.INFO,
            "The Sample file repository proxy event mapper has initialized for server {0}",
            "The local server has completed initialization of a new instance.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_SHUTDOWN("OMRS-FILE-REPOSITORY-0008",
            OMRSAuditLogRecordSeverity.INFO,
            "The Sample file repository proxy event mapper has shutdown its instance for server {0}",
            "The local server has requested shut down of an Sample file repository proxy event mapper instance.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_STARTING("OMRS-FILE-REPOSITORY-0009",
            OMRSAuditLogRecordSeverity.INFO,
            "The Sample file repository proxy event mapper consumer thread is starting up",
            "The local server has requested startup of an Sample file repository proxy event mapper consumer.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_RUNNING("OMRS-FILE-REPOSITORY-0010",
            OMRSAuditLogRecordSeverity.INFO,
            "The Sample file repository proxy event mapper is running",
            "The local server is now running a consumer thread for Sample file repository proxy.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_CONSUMER_FAILURE("OMRS-FILE-REPOSITORY-0011",
            OMRSAuditLogRecordSeverity.EXCEPTION,
            "The Sample file repository proxy event mapper failed to consume an event",
            "The local server failed to consume an Sample file repository proxy event.",
            "Investigate the logs for additional information and raise a GitHub issue with the details."),
    EVENT_MAPPER_ACQUIRING_TYPES_LOOP("OMRS-FILE-REPOSITORY-0012",
                                  OMRSAuditLogRecordSeverity.INFO,
                                  "The Sample file repository proxy event mapper loop for acquiring types has started",
                                  "The Sample file repository proxy event mapper loop is attempting to get the types.",
                                  "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_ACQUIRING_TYPES_LOOP_FOUND_TYPE("OMRS-FILE-REPOSITORY-0013",
                                      OMRSAuditLogRecordSeverity.INFO,
                                      "The Sample file repository proxy event mapper loop for acquiring types has found type {0}",
                                      "The Sample file repository proxy event mapper loop has found a type.",
                                      "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_ACQUIRING_TYPES_LOOP_PRE_WAIT("OMRS-FILE-REPOSITORY-0014",
                                                 OMRSAuditLogRecordSeverity.INFO,
                                                 "The Sample file repository proxy event mapper loop for acquiring types has completed a scan",
                                                 "The Sample file repository proxy event mapper acquiring types loop is about the sleep for 1 second then retry.",
                                                 "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_ACQUIRING_TYPES_LOOP_POST_WAIT("OMRS-FILE-REPOSITORY-0015",
                                                 OMRSAuditLogRecordSeverity.INFO,
                                                "The Sample file repository proxy event mapper loop for acquiring types has woken; we have retried {0} times  ",
                                                 "The Sample file repository proxy event mapper acquiring types loop has woken from its 1 second sleep.",
                                                 "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_ACQUIRED_ALL_TYPES("OMRS-FILE-REPOSITORY-0016",
                                    OMRSAuditLogRecordSeverity.INFO,
                                    "The Sample file repository proxy event mapper has acquired the types it needs",
                                    "The Sample file repository proxy event mapper is about to construct the events.",
                                    "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_ACQUIRING_TYPES_LOOP_INTERRUPTED_EXCEPTION("OMRS-FILE-REPOSITORY-0017",
    OMRSAuditLogRecordSeverity.EXCEPTION,
            "The Sample file repository proxy event mapper sleep has failed with an interrupted exception",
            "The Sample file repository proxy event mapper's acquiring types loop sleep has been interrupted.",
            "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_POLL_LOOP_PRE_WAIT("OMRS-FILE-REPOSITORY-0017",
                                               OMRSAuditLogRecordSeverity.INFO,
                                               "The Sample file repository proxy event mapper polling loop  has completed a scan",
                                               "The Sample file repository proxy event mapper polling loop is about the sleep for 1 second then retry.",
                                               "No action is required.  This is part of the normal operation of the service."),
    EVENT_MAPPER_POLL_LOOP_POST_WAIT("OMRS-FILE-REPOSITORY-0018",
                                                OMRSAuditLogRecordSeverity.INFO,
                                                "The Sample file repository proxy event mapper polling loop has woken.",
                                                "The Sample file repository proxy event mapper loop has woken from its 1 second sleep.",
                                                "No action is required.  This is part of the normal operation of the service."),

    EVENT_MAPPER_POLL_LOOP_INTERRUPTED_EXCEPTION("OMRS-FILE-REPOSITORY-0019",
                                                            OMRSAuditLogRecordSeverity.EXCEPTION,
                                                            "The Sample file repository proxy event mapper polling loop sleep has failed with an interrupted exception",
                                                            "The Sample file repository proxy event mapper's polling loop sleep has been interrupted.",
                                                            "No action is required.  This is part of the normal operation of the service."),
    ;


    private String logMessageId;
    private OMRSAuditLogRecordSeverity severity;
    private String logMessage;
    private String systemAction;
    private String userAction;


    /**
     * The constructor for OMRSAuditCode expects to be passed one of the enumeration rows defined in
     * OMRSAuditCode above.   For example:
     * <p>
     * OMRSAuditCode   auditCode = OMRSAuditCode.SERVER_NOT_AVAILABLE;
     * <p>
     * This will expand out to the 4 parameters shown below.
     *
     * @param messageId    - unique Id for the message
     * @param severity     - the severity of the message
     * @param message      - text for the message
     * @param systemAction - description of the action taken by the system when the condition happened
     * @param userAction   - instructions for resolving the situation, if any
     */
   FileOMRSAuditCode(String messageId, OMRSAuditLogRecordSeverity severity, String message,
                             String systemAction, String userAction) {
        this.logMessageId = messageId;
        this.severity = severity;
        this.logMessage = message;
        this.systemAction = systemAction;
        this.userAction = userAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditLogMessageDefinition getMessageDefinition() {
        return new AuditLogMessageDefinition(logMessageId,
                severity,
                logMessage,
                systemAction,
                userAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditLogMessageDefinition getMessageDefinition(String ...params) {
        AuditLogMessageDefinition messageDefinition = new AuditLogMessageDefinition(logMessageId,
                severity,
                logMessage,
                systemAction,
                userAction);
        messageDefinition.setMessageParameters(params);
        return messageDefinition;
    }

}
