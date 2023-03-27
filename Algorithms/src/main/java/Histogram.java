import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

// Входной файл содержит строчные и прописные латинские буквы, цифры, знаки препинания
// («.», «!», «?», «:», «-», «,», «;», «(», «)»), пробелы и переводы строк. Текст содержит
// хотя бы один непробельный символ. Для каждого символа кроме пробелов и переводов строк
// выведите столбик из символов «#», количество которых должно быть равно количеству символов
// в данном тексте. Под каждым столбиком напишите символ, соответствующий ему. Отформатируйте
// гистограмму так, чтобы нижние концы столбиков были на одной строке, первая строка и первый
// столбец были непустыми. Не отделяйте столбики друг от друга. Отсортируйте столбики в порядке
// увеличения кодов символов.

public class Histogram {
    public static void main(String[] args) throws IOException {
        String text = Files.lines(Path.of("input.txt")).collect(Collectors.joining());
        histogram(text);
    }

    public static void histogram(String inputText){
        Map<Character, Integer> dictionary = new TreeMap<>();
        int height = 1;

        for (int i = 0; i < inputText.length(); i++){
            if (inputText.charAt(i) == ' '){
                continue;
            }

            if (!dictionary.containsKey(inputText.charAt(i))){
                dictionary.put(inputText.charAt(i), 1);
            }else {
                dictionary.put(inputText.charAt(i), dictionary.get(inputText.charAt(i)) + 1);
                if(dictionary.get(inputText.charAt(i)) > height)
                    height = dictionary.get(inputText.charAt(i));
            }
        }

        Set<Character> characters = dictionary.keySet();

        for (int h = height; h > 0; h--){
            for(Character character : characters){
                if(dictionary.get(character) < h)
                    System.out.print(" ");
                else System.out.print("#");
            }
            System.out.print("\n");
        }

        for(Character character : characters){
            System.out.print(character);
        }
    }
}
