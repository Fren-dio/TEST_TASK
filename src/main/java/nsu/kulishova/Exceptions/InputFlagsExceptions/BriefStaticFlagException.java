package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class BriefStaticFlagException extends Exception{
    public BriefStaticFlagException()
    {
        super("If you write '-s' flag, then it should either be the last argument given to the program, \n" +
                "or the following flag should follow it\n " +
                "For example:\n" +
                "1) java -jar util.jar -s -a\n" +
                "2) java -jar util.jar -s -o receivedPath\n" +
                "3) etc...");
    }
}
