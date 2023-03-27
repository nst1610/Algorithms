import java.util.Scanner;

// На клетчатой плоскости закрашено K клеток. Требуется найти минимальный по площади прямоугольник,
// со сторонами, параллельными линиям сетки, покрывающий все закрашенные клетки.
// В первой строке ввода находится число K.
// На следующих K строках находятся пары чисел Xi и Yi – координаты закрашенных клеток.
// Выведите координаты левого нижнего и правого верхнего углов прямоугольника.

public class MinRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPoints = Integer.parseInt(scanner.nextLine());

        int[] xArray = new int[countOfPoints];
        int[] yArray = new int[countOfPoints];

        for(int i = 0; i < countOfPoints; i++){
            String[] currentPoint = scanner.nextLine().split(" ");
            xArray[i] = Integer.parseInt(currentPoint[0]);
            yArray[i] = Integer.parseInt(currentPoint[1]);
        }

        answer(xArray, yArray);
    }

    public static void answer(int[] xArray, int[] yArray){
        int minX = xArray[0];
        int maxX = xArray[0];
        int minY = yArray[0];
        int maxY = yArray[0];

        for(int i = 0; i < xArray.length; i++){
            if(xArray[i] < minX)
                minX = xArray[i];
            if(xArray[i] > maxX)
                maxX = xArray[i];
        }
        for(int i = 0; i < yArray.length; i++){
            if(yArray[i] < minY)
                minY = yArray[i];
            if(yArray[i] > maxY)
                maxY = yArray[i];
        }

        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
    }
}
