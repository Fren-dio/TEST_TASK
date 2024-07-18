package nsu.kulishova.Exceptions.InputFlagsExceptions;

public class NoInputFilesException extends Exception{
    public NoInputFilesException()
    {
        super("You have not input files to be processed");
    }
}
