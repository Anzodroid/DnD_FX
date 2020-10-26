/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd_fx;

import static dnd_fx.Dice.Deight;
import static dnd_fx.Dice.Dfour;
import static dnd_fx.Dice.Dsix;
import static dnd_fx.Dice.Dten;
import static dnd_fx.Dice.Dtwelve;

/**
 *
 * @author Anzo
 */
public class Weapon {
//    int wep;
	
//	public int WeaponDmg (int w) {
//
//
//	switch (w) {
//	
//	case 1 :
//	// GreatAxe
//		w = Dtwelve();
//		break;
//
//	case 2 :
//		//Great Sword
//		w = Dsix()+Dsix();
//		break;
//    
//	case 3 :
//		//Club
//		w = Dfour();
//		break;
//	
//	case 4 :
//		//MorningStar
//		w = Deight();
//		break;
//	
//	case 5 :
//		//Scimitar
//		w = Dsix();
//		break;
//		
//	case 6 :	
//  		//Warhammer
//		w = Dten();
//		break;
//
//	}
//	return w;
//}
    
    	public int WeaponDmg (String weapon) {
        
        int weaponInt = 0;    
            
	switch (weapon) {
	
	case "GreatAxe" :
	// GreatAxe
		weaponInt = Dtwelve();
		break;

	case "Great Sword" :
		//Great Sword
		weaponInt = Dsix()+Dsix();
		break;
    
	case "Club" :
		//Club
		weaponInt= Dfour();
		break;
	
	case "MorningStar" :
		//MorningStar
		weaponInt = Deight();
		break;
	
	case "Scimitar" :
		//Scimitar
		weaponInt = Dsix();
		break;
		
	case "Warhammer" :	
  		//Warhammer
		weaponInt = Dten();
		break;

	}
	return weaponInt;
}
    
}
