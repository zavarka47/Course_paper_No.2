package Course_paper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();
    private static Map<Integer, Task> removeTaskMap = new HashMap<>();


    public static void addTask (Task task){
        taskMap.put(task.getId(), task);
        System.out.println("Создана новая задача:\n" +
                task);
    }

    public static void removed (Integer id) throws TaskNotFoundException{
        if (taskMap.containsKey(id)) {
            removeTaskMap.put(id, taskMap.get(id));
            taskMap.remove(id);
        }else {
            throw new TaskNotFoundException();
        }
    }

    // Актуальные задачи
    public static ArrayList<Task> getTaskByDate(LocalDate localDate) {
        ArrayList<Task> allTaskByDate = new ArrayList<>();
        for (Task task : taskMap.values()) {
            if (task.appearsIn(localDate)) {
                allTaskByDate.add(task);
            }
        }
        return allTaskByDate;
    }

    public static void printTaskByDate(LocalDate localDate) {
        if (getTaskByDate(localDate).size()!=0) {
            for (Task task : getTaskByDate(localDate)) {
                System.out.println(task);
            }
        }else  {
            System.out.println("На сегодня задач нет");
        }
    }

    public static void updateDescription (int id, String description) {
        taskMap.get(id).setDescription(description);
        System.out.println("Описание задачи " + id + " изменено \n" +
                taskMap.get(id));

    }

    public static void updateTitle (int id, String title){
        taskMap.get(id).setTitle(title);
        System.out.println("Описание задачи " + id + " изменено \n" +
                taskMap.get(id));
    }

    public static boolean checkId (int id) throws  TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            return true;
        } else {
            throw new TaskNotFoundException();
        }
    }

    public static boolean taskMapIsEmpty (){
        return taskMap.isEmpty();
    }


    // Удаленные задачи
    public static ArrayList<Task> getAllRemoveTask () {
        ArrayList<Task> allRemoveTask = new ArrayList<>();
        for (Task task : taskMap.values()) {
            allRemoveTask.add(task);
        }
        return allRemoveTask;
    }

    public static void printAllRemoveTask () {
        if (getAllRemoveTask().size()!=0){
            for (Task t : getAllRemoveTask()) {
                System.out.println(t);
            }
        } else {
            System.out.println("Список удаленных задач пуст");
        }
    }
}
