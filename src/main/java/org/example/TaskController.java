package org.example;

import org.example.exception.InvalidTaskException;
import org.example.exception.TaskNotFoundException;
import org.example.model.Task;

import java.util.Scanner;

public class TaskController {
    private final TaskManager taskManager;
    Scanner scanner = new Scanner(System.in);
    public TaskController(TaskManager taskManager){
        this.taskManager = taskManager;
    }
    public void printMenu(){
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Найти задачу по ID");
        System.out.println("4. Завершить задачу");
        System.out.println("5. Показать все задачи");
        System.out.println("6. Показать выполненные задачи");
        System.out.println("7. Выход");
    }
    public void go(){
        int id  = 1;
        printMenu();

        while (true){
            int userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    scanner.nextLine();
                    System.out.println("Введите заголовок задачи");
                    String title = scanner.nextLine();
                    System.out.println("Введите описание задачи");
                    String description = scanner.nextLine();
                    Task task = new Task(id,title,description,false);
                    try{
                        taskManager.addTask(task);
                    }catch (InvalidTaskException e){
                        System.err.println(e.getMessage());
                    }
                    System.out.println("Добавлена новая задача: "+task.getTitle());
                    id++;
                    break;
                case 2:
                    System.out.println("Какую задачу Вы хотите удалить?");
                    taskManager.showAllTasks();
                    System.out.println("Введите ID удаляемой задачи");
                    int removeId = scanner.nextInt();
                    try{
                        taskManager.removeTask(removeId);
                    }catch (TaskNotFoundException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Введите ID");
                    int searchId = scanner.nextInt();
                    try{
                        taskManager.searchById(searchId);
                    }catch (TaskNotFoundException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Какую задачу Вы хотите завершить?");
                    taskManager.showAllTasks();
                    int completedId = scanner.nextInt();
                    try{
                        taskManager.complete(completedId);
                    }catch (TaskNotFoundException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    taskManager.showAllTasks();
                    break;
                case 6:
                    taskManager.showCompletedTask();
                    break;
                case 7:
                    System.out.println("До свидания!");
                    return;
            }
            printMenu();
        }
    }
}
