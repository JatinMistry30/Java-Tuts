class Employee {
    private int id;
    private String name;

    // Setter method
    public void SetId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Encapsulate {
    public static void main(String[] args) {
        Employee emp = new Employee();

        // Using setters
        emp.SetId(101);
        emp.setName("Jatin");

        // Using getters
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
    }
}
