package nsu.kulishova;

import nsu.kulishova.inArgsParser.InArgsParser;

public class Main {
    public static void main(String[] args) {
        try {
            InArgsParser inArgsParser = new InArgsParser();
            inArgsParser.parserInFlags(args);
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