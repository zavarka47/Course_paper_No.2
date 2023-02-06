import Course_paper.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OneTimeTask task1 = new OneTimeTask(Type.WORK, "0", "0", LocalDateTime.now());
        System.out.println(
                "1 - Добвляем новую задачку  \n" +
                "2 - Получить план на день\n" +
                "3 - Удалить задачку \n" +
                        "Введите номер оперции - ");
        Scanner generalMenu = new Scanner(System.in);
        int menu1 = generalMenu.nextInt();
        switch (menu1){
            case 1:

                Type type = null;
                String title = null;
                String description = null;
                LocalDateTime localDateTime = null;

                System.out.println("********************");
                System.out.println(
                        "1 - Рабочая задача  \n" +
                        "2 - Личная задача");
                System.out.print("Выбери тип задачи - ");
                Scanner typeMenu = new Scanner(System.in);
                int tm = typeMenu.nextInt();
                switch (tm) {
                    case 1:
                        type = Type.WORK;
                        break;
                    case 2:
                        type = Type.PERSONAL;
                        break;
                }

                System.out.println("********************");
                System.out.println("Введите название задачи:");
                Scanner titleMenu = new Scanner(System.in);
                String titM = titleMenu.nextLine();

                System.out.println("********************");
                System.out.println("Введите описание задачи:");
                Scanner descriptionMenu = new Scanner(System.in);
                String dm = descriptionMenu.nextLine();

                System.out.println("********************");
                System.out.print("Введите дату в формате (ДД.ММ.ГГГГ чч:мм) - ");
                Scanner dateMenu = new Scanner(System.in);
                String dataM = dateMenu.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                localDateTime = LocalDateTime.parse(dataM, dtf);
                System.out.println("********************");
                System.out.println(
                    "0 - Однократная задача  \n" +
                            "1 - Ежедневная задача  \n" +
                            "2 - Еженедельная задача  \n"+
                            "3 - Ежемесячная задача  \n" +
                            "4 - Ежегодная задача");
                System.out.print("Выбери периодичность задачи - ");
                Scanner ap = new Scanner(System.in);
                int app = ap.nextInt();
                switch (app) {
                    case 0:
                        TaskService.addTask(new OneTimeTask(type, title, description, localDateTime));
                        break;
                    case 1:
                        TaskService.addTask(new DailyTask(type, title, description, localDateTime));
                        break;
                    case 2:
                        TaskService.addTask(new WeeklyTask(type, title, description, localDateTime));
                        break;
                    case 3:
                        TaskService.addTask(new MonthlyTask(type, title, description, localDateTime));
                        break;
                    case 4:
                        TaskService.addTask(new YearlyTask(type, title, description, localDateTime));
                        break;
                }
                break;

            case 2:
                System.out.print("Введите дату в формате (ДД.ММ.ГГГГ) - ");
                Scanner getTaskMenu = new Scanner(System.in);
                String gtMenu = getTaskMenu.nextLine();
                DateTimeFormatter gtm = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate taskDate = LocalDate.parse(gtMenu, gtm);
                for (Task task : TaskService.getAllByDate(taskDate)) {
                    System.out.println(task);}
                break;
            case 3:
                System.out.print("Введите ID задачи - ");
                Scanner removeTaskById = new Scanner(System.in);
                Integer idTask = removeTaskById.nextInt();
                TaskService.removed(idTask);
                break;
        }



    }
}
