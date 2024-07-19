package nsu.kulishova.Exceptions.BriefStaticException;

public class NullBriefStaticValueException extends Exception{

    public NullBriefStaticValueException()
    {
        super("An error occurred while collecting brief statistics. " +
                "\nThe statistics values were not recorded");
    }

}
