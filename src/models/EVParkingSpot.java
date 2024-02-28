package models;

import models.enums.ChargerStatus;

public class EVParkingSpot extends ParkingSpot{
    private ChargerStatus chargerStatus;

    public EVParkingSpot() {
    }

    public EVParkingSpot(ChargerStatus chargerStatus) {
        this.chargerStatus = chargerStatus;
    }

    public ChargerStatus getChargerStatus() {
        return chargerStatus;
    }

    public void setChargerStatus(ChargerStatus chargerStatus) {
        this.chargerStatus = chargerStatus;
    }
}
