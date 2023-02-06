package Course_paper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(Type type, String title, String description, LocalDateTime localDateTime) {
        super(type, title, description, localDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {

        return true;
    }
}
