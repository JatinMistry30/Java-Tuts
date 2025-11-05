import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // ---- Inner Student class ----
    static class Student {
        private int id;
        private String name;
        private int age;
        private String grade;
        private double marks;

        public Student(int id, String name, int age, String grade, double marks) {
            this.id = id;
            setName(name);
            setAge(age);
            setGrade(grade);
            setMarks(marks);
        }

        public int getId() { return id; }

        public String getName() { return name; }
        public void setName(String name) {
            if (name == null || name.trim().isEmpty())
                System.out.println("Invalid name.");
            else
                this.name = name;
        }

        public int getAge() { return age; }
        public void setAge(int age) {
            if (age < 5)
                System.out.println("Age must be at least 5.");
            else
                this.age = age;
        }

        public String getGrade() { return grade; }
        public void setGrade(String grade) {
            if (grade == null || grade.trim().isEmpty())
                System.out.println("Grade cannot be empty.");
            else
                this.grade = grade;
        }

        public double getMarks() { return marks; }
        public void setMarks(double marks) {
            if (marks < 0 || marks > 100)
                System.out.println("Marks must be between 0 and 100.");
            else
                this.marks = marks;
        }

        public void displayInfo() {
            System.out.println("ID: " + id + ", Name: " + name +
                ", Age: " + age + ", Grade: " + grade + ", Marks: " + marks);
        }
    }

    // ---- Main class logic ----
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int id) {
        Student found = null;
        for (Student s : students) {
            if (s.getId() == id) {
                found = s;
                break;
            }
        }
        if (found != null) {
            students.remove(found);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void updateMarks(int id, double newMarks) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setMarks(newMarks);
                System.out.println("Marks updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }

    // ---- Main method ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    sms.addStudent(new Student(id, name, age, grade, marks));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    sms.removeStudent(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    sms.searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID to update marks: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();
                    sms.updateMarks(sid, newMarks);
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
