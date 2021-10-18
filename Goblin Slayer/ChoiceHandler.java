import javax.swing.*;
import java.awt.event.*;

public class ChoiceHandler implements ActionListener
{
    Game game; 
    Story story;
    public ChoiceHandler(Game g, Story s)
    {
        game = g;
        story = s;
    }

    public void actionPerformed(ActionEvent event)
    {
        String userChoice = event.getActionCommand();
        
        switch(userChoice)
        {
            case "start": game.sManager.titleToCreation();break;
            case "load": game.sManager.creationToTown();story.loadFromSave();story.firePlace();break;
            case "submit": game.sManager.creationToTown();story.defaultSetup();story.windMill1();break;
            case "b1": story.selectLocation(story.position1);break;
            case "b2": story.selectLocation(story.position2);break;
            case "b3": story.selectLocation(story.position3);break;
            case "b4": story.selectLocation(story.position4);break;
        }
    }
}