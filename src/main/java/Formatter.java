public class Formatter {
    public String formatter(double sumForOne) {


        if (sumForOne % 100 >= 11 && sumForOne % 100 <= 19) {
            return "рублей";
        } else if (sumForOne % 10 == 1) {
            return "рубль";
        } else if (sumForOne % 10 >= 2 && sumForOne % 10 <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }

    }
}
