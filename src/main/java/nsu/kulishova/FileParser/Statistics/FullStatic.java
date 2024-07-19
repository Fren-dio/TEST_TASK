package nsu.kulishova.FileParser.Statistics;

import nsu.kulishova.Exceptions.BriefStaticException.NullBriefStaticValueException;
import nsu.kulishova.Exceptions.FullStaticException.NullFloatFullStaticValueException;
import nsu.kulishova.Exceptions.FullStaticException.NullIntegerFullStaticValueException;
import nsu.kulishova.Exceptions.FullStaticException.NullStringFullStaticValueException;
import nsu.kulishova.FileParser.DefinesString.BriefStaticDefines;
import nsu.kulishova.FileParser.DefinesString.FullStaticDefines;

public class FullStatic {

    private BriefStatic briefStatic;

    /*
    Add information for brief statistic for integer
     */
    private Integer minIntegerValue;
    private Integer maxIntegerValue;
    private Integer summaryIntegerValue;
    private Float averageIntegerValue;

    /*
    Add information for brief statistic for float
     */
    private Float minFloatValue;
    private Float maxFloatValue;
    private Float summaryFloatValue;
    private Float averageFloatValue;



    /*
    Add information for brief statistic for strings
     */
    private Integer minLengthString;
    private Integer maxLengthString;




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
                FullStaticDefines.STRING_MAX + maxLengthString
        );
    }


    public String getFullStatic() throws NullBriefStaticValueException,
            NullIntegerFullStaticValueException, NullFloatFullStaticValueException,
            NullStringFullStaticValueException {
        if ((briefStatic.getCountIntegerElements() == null) ||
                (briefStatic.getCountFloatElements() == null) ||
                (briefStatic.getCountStringElements() == null))
            throw new NullBriefStaticValueException();
        if ((minIntegerValue == null) || (maxIntegerValue == null) ||
                (averageIntegerValue == null) || (summaryIntegerValue == null))
            throw new NullIntegerFullStaticValueException();
        if ((minFloatValue == null) || (maxFloatValue == null) ||
                (averageFloatValue == null) || (summaryFloatValue == null))
            throw new NullFloatFullStaticValueException();
        if ((minLengthString == null) || (maxLengthString == null))
            throw new NullStringFullStaticValueException();
        return (fullPhraseFullStatic());
    }



}
