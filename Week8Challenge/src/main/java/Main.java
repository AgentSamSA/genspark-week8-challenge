import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input;

        input = readFile();

        //do stuff to file here

        //output talks to console and to a different file
        input.forEach(n -> System.out.println(n));
        //writeFile(output);
    }

    public static List<String> readFile() {
        List<String> fileInput = Collections.emptyList();

        try {
            fileInput = Files.readAllLines(Paths.get("src/files/TalkList.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInput;
    }

    public static void writeFile(List<Track> output) {

    }
}