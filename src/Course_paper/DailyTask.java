package Course_paper;

import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(Type type, String title) {
        super(type, title);
    }

    public DailyTask(Type type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return true;
    }
}
