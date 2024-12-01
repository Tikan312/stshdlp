package com.stshdlp;

import java.time.LocalDateTime;

public class LogManager {
    public void log(String message) {
        System.out.println(LocalDateTime.now() + " - " + message);
    }
}
