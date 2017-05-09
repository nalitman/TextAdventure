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
        methods.put("NORTH", Player.class.getMethod("moveNorth"));
        methods.put("TAKE", Player.class.getMethod("addItem"));
        methods.put("DROP", Player.class.getMethod("dropItem"));
        
        //Room Methods
        methods.put("LOOK", Room.class.getMethod("getDescription"));
    
    }
    
    public String actionPerformed(String input) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
    {
        String split = " ";
        int index;
        
        index = input.indexOf(split);
        if(index == -1)
            input1 = input;
            
        else
        {
            input1 = input.subString(0, index);
            input2 = input.subString(index + 1);
        }
        
            
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
