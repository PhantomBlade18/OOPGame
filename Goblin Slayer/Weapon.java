
public class Weapon
{
    private String name;
    private int damage;
    
    public Weapon(String n, int d)
    {
        name = n;
        damage = d + 10;
        
    }
    
    public void setWeaponName( String n)
    {
        name = n;
    }
    public String getWeaponName()
    {
        return name;
    }
    public void setDamage( int d)
    {
        damage = d;
    }
    public int getDamage()
    {
        return damage;
    }
}