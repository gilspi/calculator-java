import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter your line: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isCorrect = Correct.isCorrect(input);
        if (isCorrect) {
            System.out.println("Result=" + calc(input));
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isRoman(String substring) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean flag = false;
        for (int i = 0; i < roman.length; i++) {
            if (substring.equals(roman[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean isMethod(String str) {
        return str.contains("+") | str.contains("-") | str.contains("/") | str.contains("*");
    }

    public static String calc(String input) {
        String result = "";
        System.out.println("Your string: " + input);
        String[] strings = input.split(" ");
        int[] nums = new int [2];
        String expression="";
        String[] numsRoman = new String [2];
        int countNums = 0; // для индекса численного массива
        int countRoman = 0; // для индекса римского массива

        for (int i = 0; i < strings.length; i++) {
            if (isNumeric(strings[i])) {
                nums[countNums] = Integer.parseInt(strings[i]);
                countNums++;
            }

            if (isRoman(strings[i])){
                numsRoman[countRoman] = strings[i];
                countRoman++;
            }
            if (isMethod(strings[i])) {
                expression = strings[i];
                System.out.println("Expression: " + expression);
            }
        }

        if (countNums == 2){
            result = Calculate.calculate(nums[0], expression, nums[1]);
        }

        if (countRoman == 2){
            result = Calculate.calculate(numsRoman[0], expression, numsRoman[1]);
        }
        return result;
    };
}


class Correct extends Main{
    static String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean isCorrect(String string) {
        String[] strings = string.split(" ");
        int count = 0;

        if (strings.length == 0 | strings.length > 3) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор " +
                    "(+, -, /, *)");
        } else {
            count = getCount(strings, arab, count) | getCount(strings, roman, count);
        }

        if (count == 2) {
            return true;
        } else {
            throw new RuntimeException("Enter correct data!");
        }
    }


    public static int getCount(String[] strings, String[] basicStrings, int count) {
        for (String s : basicStrings) {
            if (strings[0].equals(s)) {
                count++;
            }

            if (strings[2].equals(s)) {
                count++;
            }
        }
        return count;
    }
}


class Calculate extends Main {

    public static String calculate (int var1, String expression, int var2) {
        int result = 0;

        switch (expression) {
            case "+" -> result = var1 + var2;
            case "-" -> result = var1 - var2;
            case "/" -> result = var1 / var2;
            case "*" -> result = var1 * var2;
            default -> throw new RuntimeException("Please, enter correct expression!");
        }
        return Integer.toString(result);
    }


    public static String calculate (String variable1, String expression, String variable2) {
        int result = 0;

        switch (expression) {
            case "+" -> result = romanToArab(variable1) + romanToArab(variable2);
            case "-" -> result = romanToArab(variable1) - romanToArab(variable2);
            case "/" -> result = romanToArab(variable1) / romanToArab(variable2);
            case "*" -> result = romanToArab(variable1) * romanToArab(variable2);
            default -> throw new RuntimeException("Please, enter correct expression!");
        }

        if (result <= 0){
            throw new RuntimeException("Roman number has only over 1!");
        } else {
            return arabToRoman(result);
        }
    }

    static int romanToArab (String substring) {
        return Roman.valueOf(substring).getNumber();
    }

    static String arabToRoman (int num) {
        String roman = "";
        for (Roman value: Roman.values()){
            if (num == value.getNumber()){
                roman = value.getName();
            }
        }
        return roman;
    }
}
