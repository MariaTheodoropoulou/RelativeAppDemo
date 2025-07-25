package gr.test.relativeappdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {


    private TextView ratingTV;
    private TextView ageTV;
    private EditText urlET;
  private Button navigateBtn;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ratingTV = findViewById(R.id.ratingTV);
        ageTV = findViewById(R.id.ageTV);
        urlET = findViewById(R.id.urlET);
        navigateBtn = findViewById(R.id.navigateBtn);

        Intent intent = getIntent();
        String ratings = intent.getStringExtra("rating");
        String age = intent.getStringExtra("age");

        ratingTV.setText("Rating: " + ratings);
        ageTV.setText("Age: " + age);

        navigateBtn.setOnClickListener(view -> {
            String url = urlET.getText().toString().trim();

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent1);
        });
    }
}