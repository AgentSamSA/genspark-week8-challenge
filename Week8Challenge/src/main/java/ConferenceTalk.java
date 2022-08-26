import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConferenceTalk {
    private String title;
    private int duration;

    private LocalTime start;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public ConferenceTalk(String title) {
        this.title = title;

        if (title.endsWith("lightning")) { //lightning talks are 5 minutes long
            this.duration = 5;
        } else {
            String[] titleArr = title.split("\\s+");
            String minutes = titleArr[titleArr.length - 1].replaceAll("[^0-9]", "");
            this.duration = Integer.parseInt(minutes);
        }
    }

    public ConferenceTalk(LocalTime start, String title, int duration) {
        this.start = start;
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return start.format(formatter) + "\t" + title;
    }
}
