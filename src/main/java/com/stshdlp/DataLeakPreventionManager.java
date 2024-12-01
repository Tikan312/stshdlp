package com.stshdlp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataLeakPreventionManager implements DLPManag {

    private static final Logger logger = LoggerFactory.getLogger(DataLeakPreventionManager.class);

    @Override
    public void detectThreats() {
        logger.info("Запущен процесс обнаружения угроз.");
        try {
            Thread.sleep(2000);
            logger.info("Обнаружены угрозы: 3 подозрительных действия.");
        } catch (InterruptedException e) {
            logger.error("Ошибка при обнаружении угроз.", e);
        }
    }

    @Override
    public void respondToIncidents() {
        logger.info("Запущен процесс реагирования на инциденты.");
        try {
            Thread.sleep(2000);
            logger.info("Реагирование завершено: заблокированы 2 IP-адреса.");
        } catch (InterruptedException e) {
            logger.error("Ошибка при реагировании на инциденты.", e);
        }
    }
}
