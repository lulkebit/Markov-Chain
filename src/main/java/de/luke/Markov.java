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

        String inputText = "The night was cold, dark.\n" +
                "Clouds covered the distant moon.\n" +
                "Wind swept through the trees.\n" +
                "Leaves rustled in soft whispers.\n" +
                "The forest felt eerily quiet.\n" +
                "I ventured deeper into shadows.\n" +
                "Branches cracked under my feet.\n" +
                "An owl hooted from afar.\n" +
                "Fog thickened with every step.\n" +
                "The path was barely visible.\n" +
                "I kept moving, heart pounding.\n" +
                "Something felt strange, almost unnatural.\n" +
                "The air carried a chill.\n" +
                "In the distance, lights flickered faintly.\n" +
                "They seemed to beckon me closer.\n" +
                "I hesitated but continued walking.\n" +
                "Soon, I reached an old cabin.\n" +
                "Its wooden frame was decaying.\n" +
                "The door creaked as I opened.\n" +
                "Inside, the silence was deafening.\n" +
                "Dust covered every forgotten surface.\n" +
                "A faint smell of rot lingered.\n" +
                "Cobwebs hung in every corner.\n" +
                "I lit a small candle.\n" +
                "The flame flickered in the darkness.\n" +
                "Shadows danced along the walls.\n" +
                "I saw an ancient book.\n" +
                "It lay open on a table.\n" +
                "The pages were brittle, yellowed.\n" +
                "Strange symbols covered the text.\n" +
                "I could not understand them.\n" +
                "But something drew me closer.\n" +
                "I reached out to touch.\n" +
                "The book suddenly glowed faintly.\n" +
                "Whispers echoed inside my mind.\n" +
                "They spoke of forgotten secrets.\n" +
                "A chill ran down my spine.\n" +
                "I stepped back in shock.\n" +
                "The glow faded into nothingness.\n" +
                "I quickly left the cabin behind.\n" +
                "The forest felt even darker.\n" +
                "Every sound heightened my fear.\n" +
                "I hurried along the path.\n" +
                "My breath visible in the cold.\n" +
                "In the distance, I saw something.\n" +
                "A figure stood, watching me.\n" +
                "It was tall, unmoving, silent.\n" +
                "I froze, unable to speak.\n" +
                "The figure slowly turned away.\n" +
                "I felt an overwhelming dread.\n" +
                "But I forced myself forward.\n" +
                "My footsteps echoed in the silence.\n" +
                "The figure vanished into the mist.\n" +
                "I continued walking, heart racing.\n" +
                "Nothing made sense anymore, nothing.\n" +
                "The forest closed in tightly.\n" +
                "Darkness swallowed everything around me.\n" +
                "I could not find direction.\n" +
                "The path was completely gone.\n" +
                "I stood still, utterly lost.";
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes(StandardCharsets.UTF_8));


        chain.build(inputStream);
        chain.generate(nwords);
    }
}
