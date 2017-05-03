import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame
{
    public GUI()
    {
        setTitle("Empty Frame");
        setSize(300,200); // default is 0,0
        setLocation(10,200); // default is 0,0
        
        //Window Listeners
        addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e)
                                                { 
                                                    //Occassionally need dispose();
                                                    System.exit(0);
                                                }
                                            });
    }
    
    public static void main(String[] args)
    {
        JFrame f = new GUI();
        f.show();
    }
}