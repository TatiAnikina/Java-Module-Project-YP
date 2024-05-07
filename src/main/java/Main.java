import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в калькулятор счета");
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        int people = Counter.getQuantity();
        calculator.input();
        calculator.finalCalculation(people, formatter);
    }

    static class Counter {

        public static int getQuantity() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("На сколько человек необходимо разделить счет?");
            int quantity;

            while (true) {
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    if (quantity < 1) {
                        System.out.println("Введите корректное значение больше одного");
                    } else if (quantity == 1) {
                        System.out.println("На одного человека нельзя разделить счет");
                    } else {
                        System.out.println("Счет разделим на " + quantity + "-х человек");
                        break;
                    }
                } else {
                    System.out.println("Нужно ввести количество человек");
                    scanner.next(); // Очищаем неправильный ввод
                }
            }
            return quantity;
        }
    }
}
