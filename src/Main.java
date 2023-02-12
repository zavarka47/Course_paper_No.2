import Course_paper.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        int optionGeneralMenu;
        do {
            printGeneralMenu();

            Scanner generalMenu = new Scanner(System.in);
            optionGeneralMenu = generalMenu.nextInt();

            if (optionGeneralMenu == 1) {
                String title = "-";
                Type type = null;
                String description = "-";
                LocalDateTime localDateTime = LocalDateTime.now();

                printTypeTaskMenu();
                int optionTypeMenu;
                do {
                    Scanner typeMenu = new Scanner(System.in);
                    optionTypeMenu = typeMenu.nextInt();
                    switch (optionTypeMenu) {
                        case 1:
                            type = Type.WORK;
                            break;
                        case 2:
                            type = Type.PERSONAL;
                            break;
                        default:
                            System.out.println("К сожалению такой опции нет\nПопробуйте еще раз");
                            printTypeTaskMenu();
                    }
                } while (optionTypeMenu < 1 || optionTypeMenu > 2);


                printTitleTaskMenu();
                Scanner titleMenu = new Scanner(System.in);
                title = titleMenu.nextLine();

                printDescriptionMenu();
                Scanner descriptionMenu = new Scanner(System.in);
                description = descriptionMenu.nextLine();


                while (true) {
                    printLocalDateTimeMenu();
                    Scanner dateMenu = new Scanner(System.in);
                    String dataM = dateMenu.nextLine();
                    try {
                        localDateTime = DataTimeService.addLocalDateTime(dataM);
                        break;
                    } catch (DateTimeParseException d){
                        System.out.println("Дата указана в неверном формате\nПопробуй еще раз");
                    }
                }


                printPeriodTaskMenu();
                int optionPeriodTaskMenu;
                do {
                    Scanner ptm = new Scanner(System.in);
                    optionPeriodTaskMenu = ptm.nextInt();

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
                    Scanner getTaskMenu = new Scanner(System.in);
                    String gtMenu = getTaskMenu.nextLine();
                    try {
                        TaskService.printAllByDate(DataTimeService.addLocalDate(gtMenu));
                        break;
                    } catch (DateTimeParseException d) {
                        System.out.println("Дата указана в неверном формате\nПопробуй еще раз");
                    }
                }


            }


            if (optionGeneralMenu == 3) {
                System.out.print("Введите ID задачи - ");
                Scanner removeTaskById = new Scanner(System.in);
                Integer idTask = removeTaskById.nextInt();
                try {
                    TaskService.removed(idTask);
                } catch (TaskNotFoundException t){
                    System.out.println("Задачи с id - " + idTask + " нет в списке задач");
                }
            }

            if (optionGeneralMenu < 0 || optionGeneralMenu > 3) {
                System.out.println("К сожалению такой опции нет\nПопробуйте еще раз");
            }

        } while (optionGeneralMenu != 0) ;


        }


    // Выпадаюие меню
    public static void printGeneralMenu(){
        System.out.println(
                        "***                        \n" +
                        "1 - Добвляем новую задачку \n" +
                        "2 - Получить план на день  \n" +
                        "3 - Удалить задачку        \n" +
                        "0 - Выйти из приложения"       );
        System.out.print("Введите номер оперции - "     );
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




}
