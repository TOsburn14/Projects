package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Bid newBid = new Bid("name",10);
        Bid otherBid = new Bid("name",10);

        System.out.println(newBid.toString());
        System.out.println(newBid.equals(otherBid));


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction buyoutAuction = new BuyoutAuction("Book",25);

        buyoutAuction.placeBid(new Bid("John", 20));

        ReserveAuction reserveAuction = new ReserveAuction("Water", 3);

        reserveAuction.placeBid(new Bid("Steve",2));
        reserveAuction.placeBid(new Bid("Rachelle", 4));


        Auction reserveAuctionAsAuction = reserveAuction;
        Object reserveAuctionAsObject = reserveAuction;

        ReserveAuction backToReserveAuction = (ReserveAuction) reserveAuctionAsAuction;


        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);

        for (Auction currentAuction : auctions) {
            currentAuction.placeBid(new Bid("Rachelle",15));
        }
    }


}
