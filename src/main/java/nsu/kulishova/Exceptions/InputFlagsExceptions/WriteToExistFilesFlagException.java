package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class WriteToExistFilesFlagException extends Exception{

    public WriteToExistFilesFlagException() {
        super("If you write '-a' flag, then it should either be the last argument given to the program, \n" +
                "or the following flag should follow it\n " +
                "For example:\n" +
                "1) java -jar util.jar -a -s\n" +
                "2) java -jar util.jar -a -o receivedPath\n" +
                "3) etc...");
    }
}
