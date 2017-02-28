package com.fernandoapeguero.quizit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuestionFive extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        TextView grandCanyonQuestion = (TextView) findViewById(R.id.grand_canyon_question);
        grandCanyonQuestion.setText(bookOfQuestion.getQuestion(4));

    }
}
