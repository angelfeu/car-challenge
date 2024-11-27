package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.CarDTO;
import com.monnet.challenge.car.caractions.model.DayActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarTuesdayStrategy extends CarStrategy {

    @Override
    public DayActionType type() {
        return DayActionType.TUESDAY;
    }

    @Override
    public void execute(CarDTO car) {
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setAction("carreras");
        log.info("Tuesday: " + car.toString());
    }

}
