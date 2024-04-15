package ressources.Game_Classes;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Card_Controller {
    //Major or Minor Arcana 
    private enum Card_Arcana{
        MAJOR("Major"), MINOR("Minor");

        private String type;
        Card_Arcana(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }

    //Enum des cartes Majeures 
    private enum MajorCard{
        FOOl(0,"The Fool", "Blissful ignorance",5,5,5,"FOOL.png");
        //Don't change the list of cards yet I'm testing
        private int id;
        private String name;
        private String description;
        private String imagePath;
        private int cost;
        private int attack;
        private int health;
        private boolean isMajor = true;

        MajorCard(int id, String name, String description, int cost, int attack, int health, String imgPath){
            this.id = id;
            this.name = name;
            this.description = description;
            this.cost = cost;
            this.attack = attack;
            this.health = health;
            this.imagePath = "MajorArcana/"+imgPath;
        };

        public int getId() {
            return this.id;
        }
    
        public String getName() {
            return this.name;
        }
    
        public String getDescription() {
            return this.description;
        }
    
        public String getImagePath() {
            return this.imagePath;
        }
    
        public int getCost() {
            return this.cost;
        }
    
        public int getAttack() {
            return this.attack;
        }
    
        public int getHealth() {
            return this.health;
        }
    
        public boolean isMajor() {
            return this.isMajor;
        }
    }

    public enum Value{
        ACE("Ace",1);

        private String valName;
        private int val;
        Value(String name, int val){
            this.valName = name;
            this.val = val;
        }
    } 

    public enum Suit{
        CUPS("Cups"), PENTACLES("Pentacles"), SWORDS("Swords"), WANDS("Wands");

        private String name;
        Suit(String name){
            this.name=name;
        }

    }

    //Enum des cartes Mineurs
    private enum MinorCard{
        ACE_CUPS(101, "Ace of cups", "Fortune in Health",1,1,1, "ACE_CUPS.png", Value.ACE, Suit.CUPS);


        private int id;
        private String name;
        private Suit suit;
        private Value value;
        private String description;
        private String imagePath;
        private int cost;
        private int attack;
        private int health;
        private boolean isMajor = false;

        MinorCard(int id, String name, String description, int cost, int attack, int health, String imagePath, Value val, Suit suit){
            this.id = id;
            this.name = name;
            this.description = description;
            this.cost = cost;
            this.attack = attack;
            this.health = health;
            this.imagePath = "MinorArcana/"+imagePath;
            this.value = val;
            this.suit = suit;
        }
        
        public int getId() {
            return this.id;
        }
    
        public String getName() {
            return this.name;
        }
    
        public String getDescription() {
            return this.description;
        }
    
        public String getImagePath() {
            return this.imagePath;
        }
    
        public int getCost() {
            return this.cost;
        }
    
        public int getAttack() {
            return this.attack;
        }
    
        public int getHealth() {
            return this.health;
        }
    
        public boolean isMajor() {
            return this.isMajor;
        }
    }

    //Populations 
    public ArrayList<Card> popWithMins(){
        ArrayList<Card> cards = new ArrayList<Card>();
        int i = 0;
        for(MinorCard mincard : MinorCard.values() ){
            cards.add(makeCard(Card_Arcana.MINOR, i));
            i++;
        }
        return cards;
    }

    public ArrayList<Card> popWithMajs(){
        ArrayList<Card> cards = new ArrayList<Card>();
        int i = 0;
        for(MajorCard majcard : MajorCard.values() ){
            cards.add(makeCard(Card_Arcana.MINOR, i));
            i++;
        }
        return cards;
    }
    //Enum contenant tous les effets possibles durant le jeu
    public enum Effects{
        STUN(0,"Stun",true);

        private int id;
        private int ActiveTurns;
        private String name;
        private boolean isActivable;
        Effects(int id, String name, boolean isActivable){
            this.id = id;
            this.name = name;
            this.isActivable = isActivable;
        }
        // Getter methods
        public int getId() {
            return id;
        }
    
        public String getName() {
            return name;
        }
    
        public boolean isActivable() {
            return isActivable;
        }
    
        // Setter methods
        public void setId(int id) {
            this.id = id;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void setActivable(boolean activable) {
            isActivable = activable;
        }
    }

    //Getter d'Arcana 
    public Card_Arcana getArcana(boolean b){
        return b ? Card_Arcana.MAJOR : Card_Arcana.MINOR;
    }

    //Create the card from a dictionnary and an ID
    public Card makeCard(Card_Arcana cArcana, int id){
        if(cArcana.getType()=="Major"){
            for(MajorCard majCard : MajorCard.values()){
                if(majCard.id == id){
                    return new MajCard(majCard.id, majCard.name, majCard.description, majCard.imagePath, majCard.cost, majCard.attack, majCard.health);
                }
            }
        }
        else if(cArcana.getType()=="Minor"){
            for(MinorCard minCard : MinorCard.values()){
                if(minCard.id == id){
                    return new MinCard(minCard.id, minCard.name, minCard.description, minCard.imagePath, minCard.cost, minCard.attack, minCard.health, minCard.value, minCard.suit);
                }
            }
        }
        return null;

    }

}
