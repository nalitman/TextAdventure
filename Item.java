import java.util.*;
import java.lang.reflect.*;

public class Item
{
    private String name, description, location, attackMessage;
    private int attackValue;
    
    public Item(String n, String d, String l, int a, String am)
    {
        name = n;
        description = d;
        location = l;
        attackValue = a;
        attackMessage = am;
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
    
    public String getCombatMessage()
    {
        return attackMessage
    }
}
