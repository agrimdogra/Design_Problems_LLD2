package designproblem.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@SuperBuilder
@AllArgsConstructor
@Data
public class Operator extends BaseModel{
    private User user;
    List<Role> roles = List.of(Role.OPERATOR);
}
