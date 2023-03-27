import java.util.Arrays;
import java.util.Scanner;

// Задача про циклопов:
// У большинства циклопов есть проблемы со зрением, при этом, если циклопу рекомендовано
// носить линзы в К диоптрий, то ему подойдут линзы в К-1, К, К+1 диоптрий.
// Циклопы заказывают линзы парами одинаковой оптической силы. Один циклоп решил собирать заказы и покупать
// как можно меньше пар, при этом удовлетворяя все заказы.
// Нужно написать метод, который будет считать минимальное количество пар для удовлетворения всех
// поступивших заказов.

public class Dioptres {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfOrders = scanner.nextInt();
        int[] diopters = new int[countOfOrders];

        for (int i = 0; i < countOfOrders; i++)
            diopters[i] = scanner.nextInt();

        System.out.println(minNumbersOfPairs(countOfOrders, diopters));

        scanner.close();
    }

    public static int minNumbersOfPairs(int N, int[] diopters){
        int count = 0;

        //Сортируем массив с рекомендованными диоптриями.
        Arrays.sort(diopters);

        //Для каждого числа проверяем следующее, т.к. если следующее число диоптрий в остсортированном массиве
        //не удовлетворяет условию K-1, K, K+1 (т.е текущее число должно отличаться от следующего не более,
        //чем на 2), то не будут удовлетворять и большие диоптрии.
        for (int i = 0; i < diopters.length; i++){
            if((i != diopters.length - 1) && (diopters[i + 1] - diopters[i]) <= 2){
                count++;
                i++;
            } else {
                count++;
            }
        }

        return count;
    }
}