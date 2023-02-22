package auction.carrot.auction.adapter.in.command;

import lombok.*;

public interface AuctionCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class AuctionCreateCommand implements AuctionCommand {
        private Long auctionNo;
        private String auctionItemName;
        private Long auctionBettingCost;
        private String auctionCompetitionFirst; // member email
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class AuctionUpdateCommand implements AuctionCommand {
        private Long auctionNo;
        private Long auctionBettingCost;
        private String auctionCompetitionFirst;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class AuctionReadCommand implements AuctionCommand {
        private Long auctionNo;
        private String auctionItemName;
        private Long auctionBettingCost;
        private String auctionCompetitionFirst;
    }

}
