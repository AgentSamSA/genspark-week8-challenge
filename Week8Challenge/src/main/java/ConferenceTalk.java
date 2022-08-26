public class ConferenceTalk {
    private String title;
    private int duration;

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

    public ConferenceTalk(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }
}
