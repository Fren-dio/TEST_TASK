package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class ReceivedInputFileFlagException extends Exception{
    public ReceivedInputFileFlagException() {
        super("If you write '-p' flag, Then the next argument you need to specify 2 input files\n " +
                "For example:\n" +
                "1) java -jar util.jar -o receivedPath -p in1.txt in2.txt -s\n" +
                "2) java -jar util.jar -a -p in1.txt in2.txt\n" +
                "3) etc...");
    }
}
