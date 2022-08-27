import java.time.LocalTime;
import java.util.*;

public class Session {
    private LocalTime start;
    private LocalTime end;

    private LocalTime currentTime;
    private int timeLeft;
    private List<ConferenceTalk> talks = new ArrayList<>();

    public List<ConferenceTalk> getTalks() {
        return this.talks;
    }

    public Session(LocalTime start, LocalTime end){
        this.talks = new ArrayList<>();
        this.end = end;
        this.start = start;
        this.currentTime = this.start;
        this.timeLeft = (end.getHour() - start.getHour())*60;
    }

    public Session(LocalTime start, LocalTime end, List<ConferenceTalk> allTalks){
        this.end = end;
        this.start = start;
        this.currentTime = this.start;
        this.timeLeft = (end.getHour() - start.getHour())*60;
        this.talks = fillSession(allTalks);
    }

    public List<ConferenceTalk> fillSession(List<ConferenceTalk> allTalks) {
        int minDuration = allTalks.get(0).getDuration();
        List<ConferenceTalk> addedTalks = new ArrayList<>();

        while (timeLeft > 0 && !allTalks.isEmpty() && timeLeft >= minDuration) {

            for (ConferenceTalk talk : allTalks) {
                int currDuration = talk.getDuration();

                if (timeLeft == 0)
                    break;
                
                minDuration =
                        allTalks.stream().min(Comparator.comparingInt(ConferenceTalk::getDuration)).get().getDuration();

                if ( currDuration <= timeLeft && !addedTalks.contains(talk)) {
                    talks.add(talk);
                    addedTalks.add(talk);
                    timeLeft -= currDuration;
                    talk.setStart(currentTime);
                    currentTime = currentTime.plusMinutes(talk.getDuration());
                }
            }
        }
        allTalks.removeAll(addedTalks);
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
