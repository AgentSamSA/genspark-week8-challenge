import java.time.LocalTime;
import java.util.List;

public class Track {
    private Session morning;
    private Session afternoon;
    private final ConferenceTalk lunch = new ConferenceTalk(LocalTime.parse("12:00"), "Lunch", 60);
    private final ConferenceTalk networkingEvent = new ConferenceTalk(LocalTime.parse("17:00"), "Networking Event", 0);

    public Track (Session morning, Session afternoon) {
        this.morning = morning;
        this.afternoon = afternoon;
    }

    public Track (List<ConferenceTalk> allTalks) {
        this.morning = new Session(LocalTime.parse("09:00"), LocalTime.parse("12:00"), allTalks);
        this.afternoon = new Session(LocalTime.parse("13:00"), LocalTime.parse("17:00"), allTalks);
    }

    @Override
    public String toString() {
        return morning.toString() + lunch + "\n" + afternoon + networkingEvent + "\n";
    }
}