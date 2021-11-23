
/** A class to represent secretaries. */
public class Secretary extends Employee {
    public Secretary(int years) {
        super(years);
    }
    /** Secretaries don't get a bonus for their years of service. */
    @Override public int getSeniorityBonus() {
        return 0;
    }
    public void takeDictation(String text) {
        System.out.println("Taking dictation of text: " + text);
    }
    @Override public boolean hasHoursBonus() {
        return (getYears() >= 10);
    }
}
