import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void fillSession(List<ConferenceTalk> talks, List<ConferenceTalk> allTalks,
                            List<Integer> indexOfOverflowTalks, int totalDuration, int indexOfOverflowTalk,
                            int timeAvailable){
        int greatCount = 0;

        for (int i = indexOfOverflowTalk; i < allTalks.size(); i++) {
            totalDuration += allTalks.get(i).getDuration();

            if (totalDuration <= timeAvailable) {
                talks.add(allTalks.get(i));
            } else if (i <= allTalks.size() - 1) {
                if (greatCount > allTalks.size() / 4) {
                    Collection.shuffle(allTalks);
                    fillSession(talks, allTalks, indexOfOverflowTalks, 0, 0, timeAvailable);
                } else {
                    indexOfOverflowTalk = temp.get(0);
                    fillSession(talks, allTalks, new ArrayList()<>, totalDuration, indexOfOverflowTalk, timeAvailable);
                }
            } else {
                temp.add(i);
                totalDuration -= allTalks.get(i).getDuration();
                greatCount++;
            }
        }
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
