package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.CarDTO;
import com.monnet.challenge.car.caractions.model.DayActionType;
import org.springframework.stereotype.Service;

@Service
public abstract class CarStrategy {

    public abstract DayActionType type();

    public abstract void execute(CarDTO car);
}
