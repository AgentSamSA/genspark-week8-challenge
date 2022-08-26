public class Main {
    public static void main(String[] args) {
        List<String> input = Collections.emptyList();

        input = readFile();

        //do stuff to file here

        //output talks to console and to a different file
        System.out.println(input);
        //writeFile(output);
    }

    public static List<String> readFile() {
        List<String> fileInput = Collections.emptyList();

        try {
            fileInput = Files.readAllLines(Paths.get("files/TalkList.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInput;
    }

    public static void writeFile(ArrayList<Track> output) {

    }
}