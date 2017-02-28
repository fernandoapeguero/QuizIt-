package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// intent and values to keep track of the score from activity to activity and lock activity after  been use
        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScoreOne", 0));
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passScoreTwo", 0));
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passScoreThird", 0));
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passScoreFourth", 0));
        // pass close value to close the activity after answering the question
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
// instantiating the onlcik listener for each activity intent
        enterQuestionOne();
        enterQuestionTwo();
        enterQuestionThree();
        enterQuestionFour();
        enterQuestionFive();
        enterQuestionSix();

    }

    public void enterQuestionOne() {

        TextView oneTextView = (TextView) findViewById(R.id.question_1);

        oneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookOfQuestion.getCloseOne() < 1) {
                    Intent firstIntent = new Intent(MainActivity.this, QuestionOne.class);
                    firstIntent.putExtra("passedScore", bookOfQuestion.getTotalScore());
                    firstIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    firstIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                    startActivity(firstIntent);
                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question. ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void enterQuestionTwo() {

        TextView secondTextView = (TextView) findViewById(R.id.question_2);

        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookOfQuestion.getCloseTwo() < 1) {
                    Intent secondIntent = new Intent(MainActivity.this, QuestionTwo.class);
                    secondIntent.putExtra("passedScoreTwo", bookOfQuestion.getTotalScore());
                    secondIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    secondIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                    startActivity(secondIntent);
                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void enterQuestionThree() {

        TextView thirdTextView = (TextView) findViewById(R.id.question_3);

        thirdTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookOfQuestion.getCloseThird() < 1) {
                    Intent thirdIntent = new Intent(MainActivity.this, QuestionThree.class);
                    thirdIntent.putExtra("passScoreThird", bookOfQuestion.getTotalScore());
                    thirdIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    thirdIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    thirdIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                    startActivity(thirdIntent);
                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void enterQuestionFour() {

        TextView FourthTextView = (TextView) findViewById(R.id.question_4);

        FourthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bookOfQuestion.getCloseFourth() < 1) {
                    Intent fourthIntent = new Intent(MainActivity.this, QuestionFour.class);
                    fourthIntent.putExtra("passScoreFourht", bookOfQuestion.getTotalScore());
                    fourthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    fourthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    fourthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                    startActivity(fourthIntent);
                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void enterQuestionFive() {

    }

    public void enterQuestionSix() {

    }

}
