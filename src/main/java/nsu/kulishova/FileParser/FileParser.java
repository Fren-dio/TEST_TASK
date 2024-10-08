package nsu.kulishova.FileParser;

import nsu.kulishova.FileParser.DefinesString.FileParserDefines;
import nsu.kulishova.FileParser.Statistics.BriefStatic;
import nsu.kulishova.FileParser.Statistics.FullStatic;
import nsu.kulishova.inArgsParser.ReceivedFlags;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class FileParser {


    private final ArrayList<String> integersResultList = new ArrayList<String>();
    private final ArrayList<String> floatsResultList = new ArrayList<String>();
    private final ArrayList<String> stringsResultList = new ArrayList<String>();


    /*
    statistics
     */
    BriefStatic briefStatic;
    FullStatic fullStatic;

    public FileParser(BriefStatic briefStaticSet, FullStatic fullStaticSet)
    {
        briefStatic = briefStaticSet;
        fullStatic = fullStaticSet;
    }


    public BriefStatic getBriefStaticFromParser()
    {
        return briefStatic;
    }

    public FullStatic getFullStaticFromParser()
    {
        return fullStatic;
    }


    public void parseFile(ReceivedFlags receivedFlags) throws IOException {


        /*
        creating a suitable final file name with the results
         */
        String integerName = FileParserDefines.definedEndOfNameResultInteger;
        String floatName = FileParserDefines.definedEndOfNameResultFloat;
        String stringName = FileParserDefines.definedEndOfNameResultString;
        if (receivedFlags.getSetResultPathFlag() && receivedFlags.getSetGenericOutputFilesFlag())
        {
            integerName = receivedFlags.getSetResultPath() + "/" + receivedFlags.getGenericOutputFiles() +
                    FileParserDefines.definedEndOfNameResultInteger;
            floatName = receivedFlags.getSetResultPath() + "/" + receivedFlags.getGenericOutputFiles() +
                    FileParserDefines.definedEndOfNameResultFloat;
            stringName = receivedFlags.getSetResultPath() + "/" + receivedFlags.getGenericOutputFiles() +
                    FileParserDefines.definedEndOfNameResultString;
        }
        else if (receivedFlags.getSetResultPathFlag()) {
            integerName = receivedFlags.getSetResultPath() + "/" + FileParserDefines.definedEndOfNameResultInteger;
            floatName = receivedFlags.getSetResultPath() + "/" + FileParserDefines.definedEndOfNameResultFloat;
            stringName = receivedFlags.getSetResultPath() + "/" + FileParserDefines.definedEndOfNameResultString;
        }
        else if (receivedFlags.getSetGenericOutputFilesFlag()) {
            integerName = receivedFlags.getGenericOutputFiles() + FileParserDefines.definedEndOfNameResultInteger;
            floatName = receivedFlags.getGenericOutputFiles() + FileParserDefines.definedEndOfNameResultFloat;
            stringName = receivedFlags.getGenericOutputFiles() + FileParserDefines.definedEndOfNameResultString;
        }

        /*
        file names for recording results
         */
        String fileName1 = receivedFlags.getInFile1();
        String fileName2 = receivedFlags.getInFile2();

        /*
        writing to a lists and processing data
         */
        BufferedReader in1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader in2 = new BufferedReader(new FileReader(fileName2));
        goThroughFile(receivedFlags, in1, in2);
        in1.close();
        in2.close();


        /*
        write from lists to result files
         */
        if (!integersResultList.isEmpty()) {
            collectContentForFullIntegerStatistic(integersResultList);
            fullStatic.setIntIsEmpty(false);
            BufferedWriter writerInteger = new BufferedWriter(new FileWriter(integerName, receivedFlags.getAddToExistingFileFlag()));
            addFromListToFile(writerInteger, receivedFlags, integerName, integersResultList);
            writerInteger.close();
        }
        else {
            fullStatic.setIntIsEmpty(true);
        }
        if (!floatsResultList.isEmpty()) {
            collectContentForFullFloatStatistic(floatsResultList);
            fullStatic.setFloatIsEmpty(false);
            BufferedWriter writerFloat = new BufferedWriter(new FileWriter(floatName, receivedFlags.getAddToExistingFileFlag()));
            addFromListToFile(writerFloat, receivedFlags, floatName, floatsResultList);
            writerFloat.close();
        }
        else {
            fullStatic.setFloatIsEmpty(true);
        }
        if (!stringsResultList.isEmpty()) {
            collectContentForFullStringStatistic(stringsResultList);
            fullStatic.setStringIsEmpty(false);
            BufferedWriter writerString = new BufferedWriter(new FileWriter(stringName, receivedFlags.getAddToExistingFileFlag()));
            addFromListToFile(writerString, receivedFlags, stringName, stringsResultList);
            writerString.close();
        }
        else {
            fullStatic.setStringIsEmpty(true);
        }

        /*
        This data yet was written, just send to full statistic
         */
        fullStatic.setBriefStatic(briefStatic);

    }


    private void collectContentForFullIntegerStatistic(ArrayList<String> integersResultList)
    {
        BigInteger minElem = BigInteger.valueOf(Long.parseLong((integersResultList.get(0))));
        //int minElem = Integer.parseInt(integersResultList.get(0));
        BigInteger maxElem = BigInteger.valueOf(Long.parseLong(integersResultList.get(0)));
        BigInteger sumElems = BigInteger.valueOf(0);
        for (String s : integersResultList) {
            if (minElem.compareTo(BigInteger.valueOf(Long.parseLong((s)))) > 0)
                minElem = BigInteger.valueOf(Long.parseLong((s)));
            if (maxElem.compareTo(BigInteger.valueOf(Long.parseLong((s)))) < 0)
                maxElem = BigInteger.valueOf(Long.parseLong((s)));
            sumElems = sumElems.add(BigInteger.valueOf(Long.parseLong((s))));
        }
        int size = integersResultList.size();
        fullStatic.setInteger(minElem.toString(), maxElem.toString(), sumElems.toString(),
                (sumElems.divide(BigInteger.valueOf(size))).toString());
    }


    private void collectContentForFullFloatStatistic(ArrayList<String> floatsResultList)
    {
        BigDecimal minElem = BigDecimal.valueOf(Double.parseDouble((floatsResultList.get(0))));
        BigDecimal maxElem = BigDecimal.valueOf(Double.parseDouble(floatsResultList.get(0)));
        BigDecimal sumElems = BigDecimal.valueOf(0.0);
        for (String s : floatsResultList) {
                if (minElem.compareTo(BigDecimal.valueOf(Double.parseDouble(s))) > 0)
                    minElem = BigDecimal.valueOf(Double.parseDouble(s));
                if (maxElem.compareTo(BigDecimal.valueOf(Double.parseDouble(s))) < 0)
                    maxElem = BigDecimal.valueOf(Double.parseDouble(s));
                sumElems = sumElems.add(BigDecimal.valueOf(Double.parseDouble(s)));

        }
        int size = floatsResultList.size();
        fullStatic.setFloat(minElem.toString(), maxElem.toString(), sumElems.toString(),
                (sumElems.divide(BigDecimal.valueOf(size), BigDecimal.ROUND_UP)).toString());
    }


    private void collectContentForFullStringStatistic(ArrayList<String> floatsResultList)
    {
        BigInteger minElem = BigInteger.valueOf(integersResultList.get(0).length());
        String minStr = "";
        BigInteger maxElem = BigInteger.valueOf(integersResultList.get(0).length());
        String maxStr = "";
        for (String s : floatsResultList) {
            if (minElem.compareTo(BigInteger.valueOf(s.length())) > 0) {
                minElem = BigInteger.valueOf(s.length());
                minStr = s;
            }
            if (maxElem.compareTo(BigInteger.valueOf(s.length())) < 0) {
                maxElem = BigInteger.valueOf(s.length());
                maxStr = s;
            }
        }
        fullStatic.setString(minElem.toString(), maxElem.toString(), minStr, maxStr);
    }



    private void addFromListToFile(BufferedWriter writer, ReceivedFlags receivedFlags, String stringName,
                                   ArrayList<String> resultList) throws IOException {
        for (String s : resultList)
        {
            if (receivedFlags.getAddToExistingFileFlag())
                writer.append(s).append("\n");
            else
                writer.write(s + "\n");
        }
    }


    /*
    read both input files, add strings to results list and collect statistic
     */
    private void goThroughFile(ReceivedFlags receivedFlags, BufferedReader in1, BufferedReader in2) throws IOException {
        String str;
        boolean file1Flag = true;
        boolean file2Flag = true;

        while (file1Flag || file2Flag) {

            if ((str = in2.readLine()) != null) {
                addToNeedList(receivedFlags, str);
            } else {
                file2Flag = false;
            }

            if ((str = in1.readLine()) != null) {
                addToNeedList(receivedFlags, str);
            } else {
                file1Flag = false;
            }
        }
    }


    /*
    collect info for statistic and add element to list
     */
    private void addToNeedList(ReceivedFlags receivedFlags, String str) throws IOException {
        String type = findCorrectStringType(str);
        if (type.equals(FileParserDefines.StringIntegerType)) {
            briefStatic.addCountIntegerElements();
            briefStatic.setBriefIsEmpty(false);
            integersResultList.add(str);
        } else if (type.equals(FileParserDefines.StringFloatType)) {
            briefStatic.addCountFloatElements();
            briefStatic.setBriefIsEmpty(false);
            floatsResultList.add(str);
        } else if (type.equals(FileParserDefines.StringStringType)) {
            briefStatic.addCountStringElements();
            briefStatic.setBriefIsEmpty(false);
            stringsResultList.add(str);
        }
    }


    private String findCorrectStringType(String str)
    {
        if(str.matches("[+-]?[0-9]+")) {
            return FileParserDefines.StringIntegerType;
        }
        else if(str.matches("[+-]?[0-9]*\\.[0-9]*") ||
                str.matches("[+-]?[0-9]*\\.[0-9]*E[+-]?[0-9][0-9]*")) {
            return FileParserDefines.StringFloatType;
        }
        else {
            return FileParserDefines.StringStringType;
        }
    }


}
