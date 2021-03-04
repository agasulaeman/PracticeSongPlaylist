package com.playlistSong;

import com.SolvingAnotherPeople.Main;
import java.util.*;
import static com.playlistSong.MainPlaylist.nextInstruction;

public class Playlist {

    public ArrayList<Album> albumArrayList = new ArrayList<>();
    private LinkedList<Song> playlist = new LinkedList();
    private LinkedList<Album> albumPlaylist = new LinkedList<>();

    public void findAlbums() {
        LinkedList<String> tempLinkList = new LinkedList<>();
        for (int i = 0; i < albumArrayList.size(); i++) {
            String tempAlbumName = albumArrayList.get(i).getAlbumName();
            tempLinkList.add(tempAlbumName);
        }
        System.out.println(" you have album  " + tempLinkList.toString());
        System.out.println();
    }

    public int findAlbum(String albumName) {
        int index = -1;
        for (int i = 0; albumArrayList.size() > i; i++) {
            if (albumArrayList.get(i).getAlbumName().equals(albumName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void printAlbumList() {
        System.out.println(" the list of your album ");
        for (int i = 0; i < albumArrayList.size(); i++) {
            System.out.println((i + 1) + " . " + albumArrayList.get(i).getAlbumName());
        }
    }

    public Album queryAlbum(String albumName) {
        int position = findAlbum(albumName);
        if (position >= 0) {
            return this.albumArrayList.get(position);
        }
        return null;
    }

    public void addNewAlbum(String albumName) {
        int index = findAlbum(albumName);
        if (index == -1) {
            System.out.println(albumName + " : Album is saved.");
            Album album = new Album(albumName);
            albumArrayList.add(album);
        } else {
            System.out.println("Album already exists.");
        }
    }

    public int findSong(String songName, ArrayList<Song> songArrayList) {
        int index = -1;
        for (int i = 0; songArrayList.size() > i; i++) {
            if (songArrayList.get(i).getSongTitle().equals(songName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void addSongtoAlbum(String albumName, String songTitle, double duration) {
        int albumLocation = findAlbum(albumName);
        if (findAlbum(albumName) >= 0) {
            System.out.println(" Ok, the song " + songTitle + " " + duration + "  has been insert to your album " + albumName);
            Album tempAlbum = albumArrayList.get(albumLocation);
            tempAlbum.addSong(songTitle, duration);
        } else {
            System.out.println(" Album is not insert to your playlist ");
        }
    }


    public void nextPrevSong(int choice) {
        ListIterator<Song> listIterator = playlist.listIterator();
        ListIterator<Album> albumListIterator = albumPlaylist.listIterator();
        boolean quit = false;
        while (!quit) {
            nextInstruction();
            boolean isAnInt = Main.scanner.hasNextInt();
            if (isAnInt) {
                choice = Main.scanner.nextInt();
                Main.scanner.nextLine();
                switch (choice) {
                    case 1:
                        if (playlist.isEmpty()) {
                            System.out.println("No songs on playlist");
                        } else {
                            if (albumListIterator.hasNext()) {
                                System.out.println("Now playing " + albumListIterator.next());
                            } else {
                                System.out.println("Reached end of list");
                            }
                        }
                        break;

                    case 2:
                        if (playlist.isEmpty()) {
                            System.out.println("No songs on playlist");
                        } else {
                            if (albumListIterator.hasPrevious()) {
                                System.out.println("Now playing " + albumListIterator.previous());

                            } else {
                                System.out.println("Reached beginning of list");
                            }
                        }
                        break;
                    case 3:
                        quit = true;
                        break;
                    case 4:
                        MainPlaylist.printInstructions();
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid key selection");
                        break;


                }
            }
        }

    }

}