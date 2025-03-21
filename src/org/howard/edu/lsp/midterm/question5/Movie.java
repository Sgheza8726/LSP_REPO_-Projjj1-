package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a movie that can be streamed.
 * Implements the Streamable interface and includes an additional method
 * to rewind the movie by a certain number of seconds.
 */
public class Movie implements Streamable {
    private String title;  // The name of the movie

    // Constructor to initialize the movie title
    public Movie(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Rewinds the movie by a given number of seconds
     * @param seconds - The number of seconds to rewind
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}
