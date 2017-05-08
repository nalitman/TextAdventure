

public class Room
{
   private int x,y,z;
   private String name;
   private String description;
   private boolean north, south, east, west, Neast, Seast, Nwest, Swest, up, down;
   private Item item1,item2,item3,item4;
   private ArrayList<Item> roomItems = new ArrayList<Item>();
   
   //Different constructors for # of items in room initially, max of four
   public Room(int cx, int cy, int cz, String names, String desc, boolean n, boolean s, boolean e, boolean w,
               boolean ne, boolean se, boolean nw, boolean sw, boolean u, boolean d,
               Item I1, Item I2, Item I3, Item I4)
   {
       x = cx; y = cy; z = cz;
       name = names;
       description = desc;
       north = n; south = s; east = e; west = w; Neast = ne; Seast = se; Nwest = nw; Swest = sw;
       up = u; down = d;
       item1 = I1; item2 = I2; item3 = I3; item4 = I4;
       roomItems.add(item1);
       roomItems.add(item2);
       roomItems.add(item3);
       roomItems.add(item4);
       
       if(item1 != null)
        description += "\nA " + item1.getName() + " lies on
   }
    
   public Room(int cx, int cy, int cz, String names, String desc, boolean n, boolean s, boolean e, boolean w,
               boolean ne, boolean se, boolean nw, boolean sw, boolean u, boolean d,
               Item I1, Item I2, Item I3)
   {
       x = cx; y = cy; z = cz;
       name = names;
       description = desc;
       north = n; south = s; east = e; west = w; Neast = ne; Seast = se; Nwest = nw; Swest = sw;
       up = u; down = d;
       item1 = I1; item2 = I2; item3 = I3; item4 = null;
       roomItems.add(item1);
       roomItems.add(item2);
       roomItems.add(item3);
       roomItems.add(item4);
   }
    
   public Room(int cx, int cy, int cz, String names, String desc, boolean n, boolean s, boolean e, boolean w,
               boolean ne, boolean se, boolean nw, boolean sw, boolean u, boolean d,
               Item I1, Item I2)
   {
       x = cx; y = cy; z = cz;
       name = names;
       description = desc;
       north = n; south = s; east = e; west = w; Neast = ne; Seast = se; Nwest = nw; Swest = sw;
       up = u; down = d;
       item1 = I1; item2 = I2; item3 = null; item4 = null;
       roomItems.add(item1);
       roomItems.add(item2);
       roomItems.add(item3);
       roomItems.add(item4);
   }
   
   public Room(int cx, int cy, int cz, String names, String desc, boolean n, boolean s, boolean e, boolean w,
               boolean ne, boolean se, boolean nw, boolean sw, boolean u, boolean d, Item I1)
   {
       x = cx; y = cy; z = cz;
       name = names;
       description = desc;
       north = n; south = s; east = e; west = w; Neast = ne; Seast = se; Nwest = nw; Swest = sw;
       up = u; down = d;
       item1 = I1; item2 = null; item3 = null; item4 = null;
       roomItems.add(item1);
       roomItems.add(item2);
       roomItems.add(item3);
       roomItems.add(item4);
   }
   
   public Room(int cx, int cy, int cz, String names, String desc, boolean n, boolean s, boolean e, boolean w,
               boolean ne, boolean se, boolean nw, boolean sw, boolean u, boolean d,)
   {
       x = cx; y = cy; z = cz;
       name = names;
       description = desc;
       north = n; south = s; east = e; west = w; Neast = ne; Seast = se; Nwest = nw; Swest = sw;
       up = u; down = d;
       item1 = null; item2 = null; item3 = null; item4 = null;
       roomItems.add(item1);
       roomItems.add(item2);
       roomItems.add(item3);
       roomItems.add(item4);
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
    
    //Room Description / room item status
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String newDesc)
    {
        description = newDesc;
    }
    
    public void addItem(Item item)
    {
        roomItems.add(item);
        setDescription(getDescription() + "\nA " + item.getName() + " lies on the ground");
    }
}
