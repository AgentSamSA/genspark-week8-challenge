import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TimeTable {
    int sum = 0;
    int x = 0;
    private Boolean talk(List<ConferenceTalk> morningSession, ArrayList<ConferenceTalk> list, ArrayList<Integer> temp, int sum, int x,int total) {
        int greatCount = 0;
        Boolean result = false;
        if(x==0) {
            Collections.shuffle(list);
        }
        for(int i = x; i< list.size(); i++){

            sum = sum + list.get(i).getDuration();
            if(sum <=total){
                morningSession.add(list.get(i));
                if(sum ==total){
                    result = true;
                    break;
                }
            }else if(i== list.size()-1){
                if(greatCount > list.size()/4) {
                    Collections.shuffle(list);
                    morningSession.clear();
                    temp.clear();
                    talk(morningSession, list, temp, 0, 0, 180);
                }else {
                    int j = (temp.get(0));
                    temp.clear();
                    talk(morningSession, list, new ArrayList<>(), sum, j, total);
                }
            }else if(sum >total){
                temp.add(i);
                sum = sum - list.get(i).getDuration();
                greatCount++;
            }
        }
        return result;
    }

    private List<ConferenceTalk> getAfternoonSession(TimeTable timeTable, ArrayList<ConferenceTalk> list, ArrayList<Integer> temp) {
        List<ConferenceTalk> morningSession = timeTable.getMorningSession(timeTable, list, temp);
        ArrayList<ConferenceTalk> afternoonSession = new ArrayList<>();
        list.removeAll(morningSession);
        temp.clear();
        timeTable.talk(afternoonSession, list, temp, timeTable.sum, timeTable.x,240);
        ConferenceTalk networkingEvent = new ConferenceTalk("Networking Event", 60);
        afternoonSession.add(networkingEvent);
        for(ConferenceTalk t:afternoonSession){
            System.out.println(t.getTitle()+" "+t.getDuration()+" min");
        }
        return afternoonSession;
    }

    private List<ConferenceTalk> getMorningSession(TimeTable timeTable, ArrayList<ConferenceTalk> list, ArrayList<Integer> temp) {
        List<ConferenceTalk> morningSession = new ArrayList<>();
        timeTable.talk(morningSession, list, temp, timeTable.sum, timeTable.x,180);
        ConferenceTalk lunch = new ConferenceTalk("lunch", 60);
        morningSession.add(lunch);
        for(ConferenceTalk s:morningSession){
            System.out.println(s.getTitle()+" "+s.getDuration()+" min");
        }
        return morningSession;
    }
    public static void main(String[] args) throws FileNotFoundException {
        TimeTable timeTable1 = new TimeTable();
        TimeTable timeTable2 = new TimeTable();
        Scanner scan = new Scanner(new File("Week8Challenge/src/main/java/TestInput.txt"));
        ArrayList<ConferenceTalk> list = new ArrayList<>();

        while (scan.hasNextLine()) {
            String[] input = scan.nextLine().split("    ");
            if (input[1].equals("lightning")) {
                list.add(new ConferenceTalk(input[0], 5));
            } else {
                list.add(new ConferenceTalk(input[0], Integer.parseInt(input[1].substring(0, 2))));
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        System.out.println();
        System.out.println();
        System.out.println("Track1");
        System.out.println();
        System.out.println();
        timeTable1.getMorningSession(timeTable1, list, temp);
        timeTable1.getAfternoonSession(timeTable1, list, temp);

        System.out.println();
        System.out.println();
        System.out.println("Track2");
        System.out.println();
        System.out.println();
        timeTable2.getMorningSession(timeTable2, list, temp);
        timeTable2.getAfternoonSession(timeTable2, list, temp);

    }




}


