public class Rogue extends Player
{
    public Rogue(String n)
    {
        super(n);
    }
    
    public String getAttackMsg()
    {
        return "As a Rogue, you dash a hidden dagger at the";
    }
    
    public String getSpecialAttackMsg()
    {
        return "As a Rogue, you teleport behind and stab the ";
    }
    
    public String getHeavyAttackMsg()
    {
        return "As a Rogue, you deliver a quick blow with your knife to the kidney of the ";
    }
    
    public int specialAttack(int dmg)
    {
        dmg *= 1.85;
        return dmg;
    }
    
    public int heavyAttack(int dmg)
    {
        dmg *= 1.15;
        return dmg;
    }
    
    public String healMsg()
    {
        return "You pop open and drink a crimson red vial HP restored by 25 points";
    }
}