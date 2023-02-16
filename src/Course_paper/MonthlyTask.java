package Course_paper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(Type type, String title, String description, LocalDateTime localDateTime) {
        super(type, title, description, localDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().getDayOfMonth() && localDate.isAfter(getDateTime().toLocalDate());
    }
}
