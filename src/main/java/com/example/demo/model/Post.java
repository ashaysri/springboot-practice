package com.example.demo.model;

public class Post {
    private int postId;
    private String firstName;
    private String lastName;
    private String gender;
    private String post;
    private int likes;

    public Post(int postId, String firstName, String lastName, String gender, String post, int likes) {
        this.postId = postId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.post = post;
        this.likes = likes;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
