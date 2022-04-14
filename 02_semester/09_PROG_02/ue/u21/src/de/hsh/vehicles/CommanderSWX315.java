package de.hsh.vehicles;

/**
 * 
 * @author lushaj
 *
 */
public class CommanderSWX315 implements RoadRailVehicle {
    private int wheels = 4;
    private int trackgauge = 1435;
    
    /**
     * description
     */
    @Override
    public void operate() {
        System.out.println("Commander SWX 315 is operating as a railcar mover");
    }
    
    /**
     * @return wheels
     */
    @Override
    public int numberOfWheels() {
        return wheels;
    }
    
    /**
     * @return trackgauge
     */
    @Override
    public int trackGauge() {
        return trackgauge;
    }
}
