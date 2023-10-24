package designproblem.parkinglot.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public abstract class BaseModel {
    protected UUID id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
