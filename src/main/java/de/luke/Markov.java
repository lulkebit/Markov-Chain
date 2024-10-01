package de.luke;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Markov {
    static final int MAXGEN = 10000; // maximum words generated

    public static void main(String[] args) throws IOException {
        Chain chain = new Chain();
        int nwords = MAXGEN;

        String inputText = "Wash the blackboard. Watch it dry. The water goes\n" +
                "into the air. When water goes into the air it\n" +
                "evaporates. Tie a damp cloth to one end of a solid or\n" +
                "liquid. Look around. What are the solid things?\n" +
                "Chemical changes take place when something burns. If\n" +
                "the burning materi a1 has 1 iqui ds, they are stab1 e and\n" +
                "the sponge rise. It looked like dough, but it is\n" +
                "burning. Break up the lump of sugar into small pieces\n" +
                "and put them together again in the bottom of a liquid. ";
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes(StandardCharsets.UTF_8));


        chain.build(inputStream);
        chain.generate(nwords);
    }
}
