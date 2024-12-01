package com.stshdlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StealthShieldDlpApplication {
	private final LogManager logManager;
	private final NetworkSecurityController networkController;
	private final IncidentResponseHandler incidentHandler;

	public StealthShieldDlpApplication() {
		this.logManager = new LogManager();
		this.networkController = new NetworkSecurityController(logManager);
		this.incidentHandler = new IncidentResponseHandler(logManager);
	}

	public void start() {
		logManager.log("Initializing DLP System...");
		networkController.startMonitoring(event -> {
			logManager.log("Security event detected: " + event);
			incidentHandler.handleIncident(event);
		});
		logManager.log("DLP System is running.");
	}

	public static void main(String[] args) {
		SpringApplication.run(StealthShieldDlpApplication.class, args);
		new StealthShieldDlpApplication().start();
	}

}
