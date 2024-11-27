package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.CarDTO;
import com.monnet.challenge.car.caractions.model.CarSecretAgentDTO;
import com.monnet.challenge.car.caractions.model.DayActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarFridayStrategy extends CarStrategy {

    @Override
    public DayActionType type() {
        return DayActionType.FRIDAY;
    }

    @Override
    public void execute(CarDTO car) {
        car.setMake("Toyota");
        car.setModel("Corolla");
        car.setAction("Secret Agent");
        CarSecretAgentDTO carSecretAgent = (CarSecretAgentDTO) car;
        carSecretAgent.setArmament("AK47");
        carSecretAgent.setCamuflagActivated(true);
        log.info("Friday: " + carSecretAgent.toString());
    }

}
