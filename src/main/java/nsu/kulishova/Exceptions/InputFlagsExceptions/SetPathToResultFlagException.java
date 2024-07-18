package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class SetPathToResultFlagException extends Exception{
    public SetPathToResultFlagException() {
        super("If you write '-o' flag, Then the next argument you need to specify the path in the file directory\n " +
                "For example:\n" +
                "1) java -jar util.jar -o receivedPath -s\n" +
                "2) java -jar util.jar -a -o receivedPath -s\n" +
                "3) etc...");
    }
}
