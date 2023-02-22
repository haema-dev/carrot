package auction.carrot.auction.port.in;

import auction.carrot.auction.domain.Auction;

import java.util.List;

public interface AuctionUseCase {

    Auction createAuction(Auction auction);

    void updateAuction(final Long auctionId, Auction updateAuction);

    void deleteAuction(final Long auctionId);

    Auction getAuctionOne(final Long auctionId);

    List<Auction> getAuctions();

}
