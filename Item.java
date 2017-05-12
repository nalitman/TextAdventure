import java.util.*;
import java.lang.reflect.*;

public class Item
{
    private String name, description, location, attackMessage;
    private int attackValue,healthValue;
    
    public Item(String n, String d, String l, int a, String am, int healing)
    {
        name = n;
        description = d;
        location = l;
        attackValue = a;
        attackMessage = am;
        healthValue = healing;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public int getAttack()
    {
        return attackValue;
    }
    
    public String getHealth()
    
    public String getCombatMessage()
    {
        return attackMessage;
    }
}
