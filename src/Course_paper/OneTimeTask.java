package Course_paper;

import java.time.LocalDate;

public class OneTimeTask extends Task{
    public OneTimeTask(Type type, String title) {
        super(type, title);
    }

    public OneTimeTask(Type type, String title, String description) {
        super(type, title, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDateTime());
    }
}
