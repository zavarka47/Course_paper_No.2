package Course_paper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private String title;
    private Type type;
    private int id = idGenerator;
    private LocalDateTime dateTime;
    private String description;

//Конструкторы

    public Task(Type type, String title, String description, LocalDateTime localDateTime) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.dateTime = localDateTime;
        ++idGenerator;
    }

// Мтоды Get
    public String getTitle() {
        return title;
    }
    public Type getType() {
        return type;
    }
    public int getId() {
        return id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getDescription() {
        return description;
    }

// Методы Set
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

// Методы equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

// Метод toString
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

// Метод appearsIn boolean
    public abstract boolean appearsIn (LocalDate localDate);




}
