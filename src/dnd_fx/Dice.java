/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd_fx;

import static java.lang.Math.random;

/**
 *
 * @author Anzo
 */
public class Dice {
    public static int Dfour() {
        int D4 = (int) (random() * 4 + 1);
        return D4;
}
	
public static int Dsix() {
        int D6 = (int) (random() * 6 + 1);
        return D6;
}

public static int Deight() {
        int D8 = (int) (random() * 8 + 1);
        return D8;
}

public static int Dten() {
    int D10 = (int) (random() * 10 + 1);
    return D10;
}


public static int Dtwelve() {
        int D12 = (int) (random() * 12 + 1);
        return D12;
}

public static int Dtwenty() {
        int D20 = (int) (random() * 20 + 1);
        return D20;
}
}
