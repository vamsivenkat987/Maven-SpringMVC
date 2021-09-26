package org.example;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator{
    private final Random random = new Random();



    private int maxNumber ;
    private int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber){
        this.minNumber=minNumber;
        this.maxNumber=maxNumber;
    }
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber+1)+minNumber;
    }
//
//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//    public int getMinNumber(){
//        return minNumber;
//    }
}
