package auction.carrot.betting.adapter.in.mapper;

import auction.carrot.betting.adapter.in.command.BettingCommand;
import auction.carrot.betting.domain.Betting;


public class BettingMapper {

    public Betting toEntity(BettingCommand command) {

        Betting betting = null;

        if(command instanceof BettingCommand.BettingCreateCommand){
            betting = toCreateEntity((BettingCommand.BettingCreateCommand) command);
        }else if(command instanceof BettingCommand.BettingUpdateCommand){
            betting = toUpdateEntity((BettingCommand.BettingUpdateCommand) command);
        } else {
            betting = toReadEntity((BettingCommand.BettingReadCommand) command);
        }
        return betting;
    }

    public BettingCommand toDomain(String req, Betting betting) {

        BettingCommand command = null;

        if(req.equals("c")) {
            command = toCreateDomain(betting);
        } else {
            command = toReadDomain(betting);
        }
        return command;
    }

    public Betting toReadEntity(BettingCommand.BettingReadCommand command) {
        return Betting.builder()
                .bettingSeq(command.getBettingSeq())
                .auctionId(command.getAuctionId())
                .bettingCost(command.getBettingCost())
                .email(command.getEmail())
                .build();
    }

    public BettingCommand toReadDomain(Betting betting) {
        return BettingCommand.BettingReadCommand.builder()
                .bettingSeq(betting.getBettingSeq())
                .auctionId(betting.getAuctionId())
                .bettingCost(betting.getBettingCost())
                .email(betting.getEmail())
                //.bettingStatus(betting.getBettingStatus())
                .build();
    }

    private Betting toCreateEntity(BettingCommand.BettingCreateCommand command) {
        return Betting.builder()
                .bettingSeq(command.getBettingSeq())
                .auctionId(command.getAuctionId())
                .bettingCost(command.getBettingCost())
                .email(command.getEmail())
                .build();
    }
    private Betting toUpdateEntity(BettingCommand.BettingUpdateCommand command) {
        return Betting.builder()
                .bettingSeq(command.getBettingSeq())
                .auctionId(command.getAuctionId())
                .bettingCost(command.getBettingCost())
                .email(command.getEmail())
                .build();
    }

    private BettingCommand toCreateDomain(Betting Betting) {
        return BettingCommand.BettingCreateCommand.builder()
                .bettingSeq(Betting.getBettingSeq())
                .auctionId(Betting.getAuctionId())
                .bettingCost(Betting.getBettingCost())
                .email(Betting.getEmail())
                .build();
    }

}
