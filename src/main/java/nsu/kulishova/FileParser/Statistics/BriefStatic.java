package nsu.kulishova.FileParser.Statistics;

import nsu.kulishova.Exceptions.BriefStaticException.NullBriefStaticValueException;
import nsu.kulishova.FileParser.DefinesString.ForStatic.BriefStaticDefines;

public class BriefStatic {

    private Integer countIntegerElements;
    private Integer countFloatElements;
    private Integer countStringElements;
    private boolean briefIsEmpty;


    public BriefStatic()
    {
        countIntegerElements = 0;
        countFloatElements = 0;
        countStringElements = 0;
        briefIsEmpty = true;
    }

    public void setBriefIsEmpty(boolean flag)
    {
        briefIsEmpty = flag;
    }

    private String fullBriefPhrase()
    {
        return (BriefStaticDefines.START_BRIEF_STATIC + BriefStaticDefines.SHORT_STATIC +
                BriefStaticDefines.INTEGER_COUNT + countIntegerElements +
                BriefStaticDefines.FLOAT_COUNT + countFloatElements +
                BriefStaticDefines.STRING_COUNT + countStringElements +
                BriefStaticDefines.SHORT_HELP);
    }


    public String getBriefStatic() throws NullBriefStaticValueException {
        if ((!briefIsEmpty) && ((countIntegerElements == null) || (countFloatElements == null) ||
                (countStringElements == null)))
            throw new NullBriefStaticValueException();
        return (fullBriefPhrase());
    }


    public void setCountIntegerElements(Integer countIntegerElements) {
        this.countIntegerElements = countIntegerElements;
    }


    public void addCountIntegerElements() {
        this.countIntegerElements++;
    }

    public Integer getCountIntegerElements() {
        return this.countIntegerElements;
    }

    public void setCountFloatElements(Integer countFloatElements) {
        this.countFloatElements = countFloatElements;
    }


    public void addCountFloatElements() {
        this.countFloatElements++;
    }

    public Integer getCountFloatElements() {
        return this.countFloatElements;
    }

    public void setCountStringElements(Integer countStringElements) {
        this.countStringElements = countStringElements;
    }


    public void addCountStringElements() {
        this.countStringElements++;
    }

    public Integer getCountStringElements() {
        return this.countStringElements;
    }
}
