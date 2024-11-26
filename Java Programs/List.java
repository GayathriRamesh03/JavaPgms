import java.util.Arrays;

public class List<T> {
    private T[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public List() {
        capacity = 100;
        data = (T[]) new Object[capacity];
        size = 0;
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public void add(T value) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size] = value;
        size++;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
    }

    public void deleteByValue(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                deleteByIndex(i);
                return;
            }
        }
        throw new IllegalArgumentException("Value not found in the list");
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example with Integer
        List<Integer> intList = new List<>();
        intList.add(100);
        intList.add(200);
        intList.add(300);
        intList.printList();
        intList.deleteByIndex(1);
        intList.printList();
        intList.deleteByValue(300);
        intList.printList();

        // Example with String
        List<String> strList = new List<>();
        strList.add("Rahul");
        strList.add("Ananya");
        strList.add("Kavya");
        strList.printList();
        strList.deleteByValue("Ananya");
        strList.printList();
        System.out.println(strList.get(1));

        // Example with Custom Class
        List<Employee> employeeList = new List<>();
        employeeList.add(new Employee("E101", "Ram", 28, "2023-04-10"));
        employeeList.add(new Employee("E102", "Sita", 26, "2022-12-20"));

        // Explicitly printing Employee fields
        for (int i = 0; i < employeeList.getSize(); i++) {
            Employee e = employeeList.get(i);
            System.out.println("ID: " + e.id + ", Name: " + e.name + ", Age: " + e.age + ", Date of Joining: " + e.dateOfJoining);
        }

        // Deleting an Employee
        employeeList.deleteByValue(new Employee("E102", "Sita", 26, "2022-12-20"));

        // Print remaining employees
        for (int i = 0; i < employeeList.getSize(); i++) {
            Employee e = employeeList.get(i);
            System.out.println("ID: " + e.id + ", Name: " + e.name + ", Age: " + e.age + ", Date of Joining: " + e.dateOfJoining);
        }
    }
}

// Employee class with Indian names and attributes
class Employee {
    String id;
    String name;
    int age;
    String dateOfJoining;

    public Employee(String id, String name, int age, String dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id.equals(employee.id) && name.equals(employee.name) && age == employee.age && dateOfJoining.equals(employee.dateOfJoining);
    }
}