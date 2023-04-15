import java.util.Scanner;

public class Main {
    static final String EXCEPTION = "throws Exception";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arithmeticExpression = scanner.nextLine();
        System.out.println(calc(arithmeticExpression));

    }
    public static String calc(String input) {
        String sign;
        String[] data = input.split("\\s{1}+[\\-+*/]+\\s{1}");
        if (data.length != 2) systemExit();
        sign = determinationOperation(input);
        int[] number = tryParseInt(data);
        return action(number[0], number[1], sign);
    }

    static String determinationOperation(String operation) {
        if (operation.contains("-")) return "-";
        else if (operation.contains("+")) return "+";
        else if (operation.contains("*")) return "*";
        else if (operation.contains("/")) return "/";
        else systemExit();
        return " ";
    }

    static String action(int one, int two, String sign) {
        int res = 0;
        switch (sign){
            case "-":
                res = one - two;
                break;
            case "+":
                res = one + two;
                break;
            case "/":
                res = one / two;
                break;
            case "*":
                res = one * two;
                break;
        }
        return Integer.toString(res);
    }

    static int[] tryParseInt(String[] data) {
        int[] number = new int[data.length];
        try {
            for (int i = 0; i < 2 ; i++) { //  проверка на 0 - 10 и парс
                if (Integer.parseInt(data[i]) > 0 && Integer.parseInt(data[i]) <= 10)
                    number[i] = Integer.parseInt(data[i]);
                else systemExit();
            }
        } catch(NumberFormatException e) {
            systemExit();
        }
        return number;
    }

    static void systemExit() {
        System.out.print(EXCEPTION);
        System.exit(0);
    }
}