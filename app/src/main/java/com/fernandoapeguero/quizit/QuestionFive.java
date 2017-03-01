package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionFive extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        TextView grandCanyonQuestion = (TextView) findViewById(R.id.grand_canyon_question);
        grandCanyonQuestion.setText(bookOfQuestion.getQuestion(4));

        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScoreFifth", 0));
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseSixth(getIntent.getIntExtra("passCloseSixth", 0));

        submit();
    }

    private void submit() {

        Button submitGrandCanyon = (Button) findViewById(R.id.submit_grand_canyon);

        final RadioButton kilometerRadioButton = (RadioButton) findViewById(R.id.radioButton_canyon);
        final RadioButton milesRadioButton = (RadioButton) findViewById(R.id.radioButton_canyon2);
        final RadioButton yardsRadioButton = (RadioButton) findViewById(R.id.radioButton_canyon3);

        submitGrandCanyon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fifthIntent = new Intent(QuestionFive.this, MainActivity.class);
                if (milesRadioButton.isChecked()) {
                    bookOfQuestion.setTotalScore(1);
                    bookOfQuestion.setCloseFifth(1);
                } else if (kilometerRadioButton.isChecked() || yardsRadioButton.isChecked()) {
                    bookOfQuestion.setCloseFifth(1);
                }
                fifthIntent.putExtra("passScoreFifth", bookOfQuestion.getTotalScore());
                fifthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                fifthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                fifthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                fifthIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                fifthIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                fifthIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                startActivity(fifthIntent);
            }
        });
    }
}
