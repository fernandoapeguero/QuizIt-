package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionTwo extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        // getting the information from each close and score so  is not lost between activities
        TextView libertyQuestion = (TextView) findViewById(R.id.statue_liberty_question);
        libertyQuestion.setText(bookOfQuestion.getQuestion(1));

        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScoreTwo", 0));
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
        bookOfQuestion.setCloseFifth(getIntent.getIntExtra("passCloseFifth", 0));
        bookOfQuestion.setCloseSixth(getIntent.getIntExtra("passCloseSixth", 0));

        answerQuestionTwo();

    }

    public void answerQuestionTwo() {

        Button submitSecond = (Button) findViewById(R.id.submit_liberty_answer);
        final EditText enterYourAnswer = (EditText) findViewById(R.id.liberty_edit_field);
        final TextView yourAnswerTextView = (TextView) findViewById(R.id.checkbox_your_liberty_answer);

        enterYourAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String result = enterYourAnswer.getText().toString();
                    yourAnswerTextView.setText(result);
                    enterYourAnswer.clearFocus();
                    enterYourAnswer.setText("");
                }
                return false;
            }
        });

        submitSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent passDataTwo = new Intent(QuestionTwo.this, MainActivity.class);
                if (yourAnswerTextView.getText().equals("France")) {
                    bookOfQuestion.setTotalScore(1);
                    bookOfQuestion.setCloseTwo(1);
                } else {
                    bookOfQuestion.setCloseTwo(1);
                }
                passDataTwo.putExtra("passScoreTwo", bookOfQuestion.getTotalScore());
                passDataTwo.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                passDataTwo.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                passDataTwo.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                passDataTwo.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                passDataTwo.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                passDataTwo.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                startActivity(passDataTwo);
            }
        });

    }

}
