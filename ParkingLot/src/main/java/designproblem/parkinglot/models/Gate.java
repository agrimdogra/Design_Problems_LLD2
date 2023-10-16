package designproblem.parkinglot.models;

public abstract class Gate extends BaseModel{
    private Operator operator;
    private int gateNumber;
    private String location;
    private GateStatus gateStatus;
}
