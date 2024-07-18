package nsu.kulishova.inArgsParser;

public class ReceivedFlags {

    private boolean GET_BRIEF_STATIC;
    private boolean GET_FULL_STATIC;
    private boolean ADD_TO_EXISTING_FILES;
    private boolean SET_RESULT_PATH;
    private String resultPath;
    private boolean SET_GENERIC_OUTPUT_FILES;
    private String genericOutputFiles;
    private String inFile1;
    private String inFile2;


    public void setBriefStaticFlag(boolean briefFlagExist)
    {
        GET_BRIEF_STATIC = briefFlagExist;
    }

    public boolean getBriefStaticFlag()
    {
        return GET_BRIEF_STATIC;
    }
    public void setFullStaticFlag(boolean fullFlagExist)
    {
        GET_FULL_STATIC = fullFlagExist;
    }

    public boolean getFullStaticFlag()
    {
        return GET_FULL_STATIC;
    }

    public void setAddToExistingFileFlag(boolean addToExistingFileFlag)
    {
        ADD_TO_EXISTING_FILES = addToExistingFileFlag;
    }

    public boolean getAddToExistingFileFlag()
    {
        return ADD_TO_EXISTING_FILES;
    }

    public void setSetResultPathFlag(boolean setResultPath)
    {
        SET_RESULT_PATH = setResultPath;
    }

    public boolean getSetResultPathFlag()
    {
        return SET_RESULT_PATH;
    }

    public void setSetResultPath(String setResultPath)
    {
        resultPath = setResultPath;
    }

    public String getSetResultPath()
    {
        return resultPath;
    }


    public void setSetGenericOutputFilesFlag(boolean setGenericOutputFiles)
    {
        SET_GENERIC_OUTPUT_FILES = setGenericOutputFiles;
    }

    public boolean getSetGenericOutputFilesFlag()
    {
        return SET_GENERIC_OUTPUT_FILES;
    }

    public void setGenericOutputFiles(String currGenericOutputFiles)
    {
        genericOutputFiles = currGenericOutputFiles;
    }

    public String getGenericOutputFiles()
    {
        return genericOutputFiles;
    }


    public void setInFile1(String inFile)
    {
        inFile1 = inFile;
    }

    public String getInFile1()
    {
        return inFile1;
    }

    public void setInFile2(String inFile)
    {
        inFile2 = inFile;
    }

    public String getInFile2()
    {
        return inFile2;
    }

}
