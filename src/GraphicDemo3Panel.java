import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicDemo3Panel extends JPanel implements MouseListener, KeyListener
{
    private Color dotColor;
    private boolean shouldShowBox;
    private int diameter;
    private int letterX, letterY;
    private String letter;
    private Font letterFont;


    public GraphicDemo3Panel()
    {
        super();
        dotColor = Color.BLACK;
        shouldShowBox = false;
        diameter = 50;
        letterX = 200;
        letterY = 200;
        letter = "H";
        letterFont = new Font("Times New Roman", Font.BOLD, 24);
        addMouseListener(this);
        addKeyListener(this);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(dotColor);
        g.fillOval((getWidth()-diameter)/2,(getHeight()-diameter)/2,diameter,diameter);
        if (shouldShowBox)
        {
            g.setColor(Color.BLACK);
            g.drawRect((getWidth()-diameter)/2,(getHeight()-diameter)/2,diameter,diameter);
        }
        g.setColor(new Color(0, 128, 0));
        g.setFont(letterFont);
        g.drawString(letter, letterX, letterY+12);

    }

    public void setDotColor(Color c)
    {
        dotColor = c;
        repaint();
    }

    public void showBox()
    {
        shouldShowBox = true;
        repaint();
    }

    public void hideBox()
    {
        shouldShowBox = false;
        repaint();
    }

    public void setDiameter(int diameter)
    {
        this.diameter = diameter;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent mEvt)
    {
        letterX = mEvt.getX();
        letterY = mEvt.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent kEvt)
    {
        letter = ""+kEvt.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent kEvt)
    {

    }

    @Override
    public void keyReleased(KeyEvent kEvt)
    {

    }
}
