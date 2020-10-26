/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd_fx;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Anzo
 */
public class CharacterFX {
    
    private SimpleStringProperty name;
    private String weapon;
    private double hp;
    private int  ap, str, dex, pro;
    
    public CharacterFX(String name, int str, int dex, int ap, double hp, int pro, String weapon) {
        this.name = new SimpleStringProperty(name);// normal string requires conversion to SimpleStringProperty for JavaFX
        this.hp = hp;
        this.ap = ap;
        this.str = str;
        this.dex = dex;
        this.pro = pro;
        this.weapon = weapon;                
//        this.weapon = new SimpleStringProperty(weapon);// normal string requires conversion to SimpleStringProperty for JavaFX
    }

    public String getName() {
        return name.get(); // not sure why, but needs GET
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
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

    public String getWeapon() {
        return weapon; // not sure why, but needs GET
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }


//    @Override
//    public void initalize(URL url, ResourceBundle rb){
//        


        
    
    
    
    
}
