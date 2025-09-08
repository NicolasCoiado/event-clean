package dev.java10x.EventClean.infrastructure.config;

import dev.java10x.EventClean.core.entity.Event;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IdentifierGenerator {
    public String generate(Event event){

        Random random = new Random();

        String title = event.title();
        String[] words = title.trim().split("\\s+");
        StringBuilder acronym = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                acronym.append(word.charAt(0));
            }
            if (acronym.length() == 3) {
                break;
            }
        }
        String letters = acronym.toString().toUpperCase();
        int number = 1000000 + random.nextInt(9000000);
        int year = event.start_date().getYear();

        return letters+year+"-"+number;
    }
}
