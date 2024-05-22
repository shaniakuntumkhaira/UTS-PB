package com.example.utspb.data.retrofit;

import com.example.utspb.data.response.GitHubUserResponse;
import com.example.utspb.data.response.GitHubUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface ApiService {
    @GET("search/users")
    Call<GitHubUserResponse> searchUsers(@Query("q") String query);

    @GET("users/{username}")
    Call<GitHubUsers> getUser(@Path("username") String username);
}
