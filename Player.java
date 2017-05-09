import java.util.*;
import java.lang.reflect.*;

public class Player
{
    private String name;
    private int x,y,z; 
    private boolean isAlive;
    private boolean isEquipped;
    private int health; 
    private int maxHealth;
    private Item equippedItem;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Room[][][] map;
    private int inventoryMax;
    private Room currentRoom;
    private int armor, attack;
    //private Weapon eqWep;
    
    public Player(String user, Room map[][][])
    {
        name = user;    x = 0; y = 0; z = 0;
        isAlive = true;     isEquipped = false;
        equippedItem = null;
        health = 100; maxHealth = 100;
        inventoryMax = 15;
        map = map;
        currentRoom = map[0][0][0];
        armor = 0; attack = 1;
        //eqWep = null;
        
        for(int k = 0; k < 15; k++)
        {
            inventory.add(null);
        }
        
        //Add some if statements for easter egg user names
    }
    
    //Position Methods
    
    public void moveNorth()
    {
        if(currentRoom.canMoveNorth())
        {
            y += 1;
            setCurrentRoom();
        }
    }
    
    public void moveSouth()
    {
        if(currentRoom.canMoveSouth())
        {
            y -= 1;
            setCurrentRoom();
        }
    }
    
    public void moveEast()
    {
        if(currentRoom.canMoveEast())
        {
            x += 1;
            setCurrentRoom();
        }
    }
    
    public void moveWest()
    {
        if(currentRoom.canMoveWest())
        {
            x -= 1;
            setCurrentRoom();
        }
    }
    
    public void moveNorthEast()
    {
        if(currentRoom.canMoveNorthEast())
        {
            x += 1; y += 1;
            setCurrentRoom();
        }
    }
    
    public void moveNorthWest()
    {
        if(currentRoom.canMoveNorthWest())
        {
            x -= 1; y += 1;
            setCurrentRoom();
        }
    }
    
    public void moveSouthEast()
    {
        if(currentRoom.canMoveSouthEast())
        {
            x += 1; y -= 1;
            setCurrentRoom();
        }
    }
    
    public void moveSouthWest()
    {
        if(currentRoom.canMoveSouthWest())
        {
            x -= 1; y -= 1;
            setCurrentRoom();
        }
    }
    
    public void moveUp()
    {
        if(currentRoom.canMoveUp())
        {
            z += 1;
            setCurrentRoom();
        }
    }
    
    public void moveDown()
    {
        if(currentRoom.canMoveDown())
        {
            z -= 1;
            setCurrentRoom();
        }
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
    
    public void setZ(int c)
    {
        z = c;
    }
    
    public Room getCurrentRoom(Room[][] map)
    {
        return currentRoom;
    }
 
    public void setCurrentRoom()
    {
        boolean outOfBounds = true;
        for( int x = 0; x < map.length; x++)
        {
            for( int y = 0; y < map[x].length; y++)
            {
                for( int z = 0; z < map[x][y].length; z++)
                {
                    if(getX() == map[x][y][z].getX() && getY() == map[x][y][z].getY() && getZ() == map[x][y][z].getZ())
                    {
                        outOfBounds = false;
                        currentRoom =  map[x][y][z];
                    }
                }
            }
        }
        
        if(outOfBounds)
            System.out.println("Error: Player out of bounds!");
        }
    
    //Player Status methods
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        name = n;
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
        int index = -1;
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
        if( isFull == false && index != -1)
        {   inventory.set(index, item);
            status = item.getName() + "taken";
        }
            
        else
            status = "Bag is full...";
            
        return status;
    }
    
    public int findItem(String Iname)
    {
        boolean found = false;
        int index = 0;
        
        for(int k = 0; k < inventory.size(); k++)
        {
            if( Iname.toUpperCase().equals(inventory.get(k).getName().toUpperCase()))
            {
                found = true;
                index = k;
            }
        }
        
        if(found)
            return index;
            
        else
            return -1;
                
    }
    
    public String removeItem(String Iname)
    {
        String status;
        int index = findItem(Iname);
        
        if(index != -1)
        {
            status = inventory.get(index).getName() + " removed!";
            inventory.remove(index);
            inventory.add(null);
            return status;
        }
        
        else
        {
            status = Iname + " not found...";
            return status;
        }
    }
    
    public String dropItem(String Iname)
    {
        String status;
        int index = findItem(Iname);
        
        if(index != -1)
        {
            status = inventory.get(index).getName() + " dropped!";
            currentRoom.addItem(inventory.get(index));
            inventory.remove(index);
            inventory.add(null);
            return status;
        }
        
        else
        {
            status = Iname + " not found...";
            return status;
        }
    }
        
}

