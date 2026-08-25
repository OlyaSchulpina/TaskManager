package org.example;

import org.example.exception.InvalidTaskException;
import org.example.exception.TaskNotFoundException;
import org.example.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private static TaskManager instance;

    public static TaskManager getInstance() {
        if (instance==null){
            instance = new TaskManager();
        }
        return instance;
    }

    Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task task){
        int id = task.getId();
        if (task.getTitle().isEmpty()){
            throw new InvalidTaskException("Заголовок не может быть пустым");
        }else{
            tasks.put(id,task);
        }
    }

    public Task searchById(int id){
        if (tasks.containsKey(id)){
            return tasks.get(id);
        }else{
            throw new TaskNotFoundException("Задача не найдена");
        }
    }

    public void removeTask(int id){
        if (tasks.containsKey(id)){
            tasks.remove(id);
        }else{
            throw new TaskNotFoundException("Задача не найдена");
        }
    }

    public void showAllTasks(){
        System.out.println("ID Задача");
        for (int id: tasks.keySet()){
            System.out.println(id +"  "+ tasks.get(id).getTitle()+"  "+tasks.get(id).getDescription());
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
    public void complete(int id){
        if (tasks.containsKey(id)){
            Task task = tasks.get(id);
            task.setCompleted(true);
        }else{
            throw new TaskNotFoundException("Задача не найдена");
        }
    }
}
