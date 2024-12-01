package com.stshdlp;

public class IncidentResponseHandler {
    private final LogManager logManager;

    public IncidentResponseHandler(LogManager logManager) {
        this.logManager = logManager;
    }

    public void handleIncident(SecurityEvent event) {
        logManager.log("Handling incident: " + event);
        if ("High".equals(event.getSeverity())) {
            blockThreat();
            notifyAdmin(event);
        }
    }

    private void blockThreat() {
        logManager.log("Threat blocked.");
    }

    private void notifyAdmin(SecurityEvent event) {
        logManager.log("Admin notified about: " + event);
    }
}
