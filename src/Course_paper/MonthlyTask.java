package Course_paper;

import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(Type type, String title) {
        super(type, title);
    }

    public MonthlyTask(Type type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
