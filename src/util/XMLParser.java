/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory; 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import model.entities.Weapon;
import model.entities.Monster;
import java.util.LinkedList;

/**
 *
 * @author mandreacchio
 */
public class XMLParser {

    File file;
    DocumentBuilderFactory dbf;
    Document doc;
    XPathFactory xpathfactory;
    XPath xpath;
    
    public XMLParser() {

        try {
            
            file = new File("src/application/resources/compendium.xml");
            dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            xpathfactory = XPathFactory.newInstance();
            xpath = xpathfactory.newXPath();
        
        } catch (Exception e) {
            System.out.println("Failed attempted compendium xml parse");
            e.printStackTrace();
        }
    }
   
    
    public LinkedList<Weapon> getWeapons(){

        LinkedList<Weapon> weaponList = new LinkedList<>();
        
        try {
            XPathExpression expr = xpath.compile("/compendium/item[type = 'M' and magic = '']");
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String dice = eElement.getElementsByTagName("dmg1").item(0).getTextContent();
                    String[] arrOfStr = dice.split("d", 2);
                    int diceCount = Integer.parseInt(arrOfStr[0]);
                    int diceType = Integer.parseInt(arrOfStr[1]);
                    Weapon weapon = new Weapon(name, diceType, diceCount);
                    weaponList.add(weapon);
                }                             
            }   
        } catch (Exception e) {
            System.out.println("Failed getting weapons from .xml");
            e.printStackTrace();
        }

        return weaponList;
    }
    

    public LinkedList<Monster> getMonsters(){

        LinkedList<Monster> monsterList = new LinkedList<>();
        
        try {
            XPathExpression expr = xpath.compile("/compendium[1]/monster[contains(type, 'beast') and cr = '1/2']");
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String size = eElement.getElementsByTagName("size").item(0).getTextContent();
                    String type = eElement.getElementsByTagName("type").item(0).getTextContent();
                    int ac = Integer.parseInt(eElement.getElementsByTagName("ac").item(0).getTextContent().split(" ")[0]);
                    String healthPoints = eElement.getElementsByTagName("hp").item(0).getTextContent();
                    int hp = Integer.parseInt(healthPoints.split(" ")[0]);
                    int str = Integer.parseInt(eElement.getElementsByTagName("str").item(0).getTextContent());
                    int dex = Integer.parseInt(eElement.getElementsByTagName("dex").item(0).getTextContent());
                    int con = Integer.parseInt(eElement.getElementsByTagName("con").item(0).getTextContent());
                    int in = Integer.parseInt(eElement.getElementsByTagName("int").item(0).getTextContent());
                    int wis = Integer.parseInt(eElement.getElementsByTagName("wis").item(0).getTextContent());
                    String cr = eElement.getElementsByTagName("cr").item(0).getTextContent();
                    Monster monster = new Monster(name, size, type, ac, hp, str, dex, con, in, wis, cr);
                    monsterList.add(monster);
                }                             
            }   
        } catch (Exception e) {
            System.out.println("Failed getting Monsters from .xml");
            e.printStackTrace();
        }
        
        for (Monster m : monsterList) {
            System.out.println(m.getName());
            System.out.println(m.getSize());
        }

        return monsterList;
    }
    
    
    
    
    
    
}
