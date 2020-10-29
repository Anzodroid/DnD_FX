package DnDFx.model.actions;

import DnDFx.model.entities.Dice;

/**
 *
 * @author Anzo
 */
public class Battle {
    	int army1;
	int army2;
        int d20; 
        int sleeptime = 300;  


    public int getD20() {
        return d20;
    }
      
    public Battle(int d20) {
        this.d20 = d20;
    }
	
        
	public static int Initiative(int dex) {
		int ini = Dice.Dtwenty() + dex;
		return ini;
	}
		
	public  int Attack(int str, int pro) {
		int atk = d20 + str + pro;
		return atk;
	}

	public int getArmy1() {
		return army1;
	}

	public void setArmy1(int army1) {
		this.army1 = army1;
	}

	public int getArmy2() {
		return army2;
	}

	public void setArmy2(int army2) {
		this.army2 = army2;
	}

}

