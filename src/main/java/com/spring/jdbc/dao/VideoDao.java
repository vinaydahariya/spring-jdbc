package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VideoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a video record
    public int save(Video video) {
        String query = "INSERT INTO videos (videoId, title, description, url, duration, courseId) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                video.getVideoId(),
                video.getTitle(),
                video.getDescription(),
                video.getUrl(),
                video.getDuration(),
                video.getCourseId()
        );
    }

    // Update a video record by videoId
    public int update(Video video) {
        String query = "UPDATE videos SET title = ?, description = ?, url = ?, duration = ?, courseId = ? WHERE videoId = ?";
        return jdbcTemplate.update(query,
                video.getTitle(),
                video.getDescription(),
                video.getUrl(),
                video.getDuration(),
                video.getCourseId(),
                video.getVideoId()
        );
    }

    // Delete a video record by videoId
    public int delete(int videoId) {
        String query = "DELETE FROM videos WHERE videoId = ?";
        return jdbcTemplate.update(query, videoId);
    }

    // Get a single video record by videoId
    public Video get(int videoId) {
        String query = "SELECT * FROM videos WHERE videoId = ?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            Video video = new Video();
            video.setVideoId(rs.getInt("videoId"));
            video.setTitle(rs.getString("title"));
            video.setDescription(rs.getString("description"));
            video.setUrl(rs.getString("url"));
            video.setDuration(rs.getInt("duration"));
            video.setCourseId(rs.getInt("courseId"));
            return video;
        }, videoId);
    }

    // Get all video records
    public List<Video> getAll() {
        String query = "SELECT * FROM videos";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Video video = new Video();
            video.setVideoId(rs.getInt("videoId"));
            video.setTitle(rs.getString("title"));
            video.setDescription(rs.getString("description"));
            video.setUrl(rs.getString("url"));
            video.setDuration(rs.getInt("duration"));
            video.setCourseId(rs.getInt("courseId"));
            return video;
        });
    }

    // Get videos by courseId (for videos associated with a specific course)
    public List<Video> getByCourseId(int courseId) {
        String query = "SELECT * FROM videos WHERE courseId = ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Video video = new Video();
            video.setVideoId(rs.getInt("videoId"));
            video.setTitle(rs.getString("title"));
            video.setDescription(rs.getString("description"));
            video.setUrl(rs.getString("url"));
            video.setDuration(rs.getInt("duration"));
            video.setCourseId(rs.getInt("courseId"));
            return video;
        }, courseId);
    }
}
