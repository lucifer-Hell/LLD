package Interviews.flipkart.machine_coding_round.enums;

import Interviews.flipkart.machine_coding_round.enums.models.Board;
import Interviews.flipkart.machine_coding_round.enums.models.Project;
import Interviews.flipkart.machine_coding_round.enums.models.Task;
import Interviews.flipkart.machine_coding_round.enums.models.User;
import Interviews.flipkart.machine_coding_round.enums.service.TaskMgmtService;

public class TaskMgmtServiceDemo {

    public static void main(String[] args) {
        TaskMgmtService taskMgmtService = TaskMgmtService.getInstance();

        // USER CREATE
        User scott = taskMgmtService.createUser("Scott", "scott@g.in");
        User brett = taskMgmtService.createUser("Brett", "brett@g.in");
        User tina = taskMgmtService.createUser("Tina", "tina@g.in");
        User chan = taskMgmtService.createUser("Chan", "chan@g.in");
        User thor = taskMgmtService.createUser("Thor", "thor@g.in");

        // BOARD CREATE
        Board ordersBoard = taskMgmtService.createBoard("OrdersProjectBoard", true);
        Board supplyBoard = taskMgmtService.createBoard("SupplyProjectBoard", false);
        Board androidBoard = taskMgmtService.createBoard("AndroidProjectBoard", true);

        // ADD_MEMBER to a Board
        taskMgmtService.addMemberToBoard(ordersBoard.getBoardId(), scott.getUserId());
        taskMgmtService.addMemberToBoard(supplyBoard.getBoardId(), brett.getUserId());

        // LIST CREATE
        Project orderList1 = taskMgmtService.createProject(ordersBoard.getBoardId(), "OrderProjectList1");
        Project orderList2 = taskMgmtService.createProject(ordersBoard.getBoardId(), "OrderProjectList2");
        Project androidList1 = taskMgmtService.createProject(androidBoard.getBoardId(), "AndroidProjectList1");
        Project androidList2 = taskMgmtService.createProject(androidBoard.getBoardId(), "AndroidProjectList2");
        Project supplyList1=taskMgmtService.createProject(supplyBoard.getBoardId(),"SupplyList1");

        // TASK CREATE
        Task task1 = taskMgmtService.createTask(orderList1.getProjectId(), "OrderProjectTask1", Priority.P0);
        Task task2 = taskMgmtService.createTask(orderList1.getProjectId(), "OrderProjectTask2", Priority.P2);
        Task task3 = taskMgmtService.createTask(orderList2.getProjectId(), "OrderProjectTask3", Priority.P1);
        Task task4 = taskMgmtService.createTask(supplyList1.getProjectId(), "SupplyProjectTask1", Priority.P1);

        // TASK ASSIGN
        taskMgmtService.assignUserToTask(task1.getTaskId(), scott.getUserId());
        taskMgmtService.assignUserToTask(task3.getTaskId(), brett.getUserId());
        taskMgmtService.assignUserToTask(task4.getTaskId(), scott.getUserId());


        // TASK UNASSIGN
        taskMgmtService.unassignUserFromTask(task1.getTaskId());
        // VIEW BOARD
        taskMgmtService.viewBoard(ordersBoard.getBoardId());
        // TASK MOVE IN THE BOARD ACROSS PROJECTS
        taskMgmtService.moveTask(task1.getTaskId(), orderList1.getProjectId(), orderList2.getProjectId(), scott.getUserId());

        // MOVE TASK ACROSS BOARDS
        taskMgmtService.moveTask(task1.getTaskId(), orderList2.getProjectId(), androidList1.getProjectId(), scott.getUserId());

        try {
            // TRY TO MOVE TASK TO PRIVATE BOARD IN ERROR
            taskMgmtService.moveTask(task2.getTaskId(), orderList1.getProjectId(), supplyList1.getProjectId(), scott.getUserId());
        }catch (Exception ex){
            System.out.println("Exception "+ex.getMessage());
        }

        // BOARD DELETE
        taskMgmtService.deleteBoard(supplyBoard.getBoardId());

        // DELETE A USER
        taskMgmtService.deleteUser(scott.getUserId());

        // TASK DELETE
        taskMgmtService.deleteTask(task2.getTaskId());

        // LIST DELETE
        taskMgmtService.deleteProject(orderList2.getProjectId());



    }
}

