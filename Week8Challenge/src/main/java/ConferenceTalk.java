public class ConferenceTalk {
    private String title;
    private int duration = 0;

    public ConferenceTalk(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }
    public void setDuration() {
        if (title.endsWith("lightning")) { //lightning talks are 5 minutes long
            this.duration = 5;
        } else {
            String[] titleArr = title.split("\\s+");
            String minutes = titleArr[titleArr.length - 1].substring(0, 2);
            this.duration = Integer.parseInt(minutes);
        }
    }
}
