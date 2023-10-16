package designproblem.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class Operator extends BaseModel{
    private User user;
    List<Role> roles = List.of(Role.OPERATOR);
}
