package de.hsh.vehicles;
/**
 * 
 * @author lushaj
 *
 */
public class BMWS1000RR implements RoadVehicle {
    private int wheels = 2;
    
    /**
     * description
     */
    @Override
    public void operate() {
        System.out.println("BMW S1000RR is operating as a sport bike");
    }
    
    /**
     * @return wheels 
     */
    @Override
    public int numberOfWheels() {
        return wheels;
    }


}
