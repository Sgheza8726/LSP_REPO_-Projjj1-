package org.howard.edu.lsp.midterm.question5;

/**
 * Represents an audiobook that can be streamed.
 * Implements the Streamable interface and includes an additional method
 * to change the playback speed of the audiobook.
 */
public class Audiobook implements Streamable {
    private String title;  // The name of the audiobook

    // Constructor to initialize the audiobook title
    public Audiobook(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Adjusts the playback speed of the audiobook
     * @param speed - The playback speed multiplier (e.g., 1.5x)
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
