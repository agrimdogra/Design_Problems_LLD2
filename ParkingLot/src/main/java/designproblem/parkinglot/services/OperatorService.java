package designproblem.parkinglot.services;

import designproblem.parkinglot.models.Operator;
import designproblem.parkinglot.repositories.OperatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OperatorService {
    private OperatorRepository operatorRepository;
    public Operator saveOperator(Operator operator) {
        Operator persistedOperator = operatorRepository.save(operator);
        return persistedOperator;
    }
}
