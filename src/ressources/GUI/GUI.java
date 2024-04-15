package ressources.GUI;
import ressources.Game_Classes.*;


public class GUI {
    private swingControler sC;
    private Game game;

    public GUI(){
        this.init();
        game = null;
    }


    public void init(){
        goToMainMenu();
    }


    public void goToMainMenu(){
        if(sC!=null){
            sC.close();
        }
        sC = new MainMenu(this);
        sC.show();
    }

    public void goToGamePreparer(){
        if(sC!=null){
            sC.close();
        }
        sC = new GamePreparer(this);
        sC.show();
    }

    public void goToTester(Card card){
        if(sC!=null){
            sC.close();
        }
        sC = new CardTester(this,card);
        sC.show();
    }

    public void goToCredits(){
        if(sC!=null){
            sC.close();
        }
        sC = new Credits(this);
        sC.show();
    }

    public void goToGame(){
        System.out.println("Going to Game");
        if(sC!=null){
            sC.close();
            if(this.game != null){
                sC = new GameArena(this, game);
                sC.show();
            }
        }
        
    }

    public void pauseGame(){}

    public void setGame(Game game){
        this.game = game;
    }

    public void quit(){
        //game = null;
        sC.close();
    }
}
