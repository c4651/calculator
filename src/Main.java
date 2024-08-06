import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        Scanner s = new Scanner(input).useDelimiter("\\s");
        int a = s.nextInt();
        String operation = s.next();
        int b = s.nextInt();
        int result;

        if (s.hasNext()) throw new RuntimeException("Неккоректный ввод");
        if (a < 1 || a > 10 || b < 1 || b > 10) throw new RuntimeException("Используйте числа от 1 до 10");

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new RuntimeException("Недопустимая операция");
        }

        return String.valueOf(result);
    }
}