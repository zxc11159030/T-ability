package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Apra extends AppCompatActivity {

    Button btAns1, btAns2, btAns3, btAns4;
    TextView tvScore, tvQuestion;

    private Question mQuestions = new Question();

    // 問題答案
    private String mAnswer;
    // 初始分數
    private int mScore = 0;
    // 問題題目數
    private int mQuestionsLength = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apra);
        r = new Random();
        btAns1 =(Button)findViewById(R.id.btIdAns1);
        btAns2 =(Button)findViewById(R.id.btIdAns2);
        btAns3 =(Button)findViewById(R.id.btIdAns3);
        btAns4 =(Button)findViewById(R.id.btIdAns4);

        tvScore =(TextView)findViewById(R.id.tvIdScore);
        tvQuestion =(TextView)findViewById(R.id.tvIdQuestion);

        tvScore.setText("Score: " + mScore);

        updateQuestion(r.nextInt(mQuestionsLength));

        btAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btAns1.getText() == mAnswer) {
                    mScore++;
                    tvScore.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });
        btAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btAns2.getText() == mAnswer) {
                    mScore++;
                    tvScore.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });
        btAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btAns3.getText() == mAnswer) {
                    mScore++;
                    tvScore.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });
        btAns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btAns4.getText() == mAnswer) {
                    mScore++;
                    tvScore.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }

            }
        });
    }
    //取得題庫中的問題、選項與答案
    private void updateQuestion(int num) {
        tvQuestion.setText(mQuestions.getQuestion(num));
        btAns1.setText(mQuestions.getChoice1(num));
        btAns2.setText(mQuestions.getChoice2(num));
        btAns3.setText(mQuestions.getChoice3(num));
        btAns4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }
    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Apra.this);
        alertDialogBuilder
                .setMessage("練習結束! 你的分數是 " + mScore + " 分。")
                .setCancelable(false)
                .setPositiveButton("閣練習一擺",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), Apra.class));
                            }
                        })
                .setNegativeButton("再會",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
