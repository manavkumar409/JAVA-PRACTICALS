import java.util.ArrayList;
import java.util.List;

// 1. Generic Class
class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

public class Main {
    // 2. Generic Method
    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 3. Bounded Type Parameter (<T extends Number>)
    public static <T extends Number> double getDoubleValue(T number) {
        return number.doubleValue();
    }

    // 4. Upper Bounded Wildcard (? extends Number)
    public static double sumList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // 5. Lower Bounded Wildcard (? super Integer)
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        // Generic Class & Type Safety
        Box<String> strBox = new Box<>();
        strBox.set("Hello Java Generics");
        System.out.println("Box Value: " + strBox.get());

        // Generic Method
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"A", "B", "C"};
        System.out.print("Integer Array: ");
        printArray(intArray);
        System.out.print("String Array: ");
        printArray(strArray);

        // Bounded Type
        System.out.println("Bounded Double: " + getDoubleValue(42));

        // Wildcard: ? extends Number
        List<Double> doubleList = List.of(2.5, 3.5, 4.0);
        System.out.println("Sum of Numbers: " + sumList(doubleList));

        // Wildcard: ? super Integer
        List<Number> numList = new ArrayList<>();
        addIntegers(numList);
        System.out.println("Super List: " + numList);
    }
}

