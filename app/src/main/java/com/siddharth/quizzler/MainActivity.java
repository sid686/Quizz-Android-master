package com.siddharth.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
            Button mtruebutton;
            Button mfalsebut;
            TextView mquestiontextview;
            TextView mscoretextview;
            int mIndex;
            int mquestion;
            int mscore;
            ProgressBar  mProgressBar;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true),
            new TrueFalse(R.string.question_14,true),
            new TrueFalse(R.string.question_15,true),
            new TrueFalse(R.string.question_16,true),
            new TrueFalse(R.string.question_17,true),
            new TrueFalse(R.string.question_18,true)
    };

    final int progress_inc= (int) Math.ceil(100.0/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtruebutton=(Button)findViewById(R.id.true_button);
        mfalsebut=(Button)findViewById(R.id.false_button);
        mquestiontextview=(TextView) findViewById(R.id.question_text_view);
        mscoretextview=(TextView)findViewById(R.id.score);
        mProgressBar=(ProgressBar) findViewById(R.id.progress_bar);

         mquestion =mQuestionBank[mIndex].getMquestionID();
        mquestiontextview.setText(mquestion);

        View.OnClickListener mylisteer=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer(true);
                upDatequestion();



            }
        };
        mtruebutton.setOnClickListener(mylisteer);
        mfalsebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer(false);
                upDatequestion();
            }
        });



    }
    private  void upDatequestion(){
        mIndex=(mIndex+1)%mQuestionBank.length;
        if (mIndex==0){
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Gameover");
            alert.setCancelable(false);
            alert.setMessage("you scored " +mscore+ " points");
            alert.setPositiveButton("Restart application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   recreate();
                    mProgressBar.setProgress(0);
                }
            });
            alert.show();
        }
        mquestion=mQuestionBank[mIndex].getMquestionID();
        mquestiontextview.setText(mquestion);
        mscoretextview.setText("Score"+mscore+"/"+mQuestionBank.length);
        mProgressBar.incrementProgressBy(progress_inc);

    }
    private  void checkanswer(boolean userSelection){
        boolean correctanswer =mQuestionBank[mIndex].isManswer();
        if (userSelection == correctanswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }

}
