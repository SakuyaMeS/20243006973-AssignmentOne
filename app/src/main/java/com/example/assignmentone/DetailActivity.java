package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    static final String EXTRA_TOPIC_ID = "topic_id";

    // The short banner labels follow the same topic order as the three arrays in arrays.xml.
    private static final int[] TOPIC_LABELS = {
            R.string.facilities, R.string.events, R.string.clubs, R.string.support
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Topic IDs 0 to 3 select matching entries in the image, title, and content arrays.
        int topicId = getIntent().getIntExtra(EXTRA_TOPIC_ID, 0);

        String[] images = getResources().getStringArray(
                R.array.string_array_images);

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles);

        String[] contents = getResources().getStringArray(
                R.array.string_array_content);

        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailTopic = findViewById(R.id.detailTopic);
        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView detailContent = findViewById(R.id.detailContent);

        detailTopic.setText(TOPIC_LABELS[topicId]);
        detailTitle.setText(titles[topicId]);
        detailContent.setText(contents[topicId]);

        int imageResource = getResources().getIdentifier(
                images[topicId].trim(),
                "drawable",
                getPackageName());

        detailImage.setImageResource(imageResource);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom);

                    return insets;
                });
    }
}
