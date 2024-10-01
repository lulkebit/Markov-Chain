package de.luke;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Markov {
    static final int MAXGEN = 8; // maximum words generated

    public static void main(String[] args) throws IOException {
        Chain chain = new Chain();
        int nwords = MAXGEN;

        String inputText = "It was a dreary night.\n" +
                "Ominous clouds veiled the sky.\n" +
                "The wind howled through streets.\n" +
                "The sea crashed against cliffs.\n" +
                "It sought to drag earth.\n" +
                "A cold mist lingered above.\n" +
                "It chilled the bones deeply.\n" +
                "The moon was hidden away.\n" +
                "Darkened fog covered the sky.\n" +
                "No light touched the ground.\n" +
                "Everything felt melancholic and still.\n" +
                "In the distance, ruins loomed.\n" +
                "Ancient castles reached toward heaven.\n" +
                "Silent pleas for forgotten glory.\n" +
                "My heart pounded with dread.\n" +
                "The ruins stood before me.\n" +
                "A monument to a past.\n" +
                "Forgotten by time and man.\n" +
                "Stones lay scattered like memories.\n" +
                "Ivy covered the broken stones.\n" +
                "Shadows shrouded the fallen walls.\n" +
                "Inside, the air smelled decay.\n" +
                "Footsteps echoed through empty halls.\n" +
                "The walls whispered old secrets.\n" +
                "Unseen eyes watched my movements.\n" +
                "They waited, lurking beyond light.";
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes(StandardCharsets.UTF_8));


        chain.build(inputStream);
        chain.generate(nwords);
    }
}
