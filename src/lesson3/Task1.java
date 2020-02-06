package lesson3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {

        Map<String, Integer> mapCount = new HashMap<>();

        String[] words = new String[]{
                "Java", "Kotlin", "Android", "Code",
                "Computer", "Keyboard", "Mouse", "Java",
                "Develop", "Code", "JavaScript", "Computer"
        };

        for (String word : words) {
            mapCount.put(word, mapCount.getOrDefault(word, 0) + 1);
        }


        System.out.println(mapCount);

    }
}


