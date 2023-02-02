package Course_paper;

import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(Type type, String title) {
        super(type, title);
    }

    public YearlyTask(Type type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getMonth().equals(getDateTime().getMonth()) &
                localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
