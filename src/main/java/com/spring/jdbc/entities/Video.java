package com.spring.jdbc.entities;

public class Video {
    private int videoId;
    private String title;
    private String description;
    private String url;
    private int duration; // in seconds
    private int courseId; // Foreign key to link with a Course

    // Default Constructor
    public Video() {
    }

    // Parameterized Constructor
    public Video(int videoId, String title, String description, String url, int duration, int courseId) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.url = url;
        this.duration = duration;
        this.courseId = courseId;
    }

    // Getters and Setters
    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", courseId=" + courseId +
                '}';
    }
}
