/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author mandreacchio
 */
public class Monster {
    
    private String name;
    private String size;
    private String type;
    private int ac;
    private int hp;
    private int str;
    private int dex;
    private int con;
    private int in;
    private int wis;
    private String cr;
//    private int attack;

    public Monster(String name, String size, String type, int ac, int hp, int str, int dex, int con, int in, int wis, String cr) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.ac = ac;
        this.hp = hp;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.in = in;
        this.wis = wis;
        this.cr = cr;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public int getAc() {
        return ac;
    }

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getIn() {
        return in;
    }

    public int getWis() {
        return wis;
    }

    public String getCr() {
        return cr;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
