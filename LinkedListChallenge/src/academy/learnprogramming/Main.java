package academy.learnprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums =new ArrayList<>();
    private static  LinkedList<Song> playlist  = new LinkedList<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Album swagSociety = new Album("Swag Society");
        Album melodicTrapstars = new Album("Melodic Trapstars");


        swagSociety.addSong("Acid Rain", "3:16");
        swagSociety.addSong("Awesome", "3:30");
        swagSociety.addSong("Every Night", "2:40");
        albums.add(swagSociety);


        melodicTrapstars.addSong("Lifestyle", "2:53");
        melodicTrapstars.addSong("Numb", "2:50");
        melodicTrapstars.addSong("Problems", "3:22");
        albums.add(melodicTrapstars);



        addToPlaylist("Swag Society",  "Acid Rain");
        addToPlaylist("Melodic Trapstars",  "Numb");
        addToPlaylist("Melodic Trapstars",  "Problems");
        addToPlaylist("Swag Society",  "Awesome");
        addToPlaylist("Swag Society",  "Every Night");
        addToPlaylist("Melodic Trapstars",  "Lifestyle");

        addToPlaylist("Swag Society",  "kre");

        ListIterator<Song> listIterator = playlist.listIterator();
        boolean quit =false;
        boolean goingForward = true;

        while (!quit) {
            System.out.println("Enter the playlist option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            goingForward = true;
                        }
                    }

                    if(listIterator.hasNext()){
                        System.out.println("Current song is " + listIterator.next().getTitle());
                    } else {
                        System.out.println("End of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            goingForward = false;
                        }
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("Current song is " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("Start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward && listIterator.hasPrevious()){
                        System.out.println("Song " + listIterator.previous().getTitle() + " is replayed");
                        listIterator.next();
                    } else if(!goingForward && listIterator.hasNext()){
                        System.out.println("Song " + listIterator.next().getTitle() + " is replayed");
                        listIterator.previous();
                    }
                    break;
                case 4:
                    showPlaylist();
                    break;
/*                case 5:
                    removeSong();
                    break;*/
                case 6:
                    quit = true;
                    break;
            }
        }


    }

    public static void addToPlaylist(String albumName, String songTitle){
        int position = findAlbum(albumName);
        Album album = albums.get(position);
        Song song = album.findSong(songTitle);
        if(song != null){
            playlist.addLast(song);
        } else {
            System.out.println("Song " + songTitle + " is not found in album " + albumName);
        }
    }

    private static int findAlbum(String albumName){
        for(int i = 0; i < albums.size(); i++){
            if(albums.get(i).getName().equals(albumName)){
                return i;
            }
        }

        return -1;
    }

    private static void printMenu(){
        System.out.println("Menu:\n " +
                "0 - print menu\n" +
                "1 - skip forward\n" +
                "2 - skip backwards\n" +
                "3 - replay song\n" +
                "4 - show playlist\n" +
                "5 - remove song\n" +
                "6 - quit");
    }

    private static void skipForward(boolean goingForward){
        ListIterator<Song> listIterator = playlist.listIterator();

        if(!goingForward){
            if(listIterator.hasNext()) {
                listIterator.next();
                goingForward = true;

            }

            goingForward = false;

        }

        if(listIterator.hasNext()){
            System.out.println("Current song is "
                    + listIterator.next().getTitle());
        } else {
            System.out.println("End of the playlist");
        }
    }

    private static void skipBackwards(boolean goingForward){
        ListIterator<Song> listIterator = playlist.listIterator();

        if(goingForward){
            if(listIterator.hasPrevious()) {
                listIterator.previous();
                goingForward = false;
            }
            goingForward = true;
        }

        if(listIterator.hasPrevious()){
            System.out.println("Current song is " + listIterator.previous().getTitle());
        } else {
            System.out.println("Start of the playlist");
        }


    }

    private static void replay(boolean goingForward){
        ListIterator<Song> listIterator = playlist.listIterator();

       if(goingForward && listIterator.hasPrevious()){
           System.out.println("Song " + listIterator.previous().getTitle() + " is replayed");
         //  listIterator.next();
        } else if(!goingForward && listIterator.hasNext()){
           System.out.println("Song " + listIterator.next().getTitle() + " is replayed");
          // listIterator.previous();
       }
    }

    private static void showPlaylist(){
        System.out.println("Songs in playlist:");
        for (int i = 0; i < playlist.size(); i++){
            System.out.println("#" + (i+1) + ": " + playlist.get(i).getTitle());
        }
    }
}
