package com.example.utspb.data;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.utspb.R;
import com.example.utspb.data.response.GitHubUsers;

import java.util.List;

public class GitHubUserAdapter extends RecyclerView.Adapter<GitHubUserAdapter.UserViewHolder> {
    private List<GitHubUsers> userList;

    public GitHubUserAdapter(List<GitHubUsers> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        GitHubUsers user = userList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatarImageView;
        private TextView usernameTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.ivAvatar);
            usernameTextView = itemView.findViewById(R.id.tvUsername);
        }

        public void bind(GitHubUsers user) {
            Glide.with(itemView.getContext()).load(user.getAvatarUrl()).into(avatarImageView);
            usernameTextView.setText(user.getUsername());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra("user", String.valueOf(user));
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
