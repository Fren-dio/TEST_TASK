package nsu.kulishova.Exceptions.FullStaticException;

public class NullIntegerFullStaticValueException extends Exception{

    public NullIntegerFullStaticValueException()
    {
        super("An error occurred while collecting full integer's statistics." +
                    "\nThe statistics values were not recorded");
    }

}