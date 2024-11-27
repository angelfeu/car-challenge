package com.monnet.challenge.car.caractions.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarSecretAgentDTO extends CarDTO {

    private String armament;
    private Boolean camuflagActivated;

}
