package nsu.kulishova.inArgsParser;

import nsu.kulishova.Exceptions.InputFlagsExceptions.*;
import nsu.kulishova.Security.ResultPathValid;
import nsu.kulishova.TextMainMenu;

public class InArgsParser {
    private boolean s_flag;
    private boolean f_flag;
    private boolean a_flag;
    private boolean o_flag;
    private String resultPath;
    private boolean p_flag;
    private String genericOutputFiles;
    private String inputFile1;
    private String inputFile2;



    /*
    Верно только если есть все флаги - нужно дописать, чтобы обрабатывался при любом их количестве
     */
    private boolean isCorrect(String[] args) throws NoInputFilesException, BriefStaticFlagException,
            FullStaticFlagException, WriteToExistFilesFlagException, SetPathToResultFlagException,
            ReceivedInputFileFlagException, MoreInputFilesException, InvalidResultPathException {
        return checkInputCorrectFlags(args);
    }

    private boolean isAllFlagsInInput(String[] args)
    {
        boolean isSFlag = false;
        boolean isFFlag = false;
        boolean isAFlag = false;
        boolean isOFlag = false;
        boolean isPFlag = false;
        for (String arg : args) {
            if (arg.equals("-s"))
                isSFlag = !isSFlag;
            if (arg.equals("-f"))
                isFFlag = !isFFlag;
            if (arg.equals("-a"))
                isAFlag = !isAFlag;
            if (arg.equals("-o"))
                isOFlag = !isOFlag;
            if (arg.equals("-p"))
                isPFlag = !isPFlag;
        }
        return ((isSFlag || isFFlag) && isAFlag && isOFlag && isPFlag);
    }


    private boolean checkInputCorrectFlags(String[] args) throws BriefStaticFlagException,
            FullStaticFlagException, WriteToExistFilesFlagException, SetPathToResultFlagException,
            ReceivedInputFileFlagException, InvalidResultPathException {
        s_flag = false;
        f_flag = false;
        a_flag = false;
        o_flag = false;
        p_flag = false;
        for (int i=0; i<args.length; i++)
        {
            if (args[i].equals("-s")) {
                if (args[i].equals("-s")) s_flag = true;
                if (!((i < args.length - 2) ))
                    throw new BriefStaticFlagException();
            }
            if (args[i].equals("-f")) {
                if (args[i].equals("-f")) f_flag = true;
                if (!((i < args.length - 2) ))
                    throw new FullStaticFlagException();
            }
            if (args[i].equals("-a")) {
                if (args[i].equals("-a")) a_flag = true;
                if (!((i < args.length - 2) ))
                    throw new WriteToExistFilesFlagException();
            }
            if (args[i].equals("-o"))
            {
                if (args[i].equals("-o")) o_flag = true;
                if (!((i < args.length - 1) && (!(args[i + 1].contains("-")))))
                    throw new SetPathToResultFlagException();
                if (!((new ResultPathValid()).isResultPathCorrect(args[i+1])))
                    throw (new InvalidResultPathException());
                else
                    resultPath = args[i+1];
            }
            if (args[i].equals("-p"))
            {
                if (args[i].equals("-p")) p_flag = true;
                if (!((i < args.length - 1) && (!(args[i + 1].contains("-")))))
                    throw new ReceivedInputFileFlagException();
                else
                    genericOutputFiles = args[i+1];
            }
        }
        inputFile1 = args[args.length-1];
        inputFile2 = args[args.length-2];
        return true;
    }


    public void parserInFlags(String[] args, ReceivedFlags receivedFlags) throws NoInputFilesException, BriefStaticFlagException,
            FullStaticFlagException, ReceivedInputFileFlagException, WriteToExistFilesFlagException,
            SetPathToResultFlagException, MoreInputFilesException, InvalidResultPathException {
        TextMainMenu textMainMenu = new TextMainMenu();
        if (args.length == 2 && args[1].equals("more")) {
            textMainMenu.getMoreInfo();
            return;
        }
        else
        {
            if (isCorrect(args))
            {
                receivedFlags.setBriefStaticFlag(s_flag);
                receivedFlags.setFullStaticFlag(f_flag);
                receivedFlags.setAddToExistingFileFlag(a_flag);
                receivedFlags.setSetResultPathFlag(o_flag);
                receivedFlags.setSetResultPath(resultPath);
                receivedFlags.setSetGenericOutputFilesFlag(p_flag);
                receivedFlags.setGenericOutputFiles(genericOutputFiles);
                receivedFlags.setInFile1(inputFile1);
                receivedFlags.setInFile2(inputFile2);
            }
            else {
                textMainMenu.getMenu();
            }
        }
    }



    private void checkIsResultPathValid(String resultPath) throws InvalidResultPathException {
        if (!((new ResultPathValid()).isResultPathCorrect(resultPath)))
            throw new InvalidResultPathException();
    }


}
