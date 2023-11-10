package designproblem.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String email;
}
