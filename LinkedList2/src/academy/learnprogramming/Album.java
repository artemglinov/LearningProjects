package academy.learnprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
   // private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private class SongList{
        private List<Song> playlistSongs;

        private boolean addToPlayList(int trackNumber) {
            int index = trackNumber -1;
            if((index >=0) && (index < songs.size())) {
                    playlistSongs.add(songs.get(index));
                    return true;
            }
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }

        private boolean addToPlayList(String title) {
            Song checkedSong = this.findSong(title);
            if(checkedSong != null) {
                playlistSongs.add(checkedSong);
                return true;
            }
            System.out.println("The song " + title + " is not in this album");
            return false;
        }

        private Song findSong(String title) {
            for(Song checkedSong: songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song checkedSong: this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        SongList songList = new SongList();;
        songList.playlistSongs = playList;

        return songList.addToPlayList(trackNumber);
     //   playList = songList.playlistSongs;

    }

    public boolean addToPlayList(String title, List<Song> playList) {
        SongList songList = new SongList();
        songList.playlistSongs = playList;

        return songList.addToPlayList(title);
     //   playList = songList.playlistSongs;


    }

   /* public boolean addToPlayList(int trackNumber, List<Song> playList) {
        int index = trackNumber -1;
        if((index >0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }*/

   /* public boolean addToPlayList(String title, List<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }*/



















}
