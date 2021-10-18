import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Story
{
    Game game;
    UserInterface ui;
    OnScreenManager sManager;
    Player hero;
    Enemy[] opponent = {new Goblin(),new Goblin(),new Dragon()};
    int id;
    String currentPosition,previousPosition;
    String position1,position2,position3,position4;
    ArrayList<String> questLog=new ArrayList<String>();
    boolean quest1;
    boolean quest2;
    
    public Story( Game g, UserInterface u, OnScreenManager s)
    {
        game = g;
        ui = u;
        sManager = s;
        
    }
    
    public void defaultSetup()
    {
        try
        {
            if (ui.radio1.isSelected())
            {
                hero = new Warrior(ui.enterName.getText());
            }
            else if (ui.radio2.isSelected())
            {
                hero = new Mage(ui.enterName.getText());
            }
            else if (ui.radio3.isSelected())
            {
                hero = new Rogue(ui.enterName.getText());
            }
            
            ui.hpLabel.setText(hero.getName()+" HP: ");
            ui.hpLabelNumber.setText(""+ hero.getHP());
            
            ui.weaponLabelName.setText(hero.getEquipped().getWeaponName());
            
            quest1 = false;
            quest2= false;
        }
        catch(Exception e)
        {
            hero = new Warrior("Hero");
            ui.hpLabel.setText(hero.getName()+" HP: ");
            ui.hpLabelNumber.setText(""+ hero.getHP());
            hero.setEquipped(new Weapon_Knife());
            ui.weaponLabelName.setText(hero.getEquipped().getWeaponName());
        }
        
    
    }
    public void loadFromSave()
    {
        String fileData;
        char hClass = 'x';
        String hName = "";
        int hHealth = 100;
        String hWeapon = "";
        
        try
        {
            FileReader fileReader = new FileReader("GameSave.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((fileData = bufferedReader.readLine()) != null)
            {
                String[] charInfo = fileData.split("-");
                hClass = charInfo[0].charAt(0);
                hName = charInfo[1];
                hHealth = Integer.parseInt(charInfo[2]);
                hWeapon = charInfo[3];
                
                
            }
            
        }
        catch(Exception e)
        {
            System.out.println("ERROR. COULD NOT LOAD GAME FILE");
        }
        
        if (hClass == 'w')
        {
            hero = new Warrior(hName);
        }
        else if (hClass == 'm')
        {
            hero = new Mage(hName);
        }
        else if (hClass == 'r')
        {
            hero = new Rogue(hName);
        }
        hero.setHP(hHealth);
        if (hWeapon.equals("Zweihander"))
        {
            hero.setEquipped(new Weapon_Zweihander());
        }
        else if(hWeapon.equals("Knife"))
        {
            hero.setEquipped(new Weapon_Knife());
        }
        ui.hpLabel.setText(hero.getName()+" HP: ");
        ui.hpLabelNumber.setText(""+ hero.getHP());
        
        ui.weaponLabelName.setText(hero.getEquipped().getWeaponName());
    }
    
    public void selectLocation(String next)
    {
        switch(next)
        {
            case "townGate": townGate(); break;
            case "talkGuard": talkGuard();break;
            case "attackGuard": attackGuard();break;
            case "crossRoad": crossRoads(); break;
            case "windMill2": windMill2(); break;
            case "town": town(); break;
            case "toTavern": tavern(); break;
            case "addQuest1": addQuest1();break;
            case "addQuest2": addQuest2();break;
            case "completeQuest1": quest1Complete(); break;
            case "completeQuest2": quest2Complete(); break;
            case "viewActive": viewActive();break;
            case "bossRoom": bossRoom(); break;
            case "caveEntrance": caveEntrance(); break;
            case "cave1": cave1(); break;
            case "path1": path1(); break;
            case "west": west(); break;
            case "fight": fight(); break;
            case "heavyAttack": heavyAttack(); break;
            case "specialAttack": specialAttack(); break;
            case "enemyAttack": enemyAttack(); break;
            case "playerAttack": playerAttack(); break;
            case "checkQuests": checkQuests(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "toTitle": toTitle(); break;
            case "goBar": goBar();break;
            case "firePlace": firePlace();break;
            case "saveGame": saveGame();break;
        }
    }
    

    public void windMill1()
    {
        
        ui.mainTextArea.setText("You wake up under an old windmill. The sun shines warmly above you. You can see a path heading through the fields around you \n what do you do?");
        ui.button1.setText("Walk down the path");
        ui.button2.setText("nothing");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "crossRoad";
        position2 = "";
        position3 = "";
        position4 = "";
    }
    
    public void windMill2()
    {
        
        ui.mainTextArea.setText("You approach the windmill. The sun shines warmly above you as you look upon the golden wheat fields. \n what do you do?");
        ui.button1.setText("Walk down the path");
        ui.button2.setText("nothing");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "crossRoad";
        position2 = "";
        position3 = "";
        position4 = "";
    }
    
    public void crossRoads()
    {
        
        ui.mainTextArea.setText("After a short walk,you appear at a Crossroads. \n\nWhat do you do?");
        ui.button1.setText("Head North");
        ui.button2.setText("Head East");
        ui.button3.setText("Head South");
        ui.button4.setText("Head West");
        
        position1 = "path1";
        position2 = "townGate";
        position3 = "windMill2";
        position4 = "west";
    }
    public void west() //remember that you switched what happens in north and east
    {
        ui.mainTextArea.setText("You enter a Forest and find a  Zweihander");
        hero.setEquipped(new Weapon_Zweihander());
        ui.weaponLabelName.setText(hero.getEquipped().getWeaponName());
        
        ui.button1.setText("Return to path");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "crossRoad";
        position2 = "";
        position3 = "";
        position4 = "";
    }
    // The following sets a path for going to town
    public void townGate()
    {
        
        ui.mainTextArea.setText("You arrive at the gate of a town. The sign in front says 'Dalaran'. \n\nWhat do you do?");
        ui.button1.setText("Enter Town");
        ui.button2.setText("Turn back");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "town";
        position2 = "crossRoad";
        position3 = "";
        position4 = "";
    }
    public void town()
    {
        
        ui.mainTextArea.setText("You enter the town which is bustling with life. A guard stands in front of you.There is a tavern to your left and a notice board to your right \n\nWhat do you do?");
        ui.button1.setText("Approach Guard");
        ui.button2.setText("Approach Tavern");
        ui.button3.setText("Approach notice Board");
        ui.button4.setText("Leave");
        
        position1 = "talkGuard";
        position2 = "toTavern";
        position3 = "checkQuests";
        position4 = "townGate";
    }
    public void talkGuard()
    {
        if (opponent[2].getStatus() == true)
        {
            ui.mainTextArea.setText("Guard: Welcome to Dalaran Adventurer. Enjoy your stay but be careful as monsters have been sighted near town. \n\n What do you do?");
            ui.button1.setText("Attack the Guard");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
        
            position1 = "attackGuard";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
        else if (opponent[2].getStatus() == false)
        {
           ending(); 
        }
    
    }
    public void attackGuard()
    {
        ui.mainTextArea.setText("Guard: It is brave and foolish of you to attack me");
        hero.setHP((hero.getHP()-2));
        ui.hpLabelNumber.setText(""+hero.getHP());
        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "town";
        position2 = "";
        position3 = "";
        position4 = "";
    }
    public void checkQuests()
    {
        
        if ((opponent[0].getStatus() == true) && (opponent[2].getStatus() == true))
        {
            ui.mainTextArea.setText("You go up to the Noticeboard and notice the Bounties available. \n Quest 1: ELIMINATE GOBLIN \n Quest 2: ELIMINATE DRAGON ");
            ui.button1.setText("Accept Quest 1");
            ui.button2.setText("Accept Quest 2");
            ui.button3.setText("Leave");
            ui.button4.setText("View Active Quests");
        
            position1 = "addQuest1";
            position2 = "addQuest2";
            position3 = "town";
            position4 = "viewActive";
        }
        else if ((opponent[0].getStatus() == true) && (opponent[2].getStatus() == false))
        {
            ui.mainTextArea.setText("You go up to the Noticeboard and notice the Bounties available. \n Quest 1: ELIMINATE GOBLIN \n Quest 2: ELIMINATE DRAGON ");
            ui.button1.setText("Accept Quest 1");
            ui.button2.setText("Complete Quest 2");
            ui.button3.setText("Leave");
            ui.button4.setText("View Active Quests");
        
            position1 = "addQuest1";
            position2 = "completeQuest2";
            position3 = "town";
            position4 = "viewActive";
        }
        else if ((opponent[0].getStatus() == false) && (opponent[2].getStatus() == true))
        {
            ui.mainTextArea.setText("You go up to the Noticeboard and notice the Bounties available. \n Quest 1: ELIMINATE GOBLIN \n Quest 2: ELIMINATE DRAGON ");
            ui.button1.setText("Complete Quest 1");
            ui.button2.setText("Accept Quest 2");
            ui.button3.setText("Leave");
            ui.button4.setText("View Active Quests");
        
            position1 = "completeQuest1";
            position2 = "addQuest2";
            position3 = "town";
            position4 = "viewActive";
        }
        else if ((opponent[0].getStatus() == false) && (opponent[2].getStatus() == false))
        {
            ui.mainTextArea.setText("You go up to the Noticeboard and notice the Bounties available. \n Quest 1: ELIMINATE GOBLIN \n Quest 2: ELIMINATE DRAGON ");
            ui.button1.setText("Complete Quest 1");
            ui.button2.setText("Complete Quest 2");
            ui.button3.setText("Leave");
            ui.button4.setText("View Active Quests");
        
            position1 = "completeQuest1";
            position2 = "completeQuest2";
            position3 = "town";
            position4 = "viewActive";
        }
    }
    public void viewActive()
    {
        String q = "Active Quests: \n";
        for(int i = 0;i < questLog.size(); i++)
        {
            q = q + questLog.get(i) + "\n";
        }
        ui.mainTextArea.setText(q+ "");
        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
    
        position1 = "checkQuests";
        position2 = "";
        position3 = "";
        position4 = "";
    }
    public void addQuest1()
    {
        if(!(questLog.contains("Quest 1: SLAY GOBLIN")))
        {
            questLog.add("Quest 1: SLAY GOBLIN");
            ui.mainTextArea.setText("You have accepted the SLAY GOBLIN Quest.");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
        else
        {
            ui.mainTextArea.setText("You have already accepted the SLAY GOBLIN Quest.");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
    }
    public void addQuest2()
    {
        if(!(questLog.contains("Quest 2: SLAY DRAGON")))
        {
            questLog.add("Quest 2: SLAY DRAGON");
            ui.mainTextArea.setText("You have accepted the SLAY DRAGON Quest.");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
        else
        {
            ui.mainTextArea.setText("You have already accepted the SLAY DRAGON Quest.");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
    }
    public void quest1Complete()
    {
        if (quest1 == false)
        {
            quest1 = true;
            questLog.remove("Quest 1: SLAY GOBLIN");
            ui.mainTextArea.setText("You have Completed the SLAY GOBLIN Quest. CONGRATULATIONS!");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
        else if( quest1 == true)
        {
            ui.mainTextArea.setText("You have Already Completed this quest");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
    }
    public void quest2Complete()
    {
        if (quest2 == false)
        {
            quest2 = true;
            questLog.remove("Quest 2: SLAY DRAGON");
            ui.mainTextArea.setText("You have Completed the SLAY DRAGON Quest. CONGRATULATIONS!");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
        else if( quest2 == true)
        {
            ui.mainTextArea.setText("You have Already Completed this quest");
            ui.button1.setText(">");
            ui.button2.setText("Leave");
            ui.button3.setText("");
            ui.button4.setText("");
            
            position1 = "checkQuests";
            position2 = "town";
            position3 = "";
            position4 = "";
        }
    }
    
    public void tavern()
    {
        
        ui.mainTextArea.setText("You enter the quiet tavern. You notice a nice little bar on one side of the room and a cozy looking seat by the fireplace on the other side \n What do you do?");
        ui.button1.setText("Walk to the bar");
        ui.button2.setText("Sit by the fireplace");
        ui.button3.setText("");
        ui.button4.setText("Leave");
        
        position1 = "goBar";
        position2 = "firePlace";
        position3 = "";
        position4 = "town";
    }
    public void firePlace()
    {
        
        ui.mainTextArea.setText("You sit in a seat by the fireplace,you relax as you revel in the heat of the flames \n What do you do?");
        ui.button1.setText("<SAVE GAME>");
        ui.button2.setText("Walk to the bar");
        ui.button3.setText("");
        ui.button4.setText("Leave");
        
        position1 = "saveGame";
        position2 = "goBar";
        position3 = "";
        position4 = "town";
    }
    public void goBar()
    {
        ui.mainTextArea.setText("You sit at the bar and order yourself a hearty meal. You restore 25 HP");
        hero.setHP(hero.getHP()+ 25);
        ui.hpLabelNumber.setText(""+ hero.getHP());
        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "toTavern";
        position2 = "";
        position3 = "";
        position4 = "";
    
    }
    public void path1()
    {
        id = 0;
        currentPosition = "path1";
        previousPosition= "crossRoad";
        if (opponent[id].getStatus() == true)
        {
            ui.mainTextArea.setText("You encounter a goblin \n\n What do you do?");
            ui.button1.setText("Fight!");
            ui.button2.setText("Run Away");
            ui.button3.setText("");
            ui.button4.setText("");
        
            position1 = "fight";
            position2 = previousPosition;
            position3 = "";
            position4 = "";
        }
        else if (opponent[id].getStatus() == false)
        {
            ui.mainTextArea.setText("You approach the carcass of a dead goblin on the road to the mountain. a sign of your skill");
            ui.button1.setText("Head towards the Crossroad");
            ui.button2.setText("Follow the path to the mountain");
            ui.button3.setText("");
            ui.button4.setText("");
        
            position1 = "crossRoad";
            position2 = "caveEntrance";
            position3 = "";
            position4 = "";
        }
    
    }
    
    public void fight()
    {
        ui.mainTextArea.setText( opponent[id].getName() +": "+ opponent[id].getHP() +"\n What do you do?");
        
        ui.button1.setText("Attack");
        ui.button2.setText("Heavy Attack");
        ui.button3.setText("Special Attack");
        ui.button4.setText("Run Away!");
        
        position1 = "playerAttack";
        position2 = "heavyAttack";
        position3 = "specialAttack";
        position4 = previousPosition;
    }
    
    public void playerAttack()
    {
        int playerDamage = new java.util.Random().nextInt(hero.getEquipped().getDamage());
        ui.mainTextArea.setText(hero.getAttackMsg()+ opponent[id].getName()+ " and deal "+ playerDamage +" damage.");
        opponent[id].setHP(opponent[id].getHP()-playerDamage);
        
        ui.button1.setText(">");
        ui.button2.setText("Run Away!");
        ui.button3.setText("");
        ui.button4.setText("");
        
        if (opponent[id].getHP() > 0)
        {
            position1 = "enemyAttack";
            position2 = previousPosition;
            position3 = "";
            position4 = "";
        }
        else if(opponent[id].getHP() < 1)
        {
            position1 = "win";
            position2 = "crossRoad";
            position3 = "";
            position4 = "";
        }
    
    }
    public void heavyAttack()
    {
        int playerDamage = hero.heavyAttack(new java.util.Random().nextInt(hero.getEquipped().getDamage()));
        ui.mainTextArea.setText(hero.getHeavyAttackMsg()+ opponent[id].getName()+ " and deal "+ playerDamage +" damage.");
        opponent[id].setHP(opponent[id].getHP()-playerDamage);
        
        ui.button1.setText(">");
        ui.button2.setText("Run Away!");
        ui.button3.setText("");
        ui.button4.setText("");
        
        if (opponent[id].getHP() > 0)
        {
            position1 = "enemyAttack";
            position2 = previousPosition;
            position3 = "";
            position4 = "";
        }
        else if(opponent[id].getHP() < 1)
        {
            position1 = "win";
            position2 = "crossRoad";
            position3 = "";
            position4 = "";
        }
    
    }
    public void specialAttack()
    {
        int playerDamage = hero.specialAttack(new java.util.Random().nextInt(hero.getEquipped().getDamage()));
        ui.mainTextArea.setText(hero.getSpecialAttackMsg()+ opponent[id].getName()+ " and deal "+ playerDamage +" damage.");
        opponent[id].setHP(opponent[id].getHP()-playerDamage);
        
        ui.button1.setText(">");
        ui.button2.setText("Run Away!");
        ui.button3.setText("");
        ui.button4.setText("");
        
        if (opponent[id].getHP() > 0)
        {
            position1 = "enemyAttack";
            position2 = previousPosition;
            position3 = "";
            position4 = "";
        }
        else if(opponent[id].getHP() < 1)
        {
            position1 = "win";
            position2 = "crossRoad";
            position3 = "";
            position4 = "";
        }
    
    }
    public void enemyAttack()
    {
        int enemyDamage = new java.util.Random().nextInt(opponent[id].getAttack());
        ui.mainTextArea.setText("The "+ opponent[id].getName()+" attacked you. They dealt "+enemyDamage + " damage");
        hero.setHP((hero.getHP() - enemyDamage));
        ui.hpLabelNumber.setText(""+ hero.getHP());
        
        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
        
        if (hero.getHP() > 0)
        {
            position1 = "fight";
            position2 = "";
            position3 = "";
            position4 = "";
        }
        else if(hero.getHP() < 1)
        {
            position1 = "lose";
            position2 = "";
            position3 = "";
            position4 = "";
        }
    }
    public void win()
    {
        ui.mainTextArea.setText("You have defeated the "+opponent[id].getName()+"\n\n What do you do?");
        
        ui.button1.setText("Stay on route");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
        opponent[id].setStatus(false);
        position1 = currentPosition;
        position2 = "";
        position3 = "";
        position4 = "";
    }
    
    public void lose()
    {
        ui.mainTextArea.setText("You are Dead \n\n <GAME OVER> ");
        
        ui.button1.setText("return to Title Screen");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
         
        position1 = "toTitle";
        position2 = "";
        position3 = "";
        position4 = "";
    
    }
    
    public void caveEntrance()
    {
        ui.mainTextArea.setText("You arrive at the entrance to the cave. What do you do?");
        
        ui.button1.setText("Enter");
        ui.button2.setText("Turn back");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "cave1";
        position2 = "path1";
        position3 = "";
        position4 = "";
    }
    public void cave1()
    {
        id = 2;
        currentPosition = "path1";
        previousPosition= "crossRoad";
        ui.mainTextArea.setText("You enter the cave.A terrifying roar can be heard from inside, what do you do?");
        
        ui.button1.setText("Go in further");
        ui.button2.setText("Exit Cave");
        ui.button3.setText("");
        ui.button4.setText("");
        
        position1 = "bossRoom";
        position2 = "caveEntrance";
        position3 = "";
        position4 = "";
    }
    public void bossRoom()
    {
        if (opponent[id].getStatus() == true)
        {
            id = 2;
            previousPosition= "cave1";
            
            ui.mainTextArea.setText("You enter a huge room in the cave. A dragon wakes up and unleashes a mighty roar \n\n");
            ui.button1.setText("Fight!");
            ui.button2.setText("Run Away");
            ui.button3.setText("");
            ui.button4.setText("");
        
            position1 = "fight";
            position2 = previousPosition;
            position3 = "";
            position4 = "";
        }
        else if (opponent[id].getStatus() == false)
        {
            ui.mainTextArea.setText("You approach the carcass of the dragon in the large room. A true achievement");
            ui.button1.setText("Head towards the exit");
            ui.button2.setText("");
            ui.button3.setText("");
            ui.button4.setText("");
        
            position1 = "cave1";
            position2 = "";
            position3 = "";
            position4 = "";
        }
    }
    
    public void ending(){
        ui.mainTextArea.setText("oh so you killed the "+ opponent[2].getName()+ " Welcome to our Town \n\n <THE END>");
        ui.button1.setVisible(false);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }
    public void saveGame()
    {
        char spec = 'w';
        if( hero instanceof Warrior)
        {
            spec = 'w';
        }
        else if (hero instanceof Mage)
        {
            spec = 'm';
        }
        else if (hero instanceof Rogue)
        {
            spec = 'r';
        }
        try
        {
            FileWriter fileWriter = new FileWriter("GameSave.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.println(spec+"-"+hero.getName()+"-"+hero.getHP()+"-"+hero.getEquipped().getWeaponName());
            printWriter.close();
            fileWriter.close();
        }
        catch(Exception e)
        {
            ui.mainTextArea.setText("ERROR! Could not save game at this moment What would you like to do?");
            ui.button1.setText("Try Again");
            ui.button2.setText("Walk to the bar");
            ui.button3.setText("");
            ui.button4.setText("Leave");
            
            position1 = "saveGame";
            position2 = "goBar";
            position3 = "";
            position4 = "town";
        }
        ui.mainTextArea.setText("Save Successful, \n What do you do?");
        ui.button1.setText("<SAVE GAME>");
        ui.button2.setText("Walk to the bar");
        ui.button3.setText("");
        ui.button4.setText("Leave");
        
        position1 = "saveGame";
        position2 = "goBar";
        position3 = "";
        position4 = "town";
        
    }
    public void toTitle()
    {
        defaultSetup();
        sManager.showTitleScreen();
    }
}