import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ConferenceTalk> allTalks;

        allTalks = readFile();

        //do stuff to file here

        //output talks to console and to a different file
        //allTalks.forEach(n -> System.out.println(n));
        //writeFile(output);
    }

    public static List<ConferenceTalk> readFile() {
        List<String> fileInput = Collections.emptyList();
        List<ConferenceTalk> allTalks = new ArrayList<>();

        try {
            fileInput = Files.readAllLines(Paths.get("src/files/TalkList.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (String i : fileInput) {
            allTalks.add(new ConferenceTalk(i));
        }

        return allTalks;
    }

    public static void writeFile(List<Track> output) {

    }
}