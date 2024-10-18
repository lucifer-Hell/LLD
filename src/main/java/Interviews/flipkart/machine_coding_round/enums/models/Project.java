package Interviews.flipkart.machine_coding_round.enums.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private String projectId;
    private String name;
    private List<Task> tasks;
    private Board board;

    public Project(String projectId, String name, Board board) {
        this.projectId = projectId;
        this.name = name;
        this.board = board;
        this.tasks = new ArrayList<>();
    }

    // Getters and Setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Board getBoard() {
        return board;
    }

    // Add or remove a task, tasks sorted by priority
    public void addTask(Task task) {
        tasks.add(task);
        sortTasksByPriority();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    // Delete project and all tasks inside it
    public void deleteProject() {
        tasks.clear();
    }

    // Sort tasks by priority P0 (highest) to P2 (lowest)
    private void sortTasksByPriority() {
        Collections.sort(tasks, (t1, t2) -> t1.getPriority().compareTo(t2.getPriority()));
    }

    // View project along with its tasks
    public void viewProject() {
        System.out.println("  Project Name: " + name);
        for (Task task : tasks) {
            System.out.println("    " + task);
        }
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}

