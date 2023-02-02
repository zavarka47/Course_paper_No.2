package Course_paper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();


    public static void addTask (Task task){
        taskMap.put(task.getId(), task);
    }

    public void removed (Integer id){
        taskMap.remove(id);
    }

    public static ArrayList <Task> getAllByDate (LocalDate localDate){
        ArrayList <Task> allTaskByDate = new ArrayList<>();
        for (Task task : allTaskByDate) {
            if (task.appearsIn(localDate)){
                allTaskByDate.add(task);
            }
        }
        return allTaskByDate;
    }
}
