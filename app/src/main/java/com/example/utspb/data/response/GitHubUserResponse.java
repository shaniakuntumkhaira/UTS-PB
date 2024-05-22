package com.example.utspb.data.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GitHubUserResponse {

	@SerializedName("items")
	private List<GitHubUsers> items;

	public void setItems(List<GitHubUsers> items) {
		this.items = items;
	}

	public List<GitHubUsers> getItems() {
		return items;
	}
}
