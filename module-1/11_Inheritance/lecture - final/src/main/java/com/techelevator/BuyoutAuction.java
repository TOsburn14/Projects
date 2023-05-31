package com.techelevator;

/*
    The extends keyword makes this class a subclass of the
    class it extends
    subclass extends superclass
 */
public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        /*
            The super keyword allows the subclass to call code in
            its superclass.  When used with () the super keyword calls
            the superclass constructor.

            super()
         */
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if (getHighBid().getBidAmount() < buyoutPrice) {

            if (offeredBid.getBidAmount() > buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            /*
                When the super keyword is used with a method it allows the
                subclass to call the super class version of an overridden method.

                super.method()
             */
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }
}
