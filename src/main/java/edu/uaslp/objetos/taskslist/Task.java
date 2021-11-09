package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;

public class Task {
    private String tittle;
    private String description;
    private LocalDateTime dueDate;
    private Boolean done;

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        LocalDateTime now = LocalDateTime.now();

        if (dueDate.isBefore(now)) {
            throw new ToDoListException("Due date is set in the past");
        }
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
