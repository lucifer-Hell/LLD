//package Interviews.Bitgo;
//
//public class Round2 {
//    public static void main(String[] args) {
//
//    }
//}
//
//
//import java.util.*;
//        import java.io.*;
//
//class Row{
//    String rowId;
//    // represent each coloum value
//    List<String> values;
//
//    Row(List<String> values){
//        rowId=UUID.randomUUID().toString();
//        if(values.size()==0) throw new RuntimeException("Values can't be empty");
//        this.values=values;
//    }
//
//    void prettyPrint(){
//        String str="";
//        System.out.println();
//        for(String value : values) str+=value + " ";
//        System.out.println(str);
//        System.out.println();
//    }
//
//}
//class TableMeta{
//    String tableName;
//    List<String> coloumns;
//    TableMeta(List<String> coloumns,String tableName){
//        if(coloumns.size()==0) throw new RuntimeException("Coloumn cannot be empty ");
//        this.coloumns=coloumns;
//        this.tableName=tableName;
//    }
//}
//
//class IndexMap{
//    HashMap<String,Row> rowMap;
//    IndexMap(){
//        this.rowMap=new HashMap<>();
//    }
//}
//
//class Table{
//    TableMeta tableMeta;
//    IndexMap idxMap;
//    Table(TableMeta tableMeta){
//        this.tableMeta=tableMeta;
//        idxMap=new IndexMap();
//    }
//    // returns row id after insertion
//    String insertRow(List<String> values){
//        if(values.size()!=tableMeta.coloumns.size()) throw new RuntimeException("Invalid no of values provided ");
//        // check for row duplicay
//        for(Row row : idxMap.rowMap.values()){
//            List<String> temp=row.values;
//            boolean areAllEqual=true;
//            for(int i=0;i<temp.size();i++)
//                if(!temp.get(i).equals(values.get(i))){
//                    areAllEqual=false;
//                    break;
//                }
//            if(areAllEqual) throw new RuntimeException("Duplicate Row Insertion failed ");
//        }
//        // create new row
//        Row row=new Row(values);
//        // add in map
//        idxMap.rowMap.put(row.rowId,row);
//        System.out.println("Row sucesfully inserted with row id "+row.rowId);
//        return row.rowId;
//    }
//
//    Row getRow(String rowId){
//        if(idxMap.rowMap.containsKey(rowId)) return idxMap.rowMap.get(rowId);
//        else throw new RuntimeException("Row not found ");
//    }
//
//}
//class Database{
//    private static Database instance;
//    String databaseName;
//    Map<String,Table> tableMap;
//    Database(String databaseName){
//        this.databaseName=databaseName;
//        this.tableMap=new HashMap<>();
//        System.out.println("database intialized with nae "+databaseName);
//    }
//
//    Table addTable(TableMeta tableMeta){
//        String tableName= tableMeta.tableName;
//        if(tableMap.containsKey(tableName))
//            throw new RuntimeException("Duplicate Table entry");
//        Table table= new Table(tableMeta);
//        tableMap.put(tableName,table);
//        System.out.println("Table created with table name "+table.tableMeta.tableName);
//        return table;
//    }
//
//    void deleteTable(String tableName){
//
//    }
//    void modifyTable(String tableName, TableMeta tableMeta){
//
//    }
//
//}
//
//
//
//class Main {
//
//// Database --> List of tables -> List of rows , tableMeta
//// table -> select / update ..
//// Database -> create ,delete ...
//// Table -> create ,delete
//
//    public static void main (String[] args) {
//
//        try{
//
//            Database db1=new Database("Bitgo");
//            TableMeta userTableMeta=new TableMeta(List.of("Username","Address","DEPT"),"User Table");
//            Table userTable =db1.addTable(userTableMeta);
//            // ADD ROW
//            String row1Id=userTable.insertRow(List.of("Ram","DELHI","TECH"));
//            String row2Id=userTable.insertRow(List.of("Shyam","DELHI","TECH"));
//            // String row3Id=userTable.insertRow(List.of("Shyam","DELHI","TECH"));
//            Row row1= userTable.getRow(row1Id);
//            row1.prettyPrint();
//            Row row2= userTable.getRow(row2Id);
//            row2.prettyPrint();
//
//
//            // TableMeta userTableMeta2=new TableMeta(List.of("Username","Address","DEPT"),"User Table");
//            // Table userTable2 =db1.addTable(userTableMeta2);
//            // System.out.print(Foo("hello"));
//
//
//        }catch(Exception ex){
//            System.out.println("EX occured "+ex.getMessage());
//        }
//
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
