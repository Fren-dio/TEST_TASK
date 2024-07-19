package nsu.kulishova.Exceptions.FullStaticException;

public class NullFloatFullStaticValueException extends Exception{

    public NullFloatFullStaticValueException()
    {
        super("An error occurred while collecting full float's statistics." +
                               "\nThe statistics values were not recorded");
    }

}
