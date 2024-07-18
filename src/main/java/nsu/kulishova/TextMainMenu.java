package nsu.kulishova;

public class TextMainMenu {


    private String getMainMenuStartPhrase()
    {
        return "It's a main error menu";
    }

    public void getMenu() {
        System.out.println(getMainMenuStartPhrase());

        System.out.println("Your input is incorrect");
        System.out.println("One of variant to start program's work is:");
        System.out.println("java -jar util.jar -s -a -p sample- in1.txt in2.txt");
        System.out.println();
        System.out.println("Also, you can choose next flags");
        System.out.println("1. '-o' - sets the path for the result.");
        System.out.println("2. '-p' - specifies the prefix of the output file names.");
        System.out.println("3. '-a' - mode for adding to existing files.");
        System.out.println("4. Statistic");
        System.out.println("    a) '-s' - brief statistics");
        System.out.println("    a) '-f' - full statistics");
        System.out.println("If you want to get more information, write: java -jar util.jar more");
    }

    public void getMoreInfo()
    {
        System.out.println("One of variant to start program's work is:");
        System.out.println("java -jar util.jar -s -a -p sample- in1.txt in2.txt");
        System.out.println();
        System.out.println("Also, you can choose next flags");
        System.out.println("1. '-o' - sets the path for the result.");
        System.out.println("2. '-p' - specifies the prefix of the output file names.");
        System.out.println("Example: ");
        System.out.println("input:  -o /some/path -p result_ ");
        System.out.println("output will be write to  /some/path/result_integers.txt, /some/path/result_strings.txt, etc.\n");
        System.out.println("3. '-a' - mode for adding to existing files.");
        System.out.println("       The result files should be created as needed.\n" +
                "       If there is no data type in the incoming files, then you do not need " +
                "       to create an outgoing file that will be obviously empty.");
        System.out.println("4. Statistic");
        System.out.println("    a) '-s' - brief statistics");
        System.out.println("        Brief statistics contain only the number of items recorded in the outgoing files");
        System.out.println("    a) '-f' - full statistics");
        System.out.println("""
                        The complete statistics for numbers
                additionally contains the minimum and maximum values, the sum and the average.
                The full statistics for strings, in addition to their number, also contains the size of the
                shortest string and the longest.""");
        System.out.println("If you want to get more information, write: java -jar util.jar more");

    }

}
