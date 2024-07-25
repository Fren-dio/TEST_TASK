package nsu.kulishova;

import nsu.kulishova.FileParser.FileParser;
import nsu.kulishova.FileParser.Statistics.BriefStatic;
import nsu.kulishova.FileParser.Statistics.FullStatic;
import nsu.kulishova.inArgsParser.InArgsParser;
import nsu.kulishova.inArgsParser.ReceivedFlags;

public class Main {

    static ReceivedFlags receivedFlags;

    static BriefStatic briefStatic = new BriefStatic();
    static FullStatic fullStatic = new FullStatic();

    public static void main(String[] args) {
        try {
            receivedFlags = new ReceivedFlags();
            InArgsParser inArgsParser = new InArgsParser();
            inArgsParser.parserInFlags(args, receivedFlags);


            FileParser fileParser = new FileParser(briefStatic, fullStatic);
            fileParser.parseFile(receivedFlags);

            if (receivedFlags.getBriefStaticFlag())
            {
                System.out.println((fileParser.getBriefStaticFromParser()).getBriefStatic());
            }

            if (receivedFlags.getFullStaticFlag())
            {
                System.out.println((fileParser.getFullStaticFromParser()).getFullStatic());
            }

        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
            System.out.println();
            System.out.println("An error was received during the operation of the program");
            System.out.println("Please read the 'more', use the command to do this: \n" +
                               "'java -jar util.jar more'\n " +
                               "or \n" +
                               "'java -jar util.jar'");
        }
        finally {
            System.out.println("The work of the program has been completed");
        }
    }
}