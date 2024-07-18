package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class FullStaticFlagException extends Exception{

    public FullStaticFlagException() {
        super("If you write '-f' flag, then it should either be the last argument given to the program, \n" +
                "or the following flag should follow it\n " +
                "For example:\n" +
                "1) java -jar util.jar -f -a\n" +
                "2) java -jar util.jar -f -o receivedPath\n" +
                "3) etc...");
    }
}
