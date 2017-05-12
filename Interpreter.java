import java.util.*;
import java.lang.reflect.*;

public class Interpreter 
{
    private String outputSTR, input1, input2;
    private int outputNum;
    private Item outputItem;
    private Map<String,Method> methods = new HashMap<String, Method>();
    private Player user;
    
    
    public Interpreter(Player player) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
    {
        user = player;
        //Player movement methods
        methods.put("NAME", Player.class.getMethod("getName"));
        methods.put("NORTH", Player.class.getMethod("moveNorth"));
        methods.put("N", Player.class.getMethod("moveNorth"));
        methods.put("SOUTH", Player.class.getMethod("moveSouth"));
        methods.put("S", Player.class.getMethod("moveSouth"));
        methods.put("EAST", Player.class.getMethod("moveEast"));
        methods.put("E", Player.class.getMethod("moveEast"));
        methods.put("WEST", Player.class.getMethod("moveWest"));
        methods.put("W", Player.class.getMethod("moveWest"));
        methods.put("UP", Player.class.getMethod("moveUp"));
        methods.put("DOWN", Player.class.getMethod("moveDown"));
        methods.put("NORTHEAST", Player.class.getMethod("moveNorthEast"));
        methods.put("NE", Player.class.getMethod("moveNorthEast"));
        methods.put("NORTHWEST", Player.class.getMethod("moveNorthWest"));
        methods.put("NW", Player.class.getMethod("moveNorthWest"));
        methods.put("SOUTHEAST", Player.class.getMethod("moveSouthEast"));
        methods.put("SE", Player.class.getMethod("moveSouthEast"));
        methods.put("SOUTHWEST", Player.class.getMethod("moveSouthWest"));
        methods.put("SW", Player.class.getMethod("moveSouthWest"));
        
        //Player Item managment methods
        methods.put("INVENTORY", Player.class.getMethod("getInventory"));
        methods.put("TAKE", Player.class.getMethod("addItem"));
        methods.put("DROP", Player.class.getMethod("dropItem"));
        methods.put("INSPECT", Item.class.getMethod("getDescription"));
        
        //Player Health
        methods.put("DIAGNOSE", Player.class.getMethod("getHealth"));
        
        //Room Methods
        methods.put("LOOK", Room.class.getMethod("getDescription"));
        
        //Combat
        methods.put("ATTACK", Enemy.class.getMethod("combat"));
    
    }
    
    public String actionPerformed(String input, Room cRoom) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
    {
        String split = " ";
        int index;
        
        index = input.indexOf(split);
        if(index == -1)
            input1 = input;
            
        else
        {
            input1 = input.substring(0, index);
            input2 = input.substring(index + 1);
        }
        
        if(input1.toUpperCase().equals("MOVE"))
        {
            try
            {
                return (String) methods.get(input2.toUpperCase()).invoke(user);
            }
            catch(NullPointerException e)
            {
                return "You want to move where?";
            }   
        }
        
        else if(input1.toUpperCase().equals("TAKE"))
        {
            int item = -1;
            for(int k = 0; k < cRoom.getItems().size(); k++)
            {
                if(input2.toUpperCase().equals(cRoom.getItems().get(k).getName()))
                {
                    item = k;
                }
            }
            
            if(item != -1)
            {
                methods.get("TAKE").invoke(user, cRoom.getItems().get(item));
                cRoom.removeItem(cRoom.getItems().get(item));
                //Change Description
                return "Taken";
            }
            else
                return "You see no such thing";
        }
        
        else if(input1.toUpperCase().equals("DROP"))
        {
            int item = -1;
            for(int k = 0; k < user.getItems().size(); k++)
            {
                if(input2.toUpperCase().equals(user.getItems().get(k).getName()))
                {
                    item = k;
                }
            }
            
            if(item != -1)
            {
                methods.get("DROP").invoke(user, input2);
                cRoom.addItem(user.getItems().get(item));
                return "Dropped";
            }
            else
                return "You hold no such thing";
            }
            
        else if(input1.toUpperCase().equals("DIAGNOSE"))
        {
            return (String)methods.get("DIAGNOSE").invoke(user);
        }
        
        else if(input1.toUpperCase().equals("LOOK"))
        {
            return (String)methods.get("LOOK").invoke(cRoom);
        }
        
        else if(input1.toUpperCase().equals("ATTACK"))
        {
            if(cRoom.getEnemy() == null)
            {
                return "Why would you want to attack that?";
            }
            return (String)methods.get("ATTACK").invoke(cRoom.getEnemy());
        }
        
        else if(input1.toUpperCase().equals("INSPECT"))
        {
            Item thing = null;
            
            for(int k = 0; k < user.getItems().size(); k++)
            {
                if( input2.toUpperCase().equals(user.getItems().get(k).getName() ))
                    thing = user.getItems().get(k);
                }
        
            if(thing = null)
            {
                for(int k = 0; k< cRoom.getItems().size(); k++)
                {
                    if( input2.toUpperCase().equals(cRoom.getItems().get(k).getName() ))
                        thing = cRoom.getItems().get(k);
                    }
                }
                
            if(thing = null)
            {
                return "Inspect what?";
            }
            
            else
            {
                return thing.getDescription();
            }
        }
        else
            return "What?";
            
    }
     
public String thing()throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
{
     outputSTR =  (String)methods.get("NAME").invoke(user);
     return outputSTR;
}

public void thing2(String n) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
{
    methods.get("SET").invoke(user, n);
}

public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
{
    Room map[][][] = new Room[1][1][1];
    Player test = new Player("Nick", map);
    
    Interpreter t = new Interpreter(test);
    System.out.print(t.thing());
    
    t.thing2("Jeb");
    System.out.print(t.thing());
    System.out.print(test.getName());
    
}

}
