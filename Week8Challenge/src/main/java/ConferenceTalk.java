public class ConferenceTalk {
    private String title;
    private Integer duration;

    public ConferenceTalk() {

    }

    public ConferenceTalk(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ConferenceTalk{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
