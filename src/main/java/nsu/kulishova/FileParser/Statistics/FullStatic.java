package nsu.kulishova.FileParser.Statistics;

import nsu.kulishova.Exceptions.BriefStaticException.NullBriefStaticValueException;
import nsu.kulishova.Exceptions.FullStaticException.NullFloatFullStaticValueException;
import nsu.kulishova.Exceptions.FullStaticException.NullIntegerFullStaticValueException;
import nsu.kulishova.Exceptions.FullStaticException.NullStringFullStaticValueException;
import nsu.kulishova.FileParser.DefinesString.ForStatic.FullStaticDefines;

public class FullStatic {

    private BriefStatic briefStatic;

    public void setBriefStatic(BriefStatic setBriefStatic)
    {
        briefStatic = setBriefStatic;
    }

    /*
    Add information for brief statistic for integer
     */
    private boolean intIsEmpty;
    private String minIntegerValue;
    private String maxIntegerValue;
    private String summaryIntegerValue;
    private String averageIntegerValue;

    public void setIntIsEmpty(boolean flag)
    {
        intIsEmpty = flag;
    }

    public void setInteger(String minElem, String maxElem, String summary, String average)
    {
        minIntegerValue = minElem;
        maxIntegerValue = maxElem;
        summaryIntegerValue = summary;
        averageIntegerValue = average;
    }

    /*
        Add information for brief statistic for float
         */
    private boolean floatIsEmpty;
    private String minFloatValue;
    private String maxFloatValue;
    private String summaryFloatValue;
    private String averageFloatValue;

    public void setFloatIsEmpty(boolean flag)
    {
        floatIsEmpty = flag;
    }

    public void setFloat(String minElem, String maxElem, String summary, String average)
    {
        minFloatValue = minElem;
        maxFloatValue = maxElem;
        summaryFloatValue = summary;
        averageFloatValue = average;
    }


    /*
    Add information for brief statistic for strings
     */
    private boolean stringIsEmpty;
    private String minLengthString ;
    private String minString;
    private String maxLengthString;
    private String maxString;

    public void setStringIsEmpty(boolean flag)
    {
        stringIsEmpty = flag;
    }
    public void setString(String minElem, String maxElem, String minStr, String maxStr)
    {
        minLengthString = minElem;
        minString = minStr;
        maxLengthString = maxElem;
        maxString = maxStr;
    }



    private String fullPhraseFullStatic()
    {
        return (FullStaticDefines.START_FULL_STATIC + FullStaticDefines.SHORT_STATIC +
                FullStaticDefines.INTEGER_STATIC +
                FullStaticDefines.INTEGER_COUNT + briefStatic.getCountIntegerElements() +
                FullStaticDefines.INTEGER_MIN + minIntegerValue +
                FullStaticDefines.INTEGER_MAX + maxIntegerValue +
                FullStaticDefines.INTEGER_AVERAGE + averageIntegerValue +
                FullStaticDefines.INTEGER_SUMMARY + summaryIntegerValue +
                FullStaticDefines.FLOAT_STATIC +
                FullStaticDefines.FLOAT_COUNT + briefStatic.getCountFloatElements() +
                FullStaticDefines.FLOAT_MIN + minFloatValue +
                FullStaticDefines.FLOAT_MAX + maxFloatValue +
                FullStaticDefines.FLOAT_AVERAGE + averageFloatValue +
                FullStaticDefines.FLOAT_SUMMARY + summaryFloatValue +
                FullStaticDefines.STRING_STATIC +
                FullStaticDefines.STRING_COUNT + briefStatic.getCountStringElements() +
                FullStaticDefines.STRING_MIN + minLengthString +
                FullStaticDefines.STRING_MIN_ELEM + minString +
                FullStaticDefines.STRING_MAX + maxLengthString +
                FullStaticDefines.STRING_MAX_ELEM + maxString
        );
    }


    public String getFullStatic() throws NullBriefStaticValueException,
            NullIntegerFullStaticValueException, NullFloatFullStaticValueException,
            NullStringFullStaticValueException {
        if ((briefStatic.getCountIntegerElements() == null) ||
                (briefStatic.getCountFloatElements() == null) ||
                (briefStatic.getCountStringElements() == null))
            throw new NullBriefStaticValueException();
        if ((!intIsEmpty) && ((minIntegerValue == null) || (maxIntegerValue == null) ||
                (averageIntegerValue == null) || (summaryIntegerValue == null)))
            throw new NullIntegerFullStaticValueException();
        if ((!floatIsEmpty) && ((minFloatValue == null) || (maxFloatValue == null) ||
                (averageFloatValue == null) || (summaryFloatValue == null)))
            throw new NullFloatFullStaticValueException();
        if ((!stringIsEmpty) && ((minLengthString == null) || (maxLengthString == null) ||
                (minString == null) || (maxString == null)))
            throw new NullStringFullStaticValueException();
        return (fullPhraseFullStatic());
    }



}
