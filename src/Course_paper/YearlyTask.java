package Course_paper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(Type type, String title, String description, LocalDateTime localDateTime) {
        super(type, title, description, localDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfYear() == getDateTime().getDayOfYear()  &&  localDate.isAfter(getDateTime().toLocalDate());
    }
}
