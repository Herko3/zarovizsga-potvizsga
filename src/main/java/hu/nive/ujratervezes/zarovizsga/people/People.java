package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class People {

    public int getNumberOfMales(String path) {
        int numberOfMales = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(",Male,")) {
                 numberOfMales++;
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return numberOfMales;
    }

    public long getNumberOfMales2(String path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        return lines.stream()
                .filter(s->s.contains(",Male,"))
                .count();
    }
}
