/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import static java.lang.Math.random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    
    public static int rollSidedDice(int diceType) {
        switch (diceType) {
            case 4:
                return Dice.Dfour();
            case 6:
                return Dice.Dsix();
            case 8:
                return Dice.Deight();
            case 10:
                return Dice.Dten();
            case 12:
                return Dice.Dtwelve();
            case 20:
                return Dice.Dtwenty();
            default:
                return 0;
        }
    }

    
    public static int rollDiceEqn(String roll) {
        Pattern pattern = Pattern.compile("([1-9]+)d([4,6,8,10,12,20]+)\\+?([0-9]){0,1}"); 
        Matcher m = pattern.matcher(roll); 
        int result = 0;
        while (m.find()) {
            
            System.out.println(m.group(0));
            int diceNumber = Integer.parseInt(m.group(1));
            int diceType = Integer.parseInt(m.group(2));
            int dicePlus;
            
            try {
                dicePlus = Integer.parseInt(m.group(3));
            } catch (NumberFormatException e) {
                dicePlus = 0;
            }
            
            
            for (int i = 0; i < diceNumber; i++) {
                int rollResult = Dice.rollSidedDice(diceType);
                System.out.println("Rolling: d" + diceType + " Result: " + rollResult);
                result = result + rollResult;
            }
            result = result + dicePlus;
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        System.out.println(Dice.rollDiceEqn("(1d20+5) 2d6 1d4 1d10"));
    }
    
}
