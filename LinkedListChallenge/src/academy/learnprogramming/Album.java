package academy.learnprogramming;

import java.util.ArrayList;

public class Album {

    private String name;
    ArrayList<Song> songs = new ArrayList<>();

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSong(String title, String duration){
        Song newSong = new Song(title, duration);
        if(findSong(title) == null) {
            songs.add(newSong);
        } else {
            System.out.println("The song is already in the album");
        }
    }

    public Song findSong(String songTitle){

        for(int i = 0; i < songs.size(); i++){
            Song songInAlbum = songs.get(i);
            if(songInAlbum.getTitle().equals(songTitle)){
                return songInAlbum;
            }
        }

        return null;
    }
}
