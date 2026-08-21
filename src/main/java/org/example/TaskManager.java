package org.example;

import org.example.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task task){
        int id = task.getId();
        tasks.put(id,task);
    }

    public Task searchById(int id){
        return tasks.get(id);
    }

    public void removeTask(int id){
        tasks.remove(id);
    }

    public void showAllTasks(){
        for (int id: tasks.keySet()){
            System.out.println(tasks.get(id).getTitle());
        }
    }

    public void showCompletedTask(){
        for (int id: tasks.keySet()){
            Task task = tasks.get(id);
            if (task.getStatus()){
                System.out.println(task.getTitle());
            }
        }
    }
}
