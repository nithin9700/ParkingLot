import controller.InitializationController;
import models.ParkingLot;
import repository.*;
import services.InitializationService;

public class MainParkingLot {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();

        
        InitializationService  initializationService = new InitializationService(gateRepository, parkingSpotRepository, parkingLotRepository, parkingFloorRepository);
        
        InitializationController initializationController = new InitializationController(initializationService);
        

        ParkingLot parkingLot = initializationController.init();

        System.out.println(parkingLot);
        System.out.println("System was created");


    }
}
