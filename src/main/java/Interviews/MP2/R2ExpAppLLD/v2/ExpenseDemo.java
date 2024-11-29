package Interviews.MP2.R2ExpAppLLD.v2;

public class ExpenseDemo {
    public static void main(String[] args) {

        // EXPENSE APP
        // USER WILL BE PAYING FOR HIMSLEF AND OTHER FOLKS
        // EXPENSE CAN BE DISTRIBUTED IN VARIOUS WAYS
        // APP SHOULD TELL HOW MUCH USER TO HAVE TO PAY TO OTHER USERS
        /*
            Services
                ExpenseService
                    addExpense(expense)
                   // more crud ...
                   getUnpaidExpenseForUser( user )
                   payBackToUser( user )
            Repo
                UserRepo
                ExpenseRepo
            Model
                User ( username, id)
                Expense ( id, amt , paidBy , List<User> paidFor, splitType)
        * */
    }
}
