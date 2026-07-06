package com.example.MyAwesomeMusicLibrary.modelDTO.request;


public class CreateSongRequest {

    private String title;
    private Integer duration;
    private Integer albumId;
    private Integer releaseYear;
    private Integer artistIds;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(Integer artistIds) {
        this.artistIds = artistIds;
    }
}
