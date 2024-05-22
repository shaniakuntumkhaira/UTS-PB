package com.example.utspb.data;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.utspb.R;
import com.example.utspb.data.response.GitHubUsers;

public class DetailActivity extends AppCompatActivity {
    private ImageView avatarImageView;
    private TextView usernameTextView;
    private TextView nameTextView;
    private TextView bioTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        avatarImageView = findViewById(R.id.avatar_image_view);
        usernameTextView = findViewById(R.id.username_text_view);
        nameTextView = findViewById(R.id.name_text_view);
        bioTextView = findViewById(R.id.bio_text_view);

        // Mendapatkan data pengguna dari intent
        GitHubUsers user = (GitHubUsers) getIntent().getSerializableExtra("user");
        if (user != null) {
            // Menampilkan data pengguna
            Glide.with(this).load(user.getAvatarUrl()).into(avatarImageView);
            usernameTextView.setText(user.getUsername());
            nameTextView.setText(user.getName());
            bioTextView.setText(user.getBio());
        } else {
            // Handle jika data user tidak tersedia
        }
    }
}
