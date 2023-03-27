import java.util.Scanner;

//В классе стоит один ряд парт, за каждой из них (кроме, возможно, последней)
//на контрольной будут сидеть ровно два ученика. Ученики знают, что варианты будут
//раздаваться строго по порядку: правый относительно учителя ученик первой парты
//получит вариант 1, левый — вариант 2, правый ученик второй парты получит вариант
//3 (если число вариантов больше двух) и т.д. Так как K может быть меньше чем число
//учеников N, то после варианта K снова выдаётся вариант 1. На последней парте в случае
//нечётного числа учеников используется только место 1.

//Петя самым первым вошёл в класс и сел на своё любимое место. Вася вошёл следом и хочет
//получить такой же вариант, что и Петя, при этом сидя к нему как можно ближе. То есть между
//ними должно оказаться как можно меньше парт, а при наличии двух таких мест с равным
//расстоянием от Пети Вася сядет позади Пети, а не перед ним. Напишите программу, которая подскажет
//Васе, какой ряд и какое место (справа или слева от учителя) ему следует выбрать. Если же один и
//тот же вариант Вася с Петей писать не смогут, то выдайте одно число -1.


public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int K = Integer.parseInt(scanner.nextLine());
        int lineP = Integer.parseInt(scanner.nextLine());
        int positionP = Integer.parseInt(scanner.nextLine());

        placeV(N, K, lineP, positionP);
    }

    public static void placeV(int N, int K, int lineP, int positionP){
        int numberOfP = (lineP - 1) * 2 + positionP;

        int maxNumberOfV = numberOfP + K;
        int minNumberOfV = numberOfP - K;

        if((maxNumberOfV > N) && (minNumberOfV < 1 )){
            System.out.println(-1);
        } else if (maxNumberOfV > N){
            int lineV = minNumberOfV / 2 + minNumberOfV % 2;
            int positionV = 2 - minNumberOfV % 2;
            System.out.println(lineV + " " + positionV);
        } else if (minNumberOfV < 1) {
            int lineV = maxNumberOfV / 2 + maxNumberOfV % 2;
            int positionV = 2 - maxNumberOfV % 2;
            System.out.println(lineV + " " + positionV);
        } else{
            int maxLineV = maxNumberOfV / 2 + maxNumberOfV % 2;
            int minLineV = minNumberOfV / 2 + minNumberOfV % 2;
            if((maxLineV - lineP) <= (lineP - minLineV))
                System.out.println(maxLineV + " " + (2 - maxNumberOfV % 2));
            else System.out.println(minLineV + " " + (2 - minNumberOfV % 2));
        }
    }
}
