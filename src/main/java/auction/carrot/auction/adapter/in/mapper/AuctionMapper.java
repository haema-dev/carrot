package auction.carrot.auction.adapter.in.mapper;

import auction.carrot.auction.adapter.in.command.AuctionCommand;
import auction.carrot.auction.domain.Auction;


public class AuctionMapper {

    public Auction toEntity(AuctionCommand command) {

        Auction auction = null;

        if(command instanceof AuctionCommand.AuctionCreateCommand){
            auction = toCreateEntity((AuctionCommand.AuctionCreateCommand) command);
        }else if(command instanceof AuctionCommand.AuctionUpdateCommand){
            auction = toUpdateEntity((AuctionCommand.AuctionUpdateCommand) command);
        } else {
            auction = toReadEntity((AuctionCommand.AuctionReadCommand) command);
        }
        return auction;
    }

    public AuctionCommand toDomain(String req, Auction auction) {

        AuctionCommand command = null;

        if(req.equals("c")) {
            command = toCreateDomain(auction);
        } else {
            command = toReadDomain(auction);
        }
        return command;
    }

    public Auction toReadEntity(AuctionCommand.AuctionReadCommand command) {
        return Auction.builder()
                .auctionNo(command.getAuctionNo())
                .auctionItemName(command.getAuctionItemName())
                .auctionBettingCost(command.getAuctionBettingCost())
                .auctionCompetitionFirst(command.getAuctionCompetitionFirst())
                .build();
    }

    public AuctionCommand toReadDomain(Auction auction) {
        return AuctionCommand.AuctionReadCommand.builder()
                .auctionNo(auction.getAuctionNo())
                .auctionBettingCost(auction.getAuctionBettingCost())
                .auctionCompetitionFirst(auction.getAuctionCompetitionFirst())
                .build();
    }

    private Auction toCreateEntity(AuctionCommand.AuctionCreateCommand command) {
        return Auction.builder()
                .auctionNo(command.getAuctionNo())
                .auctionItemName(command.getAuctionItemName())
                .auctionBettingCost(command.getAuctionBettingCost())
                .auctionCompetitionFirst(command.getAuctionCompetitionFirst())
                .build();
    }
    private Auction toUpdateEntity(AuctionCommand.AuctionUpdateCommand command) {
        return Auction.builder()
                .auctionNo(command.getAuctionNo())
                .auctionBettingCost(command.getAuctionBettingCost())
                .auctionCompetitionFirst(command.getAuctionCompetitionFirst())
                .build();
    }

    private AuctionCommand toCreateDomain(Auction auction) {
        return AuctionCommand.AuctionCreateCommand.builder()
                .auctionNo(auction.getAuctionNo())
                .auctionBettingCost(auction.getAuctionBettingCost())
                .auctionCompetitionFirst(auction.getAuctionCompetitionFirst())
                .build();
    }

}
