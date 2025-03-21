package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a music track that can be streamed.
 * Implements the Streamable interface and includes an additional method
 * to add the music track to a playlist.
 */
public class Music implements Streamable {
    private String title;  // The name of the song

    // Constructor to initialize the music title
    public Music(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * Adds the song to a specified playlist
     * @param playlistName - The name of the playlist
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}
