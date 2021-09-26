package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
@Getter
public class GameImpl implements Game{
//    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Getter(AccessLevel.NONE)
    private NumberGenerator numberGenerator;

    private int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator,@GuessCount int guessCount){
        this.guessCount = guessCount;
        this.numberGenerator = numberGenerator;
    }
    private int number;
    @Setter
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuess;
    private boolean validNumber = true;

//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
//    public void setNumberGenerator(NumberGenerator numberGenerator){
//        this.numberGenerator = numberGenerator;
//    }
    @PostConstruct
    @Override
    public void reset() {
        smallest=numberGenerator.getMinNumber();
        guess=0;
        remainingGuess=guessCount;
        biggest=numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}",number);
    }
    @PreDestroy
    public void preDestroy(){
        log.info("In game preDestroy()");
    }
//
//    @Override
//    public int getNumber() {
//        return number;
//    }
//
//    @Override
//    public int getGuess() {
//        return guess;
//    }
//
//    @Override
//    public void setGuess(int guess) {
//        this.guess= guess;
//    }
//
//    @Override
//    public int getSmallest() {
//        return smallest;
//    }
//
//    @Override
//    public int getBiggest() {
//        return biggest;
//    }
//
//    @Override
//    public int getRemainingGuess() {
//        return remainingGuess;
//    }
//    @Override
//    public int getGuessCount(){
//        return guessCount;
//    }
    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumber){
            if (guess>number){
                biggest = guess-1;
            }
            if (guess<number){
                smallest=guess+1;
            }
        }
        remainingGuess--;

    }

//    @Override
//    public boolean isValidNumber() {
//        return validNumber;
//    }

    @Override
    public boolean isGameWon() {
        return guess== number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuess<=0;
    }

    private void checkValidNumberRange(){
        validNumber = (guess>=smallest) && (guess<=biggest);
    }
}
