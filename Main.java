import java.util.Scanner;

class Main {

    static String calc(String input) {
        String[] chasti = input.split(" "); // разбила входную строку на части по пробелам -> в массив строк

        if (chasti.length != 3) {
            throw new IllegalArgumentException("throws Exception");
        }// если количество частей после разбиения равно 3, то все ок. Если нет, то генерится исключение

        int pervoyeChislo = Integer.parseInt(chasti[0]);
        String mathAction = chasti[1];
        int vtoroyeChislo = Integer.parseInt(chasti[2]);

         if (pervoyeChislo < 1 || pervoyeChislo > 10 || vtoroyeChislo < 1 || vtoroyeChislo > 10) {
            throw new NumberFormatException("throws Exception");
        }

        int result = 0;

        switch (mathAction) {
            case "+":
                result = pervoyeChislo + vtoroyeChislo;
                break;

            case "-":
                result = pervoyeChislo - vtoroyeChislo;
                break;

            case "*":
                result = pervoyeChislo * vtoroyeChislo;
                break;

            case "/":
                if (vtoroyeChislo == 0) {
                    throw new IllegalArgumentException("throws Exception") ;
                }
                result = pervoyeChislo / vtoroyeChislo;
                break;

            default:
                throw new IllegalArgumentException("throws Exceptio");
        }

        return String.valueOf(result); // возврат результата как строки
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ввод с консоли

        System.out.println("Введи простое выражение с двумя переменными. Пример: 4 + 5. Числа должны быть целыми, в промежутке от 1 до 10 включительно. Нельзя использовать больше двух чисел. Между числами должны стоять операторы (+, -, /, *): ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Итог: " + result);
        } catch (NumberFormatException e) {
            System.out.println("throws Exception");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } // попытка вычислить результат, вызывая  calc
    }
}
