import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    ArrayList<Product> productsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

       public void input() {
       System.out.println("После ввода всех товаров введите команду Завершить");
       String name;
       double price;
          System.out.println("Введите название товара");
       while (true) {
           name = scanner.nextLine().trim();
           if (name.equalsIgnoreCase("Завершить")) {
               productPrint();
               break;
               } else {
               System.out.println("Введите его стоимость через точку в формате рубли.копейки (00.00)");
               scanner.useLocale(Locale.ENGLISH);
                while (!scanner.hasNextDouble()) {
                   System.out.println("Вы неверно ввели стоимость. Введите в формате рубли.копейки");
                   scanner.nextLine(); // Очищаем неправильный ввод
               }

               price = scanner.nextDouble();
               productsList.add(new Product(name, price));

               System.out.printf(String.format("Товар %s успешно добавлен, цена  %.2f\n", name, price));
               System.out.println("Добавьте еще товар. Или введите команду Завершить");
               name = scanner.nextLine();

           }
       }
   }

   public void productPrint() {
        System.out.println("Добавленные товары:");
        for (Product product : productsList) {
            System.out.printf("%s %.2f \n", product.getName(), product.getPrice());
        }
    }
    public void finalCalculation(int people, Formatter formatter) {
        System.out.printf("Общий счет: %.2f %s\n", totalSum(), formatter.formatter(totalSum()));
          System.out.println("Выводим окончательный расчет");
        Double finalCalc = totalSum() / people;
               System.out.printf(String.format("Для каждого из " + people + " человек сумма к оплате %.2f %s", finalCalc, formatter.formatter(finalCalc)));
        }
    public double totalSum() {
        Double sum = 0.0;
        for (Product product : productsList) {
            sum += product.getPrice();
        }
        return sum;
    }
}


