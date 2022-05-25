package ua.icm.weather.ui.content;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ua.icm.weather.datamodel.City;
import ua.icm.weather.datamodel.WeatherType;
import ua.icm.weather.network.IpmaWeatherClient;

public class CityUtils {
    // An ArrayList of Songs
    public static final List<Song> SONG_ITEMS = new ArrayList<>();

    // The ID for the index into song titles.
    public static final String SONG_ID_KEY = "item_id";

    // The number of songs.
    private static final int COUNT = 7;

    private TextView feedback;

    IpmaWeatherClient client = new IpmaWeatherClient();
    private HashMap<String, City> cities;
    private HashMap<Integer, WeatherType> weatherDescriptions;


    /**
     * A Song item represents a song title, and song details.
     */
    public static class Song {
        public final String song_title;
        public final String details;

        private Song(String content, String details) {
            this.song_title = content;
            this.details = details;
        }
    }

    /**
     * Add an item to the array.
     *
     * @param item Each song
     */
    private static void addItem(Song item) {
        SONG_ITEMS.add(item);
    }

    static {
        // Fill the array with songs.
        for (int i = 0; i < COUNT; i++) {
            addItem(createSongAtPosition(i));
        }
    }

    private static Song createSongAtPosition(int position) {

        String newTitle;
        String newDetail;
        switch (position) {
            case 0:
                newTitle = "Aveiro";
                newDetail = "Aveiro";
                break;
            case 1:
                newTitle = "Coimbra";
                newDetail = "My Bonnie - Ain’t She Sweet\n\nAt the same session, the Beatles played on “My Bonnie” (the first-ever single with Beatles playing), as the backing band for English singer Tony Sheridan, originally a member of the Jets. The popularity of this single in Liverpool brought the Beatles to the attention of Brian Epstein, who worked in the NEMS record store and tried to meet demand for the disc. John Lennon then sings a fine “Ain’t She Sweet” (his first-ever released vocal).";
                break;
            case 2:
                newTitle = "Faro";
                newDetail = "Searching\n\nA Jerry Leiber - Mike Stoller comedy song that was a hit for the Coasters in 1957, and a popular live favorite of the Beatles. The Coasters also had a hit with “Besame Mucho” and the Beatles covered that song as well. Ringo Starr had by now replaced Pete Best on drums. The high falsetto is George, who also plays a hesitant lead guitar. This is from their first audition for Decca Records in London on Jan 1., 1962, live in the studio. The Grateful Dead would later cover “Searchin” with a similar arrangement, Pigpen doing the Paul vocals. A live version is available on bootlegs featuring the Dead joined by the Beach Boys!";
                break;
            case 3:
                newTitle = "Lisboa";
                newDetail = "Love Me Do\n\nAn early version of the song, played a bit slower and with more of a blues feeling, and a cool bossa-nova beat in middle. Paul had to sing while John played harmonica — a first for the group. Pete Best played drums on this version.";
                break;
            case 4:
                newTitle = "Leiria";
                newDetail = "She Loves You – Till There Was You – Twist and Shout\n\nLive at the Princess Wales Theatre by Leicester Square in London, attended by the Queen. “Till There Was You” (by Meredith Wilson) is from the musical The Music Man and a hit for Peggy Lee in 1961. Before playing it, Paul said it was recorded by his favorite American group, “Sophie Tucker” (which got some laughs). At the end, John tells the people in the cheaper seats to clap their hands, and the rest to “rattle your jewelry” and then announces “Twist and Shout” (a song by Bert Russell and Phil Medley that was first recorded in 1962 by the Isley Brothers). A film of the performance shows the Queen smiling at John’s remark.";
                break;
            case 5:
                newTitle = "Castelo Branco";
                newDetail = "Leave My Kitten Alone\n\nOne of the lost Beatle songs recorded during the “Beatles For Sale” sessions but never released. This song, written by Little Willie John, Titus Turner, and James McDougal, was a 1959 R&B hit for Little Willie John and covered by Johnny Preston before the Beatles tried it and shelved it. A reference to a “big fat bulldog” may have influenced John’s “Hey Bulldog” (Yellow Submarine album), which is a similar rocker.";
                break;
            default:
                newTitle = "Beja";
                newDetail = "One After 909\n\nA song recorded for the Let It Be album was actually worked on way back in the beginning, six years earlier. This take shows how they did it much more slowly, with an R&B feel to it.";
                break;
        }
        return new Song(newTitle, newDetail);
    }
}
