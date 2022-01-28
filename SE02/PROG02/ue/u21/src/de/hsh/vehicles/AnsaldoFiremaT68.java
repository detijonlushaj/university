package de.hsh.vehicles;
/**
 * 
 * @author lushaj
 *
 */
public class AnsaldoFiremaT68 implements RailVehicle {
    private int trackgauge = 1435;
    
    /**
     * description
     */
    @Override
    public void operate() {
        System.out.println("Ansaldo Firema T-68 is operating as a light rail passenger vehicle");
    }
    
    /**
     * @return trackgauge
     */
    @Override
    public int trackGauge() {
        return trackgauge;
    }
}
