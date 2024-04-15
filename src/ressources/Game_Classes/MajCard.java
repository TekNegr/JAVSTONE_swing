package ressources.Game_Classes;

public class MajCard extends Card{
    public MajCard(int id, String name, String description, String imagePath, int cost, int attack, int health){
        super(id, name, description, description, cost, attack, health, true);
        this.image = getImageFromPath(imagePath);
    }

    

}
