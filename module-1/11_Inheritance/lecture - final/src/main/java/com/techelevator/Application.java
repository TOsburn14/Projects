package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Bid newBid = new Bid("name", 10);
        Bid otherBid = new Bid("name", 10);

        System.out.println( newBid.toString() ) ;
        System.out.println( newBid.equals(otherBid) );

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

        BuyoutAuction buyoutAuction = new BuyoutAuction("Book", 25);

        buyoutAuction.placeBid(new Bid("John", 20));

        ReserveAuction reserveAuction = new ReserveAuction("Water", 3);

        reserveAuction.placeBid(new Bid("Steve", 2));
        reserveAuction.placeBid(new Bid("Rachelle", 4));

        /*
            Upcasting is casting from a subclass to a super class
            It is form of widening so it is implicit
         */
        Auction reserveAuctionAsAuction = reserveAuction;
        Object reserveAuctionAsObject = reserveAuction;

        /*
            Downcasting is casting from a super class to a subclass
            The object in memory must be capable of being that subclass.
            This is a form of narrowing so it is explicit
         */
        ReserveAuction backToReserveAuction = (ReserveAuction) reserveAuctionAsAuction;


        /*
            If you try to downcast to a class that the object in memory cannot be then
            it will result in a ClassCastException

            BuyoutAuction thisWillError = (BuyoutAuction) generalAuction;
         */


        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);

        for (Auction currentAuction : auctions) {
            currentAuction.placeBid( new Bid("Rachelle", 15) );
        }

    }
}
