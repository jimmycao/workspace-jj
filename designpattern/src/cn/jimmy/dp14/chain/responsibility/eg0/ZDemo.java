package cn.jimmy.dp14.chain.responsibility.eg0;

public class ZDemo {
  public static AbstractLogger getChainLogger() {
    AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
    AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
    AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
    
    errorLogger.setNextLogger(debugLogger);
    debugLogger.setNextLogger(infoLogger);
    
    return errorLogger;
  }
  
  public static void main(String[] args) {
    AbstractLogger chainLogger = getChainLogger();
    chainLogger.log(AbstractLogger.INFO, "INFO MSG");
    System.out.println();
    
    chainLogger.log(AbstractLogger.DEBUG, "Debug MSG");
    System.out.println();
    
    chainLogger.log(AbstractLogger.ERROR, "Error MSG");
  }
}
