package Course_paper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class WeeklyTask extends Task {
    public WeeklyTask(Type type, String title, String description, LocalDateTime localDateTime) {
        super(type, title, description, localDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
    return localDate.getDayOfWeek().equals(getDateTime().getDayOfWeek()) && !localDate.isBefore(getDateTime().toLocalDate());
    }
}
