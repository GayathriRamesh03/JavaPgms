import java.util.Date;

public class Employee {
    // Fields
    private String id;
    private String name;
    private int age;
    private Date dateOfJoining;

    // Constructor
    public Employee(String id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Age: " + age + ", Date of Joining: " + dateOfJoining;
    }
}
