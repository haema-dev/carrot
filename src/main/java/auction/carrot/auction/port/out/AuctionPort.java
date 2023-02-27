package auction.carrot.auction.port.out;

import auction.carrot.auction.domain.Auction;

import java.util.List;

public interface AuctionPort {

    Auction createAuction(Auction auction);

    void updateAuction(final Long auctionId, Auction updateAuction);

    void deleteAuction(final Long auctionId);

    Auction getAuctionOne(final Long auctionId);

    List<Auction> getAuctions();
}