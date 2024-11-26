import java.util.Arrays;
import java.util.Scanner;

public class MyList {
    private int[] data;
    private int size;
    private int capacity;

    public MyList() {
        capacity = 100;
        data = new int[capacity];
        size = 0;
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public void add(int value) {
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
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
    }

    public void deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                deleteByIndex(i);
                return;
            }
        }
        throw new IllegalArgumentException("Value not found in the list");
    }

    public int get(int index) {
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
        MyList list = new MyList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MyList Operations ---");
            System.out.println("1. Add");
            System.out.println("2. Delete by Index");
            System.out.println("3. Delete by Value");
            System.out.println("4. Get Element");
            System.out.println("5. Print List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int value = scanner.nextInt();
                    list.add(value);
                    System.out.println("Added " + value + " to the list.");
                    break;

                case 2:
                    System.out.print("Enter index to delete: ");
                    int index = scanner.nextInt();
                    try {
                        list.deleteByIndex(index);
                        System.out.println("Deleted element at index " + index + ".");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    int delValue = scanner.nextInt();
                    try {
                        list.deleteByValue(delValue);
                        System.out.println("Deleted value " + delValue + " from the list.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter index to retrieve: ");
                    int getIndex = scanner.nextInt();
                    try {
                        int element = list.get(getIndex);
                        System.out.println("Element at index " + getIndex + ": " + element);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Current list:");
                    list.printList();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
