
public class EmployeeEncapsulate {

    private String name;
    private double salary;
    private int experience;
    private String department;

    public EmployeeEncapsulate(String name, double salary, int experience, String department) {
        this.name = name;
        setSalary(salary);
        setExperience(experience);
        setDepartment(department);
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Salary cannot be negative.");
        } else {
            this.salary = salary;
        }
    }

    public void setExperience(int experience) {
        if (experience < 0) {
            System.out.println("Experience cannot be negative.");
        } else {
            this.experience = experience;
        }
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            System.out.println("Department cannot be empty.");
        } else {
            this.department = department;
        }
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Department: " + department);
    }

    public void giveRaise(double raisePercentage) {
        if (raisePercentage > 0) {
            double raiseAmount = (salary * raisePercentage) / 100;
            salary += raiseAmount;
            System.out.println("Employee's new salary after " + raisePercentage + "% raise: $" + salary);
        } else {
            System.out.println("Raise percentage must be positive.");
        }
    }

    public static void main(String[] args) {
        EmployeeEncapsulate employee = new EmployeeEncapsulate("Jatin Mistry", 50000, 5, "Developer");
        employee.displayInfo();

        employee.giveRaise(10);
        employee.displayInfo();
        employee.setSalary(-2000);
        employee.setExperience(-5);
        employee.setDepartment("");
    }
}
