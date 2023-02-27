package auction.carrot.betting.adapter.in.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface BettingCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class BettingCreateCommand implements BettingCommand {
        private Long bettingSeq;
        private Long auctionId;
        private Long bettingCost;
        private String email;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class BettingUpdateCommand implements BettingCommand {
        private Long bettingSeq;
        private Long auctionId;
        private Long bettingCost;
        private String email;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class BettingCancelCommand implements BettingCommand {
        private Long bettingSeq;
        private boolean bettingStatus;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class BettingReadCommand implements BettingCommand {
        private Long bettingSeq;
        private Long auctionId;
        private Long bettingCost;
        private String email;
        private boolean bettingStatus;
    }

}
