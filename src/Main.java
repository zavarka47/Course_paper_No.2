import Course_paper.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int optionGeneralMenu;

        do {
            printGeneralMenu();
            optionGeneralMenu = scannerInt();

            if (optionGeneralMenu == 1) {

                String title = "-";
                Type type = null;
                String description = "-";
                LocalDateTime localDateTime = LocalDateTime.now();

                int optionTypeMenu;
                do {
                    printTypeTaskMenu();
                    optionTypeMenu = scannerInt();
                    switch (optionTypeMenu) {
                        case 1:
                            type = Type.WORK;
                            break;
                        case 2:
                            type = Type.PERSONAL;
                            break;
                        default:
                            System.out.println("К сожалению такой опции нет\nПопробуйте еще раз");
                    }
                } while (optionTypeMenu < 1 || optionTypeMenu > 2);


                printTitleTaskMenu();
                title = scannerString();

                printDescriptionMenu();
                description = scannerString();


                while (true) {
                    printLocalDateTimeMenu();
                    String dataByString = scannerString();
                    try {
                        localDateTime = DataTimeService.addLocalDateTime(dataByString);
                        if (localDateTime.isBefore(LocalDateTime.now())){
                            throw new DateIsBeforeException();
                        }
                        break;
                    } catch (DateTimeParseException d){
                        System.out.println("Дата указана в неверном формате\nПопробуй еще раз");
                    } catch (DateIsBeforeException d){
                        System.out.println("Вы указали прошедшую дату\nПопробуй еще раз");
                    }
                }


                printPeriodTaskMenu();
                int optionPeriodTaskMenu;
                do {
                    optionPeriodTaskMenu = scannerInt();
                    switch (optionPeriodTaskMenu) {
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
                        default:
                            System.out.println("К сожалению такой опции нет\nПопробуйте еще раз");
                            printPeriodTaskMenu();
                    }
                } while (optionPeriodTaskMenu < 0 || optionPeriodTaskMenu > 4);
            }



            if (optionGeneralMenu == 2) {
                while (true) {
                    System.out.print("Введите дату в формате (ДД.ММ.ГГГГ) - ");
                    String dataForGetTask = scannerString();
                    try {
                        TaskService.printTaskByDate(DataTimeService.addLocalDate(dataForGetTask));
                        break;
                    } catch (DateTimeParseException d) {
                        System.out.println("Дата указана в неверном формате\nПопробуй еще раз");
                    }
                }
            }


            if (optionGeneralMenu == 3) {
                if (!TaskService.taskMapIsEmpty()){
                    while (true) {
                        System.out.print("Введите ID задачи - ");
                        Integer idForRemove = scannerInt();
                        try {
                            TaskService.removed(idForRemove);
                            break;
                        } catch (TaskNotFoundException t) {
                            System.out.println("Задачи с id - " + idForRemove + " нет в списке задач \nПопробуй еще раз");
                        }
                    }
                } else {
                    System.out.println("Список задач пуст");
                }
            }



            if (optionGeneralMenu == 4 ){
                if (!TaskService.taskMapIsEmpty()){
                    int idForUpdateTitle;
                    while (true) {
                        System.out.print("Введите ID задачи, название которй хотите изменить: ");
                        idForUpdateTitle = scannerInt();
                        try {
                            TaskService.checkId(idForUpdateTitle);
                            break;
                        } catch (TaskNotFoundException t) {
                            System.out.println("Задачи с id - " + idForUpdateTitle + " нет в списке задач \n" +
                                    "Попробуйте еще раз");
                        }
                    }
                    System.out.print("Введите новое название задачи: ");
                    String title = scannerString();
                    TaskService.updateTitle(idForUpdateTitle, title);
                } else {
                    System.out.println("Список задач пуст");
                }
            }



            if (optionGeneralMenu == 5){
                if (!TaskService.taskMapIsEmpty()){
                    int idForUpdateDescription;
                    while (true) {
                        System.out.print("Введите ID задачи, описание которй хотите изменить: ");
                        idForUpdateDescription = scannerInt();
                        try {
                            TaskService.checkId(idForUpdateDescription);
                            break;
                        } catch (TaskNotFoundException t) {
                            System.out.println("Задачи с id - " + idForUpdateDescription + " нет в списке задач \n" +
                                    "Попробуйте еще раз");
                        }
                    }
                    System.out.print("Введите новое описание задачи: ");
                    String description = scannerString();
                    TaskService.updateDescription(idForUpdateDescription, description);
                } else {
                    System.out.println("Список задач пуст");
                }
            }

            if (optionGeneralMenu == 6){
                if (!TaskService.taskMapIsEmpty()){
                    TaskService.getAllGroupedByDate();
                }else {
                    System.out.println("Список задач пуст");
                }
            }


            if (optionGeneralMenu < 0 || optionGeneralMenu > 6) {
                System.out.println("К сожалению такой опции нет\nПопробуйте еще раз");
            }

        } while (optionGeneralMenu != 0);
        System.out.println("Досвидания!");


    }



    // Выпадаюие меню
    public static void printGeneralMenu(){
        System.out.println(
                        "***                           \n" +
                        "1 - Добвляем новую задачку    \n" +
                        "2 - Получить план на день     \n" +
                        "3 - Удалить задачку           \n" +
                        "4 - Изменить название задачи  \n" +
                        "5 - Изменить описание задачи  \n" +
                        "6 - Вывести все задачи        \n" +
                        "0 - Выйти из приложения"          );
        System.out.print("Введите номер оперции - "        );
    }

    public static void printTypeTaskMenu(){
        System.out.println(
                        "_______________     \n" +
                        "1 - Рабочая задача  \n" +
                        "2 - Личная задача"      );
        System.out.print("Выбери тип задачи - "  );

    }

    public static void printTitleTaskMenu(){
        System.out.println(
                        "_______________      \n" +
                        "Введите название задачи:");
    }

    public static void printDescriptionMenu(){
        System.out.println(
                        "_______________      \n" +
                        "Введите описание задачи:");
    }

    public static void printLocalDateTimeMenu(){
        System.out.print(
                      "_______________                          \n" +
                      "Введите дату в формате (ДД.ММ.ГГГГ чч:мм) - ");
    }

    public static void printPeriodTaskMenu(){
        System.out.println(
                         "_______________            \n" +
                         "0 - Однократная задача     \n" +
                         "1 - Ежедневная задача      \n" +
                         "2 - Еженедельная задача    \n" +
                         "3 - Ежемесячная задача     \n" +
                         "4 - Ежегодная задача"          );
        System.out.print("Выбери периодичность задачи - ");
    }

    // Scanner
    public static int scannerInt (){
        Scanner scannerString = new Scanner(System.in);
        int i = scannerString.nextInt();
        return i;
    }
    public static String scannerString (){
        Scanner scannerString = new Scanner(System.in);
        String string = scannerString.nextLine();
        return string;
    }
}
