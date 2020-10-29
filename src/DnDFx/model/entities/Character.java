/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DnDFx.model.entities;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Anzo
 */
public class Character {
    
    private SimpleStringProperty name;
    private Weapon weapon;
    private double maxHp, currentHp;
    private int  ap, str, dex, pro;
    
    public Character(String name, int str, int dex, int ap, double maxHp, int pro, Weapon weapon) {
        this.name = new SimpleStringProperty(name);
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.ap = ap;
        this.str = str;
        this.dex = dex;
        this.pro = pro;
        this.weapon = weapon;                
    }

    public String getName() {
        return name.get(); 
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double hp) {
        this.maxHp = hp;
    }
    
    public double getCurrentHp() {
        return maxHp;
    }

    public void setCurrentHp(double hp) {
        this.maxHp = hp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
}
