package org.howard.edu.lsp.midterm.question5;

/**
 * Interface representing a streamable media type.
 * This ensures that all media types (Music, Movie, Audiobook)
 * share common behaviors like play, pause, and stop.
 */
public interface Streamable {
    void play();   // Starts playing the media
    void pause();  // Pauses the media
    void stop();   // Stops the media
}
