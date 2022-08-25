//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Session {
//    private int start;
//    private int end;
//    private int timeLeft;
//    private ArrayList<ConferenceTalk> talks;
//
//    public ArrayList<ConferenceTalk> getTalks() {
//        return talks;
//    }
//
//    public Session(int start, int end){
//        talks = new ArrayList<>();
//        this.end = end;
//        this.start = start;
//        timeLeft = (end - start)*60;
//    }
//
//    public void fillSession(List<ConferenceTalk> allTalks){
//        int minDur = Integer.MAX_VALUE;
//        while(timeLeft > 0 || !allTalks.isEmpty() || timeLeft >= minDur){
//            for (ConferenceTalk talk: allTalks) {
//                int currDur = talk.getDuration();
//                if(currDur <= timeLeft){
//                    talks.add(talk);
//                    timeLeft-= currDur;
//                    allTalks.remove(talk);
//                }else{
//                    if(currDur < minDur){
//                        minDur = currDur;
//                    }
//                }
//            }
//        }
//    }
//
//
//    public int getTimeLeft(){
//        return this.timeLeft;
//    }
//
//    public int getStart() {
//        return this.start;
//    }
//
//    public void setStart(int start) {
//        this.start = start;
//    }
//
//    public int getEnd() {
//        return this.end;
//    }
//
//    public void setEnd(int end) {
//        this.end = end;
//    }
//
//}
