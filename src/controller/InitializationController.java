package controller;

import models.ParkingLot;
import services.InitializationService;

public class InitializationController {
    private final InitializationService initializationService;

    public InitializationController(InitializationService initializationService){
        this.initializationService = initializationService;
    }

    public ParkingLot init(){
        return initializationService.init();
    }
}
