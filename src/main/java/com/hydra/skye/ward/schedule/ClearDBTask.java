package com.hydra.skye.ward.schedule;

import com.hydra.skye.ward.service.CargoService;
import com.hydra.skye.ward.service.DozenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yahto on 26/03/2018
 */
@Component
public class ClearDBTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClearDBTask.class);
    @Autowired
    private CargoService cargoService;
    @Autowired
    private DozenService dozenService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void clearDB() {
        LOGGER.info("-------clear left_count=0 dozen start----");
        int result = dozenService.clear();
        LOGGER.info("-------clear left_count=0 dozen finish----,effect " + result + " rows");
        LOGGER.info("-------clear count=0 cargo start----");
        int res = cargoService.clear();
        LOGGER.info("-------clear count=0 cargo finish----,effect " + res + "rows");
    }
}
