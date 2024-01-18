import java.util.Scanner;

enum RomanNumbers {
    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4),
    V("V", 5), VI("VI", 6), VII("VII", 7), VIII("VIII", 8),
    IX("IX", 9), X("X", 10);

    private String name;
    private int value;

    RomanNumbers(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        if (input.length != 3) throw new RuntimeException("Неверный формат ввода");

        int a;
        int b;
        int result;

        if (isRoman(input[0]) && isRoman(input[2])) {
            a = toArabic(input[0]);
            b = toArabic(input[2]);
            if (a < 1 || a > 10 || b < 1 || b > 10) throw new RuntimeException("Используйте числа от 1 до 10");
            result = calc(input[1], a, b);
            if (result < 1) throw new RuntimeException("в римской системе счисления нет отрицательных чисел");
            System.out.println(toRoman(result));

        } else if (!isRoman(input[0]) && !isRoman(input[2])) {
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[2]);
            if (a < 1 || a > 10 || b < 1 || b > 10) throw new RuntimeException("Используйте числа от 1 до 10");
            result = calc(input[1], a, b);
            System.out.println(result);

        } else {
            throw new RuntimeException("Используйте одну систему счисления");
        }
    }

    private static boolean isRoman(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static int toArabic(String s) {
        RomanNumbers number = RomanNumbers.valueOf(s);
        return number.getValue();
    }

    private static String toRoman(int number) {
        StringBuilder result = new StringBuilder();
        if (number <= 9) { //от 1 до 9
            result.append(toRomanPart(number));
        } else if (number >= 10 && number <= 19) { //от 10 до 19
            result.append("X");
            result.append(toRomanPart(number % 10));
        } else if (number >= 20 && number <= 29) {
            result.append("XX");
            result.append(toRomanPart(number % 10));
        } else if (number >= 30 && number <= 39) {
            result.append("XXX");
            result.append(toRomanPart(number % 10));
        } else if (number >= 40 && number <= 49) {
            result.append("XL");
            result.append(toRomanPart(number % 10));
        } else if (number >= 50 && number <= 59) {
            result.append("L");
            result.append(toRomanPart(number % 10));
        } else if (number >= 60 && number <= 69) {
            result.append("LX");
            result.append(toRomanPart(number % 10));
        } else if (number >= 70 && number <= 79) {
            result.append("LXX");
            result.append(toRomanPart(number % 10));
        } else if (number >= 80 && number <= 89) {
            result.append("LXXX");
            result.append(toRomanPart(number % 10));
        } else if (number >= 90 && number <= 99) {
            result.append("XC");
            result.append(toRomanPart(number % 10));
        } else if (number == 100) {
            result.append("C");
        }
        return result.toString();
    }

    private static StringBuilder toRomanPart(int number) {
        StringBuilder result = new StringBuilder("");
        switch (number) {
            case 1:
                result.append("I");
                break;
            case 2:
                result.append("II");
                break;
            case 3:
                result.append("III");
                break;
            case 4:
                result.append("IV");
                break;
            case 5:
                result.append("V");
                break;
            case 6:
                result.append("VI");
                break;
            case 7:
                result.append("VII");
                break;
            case 8:
                result.append("VIII");
                break;
            case 9:
                result.append("IX");
                break;
        }
        return result;
    }

    private static int calc(String s, int a, int b) {
        int result;
        switch (s) {
            case "+":
                result = sum(a, b);
                break;
            case "-":
                result = subtract(a, b);
                break;
            case "*":
                result = multiply(a, b);
                break;
            case "/":
                result = divide(a, b);
                break;
            default:
                throw new RuntimeException("Неккоретная математическая операция");
        }
        return result;
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}

