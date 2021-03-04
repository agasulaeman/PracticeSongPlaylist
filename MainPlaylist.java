package com.playlistSong;
import java.util.LinkedList;
import java.util.Scanner;


public class MainPlaylist {
    LinkedList<Album> albumLinkedList = new LinkedList<>();
    private static Song song = new Song("List Song", 3.14);
    private static Album album = new Album(null);
    private static Playlist playlist = new Playlist();
    private static LinkedList<Playlist> myPlaylist = new LinkedList<>();
    private static Scanner sc = new Scanner(System.in);
    private static LinkedList<Song> playlistSong = new LinkedList<>();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: 8 to show instructions)");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 0:
                        addAlbum();
                        break;
                    case 1:
                        listYourAlbum();
                        break;
                    case 2:
                        addSongToExistAlbum();
                        break;
                    case 3:
                        printListSongByAlbum();
                        break;
                    case 4:
                        removeSongInYourAlbum();
                        break;
                    case 5:
                        playPrevAndNextSong();//playlist.nextPrevSong();
                        break;
                    case 6:
                        // printCustomerTransaction();
                        break;
                    case 7:
                        printInstructions();
                        break;
                }
            } else {
                System.out.println("Please enter correct choice");
                sc.nextLine();
            }


        }


    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - to Create Album");
        System.out.println("\t 1 - To print list  your Album");
        System.out.println("\t 2 - To Add song to your list album");
        System.out.println("\t 3 - View Song based list your Album");
        System.out.println("\t 4 - Remove Song in your Album");
        System.out.println("\t 5 - To Next Song in your Album"); // still in my mind (Sunday 14 Feb 2021)
        System.out.println("\t 6 - To Remove Album"); // still in my mind (Sunday 14 Feb 2021)
        System.out.println("\t 7 - To print choice options."); // still in my mind (Sunday 14 Feb 2021)
        System.out.println("\t 8 - To quit the application");// still in my mind (Sunday 14 Feb 2021)
    }

    public static void nextInstruction() {
        System.out.println("\t=Next / Previous Song Menu:= ");
        System.out.println("\nPress ");
        System.out.println("\t 1 - Next Song.");
        System.out.println("\t 2 - Previous song.");
        System.out.println("\t 3 - Back to Playlist Menu.");
        System.out.println("\t 4 - Back to Main Menu.");
    }

    public static void nextPrevSong() {
        int choice;
        boolean quit = false;
        while (!quit) {
            boolean nextStep = sc.hasNext();
            if (nextStep) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:

                }
            }
        }
    }


    public static void addAlbum() {
        System.out.println(" Please enter your Album Name : ");
        playlist.addNewAlbum(sc.nextLine());


    }

    public static void listYourAlbum() {
        playlist.findAlbums();

    }

    public static void addSongToExistAlbum() {
        System.out.println("Please enter the song into your album list");
        playlist.addSongtoAlbum(sc.nextLine(), sc.nextLine(), sc.nextDouble());
    }


    public static void printListSongByAlbum() {
        System.out.println(" please insert album in your playlist ");
        String albumName = sc.nextLine();
        Album existAlbum = playlist.queryAlbum(albumName);
        if (existAlbum == null) {
            System.out.println(" Album " + albumName + " does not exists");
        } else {
            existAlbum.printSongListyourAlbum();
        }
    }

    public static void playNextPrevSong() {
        System.out.println(" please insert album in your playlist ");
        String albumName = sc.nextLine();
        Album existAlbum = playlist.queryAlbum(albumName);
        if (existAlbum == null) {
            System.out.println(" Album " + albumName + " does not exists");
        } else {
            existAlbum.printSongListyourAlbum();

            boolean quit = false;
            int option = 0;
            printInstructions();
            while (!quit) {
         //       playlist.nextPrevSong(albumName);
            }
        }
    }


    public static void removeSongInYourAlbum() {
        System.out.println(" please enter the album");
        String albumName = sc.nextLine();
        Album existAlbum = playlist.queryAlbum(albumName);
        if (existAlbum == null) {
            System.out.println(" Album " + albumName + " does not exists");
        } else if (existAlbum != null) {
            System.out.println(" Please enter the song title you want remove");
            String songName = sc.nextLine();
            existAlbum.removeSong(songName);
            System.out.println(" the song has been removed in your album ");
        } else {
            System.out.println(" the Album and Song not found ");
        }
    }

    public static void playPrevAndNextSong() {
        listYourAlbum();
        System.out.println("Please input your album : ");
        String findAlbum = sc.nextLine();
        Album existAlbum = playlist.queryAlbum(findAlbum);
        if (existAlbum == null) {
            System.out.println(" Album " + findAlbum + " does not exists");
        } else if (existAlbum != null) {
            existAlbum.printSongListyourAlbum();
//            ListIterator<Song> listIterator = playlist.lis
            boolean quit = false;
            int choice = 0;
            nextInstruction();
            while (!quit) {
               /* System.out.println("Enter your choice: 1 to 4 show instructions)");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine();*/
                playlist.nextPrevSong(choice);
                }
                //if (playlist.findAlbum());

            }
        }
    }

