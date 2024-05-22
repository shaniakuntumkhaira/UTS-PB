package com.example.utspb;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utspb.data.GitHubUserAdapter;
import com.example.utspb.data.response.GitHubUserResponse;
import com.example.utspb.data.response.GitHubUsers;
import com.example.utspb.data.retrofit.ApiConfig;
import com.example.utspb.data.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GitHubUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService gitHubService = ApiConfig.getGitHubService();
        Call<GitHubUserResponse> call = gitHubService.searchUsers("your_query_here");
        call.enqueue(new Callback<GitHubUserResponse>() {
            @Override
            public void onResponse(Call<GitHubUserResponse> call, Response<GitHubUserResponse> response) {
                if (response.isSuccessful()) {
                    GitHubUserResponse userResponse = response.body();
                    List<GitHubUsers> users = userResponse.getItems();
                    adapter = new GitHubUserAdapter(users);
                    recyclerView.setAdapter(adapter);
                } else {
                    // Handle kesalahan
                }
            }

            @Override
            public void onFailure(Call<GitHubUserResponse> call, Throwable t) {
                // Handle kegagalan
            }
        });

    }
}
