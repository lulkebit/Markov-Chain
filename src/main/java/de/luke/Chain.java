package de.luke;

import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

public class Chain {
    static final int NPREF = 2;
    static final String NOWORD = "\n";
    Hashtable statetab = new Hashtable(); // key = Prefix, value = suffix Vector
    Prefix prefix = new Prefix(NPREF, NOWORD);
    Random rand = new Random();

    void build (InputStream in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);

        st.resetSyntax();
        st.wordChars(0, Character.MAX_VALUE);
        st.whitespaceChars(0, ' ');

        while (st.nextToken() != st.TT_EOF) {
            add(st.sval);
        }

        add(NOWORD);
    }

    void add (String word) {
        Vector suf = (Vector) statetab.get(prefix);

        if (suf == null) {
            suf = new Vector();
            statetab.put(new Prefix(prefix), suf);
        }

        suf.addElement(word);

        prefix.pref.removeElementAt(0);
        prefix.pref.addElement(word);
    }

    void generate (int nwords) {
        prefix = new Prefix(NPREF, NOWORD);

        for (int i = 0; i < nwords; i++) {
            Vector s = (Vector) statetab.get(prefix);
            int r = Math.abs(rand.nextInt()) % s.size();
            String suf = (String) s.elementAt(r);

            if (suf.equals(NOWORD)) {
                break;
            }

            System.out.print(suf + " ");
            prefix.pref.removeElementAt(0);
            prefix.pref.addElement(suf);
        }
    }
}
