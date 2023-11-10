package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.Operator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OperatorRepository {
    private List<Operator> operators = new ArrayList<>();
    public Operator save(Operator operator) {
        operators.add(operator);
        return operator;
    }
}
