package models;

import models.enums.GateStatus;
import models.enums.GateType;

public class Gate extends BaseModel{
    private GateStatus gateStatus;
    private GateType gateType;
    private int gateNumber;
    private String operator;

    public Gate() {
    }

    public Gate(GateStatus gateStatus, GateType gateType, int gateNumber, String operator) {
        this.gateStatus = gateStatus;
        this.gateType = gateType;
        this.gateNumber = gateNumber;
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
