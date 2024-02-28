package models;

import models.enums.GuardStatus;

public class LuxuryParkingSpot extends ParkingSpot{
    private GuardStatus guardStatus;

    public LuxuryParkingSpot() {
    }

    public LuxuryParkingSpot(GuardStatus guardStatus) {
        this.guardStatus = guardStatus;
    }

    public GuardStatus getGuardStatus() {
        return guardStatus;
    }

    public void setGuardStatus(GuardStatus guardStatus) {
        this.guardStatus = guardStatus;
    }
}
