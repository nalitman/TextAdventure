import java.util.*;
import java.lang.reflect.*;

public class Room
{
   private int x,y,z;
   private String name;
   private RoomDesc description;
   private boolean north, south, east, west, Neast, Seast, Nwest, Swest, up, down;
   private ArrayList<Item> roomItems = new ArrayList<Item>();
   private Enemy enemy;
   
   //Different constructors for # of items in room initially, max of four
   public Room(int cx, int cy, int cz, String names, RoomDesc desc, boolean n, boolean s, boolean e, boolean w,
               boolean ne, boolean se, boolean nw, boolean sw, boolean u, boolean d, ArrayList<Item> stuff, Enemy e)
   {
       x = cx; y = cy; z = cz;
       name = names;
       description = desc;
       north = n; south = s; east = e; west = w; Neast = ne; Seast = se; Nwest = nw; Swest = sw;
       up = u; down = d;
       roomItems = stuff;
       enemy = e;
    }
   
   //Possible movement methods
   
   public boolean canMoveNorth()
   {
       return north;
   }
   
   public boolean canMoveSouth()
   {
       return south;
   }
   
   public boolean canMoveEast()
   {
       return east;   
   }
   
   public boolean canMoveWest()
   {
       return west;
   }
   
   public boolean canMoveNorthEast()
   {
       return Neast;
   }
   
   public boolean canMoveNorthWest()
   {
       return Nwest;
    }
    
    public boolean canMoveSouthEast()
    {
        return Seast;
    }
    
    public boolean canMoveSouthWest()
    {
        return Swest;
    }
    
    public boolean canMoveUp()
    {
        return up;
    }
    
    public boolean canMoveDown()
    {
        return down;
    }
    
    //Get Room Coordinates
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getZ()
    {
        return z;
    }
    
    //Room Description / room item status
    public String getDescription()
    {
        return description.getDescription();
    }
    
    public void setDescription(String newDesc)
    {
        description.setBody(newDesc);
    }
    
    public void addItem(Item item)
    {
        roomItems.add(item);
        description.addItem(item);
    }
    
    public void removeItem(Item item)
    {
        int index;
        for(int k = 0; k < roomItems.size(); k++)
        {
            if(item.getName().equals(roomItems.get(k).getName()))
            {
                roomItems.remove(k);
            }
        }
    }
    
    public ArrayList<Item> getItems()
    {
        return roomItems;
    }
}
