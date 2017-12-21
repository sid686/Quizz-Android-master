package com.siddharth.quizzler;

/**
 * Created by siddharth sharma on 12/14/2017.
 */

public class TrueFalse {
    private int mquestionID;
    private boolean manswer;
    public TrueFalse(int questionId, boolean truefalse){
        mquestionID=questionId;
        manswer=truefalse;
    }

    public int getMquestionID() {
        return mquestionID;
    }

    public void setMquestionID(int mquestionID) {
        this.mquestionID = mquestionID;
    }

    public boolean isManswer() {
        return manswer;
    }

    public void setManswer(boolean manswer) {
        this.manswer = manswer;
    }
}
