package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.CarDTO;
import com.monnet.challenge.car.caractions.model.DayActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarThursdayStrategy extends CarStrategy {

    @Override
    public DayActionType type() {
        return DayActionType.THURSDAY;
    }

    @Override
    public void execute(CarDTO car) {
        car.setMake("Toyota");
        car.setModel("SW4");
        car.setAction("Offroad");
        log.info("Thursday: " + car.toString());
    }

}
