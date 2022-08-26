import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.*;

public class Session {
    private LocalTime start;
    private LocalTime end;

    private LocalTime currentTime;
    private int timeLeft;
    private List<ConferenceTalk> talks;

    public List<ConferenceTalk> getTalks() {
        return this.talks;
    }

    public Session(LocalTime start, LocalTime end){
        talks = new ArrayList<>();
        this.end = end;
        this.start = start;
        this.currentTime = this.start;
        timeLeft = (end.getHour() - start.getHour())*60;
    }

    public Session(LocalTime start, LocalTime end, List<ConferenceTalk> allTalks){
        this.end = end;
        this.start = start;
        this.currentTime = this.start;
        timeLeft = (end.getHour() - start.getHour())*60;
        talks = fillSession(allTalks);
    }

    public List<ConferenceTalk> fillSession(List<ConferenceTalk> allTalks) {
        int minDuration = allTalks.get(0).getDuration();
        while (timeLeft > 0 && !allTalks.isEmpty() && timeLeft >= minDuration) {
            minDuration =
                    allTalks.stream().min(Comparator.comparingInt(ConferenceTalk::getDuration)).get().getDuration();
            for (ConferenceTalk talk : allTalks) {
                int currDuration = talk.getDuration();

                if ( currDuration <= timeLeft) {
                    talks.add(talk);
                    timeLeft -= currDuration;
                    talk.setStart(currentTime);
                    currentTime = currentTime.plusMinutes(talk.getDuration());
                    allTalks.remove(talk);
                }
            }
        }
        return talks;
    }


    public int getTimeLeft(){
        return this.timeLeft;
    }

    public LocalTime getStart() {
        return this.start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return this.end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public String toString() { // need to test this!
        StringBuilder sessionList = new StringBuilder();

        for (ConferenceTalk talk : talks) {
            sessionList.append(talk).append("\n");
        }
        return sessionList.toString();
    }
}
