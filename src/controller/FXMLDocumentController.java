/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;
// ALT + INS 
// This seems to import from other classes !!

import model.actions.Battle;
import model.entities.Dice;
import model.entities.Character;
import model.entities.Weapon;
import util.XMLParser;
import java.awt.AWTException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 *
 * @author Anzo
 */
public class FXMLDocumentController implements Initializable {

    int army1;
    int army2;
    double armyTroops1;
    double armyTroops2;
    private TextField army1Troops;
    private TextField army2Troops;
    private SimpleStringProperty weaponSelect1;
    private SimpleStringProperty weaponSelect2;
    private XMLParser parse = new XMLParser();
    private Weapon club;
    private ObservableList<Weapon> fxWeaponList = FXCollections.observableArrayList();
    private Character c1;
    private Character c2;

    public FXMLDocumentController() {
        LinkedList<Weapon> weaponList = parse.getWeapons();
        for (Weapon w : weaponList) {
            fxWeaponList.add(w);
        }
        c1 = new Character("Smacky", 3, 2, 15, 15, 2, fxWeaponList.get(1));
        c2 = new Character("Goblin", 2, -1, 15, 7, 2, fxWeaponList.get(1));
    }

    private Weapon getAnyWeapon() {
        Weapon w = new Weapon("Club", 4, 1);
        return w;
    }

    @FXML
    private Label label;
    @FXML
    private TextField txtarmy1;
    @FXML
    private TextField txtarmy2;
    @FXML
    private TextArea textArea; // army1
    @FXML
    private TextArea textArea1; // battle area
    @FXML
    private TextArea textArea2; // army2
    @FXML
    private TextArea A1Remaining;
    @FXML
    private TextArea A2Remaining;
    @FXML
    private TableView<Character> C1table;
    @FXML
    private TableColumn<Character, String> NAME1;
    @FXML
    private TableColumn<Character, Integer> STR1;
    @FXML
    private TableColumn<Character, Integer> DEX1;
    @FXML
    private TableColumn<Character, Integer> AP1;
    @FXML
    private TableColumn<Character, Integer> HP1;
    @FXML
    private TableView<Character> C2table;
    @FXML
    private TableColumn<Character, String> NAME2;
    @FXML
    private TableColumn<Character, Integer> STR2;
    @FXML
    private TableColumn<Character, Integer> DEX2;
    @FXML
    private TableColumn<Character, Integer> AP2;
    @FXML
    private TableColumn<Character, Integer> HP2;
    @FXML
    private ProgressBar Pbar1;
    @FXML
    private ProgressBar Pbar2;
    @FXML
    private ProgressBar HPbar1;
    @FXML
    private ProgressBar HPbar2;
    @FXML
    private ImageView Background;
    @FXML
    private TextArea textAreaDex;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonStop;
    @FXML
    private Button buttonRound;
    @FXML
    private ComboBox comboBox1;
    @FXML
    private ComboBox comboBox2;

    public void setArmy1Troops(TextField army1Troops) {
        this.army1Troops = army1Troops;
    }

    public void setArmy2Troops(TextField army2Troops) {
        this.army2Troops = army2Troops;
    }

    public TextField getArmy1Troops() {
        return army1Troops;
    }

    public TextField getArmy2Troops() {
        return army2Troops;
    }

    @FXML
    public void ProgressBar(Character c1, Character c2) {
        // Progress Bar ARMY 
        double ratio1 = (army1 / armyTroops1);
        Pbar1.setProgress(ratio1);
        double ratio2 = (army2 / armyTroops2);
        Pbar2.setProgress(ratio2);
        // Progress Bar HP 
        double HPratio1 = (c1.getCurrentHp() / c1.getMaxHp());
        HPbar1.setProgress(HPratio1);
        double HPratio2 = (c2.getCurrentHp() / c2.getMaxHp());
        HPbar2.setProgress(HPratio2);
    }

     
       

    public void C1Attack() {

        Battle atk1 = new Battle(Dice.Dtwenty());

        if (atk1.getD20() == 20) {
            textArea.appendText(c1.getName() + " rolls a " + atk1.getD20() + " and scores a #CRITICAL#" + "\n");
        } else {
            textArea.appendText(c1.getName() + " rolls a " + atk1.getD20() + "\n");
        }

        int swing = atk1.Attack(c1.getStr(), c1.getPro());

        textArea.appendText(c1.getName() + " gets an attack of " + swing + ", " + c2.getName() + " has an armour class of " + c2.getAp() + "\n");

        if (swing < c2.getAp()) {
            textArea.appendText("Miss" + "\n");
        } else {
            textArea.appendText("***HIT*** , " + "\n");
            int dmg;
//                      If it's a critical then damage is rolled twice, else not
            if (atk1.getD20() == 20) {
                dmg = c1.getWeapon().getDamage() + c1.getWeapon().getDamage() + c1.getStr();
            } else {
                dmg = c1.getWeapon().getDamage() + c1.getStr();
            }

            if ((c2.getCurrentHp() - dmg) <= 0) {
                c2.setCurrentHp(0);
            } else {
                c2.setCurrentHp(c2.getCurrentHp() - dmg);
            } // to stop Progress bar going negative
            
            // updates the progress bar
            ProgressBar(c1, c2);
            textArea.appendText(c1.getName() + " strikes with a damage of " + dmg + "\n");

            if (c2.getCurrentHp() < 1) {
                textArea2.appendText("### " + c2.getName() + " is Dead ###" + "\n");
                army2 = army2 - 1;
//                c2.setCurrentHp(hp2);
                A2Remaining.setText(Integer.toString(army2));
            } else {
                // DO NOTHING
            }
        }
    }

    public void C2Attack() {

        Battle atk2 = new Battle(Dice.Dtwenty());
        if (atk2.getD20() == 20) {
            textArea2.appendText(c2.getName() + " rolls a " + atk2.getD20() + " and scores a #CRITICAL#" + "\n");
        } else {
            textArea2.appendText(c2.getName() + " rolls a " + atk2.getD20() + "\n");
        }

        int swing = atk2.Attack(c2.getStr(), c2.getPro());
        textArea2.appendText(c2.getName() + " gets an attack of " + swing + ", " + c1.getName() + " has an armour class of " + c1.getAp() + "\n");

        // TODO: a lot of this code is repeated, it should be in a shared method
        if (swing < c1.getAp()) {
            textArea2.appendText("Miss" + "\n");
        } else {
            textArea2.appendText("***HIT*** , " + "\n");
            int dmg;
            if (atk2.getD20() == 20) {
                dmg = c2.getWeapon().getDamage() + c2.getWeapon().getDamage() + c2.getStr();
            } else {
                dmg = c2.getWeapon().getDamage() + c2.getStr();
            }
            if ((c1.getCurrentHp() - dmg) <= 0) {
                c1.setCurrentHp(0);
            } else {
                
                c1.setCurrentHp(c1.getCurrentHp() - dmg);
            } // to stop Progress bar going negative

            ProgressBar(c1, c2);// updates the progress bar

            textArea2.appendText(c2.getName() + " strikes with a damage of " + dmg + "\n");

            if (c1.getCurrentHp() < 1) {
                textArea.appendText("### " + c1.getName() + " is Dead ###" + "\n");
                army1 = army1 - 1;
//                c1.setHp(hp1);
                A1Remaining.setText(Integer.toString(army1));
            } else {
                // DO NOTHING
            }
        }
    }

    private void buttonStart(ActionEvent event) throws InterruptedException, AWTException {

        Thread th = new Thread(new Superloop());
        th.start();

        army1 = Integer.parseInt(txtarmy1.getText());
        army2 = Integer.parseInt(txtarmy2.getText());

    }

    @FXML
    private void run(ActionEvent event) {
        Thread th = new Thread(new Superloop());
        th.start();

        army1 = Integer.parseInt(txtarmy1.getText());
        army2 = Integer.parseInt(txtarmy2.getText());

    }

    class Superloop implements Runnable {

        @Override

        public void run() {

            int i = 0;
            textArea.setText("");
            textArea2.setText("");
            textAreaDex.setText("");
            
            // time delay between messages
            int Sec = 1; 

            A1Remaining.setText(Integer.toString(army1));
            A2Remaining.setText(Integer.toString(army2));

            // Troops set here - needs fixing
            armyTroops1 = Integer.parseInt(txtarmy1.getText());
            armyTroops2 = Integer.parseInt(txtarmy2.getText());

            // Countdown
            for (int s = 3; s > 0; s--) { 

                System.out.println("Battle will start in " + s + " seconds. ");
                textAreaDex.setText("Battle will start in " + s + " seconds. ");

                try {
                    TimeUnit.SECONDS.sleep(Sec);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } /// Delay
                textArea.setText("");
            }

            
            while (army1 > 0 || army2 > 0) { // while loop
                if (buttonStop.isPressed()) {
                    break;
                } else {
                    if (army1 < 1 || army2 < 1) {
                        break;
                    } else {

                        ProgressBar(c1, c2);// updates the progress bar

                        i++;
                                                
                        // Update with round number
                        final int j = i;
                        Platform.runLater(new Runnable(){
                            @Override public void run() {
                                buttonRound.setText("Round " + j + "\n");
                            }
                        });
                        
                        textArea.appendText("== Round " + i + "==" + "\n");
                        textArea2.appendText("== Round " + i + "==" + "\n");

//                        newHp1 = c1.getHp();
//                        newHp2 = c2.getHp();
                        ProgressBar(c1, c2);// updates the progress bar

                        try {
                            TimeUnit.SECONDS.sleep(Sec);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        } /// Delay
                        // Army Check

                        int inic1 = Battle.Initiative(c1.getDex());
                        int inic2 = Battle.Initiative(c2.getDex());
                        textAreaDex.setText(c1.getName() + " gets an initiative of " + inic1 + "\n");
                        textAreaDex.appendText(c2.getName() + " gets an initiative of " + inic2 + "\n");

                        try {
                            TimeUnit.SECONDS.sleep(Sec);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        } /// Delay

                        textArea.appendText(c1.getName() + " has a HP of " + c1.getCurrentHp() + "\n");
                        textArea2.appendText(c2.getName() + " has a HP of " + c2.getCurrentHp() + "\n");
                        // Battle Start
                        if (inic1 >= inic2) {
                            textAreaDex.appendText(c1.getName() + " attacks first");
                            try {
                                TimeUnit.SECONDS.sleep(Sec);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            } /// Delay
                            C1Attack();
                            try {
                                TimeUnit.SECONDS.sleep(Sec);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            } /// Delay
                            if (army1 < 1 || army2 < 1) {
                                break;
                            } else {
                                C2Attack();
                            }
                            try {
                                TimeUnit.SECONDS.sleep(Sec);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            } /// Delay

                            // HALF WAY 
                        } else {
                            textAreaDex.appendText(c2.getName() + " attacks first");
                            try {
                                TimeUnit.SECONDS.sleep(Sec);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            } /// Delay
                            C2Attack();
                            try {
                                TimeUnit.SECONDS.sleep(Sec);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            } /// Delay
                            if (army1 < 1 || army2 < 1) {
                                break;
                            } else {
                                C1Attack();
                            }
                            try {
                                TimeUnit.SECONDS.sleep(Sec);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            } /// Delay

                        }
                    }
                }

            }
            
            if (army1 < 1) {
                textAreaDex.setText(" Army 1 is defeated " + "\n");
                textAreaDex.appendText(" Army 2 has " + army2 + " troops remaining" + "\n");

            } else if (army2 < 1) {
                textAreaDex.setText(" Army 2 is defeated " + "\n");
                textAreaDex.appendText(" Army 1 has " + army1 + " troop(s) remaining" + "\n");

            } else {
                // Do Nothing
            }


        }
    }

    
    
    // initalise the controller class
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        NAME1.setCellValueFactory(new PropertyValueFactory<Character, String>("name"));
        STR1.setCellValueFactory(new PropertyValueFactory<Character, Integer>("str"));
        DEX1.setCellValueFactory(new PropertyValueFactory<Character, Integer>("dex"));
        AP1.setCellValueFactory(new PropertyValueFactory<Character, Integer>("ap"));
        HP1.setCellValueFactory(new PropertyValueFactory<Character, Integer>("hp"));

        C1table.setItems(getData1());
 
        NAME2.setCellValueFactory(new PropertyValueFactory<Character, String>("name"));
        STR2.setCellValueFactory(new PropertyValueFactory<Character, Integer>("str"));
        DEX2.setCellValueFactory(new PropertyValueFactory<Character, Integer>("dex"));
        AP2.setCellValueFactory(new PropertyValueFactory<Character, Integer>("ap"));
        HP2.setCellValueFactory(new PropertyValueFactory<Character, Integer>("hp"));

        C2table.setItems(getData2());

        Pbar1.setStyle("-fx-accent: yellow;");
        Pbar2.setStyle("-fx-accent: yellow;");
        HPbar1.setStyle("-fx-accent: green;");
        HPbar2.setStyle("-fx-accent: green;");

        //     Better to store the weapons objects in the combobox and not hardcoded names
        //      comboBox1.getItems().addAll("Club","MorningStar","Scimitar","Warhammer");
        //      comboBox2.getItems().addAll("GreatAxe","Great Sword","Club","MorningStar","Scimitar","Warhammer");
        comboBox1.setItems(fxWeaponList);
        comboBox2.setItems(fxWeaponList);
    }
    
    
    //     this updates once combobox is changed
    @FXML
    public void comboUpdate1() {
        Weapon w = (Weapon) this.comboBox1.getValue();
        c1.setWeapon(w);
        System.out.println(c1.getWeapon());
    }

    @FXML
    public void comboUpdate2() {
        Weapon w = (Weapon) this.comboBox2.getValue();
        c2.setWeapon(w);
        System.out.println(c2.getWeapon());
    }
    
    public ObservableList<Character> getData1() {// table 1
        ObservableList<Character> people = FXCollections.observableArrayList();
        people.add(new Character(c1.getName(), c1.getStr(), c1.getDex(), c1.getAp(), c1.getCurrentHp(), c2.getPro(), c2.getWeapon()));
        return people;
    }

    public ObservableList<Character> getData2() {// table2
        ObservableList<Character> char2 = FXCollections.observableArrayList();
        char2.add(new Character(c2.getName(), c2.getStr(), c2.getDex(), c2.getAp(), c2.getCurrentHp(), c2.getPro(), c2.getWeapon()));
        return char2;
    }

}
