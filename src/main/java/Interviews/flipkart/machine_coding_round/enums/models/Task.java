package Interviews.flipkart.machine_coding_round.enums.models;

import Interviews.flipkart.machine_coding_round.enums.Priority;

public class Task {
    private String taskId;
    private String name;
    private User assignedUser; // Nullable, unassigned by default
    private Priority priority;

    public Task(String taskId, String name, Priority priority) {
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
        this.assignedUser = null; // Unassigned by default
    }

    // Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void assignUser(User user) {
        this.assignedUser = user;
    }

    public void unassignUser() {
        this.assignedUser = null;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", assignedUser=" + (assignedUser != null ? assignedUser.getName() : "Unassigned") +
                '}';
    }
}
