
public class Player
{
    String name;
    private int hp;
    private Weapon equippedWeapon;
    
    public Player(String n)
    {
        name = n;
        hp = 100;
        equippedWeapon = new Weapon_Knife();
    }
    public Player()
    {
        name = "";
        hp = 100;
        equippedWeapon = new Weapon_Knife();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setHP( int h)
    {
        hp = h;
    }
    
    public int getHP()
    {
        return hp;
    }
    
    public Weapon getEquipped()
    {
        return equippedWeapon;
    }
    
    public void setEquipped(Weapon w)
    {
        equippedWeapon = w;
    }
    
    public String getAttackMsg()
    {
        return "You strike the ";
    }
    public String getSpecialAttackMsg()
    {
        return "You deliver an almighty blow to the ";
    }
    
    public String getHeavyAttackMsg()
    {
        return "you deliver a heavy blow the ";
    }
    public void heal()
    {
        hp += 25;
    }
    
    public String healMsg()
    {
        return "You eat a bunch of baked potatoes and regenerate 25 HP";
    }
    public int specialAttack(int dmg)
    {
        dmg += 15;
        return dmg;
    }
    
    public int heavyAttack(int dmg)
    {
        dmg += 7;
        return dmg;
    }
}