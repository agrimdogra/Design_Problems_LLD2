package designproblem.parkinglot.models;

import java.time.LocalDateTime;

public abstract class BaseModel {
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
