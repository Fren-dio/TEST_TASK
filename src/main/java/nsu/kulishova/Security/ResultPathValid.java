package nsu.kulishova.Security;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ResultPathValid {

    public boolean isResultPathCorrect(String resultPath)
    {
        try {
            Paths.get(resultPath);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

}
