package org.example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{
//    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    private Game game;
    @Autowired
    public MessageGeneratorImpl(Game game){
        this.game=game;
    }
    @PostConstruct
    public void init(){
        log.info("game = {}",game);
    }
    @Override
    public String getMainMessage() {

        return "The number is in between "+game.getSmallest()+" and "+game.getBiggest()+ " do you want to choose in between";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "Woah! you have selected correct number, the number was "+game.getNumber();
        }else if (game.isGameLost()){
            return "ugh! the guessed number was wrong, the number you have to guess was "+game.getNumber();
        }else if (!game.isValidNumber()){
            return "Invalid number range!";
        }else if (game.getRemainingGuess() == game.getGuessCount()){
            return "What is your first guess?";
        }
        else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()){
                direction ="Higher";
            }
            return direction+"! you have "+game.getRemainingGuess()+" guess left";
        }
    }
}
