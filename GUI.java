import javax.swing.JFrame;
import java.awt.*;

public class GUI extends JFrame
{
    int W = 400;
    int H = 300;
    
    public GUI()
    {
        setTitle("test thing");
        setSize(W,H);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}