import controller.BillController;
import controller.InitializationController;
import controller.PaymentController;
import controller.TicketController;
import models.*;
import models.enums.ParkingLotStatus;
import models.enums.VehicleType;
import repository.*;
import services.InitializationService;
import services.PaymentService;
import services.TicketService;

import java.util.Scanner;

public class MainParkingLot {
    public static void main(String[] args) throws InterruptedException {
        GateRepository gateRepository = new GateRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        TicketRepository ticketRepository = new TicketRepository();
        BillRepository billRepository = new BillRepository();
        PaymentRepository paymentRepository = new PaymentRepository();
        InitializationService  initializationService = new InitializationService(gateRepository, parkingSpotRepository,
                parkingLotRepository, parkingFloorRepository, ticketRepository, billRepository, paymentRepository);
        InitializationController initializationController = new InitializationController(initializationService);

        ParkingLot parkingLot = initializationController.init();

        System.out.println("Your System is ready");

        Scanner userInput = new Scanner(System.in);
        if(parkingLot.getParkingLotStatus().equals(ParkingLotStatus.NOT_AVAILABLE) ||
                parkingLot.getParkingLotStatus().equals(ParkingLotStatus.UNDER_MAINTENANCE)){
            System.out.println("We are sorry our "+parkingLot.getName()+" parking lot is:" + parkingLot.getParkingLotStatus());
        }
        else {
            while (true) {
                System.out.println("Please select the option: \n1 Enter the parking lot \n2 Exit the parking lot \n3 Payment \n4 Exit");
                int option = userInput.nextInt();
                Ticket ticket = null;

                if(option == 1) {
                    Vehicle vehicle = new Vehicle();
                    System.out.println("Please Enter the Vehicle Number:");
                    String vehicleNumber = userInput.next();
                    System.out.println("Please Enter the Vehicle Color:");
                    String vehicleColor = userInput.next();
                    System.out.println("Please Enter the Vehicle Type:");
                    String vehicle_type = userInput.next();
                    vehicle.setVehicleNumber(vehicleNumber);
                    vehicle.setColor(vehicleColor);
                    vehicle.setVehicleType(getVehicleType(vehicle_type));
                    TicketService ticketService = new TicketService(parkingLot, vehicle, ticketRepository, parkingSpotRepository);
                    TicketController ticketController = new TicketController(ticketService);
                    ticketController.getTicket();
                }
                else if(option == 2) {
                    System.out.println("Please enter ticket ID:");
                    int ticketId = userInput.nextInt();
                    BillController billController = new BillController(billRepository, parkingFloorRepository, parkingSpotRepository, ticketRepository);
                    Bill bill = billController.billGenerator(ticketId);
                    System.out.println("Your Bill amount: ");
                    System.out.println(bill.getAmount());
                }
                else if(option == 3) {
                    System.out.println("Please enter Bill ID:");
                    int billId = userInput.nextInt();
                    PaymentService paymentService = new PaymentService();
                    PaymentController paymentController = new PaymentController(paymentService);
                    paymentController.payBill(billId);
                }
                else if(option == 4) {
                    System.out.println("Thank you for visiting");
                    break;
                }
            }
        }
    }

    private static VehicleType getVehicleType(String vehicle_type){
        if(vehicle_type.equalsIgnoreCase(String.valueOf(VehicleType.EV_VEHICLE))) return VehicleType.EV_VEHICLE;
        if(vehicle_type.equalsIgnoreCase(String.valueOf(VehicleType.LUXURY_VEHICLE))) return VehicleType.LUXURY_VEHICLE;
        if(vehicle_type.equalsIgnoreCase(String.valueOf(VehicleType.FOUR_WHEELER))) return VehicleType.FOUR_WHEELER;
        return VehicleType.TWO_WHEELER;
    }
}
