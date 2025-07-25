package gr.test.relativeappdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private CheckBox athensCB;
    private CheckBox patraCB;
    private RadioGroup agreeRG;
    private RatingBar likeRB;
    private SeekBar ageSB;
    private Switch switchBtn;
    private Button submitBtn;
    private RelativeLayout fullView;
    private TextView seekΒarTV;
    private String ratingStars;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        athensCB = findViewById(R.id.athensCB);
        patraCB = findViewById(R.id.patraCB);
        agreeRG = findViewById(R.id.agreeRG);
        likeRB = findViewById(R.id.likeRB);
        ageSB = findViewById(R.id.ageSB);
        switchBtn = findViewById(R.id.switchBtn);
        submitBtn = findViewById(R.id.submitBtn);
        fullView = findViewById(R.id.fullView);
        seekΒarTV = findViewById(R.id.seekBarTV);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Intent to SecondActivity
            }
        });

        likeRB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingStars =String.valueOf(rating);
                Toast.makeText(MainActivity.this, ratingStars, Toast.LENGTH_SHORT).show();
            }
        });

        ageSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekΒarTV.setText("Set your age (allowed 18 to 65): " + progress);
                age = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean isChecked) {
            if (isChecked) {
                switchBtn.setText("dark");
                scrollView.setBackgroundColor(getColor((R.color.black)));
                fullView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            } else {
                switchBtn.setText("dark");
                scrollView.setBackgroundColor(getColor((R.color.white)));
                fullView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
            }
        }
    });
    }
}