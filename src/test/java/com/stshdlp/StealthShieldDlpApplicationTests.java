package com.stshdlp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import({LogManager.class, NetworkSecurityController.class, IncidentResponseHandler.class})
class StealthShieldDlpApplicationTests {

	@Test
	void contextLoads() {
		LogManager logManager = new LogManager();
		NetworkSecurityController controller = new NetworkSecurityController(logManager);
		IncidentResponseHandler handler = new IncidentResponseHandler(logManager);

		SecurityEvent event = new SecurityEvent("Test Event", "High");
		assertNotNull(event);
		assertEquals("High", event.getSeverity());
		assertEquals("Test Event", event.getDescription());
	}

	@Test
	void testIncidentHandler() {
		LogManager logManager = new LogManager();
		IncidentResponseHandler handler = new IncidentResponseHandler(logManager);
		SecurityEvent event = new SecurityEvent("Test Threat", "High");
		handler.handleIncident(event);
	}

}
