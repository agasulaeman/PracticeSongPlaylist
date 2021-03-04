package com.playlistSong;

public class Song {

    private String songTitle;
    private Double durationSong;


    public Song(String songTitle, Double durationSong) {
        this.songTitle = songTitle;
        this.durationSong = durationSong;
    }

    public String getSongTitle() {
        return songTitle;
    }

    @Override
    public String toString() {
        return "Song{" +
                "durationSong=" + durationSong +
                '}';
    }
    public static Song addNewSong (String songTitle,double durationSong){
                return new Song(songTitle,durationSong);
    }


}
/*

    public static Customer addNewCustomer(String customerName, double transactionAmount){
        return new Customer(customerName,transactionAmount);
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public boolean addTransaction(double amount){
        getTransactions().add(Double.valueOf(amount));
        return true;
    }

    public void printTransaction(){
        System.out.println("You have " + transactions.size() + " transactions");
        for (int i=0; i<transactions.size();i++){
            System.out.println((i+1) + ". " + transactions.get(i).doubleValue());
        }
    }
}*/
