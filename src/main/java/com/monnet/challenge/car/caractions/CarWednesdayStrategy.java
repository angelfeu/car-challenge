package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.CarDTO;
import com.monnet.challenge.car.caractions.model.DayActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarWednesdayStrategy extends CarStrategy {

    @Override
    public DayActionType type() {
        return DayActionType.WEDNESDAY;
    }

    @Override
    public void execute(CarDTO car) {
        car.setMake("Toyota");
        car.setModel("SW4");
        car.setAction("Offroad");
        log.info("Wednesday: " + car.toString());
    }

}
