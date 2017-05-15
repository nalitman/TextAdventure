import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//JLabel.setIcon(new ImageIcon("ImagePath")) to add an image validate(); after?
public class TestGui extends JPanel
{
    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JLabel lab;
    
    public TestGui()
    {
        //basicgui();
        //basiclayout();
        //aListen();
        //basicText();
        scrollArea();
    }
    
    public void basicgui()
    {
        f = new JFrame("The test");
        f.setVisible(true);
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        p.setBackground(Color.YELLOW);
        
        b1 = new JButton("Test");
        lab = new JLabel("Test label");
        
        p.add(b1);
        p.add(lab);
        
        f.add(p, BorderLayout.SOUTH);
    }
    
    public void basiclayout()
    {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p = new JPanel(new GridBagLayout());
        
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        
        GridBagConstraints c = new GridBagConstraints();
        
        //Space between objects
        c.insets = new Insets(10,10,10,10); //top,bottom,left,right
        //Orientation of objects on x,y coordinate plane
        c.gridx = 0;
        c.gridy = 1;
        p.add(b1,c);
        
        c.gridx = 0;
        c.gridy = 2;
        p.add(b2,c);
        
        f.add(p, BorderLayout.WEST);
    }
    
    public void aListen()
    {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JPanel p = new JPanel();
        
        JButton b1 = new JButton("Action Listener");
        b1.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "You pressed the button");
            }
        });
        
        p.add(b1);
        f.add(p);
    }
    
    public void basicText()
    {
        JFrame f = new JFrame();
        JLabel lab = new JLabel();
        
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JPanel p = new JPanel();
        JTextField t = new JTextField(30);
        
        JButton b1 = new JButton("Enter");
        
        t.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = t.getText();
                lab.setText(input);
            }
        });
        
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = t.getText();
                lab.setText(input);
            }
            
        });
        p.add(b1);
        p.add(lab);
        p.add(t);
        f.add(p);
    }
    
    public void scrollArea()
    {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea textArea = new JTextArea("What",10,20);
        JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        JTextField t = new JTextField(30);
        
        //JButton b1 = new JButton("Enter");
        
        t.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = t.getText();
                textArea.append(input);
            }
        });
        
        
        scroll.add(textArea);
        f.add(scroll);
        f.add(t);
        
        
    }
    
    public static void main(String[] args)
    {        
        new TestGui();
    }
}
