package com.spring.jdbc.utils;

import com.spring.jdbc.entities.Video;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoRowMapper implements RowMapper<Video> {
    @Override
    public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
        Video video = new Video();
        video.setVideoId(rs.getInt("videoId"));
        video.setTitle(rs.getString("title"));
        video.setDescription(rs.getString("description"));
        video.setUrl(rs.getString("url"));
        video.setDuration(rs.getInt("duration"));
        video.setCourseId(rs.getInt("courseId"));
        return video;
    }
}

