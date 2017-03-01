package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();
    private int finishQuiz;

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
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passScoreFifth", 0));
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passScoreSixth", 0));
        // pass close value to close the activity after answering the question
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
        bookOfQuestion.setCloseFifth(getIntent.getIntExtra("passCloseFifth", 0));
        bookOfQuestion.setCloseSixth(getIntent.getIntExtra("passCloseSixth", 0));
// instantiating the onlcik listener for each activity intent
        enterQuestionOne();
        enterQuestionTwo();
        enterQuestionThree();
        enterQuestionFour();
        enterQuestionFive();
        enterQuestionSix();
// setting the restart and grade button onclick listener
        gradeTheQuiz();
        restartQuiz();

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
                    firstIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                    firstIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                    firstIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
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
                    secondIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                    secondIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                    secondIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
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
                    thirdIntent.putExtra("passedScoreThird", bookOfQuestion.getTotalScore());
                    thirdIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    thirdIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    thirdIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                    thirdIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                    thirdIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
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
                    fourthIntent.putExtra("passedScoreFourth", bookOfQuestion.getTotalScore());
                    fourthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    fourthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    fourthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                    fourthIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                    fourthIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                    startActivity(fourthIntent);
                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void enterQuestionFive() {

        TextView fifthTextView = (TextView) findViewById(R.id.question_5);

        fifthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bookOfQuestion.getCloseFifth() < 1) {
                    Intent fifthIntent = new Intent(MainActivity.this, QuestionFive.class);
                    fifthIntent.putExtra("passedScoreFifth", bookOfQuestion.getTotalScore());
                    fifthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    fifthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    fifthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                    fifthIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                    fifthIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                    startActivity(fifthIntent);
                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void enterQuestionSix() {

        TextView sixthTextView = (TextView) findViewById(R.id.question_6);

        sixthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookOfQuestion.getCloseSixth() < 1) {
                    Intent sixthIntent = new Intent(MainActivity.this, QuestionSix.class);
                    sixthIntent.putExtra("passedScoreSixth", bookOfQuestion.getTotalScore());
                    sixthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                    sixthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                    sixthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                    sixthIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                    sixthIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                    startActivity(sixthIntent);

                } else {
                    Toast.makeText(MainActivity.this, "You already answer this question.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void gradeTheQuiz() {
        Button gradeIt = (Button) findViewById(R.id.grade_the_quiz);

        gradeIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookOfQuestion.getTotalScore() < 5 && bookOfQuestion.getCloseOne() > 0 && bookOfQuestion.getCloseTwo() > 0 && bookOfQuestion.getCloseThird() > 0 && bookOfQuestion.getCloseFourth() > 0 && bookOfQuestion.getCloseFifth() > 0 && bookOfQuestion.getCloseSixth() > 0) {
                    Toast.makeText(MainActivity.this, "Sorry your score is to low, your score is " + bookOfQuestion.getTotalScore() + " out of 6", Toast.LENGTH_LONG).show();
                    finishQuiz += 1;
                } else if (bookOfQuestion.getTotalScore() >= 5 && bookOfQuestion.getCloseOne() > 0 && bookOfQuestion.getCloseTwo() > 0 && bookOfQuestion.getCloseThird() > 0 && bookOfQuestion.getCloseFourth() > 0 && bookOfQuestion.getCloseFifth() > 0 && bookOfQuestion.getCloseSixth() > 0) {

                    Toast.makeText(MainActivity.this, "Impressive great score. Your score is " + bookOfQuestion.getTotalScore() + " out of 6", Toast.LENGTH_LONG).show();
                    finishQuiz += 1;
                } else {
                    Toast.makeText(MainActivity.this, "Please answer all the question ", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    public void restartQuiz() {

        Button restartButton = (Button) findViewById(R.id.main_screen_restart);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (finishQuiz > 0) {

                    bookOfQuestion.reseter();
                    finishQuiz = 0;
                } else {
                    Toast.makeText(MainActivity.this, "After grading your quiz you can restart", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
