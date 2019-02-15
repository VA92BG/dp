package chainofresponsibility;

public class ChainOfResponsibility {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;

    }

    public static void main(String[] args) {
        
        AbstractLogger loggerChain = getChainOfLoggers();
        
       loggerChain.logMessage(AbstractLogger.INFO, "I N F O R M A T I O N");
       loggerChain.logMessage(AbstractLogger.DEBUG, "D E B U G");
       loggerChain.logMessage(AbstractLogger.ERROR, "E R R O R");

    }

}
