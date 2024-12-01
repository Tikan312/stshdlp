package com.stshdlp;

public class SecurityEvent {
    private final String description;
    private final String severity;

    public SecurityEvent(String description, String severity) {
        this.description = description;
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "SecurityEvent{description='" + description + "', severity='" + severity + "'}";
    }
}
