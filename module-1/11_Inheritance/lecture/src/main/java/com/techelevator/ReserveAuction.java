package com.techelevator;

public class ReserveAuction extends Auction{

    private int reservePrice;

    public ReserveAuction(String itemBeingSold, int reservePrice) {
        super(itemBeingSold);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if (offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

    public int getReservePrice() {
        return reservePrice;
    }
}
