package ressources.GUI;
import ressources.Game_Classes.*;
import javax.swing.*;
import java.awt.*;
public class CardTester extends swingControler{
    private Card card;
    private Card_Controller CC;

    public CardTester(GUI gui, Card card){
        super(720, 500, "Tester", gui);
        CC = new Card_Controller();
        this.card = card == null ? new DefaultCard(): card;
        preparePanel();
    }


    public void preparePanel(){
        this.panel = new JPanel(new GridLayout(1,2));

        JPanel cardSetterPanel = new JPanel();
        JTextField idField = new JTextField("Card ID");
        cardSetterPanel.add(idField);
        JCheckBox isMajor = new JCheckBox("MajorArcana");
        cardSetterPanel.add(isMajor);
        JButton setCard = new JButton("Set Card");
        setCard.addActionListener(e->{
            if(!idField.getText().isEmpty()){
                System.out.println("Preparing the card");
                card = CC.makeCard(CC.getArcana(isMajor.isSelected()), Integer.parseInt(idField.getText()));
                System.out.println(card == null ? "empty":card.getName());
                this.gui.goToTester(card);
            }
        });
        cardSetterPanel.add(setCard);
        panel.add(cardSetterPanel);
        JPanel cardPanel = new JPanel();
        cardPanel.add(card.getCardPanel());
        panel.add(cardPanel);
        this.addPanel();
    }
}
