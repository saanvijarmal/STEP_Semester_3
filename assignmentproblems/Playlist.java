package assignmentproblems;
import java.util.Arrays;
public class Playlist {

    private final String[] songs;
    private int songCount;

    public Playlist(int maxCapacity) {
        this.songs = new String[maxCapacity];
        this.songCount = 0;
    }

    public void addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount] = songTitle;
            songCount++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist song count: " + p.getSongCount());
        System.out.println("Actual first song: " + p.getSongs()[0]);
    }
}
