
public class Employee {
    private int years;

    public Employee(int initialYears) {
        years= initialYears;
    }
    public int getHours() {
        int hours= 40;
        if (hasHoursBonus()) {
            hours -= 2;
        }
        return hours;  
    }
    public double getSalary() {
        return 50000.0;
    }
    public int getVacationDays() {
        return 30 + getSeniorityBonus();
    }
    public int getSeniorityBonus() {
        return 2 * years;
    }
    public String getVacationForm() {
        return "yellow";
    }
    public boolean hasHoursBonus() {
        return false;
    }
    public int getYears() {
        return years;
    }
}