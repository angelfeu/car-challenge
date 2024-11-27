package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.DayActionType;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarDefaultStrategy defaultStrategy;

    private final Map<DayActionType, CarStrategy> carStrategies;

    public CarService(final CarDefaultStrategy defaultStrategy,
                      final List<CarStrategy> carStrategies) {
        this.defaultStrategy = defaultStrategy;
        this.carStrategies = indexByType(carStrategies);
    }

    private Map<DayActionType, CarStrategy> indexByType(
            List<CarStrategy> carStrategies) {

        return carStrategies.stream()
                .filter(s -> s.type() != null)
                .collect(Collectors.toMap(CarStrategy::type, Function.identity()));
    }

    public CarStrategy getActionDay() {
        DayActionType dayActionType = getDay();
        return carStrategies.getOrDefault(dayActionType, defaultStrategy);
    }

    private DayActionType getDay() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        String dayName = day.toString();
        return DayActionType.valueOf(dayName);
    }
}
