/** A class to represent legal secretaries. */
public class LegalSecretary extends Secretary {
    public LegalSecretary(int years) {
        super(years);
    }
    public void keepDeadline() {
        System.out.println("I know the deadline!");
    }
    @Override public double getSalary() {
        return super.getSalary() + 5000.0;      
    }
}

