package nsu.kulishova.Exceptions.FullStaticException;

public class NullStringFullStaticValueException extends Exception{

    public NullStringFullStaticValueException()
    {
        super("An error occurred while collecting full string's statistics." +
                "\nThe statistics values were not recorded");
    }

}
