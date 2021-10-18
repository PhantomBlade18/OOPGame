
public class Enemy
{
    private String name;
    private int hp;
    private boolean isAlive;
    private int attack;
    
    public Enemy(String n, int h, int a)
    {
        name = n;
        hp = h;
        isAlive = true;
        attack = a;
    }
    public void setHP( int h)
    {
        hp = h;
    }
    
    public int getHP()
    {
        return hp;
    }
    
    public void setAttack( int a)
    {
        attack = a;
    }
    
    public int getAttack()
    {
        return attack;
    }
    
    public String getName()
    {
        return name;
    }
    public boolean getStatus()
    {
        return isAlive;
    }
    public void setStatus(boolean s)
    {
        isAlive = s;
    }
}
