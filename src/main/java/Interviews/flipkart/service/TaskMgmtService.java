package Interviews.flipkart.service;

import Interviews.flipkart.enums.Priority;
import Interviews.flipkart.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.*;

public class TaskMgmtService {
    private static TaskMgmtService instance;
    private final Map<String, Task> taskRepo;
    private final Map<String, Project> projectRepo;
    private final Map<String, Board> boardRepo;
    private final Map<String, User> userRepo;

    private TaskMgmtService(){
        this.taskRepo = new HashMap<>();
        this.projectRepo = new HashMap<>();
        this.boardRepo = new HashMap<>();
        this.userRepo = new HashMap<>();
    }

    public static synchronized TaskMgmtService getInstance(){
        if(instance == null) {
            synchronized (TaskMgmtService.class){
                System.out.println("Created new instance of task mgmt service ");
                instance = new TaskMgmtService();
            }
        }
        return instance;
    }

    private String generateRandomId(String prefix){
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8);
    }

    // USER
    public User createUser(String name, String email) {
        User existing = userRepo.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
        if(existing != null) throw new RuntimeException("Email already exists");

        User user = new User(generateRandomId("U"), name, email);
        System.out.println("User created with ID: " + user.getUserId());
        userRepo.put(user.getUserId(), user);
        return user;
    }

    // Delete a user and remove them from all tasks
    public void deleteUser(String userId) {
        User user = userRepo.get(userId);
        if (user != null) {
            taskRepo.values().forEach(task -> {
                if (user.equals(task.getAssignedUser())) {
                    task.unassignUser();
                }
            });
            boardRepo.values().forEach(board -> {
                board.removeUser(userId);
            });
            userRepo.remove(userId);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    // BOARD
    public Board createBoard(String name, boolean isPublic) {
        String boardId = generateRandomId("B");
        Board board = new Board(boardId, name, isPublic,new ArrayList<>());
        boardRepo.put(boardId, board);
        System.out.println("Board created with ID: " + boardId);
        return board;
    }

    // Add a user to a board
    public void addMemberToBoard(String boardId, String userId) {
        Board board = boardRepo.get(boardId);
        User user = userRepo.get(userId);
        if (board != null && user != null) {
            board.addUser(user);
            System.out.println("User " + userId + " added to Board " + boardId);
        } else {
            throw new RuntimeException("Board or User not found");
        }
    }

    // Remove a user from a board
    public void removeMemberFromBoard(String boardId, String userId) {
        Board board = boardRepo.get(boardId);
        User user = userRepo.get(userId);
        if (board != null && user != null) {
            board.removeUser(userId);
            System.out.println("User " + userId + " removed from Board " + boardId);
        } else {
            throw new RuntimeException("Board or User not found");
        }
    }

    // Delete a board (deletes all projects and tasks within the board)
    public void deleteBoard(String boardId) {
        Board board = boardRepo.get(boardId);
        if (board != null) {
            board.deleteBoard();
            boardRepo.remove(boardId);
            System.out.println("Board " + boardId + " deleted");
        } else {
            throw new RuntimeException("Board not found");
        }
    }

    // View a board and all its projects and tasks
    public void viewBoard(String boardId) {
        Board board = boardRepo.get(boardId);
        if (board != null) {
            board.viewBoard();
        } else {
            throw new RuntimeException("Board not found");
        }
    }

    // PROJECT
    public Project createProject(String boardId, String projectName) {
        Board board = boardRepo.get(boardId);
        if (board == null) {
            throw new RuntimeException("Board not found");
        }
        String projectId = generateRandomId("P");
        Project project = new Project(projectId, projectName, board);
        board.addProject(project);
        projectRepo.put(projectId, project);
        System.out.println("Project created with ID: " + projectId);
        return project;
    }

    // TASK
    public Task createTask(String projectId, String taskName, Priority priority) {
        Project project = projectRepo.get(projectId);
        if (project == null) {
            throw new RuntimeException("Project not found");
        }
        String taskId = generateRandomId("T");
        Task task = new Task(taskId, taskName, priority);
        project.addTask(task);
        taskRepo.put(taskId, task);
        System.out.println("Task created with ID: " + taskId);
        return task;
    }

    // Assign a user to a task
    public void assignUserToTask(String taskId, String userId) {
        Task task = taskRepo.get(taskId);
        User user = userRepo.get(userId);
        if (task != null && user != null) {
            task.assignUser(user);
            System.out.println("User " + userId + " assigned to Task " + taskId);
        } else {
            throw new RuntimeException("Task or User not found");
        }
    }

    // Unassign a user from a task
    public void unassignUserFromTask(String taskId) {
        Task task = taskRepo.get(taskId);
        if (task != null) {
            task.unassignUser();
            System.out.println("User unassigned from Task " + taskId);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    // Delete a task
    public void deleteTask(String taskId) {
        Task task = taskRepo.get(taskId);
        if (task != null) {
            Project project = projectRepo.values().stream()
                    .filter(p -> p.getTasks().contains(task))
                    .findFirst()
                    .orElse(null);
            if (project != null) {
                project.removeTask(task);
            }
            taskRepo.remove(taskId);
            System.out.println("Task " + taskId + " deleted");
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    // Delete a project (deletes all tasks within the project)
    public void deleteProject(String projectId) {
        Project project = projectRepo.get(projectId);
        if (project != null) {
            project.deleteProject();
            projectRepo.remove(projectId);
            System.out.println("Project " + projectId + " deleted");
        } else {
            throw new RuntimeException("Project not found");
        }
    }

    // Move task from one project to another
    public void moveTask(String taskId, String fromProjectId, String toProjectId, String userId) {
        Task task = taskRepo.get(taskId);
        Project fromProject = projectRepo.get(fromProjectId);
        Project toProject = projectRepo.get(toProjectId);
        User user = userRepo.get(userId);
        if (task != null && fromProject != null && toProject != null && user != null) {
            if (toProject.getBoard().isPublic() || toProject.getBoard().getUsers().contains(userId)) {
                fromProject.removeTask(task);
                toProject.addTask(task);
                System.out.println("Task " + taskId + " moved from " + fromProjectId + " to " + toProjectId);
            } else {
                throw new RuntimeException("Permission denied to move the task to the private board.");
            }
        } else {
            throw new RuntimeException("Task, Project, or User not found.");
        }
    }
}
