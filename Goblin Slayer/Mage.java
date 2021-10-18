public class Mage extends Player
{
    public Mage(String n)
    {
        super(n);
    }
    public String getAttackMsg()
    {
        return "As a Mage, you cast a fiery ball of light at the ";
    }
    
    public String getSpecialAttackMsg()
    {
        return "As a Mage, you summon a huge rain of meteors down on the ";
    }
    
    public String getHeavyAttackMsg()
    {
        return "As a Mage, you cast a powerful explosion spell at the ";
    }
    
    public int specialAttack(int dmg)
    {
        dmg *= 1.65;
        return dmg;
    }
    
    public int heavyAttack(int dmg)
    {
        dmg *= 1.45;
        return dmg;
    }
    
    public String healMsg()
    {
        return "You cast a blessing and feel your wounds fade away regenerating 25 HP";
    }
    
}