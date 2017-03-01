package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionFour extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);
// getting data thought intent to keep values intact
        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScoreFourth", 0));
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseFifth(getIntent.getIntExtra("passCloseFifth", 0));
        bookOfQuestion.setCloseSixth(getIntent.getIntExtra("passCloseSixth", 0));
        TextView greatWallQuestion = (TextView) findViewById(R.id.china_question);
        greatWallQuestion.setText(bookOfQuestion.getQuestion(3));

        submitOrder();
    }

    public void submitOrder() {

        Button submitGreatWall = (Button) findViewById(R.id.great_wall_submit);

        final RadioButton dysnatyTang = (RadioButton) findViewById(R.id.radioButton_china);
        final RadioButton dysnatyZhou = (RadioButton) findViewById(R.id.radioButton_china2);
        final RadioButton dysnatyQin = (RadioButton) findViewById(R.id.radioButton_china3);

        submitGreatWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fourthIntent = new Intent(QuestionFour.this, MainActivity.class);
                if (dysnatyQin.isChecked()) {
                    bookOfQuestion.setCloseFourth(1);
                    bookOfQuestion.setTotalScore(1);
                } else if (dysnatyZhou.isChecked() || dysnatyTang.isChecked()) {
                    bookOfQuestion.setCloseFourth(1);
                }
                fourthIntent.putExtra("passScoreFourth", bookOfQuestion.getTotalScore());
                fourthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                fourthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                fourthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                fourthIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                fourthIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                fourthIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                startActivity(fourthIntent);
            }
        });
    }
}
