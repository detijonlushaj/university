package de.hsh.vehicles;
public class Main {
  public static void main(String[] args) {
    for (Vehicle v : new Vehicle[]{ new BMWS1000RR(), new AnsaldoFiremaT68(), new CommanderSWX315() }) {
      v.operate();
    }
    for (RoadVehicle v : new RoadVehicle[]{ new BMWS1000RR(), new CommanderSWX315() }) {
      System.out.println(v.numberOfWheels());
    }
    for (RailVehicle v : new RailVehicle[]{ new AnsaldoFiremaT68(), new CommanderSWX315() }) {
      System.out.println(v.trackGauge());
    }
  }
}