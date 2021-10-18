public class Warrior extends Player
{
    public Warrior(String n)
    {
        super(n);
    }
    
    public String getAttackMsg()
    {
        return "As a Warrior, you deliver a slash attack to ";
    }
    
    public String getSpecialAttackMsg()
    {
        return "As a warrior, you roar as you leap towards your enemy and deliver a destructive blow to the ";
    }
    
    public String getHeavyAttackMsg()
    {
        return "You lift your weapon high and deliver a devastating blow to the ";
    }
    
    public int specialAttack(int dmg)
    {
        dmg *= 1.80;
        return dmg;
    }
    
    public int heavyAttack(int dmg)
    {
        dmg *= 1.55;
        return dmg;
    }
    
    public String healMsg()
    {
        return "You go berserk as vigor fills you regenerating 25HP";
    }
    
}