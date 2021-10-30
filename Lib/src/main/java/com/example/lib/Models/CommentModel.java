package com.example.lib.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CommentModel implements  Serializable{

    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("postId")
    @Expose
    private Integer postId;
    @SerializedName("commentContent")
    @Expose
    private String commentContent;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("postNavigation")
    @Expose
    private Object postNavigation;
    @SerializedName("studentNavigation")
    @Expose
    private StudentModel studentNavigation;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getPostNavigation() {
        return postNavigation;
    }

    public void setPostNavigation(Object postNavigation) {
        this.postNavigation = postNavigation;
    }

    public StudentModel getStudentNavigation() {
        return studentNavigation;
    }

    public void setStudentNavigation(StudentModel studentNavigation) {
        this.studentNavigation = studentNavigation;
    }

    public CommentModel(Integer studentId, Integer postId, String commentContent) {
        this.studentId = studentId;
        this.postId = postId;
        this.commentContent = commentContent;
    }
}
