package Course_paper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(Type type, String title, String description, LocalDateTime localDateTime) {
        super(type, title, description, localDateTime);

    }

    @Override
    public boolean appearsIn(LocalDate localDate) {

        return localDate.equals(getDateTime().toLocalDate()) && localDate.isAfter(getDateTime().toLocalDate());
    }
}
