import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game
{
    UserInterface ui = new UserInterface();
    OnScreenManager sManager = new OnScreenManager(ui);
    Story plot = new Story(this,ui,sManager);
    ChoiceHandler cHandler = new ChoiceHandler(this, plot);
    
    public static void main(String[] args)
    {
        new Game();
    }
    public Game()
    {
        ui.createUI(cHandler);
        sManager.showTitleScreen();
    }
}