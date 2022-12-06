import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicDemo3Frame extends JFrame implements ActionListener, ChangeListener
{
    private GraphicDemo3Panel myCustomPanel;
    private JButton button1, button2;
    private JCheckBox showSquareCheckBox;
    private JSlider sizeSlider;

    public GraphicDemo3Frame()
    {
        super("Listeners");
        setSize(400,400);
        buildGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        myCustomPanel.requestFocus();
    }

    public void buildGUI()
    {
        button1 = new JButton("red");
        button2 = new JButton("blue");
        myCustomPanel = new GraphicDemo3Panel();
        showSquareCheckBox = new JCheckBox("Show Square");
        sizeSlider = new JSlider(JSlider.HORIZONTAL, 1, 300, 50);

        Box topPanel = Box.createHorizontalBox();
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(button1);
        topPanel.add(Box.createHorizontalStrut(50));
        topPanel.add(button2);
        topPanel.add(Box.createHorizontalStrut(50));
        topPanel.add(showSquareCheckBox);
        topPanel.add(Box.createHorizontalGlue());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(myCustomPanel, BorderLayout.CENTER);
        getContentPane().add(sizeSlider, BorderLayout.SOUTH);

        button1.addActionListener(this);
        button2.addActionListener(this);
        showSquareCheckBox.addActionListener(this);
        sizeSlider.addChangeListener(this);


    }

    public void showDialogBox()
    {
        Box dialogContent = Box.createVerticalBox();
        JCheckBox useColor = new JCheckBox("Override the dot's color with this?");
        JColorChooser colorPicker = new JColorChooser(Color.RED);
        dialogContent.add(colorPicker);
        dialogContent.add(useColor);

        int buttonChoice = JOptionPane.showConfirmDialog(this,
                dialogContent,
                "Override?",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (buttonChoice == JOptionPane.OK_OPTION && useColor.isSelected())
        {
            Color c = colorPicker.getColor();
            myCustomPanel.setDotColor(c);
        }
        myCustomPanel.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent aEvt)
    {
        if (aEvt.getSource() == button1)
        {
            myCustomPanel.setDotColor(Color.RED);
            showDialogBox();
        }
        else if (aEvt.getSource() == button2)
            myCustomPanel.setDotColor(Color.BLUE);
        if (aEvt.getSource() == showSquareCheckBox)
        {
            if (showSquareCheckBox.isSelected())
                myCustomPanel.showBox();
            else
                myCustomPanel.hideBox();
        }
        // amd, for the sake of showing you what the getActionCommand() method does:
        System.out.println(aEvt.getActionCommand());
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        int d = ((JSlider)e.getSource()).getValue();
        myCustomPanel.setDiameter(d);
    }
}
