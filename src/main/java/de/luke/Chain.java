package de.luke;

import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Chain {
    static final int NPREF = 2;
    static final String NOWORD = "\n";
    Map<Prefix, List<String>> statetab = new HashMap<>(); // key = Prefix, value = suffix List
    Prefix prefix = new Prefix(NPREF, NOWORD); // Declare prefix as a class member
    Random rand = new Random(System.currentTimeMillis());

    void build(InputStream in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);

        st.resetSyntax();
        st.wordChars(0, Character.MAX_VALUE);
        st.whitespaceChars(0, ' ');

        while (st.nextToken() != st.TT_EOF) {
            add(st.sval);
        }

        add(NOWORD);
    }

    void add(String word) {
        List<String> suf = statetab.get(prefix);

        if (suf == null) {
            suf = new ArrayList<>();
            statetab.put(new Prefix(prefix), suf);
        }

        suf.add(word);

        prefix.pref.remove(0);
        prefix.pref.add(word);
    }

    void generate(int nwords) {
        // Randomly initialize the prefix
        List<Prefix> keys = new ArrayList<>(statetab.keySet());
        prefix = keys.get(rand.nextInt(keys.size()));

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < nwords; i++) {
            List<String> s = statetab.get(prefix);

            if (s == null) {
                break;
            }

            int r = Math.abs(rand.nextInt()) % s.size();
            String suf = s.get(r);

            if (suf.equals(NOWORD)) {
                break;
            }

            output.append(suf).append(" ");
            prefix.pref.remove(0);
            prefix.pref.add(suf);
        }

        System.out.print(output.toString().trim());
    }
}