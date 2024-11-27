package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.CarDTO;
import com.monnet.challenge.car.caractions.model.DayActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarMondayStrategy extends CarStrategy {

    @Override
    public DayActionType type() {
        return DayActionType.MONDAY;
    }

    @Override
    public void execute(CarDTO car) {
        car.setMake("Nissan");
        car.setModel("Versa");
        car.setAction("Job");
        log.info("Monday: " + car.toString());
    }

}
