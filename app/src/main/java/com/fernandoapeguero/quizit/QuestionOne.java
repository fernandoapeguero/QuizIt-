package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionOne extends AppCompatActivity {


    private QuestionBook bookOfQuestion = new QuestionBook();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        TextView zeusQuestion = (TextView) findViewById(R.id.ask_question);
        zeusQuestion.setText(bookOfQuestion.getQuestion(0));
      // getting the information from each close and score so  is not lost between activities
        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScore", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
        bookOfQuestion.setCloseFifth(getIntent.getIntExtra("passCloseFifth", 0));
        bookOfQuestion.setCloseSixth(getIntent.getIntExtra("passCloseSixth", 0));

        submitAnswer();
    }

    private void submitAnswer() {

        final RadioButton buttonOne = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton buttonTwo = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton buttonThree = (RadioButton) findViewById(R.id.radioButton3);

        Button submitMyAnswer = (Button) findViewById(R.id.submit_answer);

        submitMyAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passData = new Intent(QuestionOne.this, MainActivity.class);
                if (buttonTwo.isChecked()) {
                    bookOfQuestion.setTotalScore(1);
                    bookOfQuestion.setCloseOne(1);
                } else if (buttonOne.isChecked() || buttonThree.isChecked()) {
                    bookOfQuestion.setCloseOne(1);
                }
                passData.putExtra("passedScoreOne", bookOfQuestion.getTotalScore());
                passData.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                passData.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                passData.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                passData.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                passData.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                passData.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                startActivity(passData);
            }
        });
    }
}
