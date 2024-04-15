package ressources.Game_Classes;



public class MinCard extends Card{
    private Card_Controller.Value val;
    private Card_Controller.Suit suit;
   
    public MinCard(int id, String name, String description, String imagePath, int cost, int attack, int health, Card_Controller.Value val, Card_Controller.Suit suit){
        super(id, name, description, description, cost, attack, health, false);
        this.image=getImageFromPath(imagePath);
        this.val = val;
        this.suit = suit;
    }

}
