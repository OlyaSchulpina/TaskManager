package org.example.model;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    public Task(int id, String title, String description, boolean completed){
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.description = description;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCompleted(boolean status){
        this.completed = status;
    }


    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public boolean getStatus(){
        return completed;
    }
}
