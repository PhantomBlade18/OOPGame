
public class OnScreenManager
{
    UserInterface ui;
    public OnScreenManager(UserInterface userInt)
    {
        ui = userInt;
    }
    
    public void showTitleScreen() //displayes titlescreen and hides game screen components
    {
        //from game to Title Screen
        ui.titleNamePanel.setVisible(true);
        ui.startPanel.setVisible(true);
        
        ui.playerPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.buttonPanel.setVisible(false);
        ui.characterCreationPanel.setVisible(false);
    }
    public void titleToCreation() //displayes titlescreen and hides game screen components
    {
        //from Title Screen to Creation
        ui.characterCreationPanel.setVisible(true);
        
        ui.playerPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.buttonPanel.setVisible(false);
        ui.titleNamePanel.setVisible(false);
        ui.startPanel.setVisible(false);
    }
    
    public void creationToTown() //hides titlescreen components and shows game UI
    {
        // From Creation to Title Screen
        ui.playerPanel.setVisible(true);
        ui.mainTextPanel.setVisible(true);
        ui.buttonPanel.setVisible(true);
        
        ui.titleNamePanel.setVisible(false);
        ui.startPanel.setVisible(false);
        ui.characterCreationPanel.setVisible(false);
    }
}