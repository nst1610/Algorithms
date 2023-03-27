import java.util.Scanner;

// Хорошестью строки называется количество позиций от 1 до L-1 (где L — длина строки),
// таких, что следующая буква в строке является следующей по алфавиту. Например, хорошесть
// строки "abcdefghijklmnopqrstuvwxyz" равна 25, а строки "abdc" — только 1.

// Первая строка ввода содержит единственное целое число N — количество различных букв в наборе
// Обратите внимание: в наборе всегда используются N первых букв латинского алфавита.
// Следующие N строк содержат целые положительные числа ci — количество букв соответствующего типа.
// Таким образом, первое число означает количество букв "a", второе число задаёт количество букв "b" и т.д.

// Выведите единственное целое число — максимально возможную хорошесть строки,
// которую можно собрать из имеющихся дощечек.

public class GoodString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int[] countOfLetter = new int[N];
        for (int i = 0; i < N; i++){
            countOfLetter[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(goodString(countOfLetter));
    }

    public static long goodString(int[] countOfLetter){
        long result = 0;

        if(countOfLetter.length == 1){
            return 0;
        }

        for (int i = 0; i < countOfLetter.length - 1; i++){
            result += Math.min(countOfLetter[i], countOfLetter[i+1]);
        }

        return result;
    }
}
