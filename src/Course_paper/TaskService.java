package Course_paper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();

    public static void addTask (Task task){
        taskMap.put(task.getId(), task);
    }

    public static void removed (Integer id) throws TaskNotFoundException{
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
        }else {
            throw new TaskNotFoundException();
        }
    }

    public static ArrayList<Task> getAllByDate (LocalDate localDate) {
        ArrayList<Task> allTaskByDate = new ArrayList<>();
        for (Task task : taskMap.values()) {
            if (task.appearsIn(localDate)) {
                allTaskByDate.add(task);
            }
        }
        return allTaskByDate;
    }

    public static void printAllByDate (LocalDate localDate) {
        ArrayList<Task> allTaskByDate = getAllByDate(localDate);
        for (Task task:allTaskByDate) {
            System.out.println(task);}
         if (allTaskByDate.size()==0) {
            System.out.println("На сегодня задач нет");
        }
    }

    public static void getAllTask (){
        for (Task t :taskMap.values()) {
            System.out.println(t);
        }
    }


}
