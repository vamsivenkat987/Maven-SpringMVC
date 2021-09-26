package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.Config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class Main {
//    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    public static final String CONFIG_LOCATION = "beans.xml";
    public static void main(String[] args) {
        log.info("Guess the Number Game?");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//        int number = numberGenerator.next();
//        log.info("Numbers = {}",number);
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info(messageGenerator.getMainMessage());
//        log.info(messageGenerator.getResultMessage());
//        Game game = context.getBean(Game.class);
//        game.reset();
        context.close();
    }
}
