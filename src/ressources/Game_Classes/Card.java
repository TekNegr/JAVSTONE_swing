package ressources.Game_Classes;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


//FOR BLACKBOX : Only change what already exist. Don't invent any functions 

public abstract class Card {
//VARIABLES 
    //basics
    protected int id;
    protected String name;
    protected String description;
    protected Image image;
    protected String[] minorVal;

    //stats
    protected boolean isPlaced;
    protected String place;
    protected int cost;
    protected int attack;
    protected int health;
    protected boolean isMajor;
    protected boolean isCharacter;
    protected boolean isStuned;

    //effects
    protected ArrayList<Card_Controller.Effects> activableEffects;
    protected ArrayList<Card_Controller.Effects> affectedEffects;

    //var ext


//CONSTRUCTEUR

    public Card(int id, String name, String description, String imagePath, int cost, int attack, int health, boolean isMajor) {
        this.id = id;
        this.name = name;
        this.description = description;
        try {
            this.image = getImageFromPath("Cover.png");;
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            this.image = getImageFromPath("Cover.png");
        }
        this.cost = cost;
        this.attack = attack;
        this.health = health;
        this.isMajor = isMajor;
        this.isStuned = false;
        
    }
//METHODES 

    //GETTERS 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }

    public int getCost() {
        return cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public boolean isMajor() {
        return isMajor;
    }

    public boolean isStuned() {
        return isStuned;
    }

    public boolean isPlaced(){
        return isPlaced;
    }

    //SETTERS 
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMajor(boolean major) {
        isMajor = major;
    }

    public void setStuned(boolean stuned) {
        isStuned = stuned;
    }

    public void setPlace(boolean b){
        this.isPlaced = b;
    }

    //GAME METHODS 

    public void Attack(Card card){
        card.setHealth(card.health - this.attack);
        if(card.health == 0){
            card.die();
        }
    }

    public void die(){
        this.place = null;
    }


    //FX METHODS
    public JPanel getCardPanel() {
        JPanel cardView = new JPanel();
        cardView.setLayout(new BorderLayout());

        // Créer le header de la carte
        JPanel cardHeader = createHeader();
        cardHeader.setBackground(Color.LIGHT_GRAY);
        cardView.add(cardHeader, BorderLayout.NORTH);

        // Créer le body de la carte
        JPanel cardBody = createBody();
        cardView.add(cardBody, BorderLayout.CENTER);

        // Créer le footer de la carte
        JPanel cardFooter = createFooter();
        cardFooter.setBackground(Color.LIGHT_GRAY);
        cardView.add(cardFooter, BorderLayout.SOUTH);

        // Définir la taille préférée du panneau de carte
        cardView.setPreferredSize(new Dimension(200, 400));

        // Retourner le panneau de carte
        return cardView;
    }

    private JPanel createHeader(){
        JPanel cardHeader = new JPanel(new GridLayout(1,3));
        cardHeader.add(new JLabel(health+"<3"));
        JButton cardTitle = new JButton(name);

        cardTitle.addActionListener(e->{
            //Implementer la logique ici

            System.out.println("Name " + this.name);
        });

        cardHeader.add(cardTitle);
        cardHeader.add(new JLabel(cost+"$"));
        cardHeader.setPreferredSize(new Dimension( 200,50));

        return cardHeader;
    }
    private JPanel createBody(){
        JPanel cardBody = new JPanel();
        cardBody.add(new JLabel(new ImageIcon(image)));
        cardBody.setPreferredSize(new Dimension( 200,500));
        return cardBody;
    }
    private JPanel createFooter(){
        JPanel cardFooter = new JPanel(new GridLayout(1,3));
        cardFooter.add(new JLabel(attack + "X"));
        cardFooter.add(new JLabel(description));
        cardFooter.add(new JLabel(isStuned+""));
        cardFooter.setPreferredSize(new Dimension( 200,50));
        return cardFooter;
    }

    //For context, we are inside the abstract Card class

    public Image getImageFromPath(String path) {
        Image image = null;
        String imgPath = "src/ressources/GUI/Images/"+path;
        try {
            image = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    //OTHERS

}
