import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserInterface
{
    JFrame window; 
    Container con;
    JPanel titleNamePanel,startPanel,mainTextPanel,buttonPanel, characterCreationPanel;
    JLabel titleNameLabel,hpLabel, hpLabelNumber, weaponLabel,weaponLabelName,enterNameLabel,chooseClassLabel;
    JButton startButton,loadButton, button1,button2,button3,button4,confirmCreation;
    JRadioButton radio1,radio2,radio3;
    ButtonGroup radioGroup;
    
    JPanel playerPanel;
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 70);
    Font generalFont = new Font("Times New Roman",Font.PLAIN,20);
    JTextArea mainTextArea,enterName;
    
    public void createUI(ChoiceHandler cHandler)
    {
        // Creates a window to hold components
        window = new JFrame("Goblin Slayer");
        window.setSize(1000,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setResizable(true);
        window.setLayout(null);
        
        //creates a title panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        
        titleNameLabel = new JLabel("GOBLIN SLAYER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        window.add(titleNamePanel);
        
        //creates a button panel with a start button
        startPanel = new JPanel();
        startPanel.setBounds(200,400,400,200);
        startPanel.setBackground(Color.black);
        startPanel.setLayout(new GridLayout(4,1));
        window.add(startPanel);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(generalFont);
        startButton.setFocusPainted(false);
        startButton.setActionCommand("start");
        startButton.addActionListener(cHandler);
        startPanel.add(startButton);
        
        loadButton = new JButton("LOAD GAME");
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.setFont(generalFont);
        loadButton.setFocusPainted(false);
        loadButton.setActionCommand("load");
        loadButton.addActionListener(cHandler);
        startPanel.add(loadButton);
        
        //the following creates a panel and components to initialise a character
        
        characterCreationPanel = new JPanel();
        characterCreationPanel.setBounds(100,100,600,250);
        characterCreationPanel.setBackground(Color.black);
        characterCreationPanel.setLayout(new GridLayout(7,1));
        
        enterNameLabel = new JLabel("Enter Name:");
        enterNameLabel.setForeground(Color.white);
        enterNameLabel.setFont(titleFont);
        enterNameLabel.setFont(generalFont);
        characterCreationPanel.add(enterNameLabel);
        
        enterName = new JTextArea();
        enterName.setBounds(100,100,60,40);
        enterName.setBackground(Color.black);
        enterName.setForeground(Color.white);
        enterName.setFont(generalFont);
        enterName.setWrapStyleWord(false);
        enterName.setEditable(true);
        characterCreationPanel.add(enterName);
        
        chooseClassLabel = new JLabel("Select Your Class:");
        chooseClassLabel.setForeground(Color.white);
        chooseClassLabel.setFont(titleFont);
        chooseClassLabel.setFont(generalFont);
        characterCreationPanel.add(chooseClassLabel);
        
        radio1 = new JRadioButton("Warrior");
        radio1.setBackground(Color.black);
        radio1.setForeground(Color.white);
        radio1.addActionListener(cHandler);
        characterCreationPanel.add(radio1);
        
        radio2 = new JRadioButton("Mage");
        radio2.setBackground(Color.black);
        radio2.setForeground(Color.white);
        radio2.addActionListener(cHandler);
        characterCreationPanel.add(radio2);
        
        radio3 = new JRadioButton("Rogue");
        radio3.setBackground(Color.black);
        radio3.setForeground(Color.white);
        radio3.addActionListener(cHandler);
        characterCreationPanel.add(radio3);
        
        confirmCreation = new JButton("SUBMIT");
        confirmCreation.setBackground(Color.black);
        confirmCreation.setForeground(Color.white);
        confirmCreation.setFont(generalFont);
        confirmCreation.setFocusPainted(false);
        confirmCreation.addActionListener(cHandler);
        confirmCreation.setActionCommand("submit");
        characterCreationPanel.add(confirmCreation);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radioGroup.add(radio3);
        
        window.add(characterCreationPanel);
        
        
        //creates a panel which will display text and story
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);
        
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(generalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        
        //creates a panel where buttons will be held for interaction
        buttonPanel = new JPanel();
        buttonPanel.setBounds(250,350,300,250);
        buttonPanel.setBackground(Color.black);
        buttonPanel.setLayout(new GridLayout(4,1));
        window.add(buttonPanel);
        
        button1 = new JButton();
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button1.setFont(generalFont);
        button1.setFocusPainted(false);
        button1.addActionListener(cHandler);
        button1.setActionCommand("b1");
        buttonPanel.add(button1);
        
        button2 = new JButton();
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.setFont(generalFont);
        button2.setFocusPainted(false);
        button2.addActionListener(cHandler);
        button2.setActionCommand("b2");
        buttonPanel.add(button2);
        
        button3 = new JButton();
        button3.setBackground(Color.black);
        button3.setForeground(Color.white);
        button3.setFont(generalFont);
        button3.setFocusPainted(false);
        button3.addActionListener(cHandler);
        button3.setActionCommand("b3");
        buttonPanel.add(button3);
        
        button4 = new JButton();
        button4.setBackground(Color.black);
        button4.setForeground(Color.white);
        button4.setFont(generalFont);
        button4.setFocusPainted(false);
        button4.addActionListener(cHandler);
        button4.setActionCommand("b4");
        buttonPanel.add(button4);
        
        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setLayout(new GridLayout(1,4));
        playerPanel.setBackground(Color.black);
        window.add(playerPanel);
        
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(generalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(generalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(generalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(generalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);
        

        window.setVisible(true);
    }
    
}