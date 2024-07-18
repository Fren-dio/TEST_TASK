package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class MoreInputFilesException extends Exception{
    public MoreInputFilesException() {
        super("You need to specify only 2 input files\n " +
                "For example:\n" +
                "1) java -jar util.jar -o receivedPath -p in1.txt in2.txt -s\n" +
                "2) java -jar util.jar -a -p in1.txt in2.txt\n" +
                "3) etc...");
    }
}
