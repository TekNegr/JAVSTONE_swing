package ressources.Game_Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class Deck extends Hand{
    private Card_Controller CC;

    //CONSTRUCTEUR
    public Deck(Game game){
        super(78, game);
        CC = new Card_Controller();
    }


    //CUSTOM METHODS
    public void populateDeck(){
        Card[] MinCards = CC.popWithMins().toArray(new Card[58]);
        Card[] MajCards= CC.popWithMajs().toArray(new Card[22]);
        this.hand = this.mixCards(MinCards, MajCards);
        this.shuffleDeck();
        // for(Card card: this.hand){
        //     card.setGame(this.game);
        // }
    }

    public Card[] mixCards(Card[] d1, Card[] d2){
        int mixedLength = d1.length + d2.length;
        ArrayList<Card> mixedDeck = new ArrayList<>(mixedLength);
        Collections.addAll(mixedDeck, d1);
        Collections.addAll(mixedDeck, d2);
        Collections.shuffle(mixedDeck);
        return mixedDeck.toArray(new Card[mixedLength]);
    }

    public void shuffleDeck(){
        ArrayList<Card> cardList =  new ArrayList<>();
        Collections.addAll(cardList, this.hand);
        Collections.shuffle(cardList);
        this.hand = cardList.toArray(new Card[this.handSize]);
    }

    public Card drawCard(){
        this.shuffleDeck();
        this.shuffleDeck();
        Card drawnCard = this.hand[0];
        this.removeCardbyObject(drawnCard);
        return drawnCard;
    }

    public MajCard drawMajor(){
        MajCard[] MajCards;
        ArrayList<Card> mixedMajors = CC.popWithMajs();
        //Collections.addAll(mixedMajors, MajCards);
        Collections.shuffle(mixedMajors);
        MajCards = mixedMajors.toArray(new MajCard[72]);
        MajCard drawnCard = MajCards[0];
        this.removeCardbyObject(drawnCard);
        return drawnCard;
    }

    public MinCard drawMinor(){
        MinCard[] MinCards;
        ArrayList<Card> mixedMinors = CC.popWithMins();
        //Collections.addAll(mixedMinors, MinCards);
        Collections.shuffle(mixedMinors);
        MinCards = mixedMinors.toArray(new MinCard[72]);
        MinCard drawnCard = MinCards[0];
        this.removeCardbyObject(drawnCard);
        return drawnCard;
    }
    
}