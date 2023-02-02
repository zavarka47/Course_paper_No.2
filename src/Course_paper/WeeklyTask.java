package Course_paper;

import java.time.LocalDate;
import java.util.Calendar;

public class WeeklyTask extends Task {
    public WeeklyTask(Type type, String title) {
        super(type, title);
    }

    public WeeklyTask(Type type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
    return localDate.getDayOfWeek().equals(getDateTime().getDayOfWeek());
    }
}
