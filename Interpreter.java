import java.util.*;
import java.lang.reflect.*;

public class Interpreter 
{
    private String output;
    private Map<String,Method> methods = new HashMap<String, Method>();
    private Player user;
    
    
    public Interpreter(Player player) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
    {
        user = player;
        methods.put("NAME", Player.class.getMethod("getName"));
        methods.put("SET", Player.class.getMethod("setName", String.class));
    
}

public String thing()throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException
{
     String t =  (String)methods.get("NAME").invoke(user);
     return t;
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
