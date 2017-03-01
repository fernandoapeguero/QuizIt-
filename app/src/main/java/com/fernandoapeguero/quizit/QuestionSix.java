package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.security.PrivateKey;

public class QuestionSix extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_six);

        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScoreSixth", 0));
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseThird(getIntent.getIntExtra("passCloseThird", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
        bookOfQuestion.setCloseFifth(getIntent.getIntExtra("passCloseFifth", 0));

        submit();
    }

    public void submit() {
        Button blueHoleSubmit = (Button) findViewById(R.id.submit_blue_hole);

        final RadioButton maldivesRadioButton = (RadioButton) findViewById(R.id.radioButton_blue_hole_maldives);
        final RadioButton philipinesRadioButton = (RadioButton) findViewById(R.id.radioButton_blue_hole_philipines);
        final RadioButton belizeRadioButton = (RadioButton) findViewById(R.id.radioButton_blue_hole_belize);

        blueHoleSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixthIntent = new Intent(QuestionSix.this, MainActivity.class);
                if (belizeRadioButton.isChecked()) {
                    bookOfQuestion.setTotalScore(1);
                    bookOfQuestion.setCloseSixth(1);
                } else if (maldivesRadioButton.isChecked() || philipinesRadioButton.isChecked()) {
                    bookOfQuestion.setCloseSixth(1);
                }
                sixthIntent.putExtra("passScoreSixth", bookOfQuestion.getTotalScore());
                sixthIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                sixthIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                sixthIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                sixthIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                sixthIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                sixthIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                startActivity(sixthIntent);
            }
        });
    }
}
