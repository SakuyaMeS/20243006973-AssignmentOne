package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bindService(R.id.btn_facilities, R.id.label_facilities, 0);
        bindService(R.id.btn_events, R.id.label_events, 1);
        bindService(R.id.btn_clubs, R.id.label_clubs, 2);
        bindService(R.id.btn_support, R.id.label_support, 3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);

                    return insets;
                });
    }

    private void bindService(int buttonId, int labelId, int topicId) {
        ImageButton button = findViewById(buttonId);
        TextView label = findViewById(labelId);

        View.OnClickListener openDetail = view -> {
            String message = getString(R.string.service_clicked, label.getText());
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, topicId);
            startActivity(intent);
        };

        button.setOnClickListener(openDetail);
        label.setOnClickListener(openDetail);
    }
}
