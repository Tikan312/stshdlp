package com.stshdlp;

import java.util.function.Consumer;

public class NetworkSecurityController {
    private final LogManager logManager;
    private boolean monitoring;

    public NetworkSecurityController(LogManager logManager) {
        this.logManager = logManager;
        this.monitoring = false;
    }

    public void startMonitoring(Consumer<SecurityEvent> eventHandler) {
        monitoring = true;
        logManager.log("Network monitoring started.");
        // Simulazione di un evento di sicurezza
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                SecurityEvent event = new SecurityEvent("Unauthorized Access", "High");
                if (monitoring) {
                    eventHandler.accept(event);
                }
            } catch (InterruptedException e) {
                logManager.log("Monitoring interrupted.");
            }
        }).start();
    }

    public void stopMonitoring() {
        monitoring = false;
        logManager.log("Network monitoring stopped.");
    }
}
