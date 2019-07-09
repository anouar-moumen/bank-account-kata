package com.kata;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Operation {

    private String description;

    private LocalDateTime operationDate;

    private float amount;
}
