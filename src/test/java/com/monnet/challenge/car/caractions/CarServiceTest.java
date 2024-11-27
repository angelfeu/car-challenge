package com.monnet.challenge.car.caractions;

import com.monnet.challenge.car.caractions.model.DayActionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CarServiceTest {

    private final CarDefaultStrategy carDefaultStrategy = new CarDefaultStrategy();
    private final CarMondayStrategy carMondayStrategy = new CarMondayStrategy();
    private final CarTuesdayStrategy carTuesdayStrategy = new CarTuesdayStrategy();
    private final CarWednesdayStrategy carWednesdayStrategy = new CarWednesdayStrategy();
    private final CarThursdayStrategy carThursdayStrategy = new CarThursdayStrategy();
    private final CarFridayStrategy carFridayStrategy = new CarFridayStrategy();

    private CarService carService;

    @BeforeEach
    void setUp() {
        // Create a mock Map of strategies
        List<CarStrategy> carStrategies = List.of(
                carMondayStrategy,
                carTuesdayStrategy,
                carWednesdayStrategy,
                carThursdayStrategy,
                carFridayStrategy
        );

        // Inject the mock Map into the service
        carService = new CarService(carDefaultStrategy, carStrategies);
    }

    @Test
    void testExecuteStrategy_ValidStrategy() {
        // Invoke the service method
        CarStrategy carStrategy = carService.getActionDay();

        // Verify the correct strategy was executed
        assertEquals(getActionDay().getClass(), carStrategy.getClass());
    }

    private CarStrategy getActionDay() {
        DayActionType dayActionType = getDay();
        return switch (dayActionType) {
            case MONDAY -> carMondayStrategy;
            case TUESDAY -> carTuesdayStrategy;
            case WEDNESDAY -> carWednesdayStrategy;
            case THURSDAY -> carThursdayStrategy;
            case FRIDAY -> carFridayStrategy;
            default -> carDefaultStrategy;
        };
    }

    private DayActionType getDay() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        String dayName = day.toString();
        return DayActionType.valueOf(dayName);
    }
}
