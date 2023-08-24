package EducativeIo.DesignPatterns.CreatorDesignPatterns.SingletonPattern;

public class Logger {
    public static Logger logger;
    private Logger(){
        System.out.println("creating logger ");
    }
    public synchronized static Logger getInstance() throws InterruptedException {
        if(logger==null){
            Thread.sleep(1000);
            logger=new Logger();
        }
        return logger;
    }
    private void writeMessageInLog(String log) throws InterruptedException {
        System.out.println("instance number: " +this.hashCode()+" logging message: "+log);
    }
    public static void logMessage(String message) throws InterruptedException {
        Logger.getInstance().writeMessageInLog(message);
    }
}
