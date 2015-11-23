import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by william on 11/22/2015.
 */
public class Calculator extends JFrame {

    private String storedNumber="0";
    private void createFrame()
    {

        setSize(270,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(false);

        JTextField mem = new JTextField(1);
        mem.setEditable(false);
        JTextField field = new JTextField(20);
        field.setEditable(false);
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel textBoxes = new JPanel();
        textBoxes.setLayout(new FlowLayout());
        textBoxes.add(mem);
        textBoxes.add(field);
        add(textBoxes);

        List<SimpleAction> simpleMathButtons = new ArrayList<>();
        List<JButton> immediateAction = new ArrayList<>();
        SimpleAction action =null;

        JButton MC = new JButton("MC");
        JButton mAdd = new JButton("M+");
        JButton mSub = new JButton("M-");
        JButton mRecall = new JButton("MR");
        JButton clearCurrent = new JButton("C");
        JButton clearEntry = new JButton("CE");

        JButton square = new JButton("√");
        JButton root = new JButton("X^2");



        JButton negPos = new JButton("+-");
        negPos.addActionListener(e -> {
            String text = field.getText();
            if(text.contains("-"))
            {
                field.setText(text.substring(1));
            }
            else
            {
                field.setText("-"+text);
            }
        });
        JButton dot = new JButton(".");
        dot.addActionListener(new Numbers(".",field));
        JButton pi = new JButton("π");
        pi.addActionListener(new Numbers(Math.PI+"",field));

        JButton addNum = new JButton("+");
        action = new SimpleAction(this,field,"+");
        addNum.addActionListener(action);
        simpleMathButtons.add(action);


        JButton sub = new JButton("-");
        action = new SimpleAction(this,field,"-");
        sub.addActionListener(action);
        simpleMathButtons.add(action);

        JButton multiply = new JButton("x");
        action = new SimpleAction(this,field,"*");
        multiply.addActionListener(action);
        simpleMathButtons.add(action);

        JButton divide = new JButton("/");
        action = new SimpleAction(this,field,"/");
        divide.addActionListener(action);
        simpleMathButtons.add(action);

        JButton equals = new JButton("=");
        equals.addActionListener(new Equals("=",simpleMathButtons));
        JButton percent = new JButton("%");
        percent.addActionListener(new Equals("%",simpleMathButtons));

        List<JButton> numButtons = new ArrayList<>();
        for(int x=0;x<10;x++)
        {
            JButton button = new JButton(""+x);
            button.addActionListener(new Numbers(x+"",field));
            numButtons.add(button);
        }

        JPanel allTheButtons = new JPanel();
        allTheButtons.setLayout(new GridLayout(8,4));
        allTheButtons.add(MC,0);
        allTheButtons.add(mAdd,1);
        allTheButtons.add(mSub,2);
        allTheButtons.add(mRecall,3);
        allTheButtons.add(square,4);
        allTheButtons.add(root,5);
        allTheButtons.add(percent,6);
        allTheButtons.add(pi,7);
        allTheButtons.add(clearCurrent,8);
        allTheButtons.add(clearEntry,9);
        allTheButtons.add(negPos,10);
        allTheButtons.add(divide,11);
        allTheButtons.add(numButtons.get(7),12);
        allTheButtons.add(numButtons.get(8),13);
        allTheButtons.add(numButtons.get(9),14);
        allTheButtons.add(multiply,15);
        allTheButtons.add(numButtons.get(4),16);
        allTheButtons.add(numButtons.get(5),17);
        allTheButtons.add(numButtons.get(6),18);
        allTheButtons.add(sub,19);
        allTheButtons.add(numButtons.get(1),20);
        allTheButtons.add(numButtons.get(2),21);
        allTheButtons.add(numButtons.get(3),22);
        allTheButtons.add(addNum,23);
        allTheButtons.add(numButtons.get(0),24);
        allTheButtons.add(dot,25);
        allTheButtons.add(equals,26);




        add(allTheButtons);
        setVisible(true);

    }
    public void setStoredNumber(String newNumber)
    {
        System.out.println(newNumber);
        storedNumber=newNumber+"";
    }
    public String getStoredNumber()
    {
        return storedNumber;
    }
    public Calculator()
    {
       createFrame();


    }
    public static void main(String[] args)
    {
        new Calculator();
    }
}
