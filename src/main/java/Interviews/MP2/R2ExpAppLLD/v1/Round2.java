package Interviews.MP2.R2ExpAppLLD.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Round2 {
    static class User{
        String userName;
        String id;

        User(String userName){
            this.userName=userName;
            this.id=UUID.randomUUID().toString();
        }
    }

    enum SplitType{
        EXACT,EQUAL,PERCENTAGE
    }
    interface SplitStrategy{
        HashMap<User,Double> split(double amt,List<User> users,User userPaidBy);
    }

    public static class EqualSplit implements  SplitStrategy{

        @Override
        public HashMap<User,Double> split( double amt,List<User> users,User userPaidBy) {
            double eachAmt=amt/users.size();
            HashMap<User,Double> map=new HashMap<>();
            for(User user : users){
                if(user.equals(userPaidBy))continue;
                map.put(user,eachAmt);
            }
            return map;
        }
    }

    public class SplitFactory{
        public static SplitStrategy getSplitStrategy(SplitType splitType){
            if(splitType.equals(SplitType.EQUAL)){
                return new EqualSplit();
            }
            // todo add more strategies
            else return null;
        }
    }

    // Models
    // EXP 1 U1 20 U2 30
    // EXP 2 U2 20 U1 30
    static class Expense{
        // 3 USERS - U1 - 100RS  U2 HAS TO PAY U1 - RS 30 RS U3 HAS TO PAY U1 - 40RS
        String id;
        double totalAmt;
        HashMap<User,Double> pendingAmtMap;
        // < U2 , 30 >
        // < U3 , 40 >
        User paidBy;
        SplitType splitType;

        Expense(User paidBy, List<User> usersUnpaid,double totalAmt,SplitType splitType){
            this.id=UUID.randomUUID().toString();
            this.paidBy=paidBy;
            this.totalAmt=totalAmt;
            this.splitType=splitType;
            // TODO ADD PENDING AMT MAP
            SplitStrategy splitStrategy=SplitFactory.getSplitStrategy(splitType);
            pendingAmtMap=splitStrategy.split(totalAmt,usersUnpaid,paidBy);
        }

    }

    static class ExpenseService{
        private static ExpenseService instance;
        ConcurrentHashMap<String,User> userRepo;
        ConcurrentHashMap<String,Expense> expenseRepo;
        ExpenseService(){
            userRepo=new ConcurrentHashMap<>();
            expenseRepo=new ConcurrentHashMap<>();
        }

        public Expense addExpense(Expense expense){
            expense.id= UUID.randomUUID().toString();
            expenseRepo.put(expense.id,expense);
            return expense;
        }
        public static ExpenseService getInstance(){
            if(instance==null) {
                instance=new ExpenseService();
                return instance;
            }
            else return instance;
        }

        public HashMap<User,Double> findPendingPayments(User user){
            // FIND THE EXPENSE RELATED TO USERS
            List<Expense> expenses=getUnpaidExpenses(user);
            return generatePendingPaymentMap(expenses,user);
        }

        private HashMap<User, Double> generatePendingPaymentMap(List<Expense> expenses,User user) {
            HashMap<User,Double> map=new HashMap<>();
            for(Expense expense : expenses){
                double pendingAmt=expense.pendingAmtMap.get(user);
                map.put(expense.paidBy,map.getOrDefault(expense.paidBy,0.00)+pendingAmt);
            }
            return map;
        }

        private List<Expense> getUnpaidExpenses(User user) {
            List<Expense> pendingExp=new ArrayList<>();
             for(Expense expense : expenseRepo.values()){
                if(expense.pendingAmtMap.containsKey(user)){
                    pendingExp.add(expense);
                }
            }
            return pendingExp;
        }
    }
    public static void main(String[] args) {
        User user=new User("RAM");
        User user1=new User("SHYAM");
        User user2=new User("RAHUL");

        ExpenseService expenseService=ExpenseService.getInstance();
        expenseService.addExpense(new Expense(
                user,List.of(user1,user2,user),100,SplitType.EQUAL
        ));
        System.out.println("pending payments for user: "+user1.userName);
        expenseService.findPendingPayments(user1).forEach((k,v)->{
            System.out.println("user "+k.userName+" pending "+v);
        });

    }
}
