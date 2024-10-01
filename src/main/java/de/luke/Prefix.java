package de.luke;

import java.util.Vector;

public class Prefix {
    public Vector pref;
    static final int MULTIPLIER = 31;

    Prefix(Prefix p) {
        pref = (Vector) p.pref.clone();
    }

    Prefix(int n, String s) {
        pref = new Vector();
        for (int i = 0; i < n; i++) {
            pref.addElement(s);
        }
    }

    public int hashCode() {
        int h = 0;
        for (int i = 0; i < pref.size(); i++) {
            h = MULTIPLIER * h + pref.elementAt(i).hashCode();
        }
        return h;
    }

    public boolean equals (Object o) {
        Prefix p = (Prefix) o;
        for (int i = 0; i < pref.size(); i++) {
            if (!pref.elementAt(i).equals(p.pref.elementAt(i))) {
                return false;
            }
        }
        return true;
    }
}
