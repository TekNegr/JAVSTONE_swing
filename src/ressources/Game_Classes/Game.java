package ressources.Game_Classes;
import java.util.Random;

public class Game {
    Player player1, player2;
    Deck drawingDeck;
    Deck graveYarDeck;
    boolean end_game;
    String winner;

    //CONSTRUCTOR
    public Game(String username1, String username2){
        this.player1 = new Player(username1, this);
        this.player2 = new Player(username2, this);
        this.drawingDeck.populateDeck();
        this.SetUpGame();
    }

    //METHODS

    //Selection des You cards et des mains des joueurs
    public void SetUpGame(){
        this.player1.setYouCard(drawingDeck.drawMajor());
        this.player2.setYouCard(drawingDeck.drawMajor());
        while(this.player1.getYouCard() == this.player2.getYouCard()){
            this.drawingDeck.addCard(this.player2.getYouCard());
            this.player2.setYouCard(drawingDeck.drawMajor());
        }
        this.initDraw();
    }
    //Coinflip to determine who goes first
    public Player coinFlip() {
        Random random = new Random();
        int startingPlayerIndex = random.nextInt(2);
        return startingPlayerIndex == 0 ? this.player1 : this.player2;
    }    

    //Launcher of the game
    public void StartGame(){
        playTurn(coinFlip());
    }

    //Logic for one turn
    public void playTurn(Player player){
        boolean turnOver=false;
        while(!this.gameEnded()){
            while (!turnOver){
                player.drawFromDeck(); //Draw au debut de tour
                player.regenMp(); //Regen MP
                //Ajouter logique de play
                
            }
            //Changement de joueur
            player.addMaxMP();
            if(player == this.player1){
                this.playTurn(this.player2);
            }
            else if(player == this.player2){
                this.playTurn(this.player1);
            }
        }
        
        
    }

    public void consolePlayer(){

    }

    //Give 7 random card  from the deck to each player
    public void initDraw(){
        drawingDeck.shuffleDeck();
        for(int i=0;i<7;i++){
            Card card1 = drawingDeck.drawCard();
            drawingDeck.removeCardbyObject(card1);
            player1.addToHand(card1);
            Card card2 = drawingDeck.drawCard();
            player2.addToHand(card2);
            drawingDeck.removeCardbyObject(card2);
        }
        
    }

    //console logging players
    public void LogPlayers(){
        player1.logPlayer();
        player2.logPlayer();
    }

    //Checker of game end
    public boolean gameEnded(){
        boolean gameEnded = false;
        if(player1.getYouCard().health ==0 || player2.getYouCard().health ==0){
            if(player1.getYouCard().health ==0 && !(player2.getYouCard().health ==0)){
                winner = player2.getUsername();
            }
            else if(player2.getYouCard().health ==0 && !(player1.getYouCard().health ==0)){
                winner = player1.getUsername();
            }
            else if(player2.getYouCard().health ==0 && player1.getYouCard().health ==0){
                winner = "Draw";
            }
            gameEnded = true;
        }
        return gameEnded;
    }


    
}
