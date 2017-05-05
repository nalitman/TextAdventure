import java.util.*;
public class Player
{
    private String name; private int x,y,z; private boolean isAlive;
    private boolean isEquipped; private int health; private int maxHealth;
    private Item equippedItem;
    private ArrayList<Item> inventory = new ArrayList<Item>; private int inventoryMax;
    
    public Player(String user)
    {
        name = username;    x = 0; y = 0; z = 0;
        isAlive = true;     isEquipped = false;
        equippedItem = null;
        health = 100; maxHealth = 100;
        inventoryMax = 15;
        
        for(int k = 0; k < 15; k++)
        {
            inventory.add(null);
        }
        
        //Add some if statements for easter egg user names
    }
    
    //Position Methods
    
    public void moveNorth()
    {
        y += 1;
    }
    
    public void moveSouth()
    {
        y -= 1;
    }
    
    public void moveEast()
    {
        x += 1;
    }
    
    public void moveWest()
    {
        x -= 1;
    }
    
    public void moveNorthEast()
    {
        x += 1; y += 1;
    }
    
    public void moveNorthWest()
    {
        x -= 1; y += ;
    }
    
    public void moveSouthEast()
    {
        x += 1; y -= 1;
    }
    
    public void moveSouthWest()
    {
        x -= 1; y -= 1;
    }
    
    public void moveUp()
    {
        z += 1;
    }
    
    public void moveDown()
    {
        z -= 1;
    }
    
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
    
    public String getPosition()
    {
        return "X: " + x + "\tY: " + y + "\tZ: " + z;
    }
    
    public void setX(int c)
    {
        x = c;
    }
    
    public void setY(int c)
    {
        y = c;
    }
    
    public void setZ(int z)
    {
        z = c;
    }
    
    //FINISH THIS
    public Room currentRoom(Room[][] map)
    {
        for( int x = 0; x < map.length; x++)
        {
            for( int y = 0; y < map[x].length; y++)
            {
                for( int z = 0; z < map[x][y].length; z++)
                {
                    
    
    //Player Status methods
    
    public String getName()
    {
        return name;
    }
    
    public boolean checkLife()
    {
        if( health > 0 )
            return true;    
        else
            return false;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int changeHealth(int change)
    {
        if( (health + change) > maxHealth)
        {
            change = maxHealth - health;
            health += change;
        }
        else
            health += change;
            
        return health;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    //Inventory Management
    
    public String getInventory()
    {
        String gubs = "Inventory - ";
        int emptySpaces = inventory.size();
        
        for (int k = 0; k < inventory.size(); k++)
        {
            if( inventory.get(k) != null )
            {
                emptySpaces --;
                gubs += "\n" + inventory.get(k);
            }
        }
        
        gubs += "\n" + emptySpaces + "/" + inventory.size();
        return gubs;
    }
    
    public String addItem(Item item)
    {
        boolean isFull = true;
        int index;
        String status;
        
        for(int k = 0; k < inventory.size(); k++)
        {
            if(inventory.get(k) == null)
            {   isFull = false;
                index = k;
                break;
            }
            }
            
        //If inventory is not full, add the item    
        if( isFull == false )
        {   inventory.add(k, item);
            status = item.getName() + "taken";
        }
            
        else
            status = "Bag is full...";
            
        return status;
    }
    
    public String removeItem(String Iname)
    {
        String status = null;
        boolean found = false;
        
        for(int k = 0; k < inventory.size(); k++)
        {
            if( Iname.toUpperCase.equals(inventory.get(k).getName()))
            {
                status = inventory.get(k).getName() + " removed";
                found = true;
            }
            }
            
        if(found)
            return status;
            
        else
        {
            status = Iname + " not in your inventory...";
            return status;
        }
    }
    
    public Item dropItem(String Iname, Room room)
    {
        
}
