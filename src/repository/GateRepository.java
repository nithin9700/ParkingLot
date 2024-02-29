package repository;

import java.util.HashMap;
import models.Gate;
import Exception.InvalidGateID;

public class GateRepository {
    private final HashMap<Integer, Gate> gateTable;
    private int gateId = 0;


    public GateRepository() {
        this.gateTable = new HashMap<>();
    }

    public void set(Gate gate){
        gateTable.put(++gateId, gate);
        System.out.println("gate has been added to repository" + gateId);
    }

    public Gate get(int gateId){
        Gate gate = gateTable.get(gateId);
        if(gate == null) throw new InvalidGateID("Gate id was not found in dataBase : " + gateId);
        return gate;
    }


}
