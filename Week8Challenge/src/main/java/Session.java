import java.lang.reflect.Array;
import java.util.*;

public class Session {
    private int start;
    private int end;
    private int timeLeft;
    private ArrayList<ConferenceTalk> talks;

    public ArrayList<ConferenceTalk> getTalks() {
        return this.talks;
    }

    public Session(int start, int end){
        talks = new ArrayList<>();
        this.end = end;
        this.start = start;
        timeLeft = (end - start)*60;
    }

    public List<ConferenceTalk> fillSession(List<ConferenceTalk> allTalks) {
        int minDuration = Integer.MAX_VALUE;
        while (timeLeft > 0 && !allTalks.isEmpty() && timeLeft < minDuration) {
            minDuration =
                    allTalks.stream().min(Comparator.comparingInt(ConferenceTalk::getDuration)).orElse(new ConferenceTalk("")).getDuration();
            for (ConferenceTalk talk : allTalks) {
                int currDuration = talk.getDuration();

                if ( currDuration <= timeLeft) {
                    talks.add(talk);
                    timeLeft -= currDuration;
                    allTalks.remove(talk);
                }
            }
        }
        return talks;
    }


    public int getTimeLeft(){
        return this.timeLeft;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}
