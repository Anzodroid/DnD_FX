/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd_fx;

/**
 *
 * @author Anzo
 */
public class Character {
    
	public String name;
	public int hp;
	public int ap;
	public int str;
	public int pro;
	public int dex;
	public int weapon;
	
	



//////////////////////////////////////// 2nd Character

	public Character(String name, int hp,  int ap, int str, int dex, int pro, int weapon){
        this.setName(name);
        this.setHp(hp);
        this.setAp(ap);
        this.setStr(str);
        this.setDex(dex);
        this.setPro(pro);
        this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
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

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}
	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

    public int getWeapon() {
		return weapon;
	}

    
    
    
}
