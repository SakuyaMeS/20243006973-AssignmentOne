
package com.example.assignmentone;

import android.os.Bundle;
import android.content.Intent;
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

        findViewById(R.id.btn_facilities).setOnClickListener(v -> {
            Toast.makeText(this, "Facilities clicked",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, 0);
            startActivity(intent);
        });

        findViewById(R.id.btn_events).setOnClickListener(v -> {
            Toast.makeText(this, "Events clicked",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, 1);
            startActivity(intent);
        });

        findViewById(R.id.btn_clubs).setOnClickListener(v -> {
            Toast.makeText(this, "Clubs clicked",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, 2);
            startActivity(intent);
        });

        findViewById(R.id.btn_support).setOnClickListener(v -> {
            Toast.makeText(this, "Support clicked",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, 3);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);

                    return insets;
                });
    }
}
