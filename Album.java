package com.playlistSong;




import java.util.*;

public class Album {
    private String albumName;
    private String title;
    private ArrayList<Song> listSong;
    private final LinkedList<Song> albumSong;

    public Album(String albumName) {
        this.albumName = albumName;
        this.title = title;
        this.listSong = new ArrayList<Song>();
        this.albumSong = new LinkedList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Song> getListSong() {
        return listSong;
    }

    public static Album addNewAlbum(String albumName) {
        return new Album(albumName);
    }


    public void addSong(String songTitle, double duration) {
        int songlocation = findsong(songTitle);
        if (songlocation < 0) {
            Song addThisSong = new Song(songTitle, duration);
            listSong.add(addThisSong);
            System.out.println(songTitle + " has been added to album.");
        } else {
            System.out.println("Song title already exists in album.");
        }

    }

    private int findsong(String songTitle) {
        int index = -1;
        for (int i = 0; i < listSong.size(); i++) {
            if (listSong.get(i).getSongTitle().equals(songTitle)) {
                index = i;
                System.out.println(index + " is current index for the song ");
                break;
            }
        }
        return index;
    }

    public Song querySong(String songTitle) {
        int position = findsong(songTitle);
        if (position >= 0) {
            return this.listSong.get(position);
        }
        return null;
    }
        public void printSongListyourAlbum(){
            System.out.println(" You have " +listSong.size() + " song in your album");
            for (int i = 0; i <listSong.size() ; i++) {
                System.out.println((i+1) + " "+ listSong.get(i).getSongTitle());
            }
        }

    public void removeSong(String songTitle) {
        int removeSongInt = findsong(songTitle);
        if (removeSongInt >= 0) {
            System.out.println("Song " + songTitle + " has been removed from album");
            listSong.remove(removeSongInt);
        } else {
            System.out.println("Song " + songTitle + "Was not found in album");
        }
    }

}
