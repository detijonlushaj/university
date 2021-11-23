public class Lawyer extends Employee {
    public Lawyer(int years) {
        super(years);  // calls Employee constructor
    }
    @Override public String getVacationForm() {
        return "blue";
    }
    @Override public int getVacationDays() {
        return super.getVacationDays()-5;
    }
    public void sue() {
        System.out.println("I'll see you in court!");
    }
}
