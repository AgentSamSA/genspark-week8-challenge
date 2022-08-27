//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SessionTest {
    List<ConferenceTalk> list;
    ArrayList<ConferenceTalk> checkList;

    Session session;

    SessionTest() {
    }

    @BeforeEach
    void setUp() {
        this.list = new ArrayList();
        this.list.add(new ConferenceTalk(LocalTime.parse("12:00"), "Java Loops 60min", 60));
        this.list.add(new ConferenceTalk(LocalTime.parse("13:00"), "Java Variables 60min", 60));
        checkList = new ArrayList<>(this.list);
        this.session = new Session(LocalTime.parse("12:00"), LocalTime.parse("14:00"), this.list);
    }


    @Test
    void getTalks() {
        Assertions.assertEquals(checkList, this.session.getTalks(), "getTalks method is not working.");
    }

    @Test
    void fillSession() {
        Assertions.assertEquals(checkList, session.fillSession(checkList));
    }

    @Test
    void getTimeLeft() {
        Assertions.assertEquals(0, this.session.getTimeLeft(), "getTimeLeft method is not working");
    }

    @Test
    void getStart() {
        Assertions.assertEquals(LocalTime.parse("12:00"), this.session.getStart(), "getStart method is not working");
    }

    @Test
    void getEnd() {
        Assertions.assertEquals(LocalTime.parse("14:00"), this.session.getEnd(), "getEnd method is not working");
    }

}
