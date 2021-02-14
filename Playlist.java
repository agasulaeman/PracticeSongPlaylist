package com.playlistSong;

import java.util.*;

public class Playlist {

    public ArrayList<Album> albumArrayList = new ArrayList<>();

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


}


//    public void addNewSongtoYourAlbum( ){//String branchName,String custName,Double transactionAmmount) {
//        //bank = new A
//        com.miniBankApplicationArrayList.Branch branch = new Branch(branchName);
//        Customer cust = new Customer(custName, transactionAmmount);
//
//        if (findCustName(custName) < 0 && (transactionAmmount > 1000 && (findBranchName(branchName))>0)) {
//            branchCustomer.add(cust);
//            branches.add(branch);
//            System.out.println(custName + " your data has been insert successfull");
//        } else if (findCustName(custName) > 0 && transactionAmmount <= 1000 && findBranchName(branchName) > 0) {
//            System.out.println("the cust " + cust.getCustName() + " not in your systems");
//        }
//
//    }


/*
    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.albumArrayList = new ArrayList<Album>();
    }

    public ArrayList<Album> getAlbumArrayList() {
        return albumArrayList;
    }

    public Playlist setAlbumArrayList(ArrayList<Album> albumArrayList) {
        this.albumArrayList = albumArrayList;
        return this;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public Playlist setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
        return this;
    }

    private Album findAlbum(String albumName) {
        for (Album checkAlbum : this.albumArrayList) {
            if (checkAlbum.getAlbumName().equals(albumName)) {
                return checkAlbum;
            }
        }
        return null;
    }

    public boolean addAlbum(String albumName) {
        if (findAlbum(albumName) == null) {
            this.albumArrayList.add(new Album(albumName));
            System.out.println(" your album : " +albumName + " has been insert in to playlist " );
            return true;
        }
        System.out.println(" your album : " +albumName + " already exists in your playlist ");
        return false;
    }




    private int findAlbumList(String albumName) {
        for (int i = 0; i < albumArrayList.size(); i++) {
            Album album = this.albumArrayList.get(i);
            if (album.getAlbumName().equals(albumName)) {
                return i;
            }
        }
        return -1;
    }

    public Album queryAlbumList(String name) {
        int position = findAlbumList(name);
        if (position >= 0) {
            return this.albumArrayList.get(position);
        }
        return null;
    }

}
*/
