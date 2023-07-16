package model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomWordFromFile {
    public String getWord() {
        String randomWord = null;
        String fileName = "/words.txt";

        try (InputStream inputStream = getClass().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {

            List<String> words = br.lines().toList();

            Random rand = new Random();
            int randomIndex = rand.nextInt(words.size());

            randomWord = words.get(randomIndex);

        } catch (IOException e) {
            System.err.format("Ошибка при чтении файла: %s%n", e);
        }

        return randomWord;
    }
}
