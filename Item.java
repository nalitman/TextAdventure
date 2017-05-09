import java.util.*;
import java.lang.reflect.*;

public class Item
{
    private String name, description, location;
    
    
    public Item(String n, String d, String l)
    {
        name = n;
        description = d;
        location = l;
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
}
