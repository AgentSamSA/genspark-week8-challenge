import java.io.File;
import java.io.FileWriter;
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
        List<Track> conferenceSchedule = new ArrayList<>();

        allTalks = readFile();

        while (!allTalks.isEmpty()) {
            Track track = new Track(allTalks);
            conferenceSchedule.add(track);
        }

        conferenceSchedule.forEach(System.out::println);
        //writeFile(conferenceSchedule);
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
        try {
            File myObj = new File("src/files/ConferenceSchedule.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("src/files/ConferenceSchedule.txt");
            for (Track n : output) {
                myWriter.write(n.toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}