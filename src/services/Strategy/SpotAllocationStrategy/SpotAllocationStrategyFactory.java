package services.Strategy.SpotAllocationStrategy;

import models.enums.SpotAllocationStrategyType;

import java.util.Stack;

public class SpotAllocationStrategyFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy(SpotAllocationStrategyType spotAllocationStrategyType){
        return new LinearSpotAllocationStrategy();
    }
}
