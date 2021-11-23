public class EmployeeClient {   
    public static void main(String[] args) {
        Employee employee= new Employee(0);
        System.out.println("Employee uses " + employee.getVacationForm() + " form");

        Secretary secretary= new Secretary(1);
        System.out.println("Secretary uses " + secretary.getVacationForm() + " form");
        secretary.takeDictation("Hello World");

        Lawyer lawyer= new Lawyer(5);
        System.out.println("Lawyer uses " + lawyer.getVacationForm() + " form");
        System.out.println("Lawyer gets " + lawyer.getVacationDays() + " vacation days");
    }
}