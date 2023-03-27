import java.util.Arrays;
import java.util.Scanner;

// Реализовать метод, находщий сумму всех простых чисел, не превышающих x.
public class SumPrimes{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        System.out.println(sumPrimes(inputNumber));
        scanner.close();
    }

    public static int sumPrimes(int x){
        int result = 0;

        boolean[] isPrime = new boolean[x + 1];
        Arrays.fill(isPrime, true);

        //Используется алгоритм "Решето Эратосфена" для нахождения всех простых чисел, не превышающих x.
        for(int i = 2; i * i<= x; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= x; j += i){
                    isPrime[j] = false;
                }
            }
        }
        //Складываем полученные простые числа
        for (int i = 2; i < isPrime.length; i++){
            if(isPrime[i]) {
                result += i;
            }
        }
        return result;
    }
}