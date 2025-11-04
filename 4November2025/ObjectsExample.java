
public class ObjectsExample {
    private String name;
    private float salary;

    // Constructor
    public ObjectsExample(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter method
    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    // Setters method
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Instance method
    public void displayDetails() {
        System.out.println("Employee: " + name);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        ObjectsExample emp = new ObjectsExample("Jatin" , 10000.0f);
        emp.displayDetails();
    }
}
