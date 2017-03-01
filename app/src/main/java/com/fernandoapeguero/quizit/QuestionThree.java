package com.fernandoapeguero.quizit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class QuestionThree extends AppCompatActivity {

    private QuestionBook bookOfQuestion = new QuestionBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        TextView eiffelQuestion = (TextView) findViewById(R.id.eiffel_ask_question);
        eiffelQuestion.setText(bookOfQuestion.getQuestion(2));

        Intent getIntent = getIntent();
        bookOfQuestion.setTotalScore(getIntent.getIntExtra("passedScoreThird", 0));
        bookOfQuestion.setCloseOne(getIntent.getIntExtra("passCloseOne", 0));
        bookOfQuestion.setCloseTwo(getIntent.getIntExtra("passCloseTwo", 0));
        bookOfQuestion.setCloseFourth(getIntent.getIntExtra("passCloseFourth", 0));
        bookOfQuestion.setCloseFifth(getIntent.getIntExtra("passCloseFifth", 0));
        bookOfQuestion.setCloseSixth(getIntent.getIntExtra("passCloseSixth", 0));

        submitAnswer();
    }

    private void submitAnswer() {

        final CheckBox yearBuild = (CheckBox) findViewById(R.id.the_year_build);
        final CheckBox year1885 = (CheckBox) findViewById(R.id.year_1885);
        final CheckBox year1889 = (CheckBox) findViewById(R.id.year_1889);

        final CheckBox gutaveCheckBox = (CheckBox) findViewById(R.id.gustave_eiffel);
        final CheckBox noelCheckBox = (CheckBox) findViewById(R.id.noel_incorrect);
        final CheckBox gabrielCheckBox = (CheckBox) findViewById(R.id.gabriel_incorrect);

        Button eiffelSubmit = (Button) findViewById(R.id.submit_eiffel);

        eiffelSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdIntent = new Intent(QuestionThree.this, MainActivity.class);
                if (yearBuild.isChecked() && gutaveCheckBox.isChecked() && !year1885.isChecked() && !year1889.isChecked() && !noelCheckBox.isChecked() && !gabrielCheckBox.isChecked()) {
                    bookOfQuestion.setTotalScore(1);
                    bookOfQuestion.setCloseThird(1);
                } else if (year1885.isChecked() || year1889.isChecked() || noelCheckBox.isChecked() || gabrielCheckBox.isChecked()) {
                    bookOfQuestion.setCloseThird(1);
                }
                thirdIntent.putExtra("passScoreThird", bookOfQuestion.getTotalScore());
                thirdIntent.putExtra("passCloseOne", bookOfQuestion.getCloseOne());
                thirdIntent.putExtra("passCloseTwo", bookOfQuestion.getCloseTwo());
                thirdIntent.putExtra("passCloseThird", bookOfQuestion.getCloseThird());
                thirdIntent.putExtra("passCloseFourth", bookOfQuestion.getCloseFourth());
                thirdIntent.putExtra("passCloseFifth", bookOfQuestion.getCloseFifth());
                thirdIntent.putExtra("passCloseSixth", bookOfQuestion.getCloseSixth());
                startActivity(thirdIntent);
            }
        });
    }
}
