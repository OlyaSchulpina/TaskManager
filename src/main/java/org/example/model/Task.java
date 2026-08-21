package org.example.model;

public class Task {
    private long id;
    private String title;
    private String description;
    private boolean completed;

    public void setId(long id){
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


    public long getId() {
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
