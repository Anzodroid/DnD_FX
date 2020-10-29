/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DnDFx.model.entities;

/**
 *
 * @author mandreacchio
 */
public class Weapon {
    private String name;
    private int diceType;
    private int diceCount;
    
    public Weapon(String name, int diceType, int diceCount) {
        this.name = name;
        this.diceType = diceType;
        this.diceCount = diceCount;
        
    }
    
    public String getName() {
        return name;
    }
    
    public int getDiceType() {
        return diceType;
    }
    
    public int getDiceCount() {
        return diceCount;
    }
    
    public int getDamage() {
        int damage = 0;
        for (int i = 0; this.getDiceCount() > i; i++) {
            damage = damage + Dice.rollSidedDice(this.getDiceType());
        }
        return damage;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
