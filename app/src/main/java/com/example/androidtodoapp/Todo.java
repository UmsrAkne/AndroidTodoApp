package com.example.androidtodoapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "todos")
public final class Todo {

    @PrimaryKey
    public int id;

    private String title = "";
    private String comment = "";

    @Ignore
    private Boolean completed;

    @Ignore
    private Date creationDateTime;

    @Ignore
    private Date completeDateTime;

    public Todo(){
        creationDateTime = new Date();
    }

    public Todo(Date creationDateTime){
        this.creationDateTime = creationDateTime;
    }

    public void complete(){
        completed = true;
        completeDateTime = new Date();
    }

    public void complete(Date completeDate){
        completed = true;
        this.completeDateTime = completeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCompleteDateTime() {
        return completeDateTime;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public boolean isCompleted(){
        return completed;
    }
}
