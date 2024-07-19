package nsu.kulishova.FileParser.DefinesString;

public record BriefStaticDefines() {

    public static String START_BRIEF_STATIC = """
            It's a brief statistic about data in given input files\n
            """;

    public static String SHORT_STATIC = """
            Statistic:
            """;

    public static String INTEGER_COUNT = """
            \nThe number of integer elements: 
            """;

    public static String FLOAT_COUNT = """
            \nThe number of float elements: 
            """;

    public static String STRING_COUNT = """
            \nThe number of string elements: 
            """;

    public static String SHORT_HELP = """
            If you need more information read results file or use '-f' flag.
            """;

}
