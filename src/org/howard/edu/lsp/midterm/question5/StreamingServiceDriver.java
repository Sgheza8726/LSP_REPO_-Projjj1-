package org.howard.edu.lsp.midterm.question5;

/**
 * Driver class to test the StreamingService functionality.
 * This demonstrates creating and using different types of media.
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Creating instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Testing common behaviors for all media types
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println(); // Line break for readability

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Testing unique behaviors for each media type
        System.out.println("Testing unique behaviors:\n");

        // Movie-specific behavior (rewind)
        Movie movieWithRewind = (Movie) movie;  // Casting to access specific method
        movieWithRewind.rewind(30);
        System.out.println();

        // Audiobook-specific behavior (setPlaybackSpeed)
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  // Casting to access specific method
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        // Music-specific behavior (addToPlaylist)
        Music musicWithPlaylist = (Music) music;  // Casting to access specific method
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}
