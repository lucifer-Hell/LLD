package Interviews.flipkart.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private String boardId;
    private String name;
    private boolean isPublic;  // true for public, false for private
    private List<User> users; // Reference to the team
    private List<Project> projects;

    public Board(String boardId, String name, boolean isPublic, List<User> users) {
        this.boardId = boardId;
        this.name = name;
        this.isPublic = isPublic;
        this.users = users;
        this.projects = new ArrayList<>();
    }

    // Getters and Setters
    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Project> getProjects() {
        return projects;
    }

    // Add or remove a project
    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    // Delete board and all projects inside it
    public void deleteBoard() {
        for (Project project : projects) {
            project.deleteProject();  // Deleting projects will delete all tasks inside them
        }
        projects.clear();
    }

    // View board along with its projects and tasks
    public void viewBoard() {
        System.out.println("Board Name: " + name + " (Public: " + isPublic + ")");
        users.forEach(member -> System.out.println("Team Member: " + member.getName()));
        for (Project project : projects) {
            project.viewProject();
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId='" + boardId + '\'' +
                ", name='" + name + '\'' +
                ", isPublic=" + isPublic +
                ", user=" + users +
                ", projects=" + projects +
                '}';
    }

    public void removeUser(String userId) {
        User user=users.stream().filter(user1 -> user1.getUserId().equals(userId)).findFirst().orElse(null);
        if(user!=null) {
            users.remove(user);
            System.out.println("user "+user.getName()+" removed from board "+boardId);
        };

    }

    public User addUser(User user){
        users.add(user);
        return user;
    }
}
