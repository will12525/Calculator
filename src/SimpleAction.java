import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by william on 11/22/2015.
 */
public class SimpleAction extends Buttons {
    Calculator calc;
    JTextField field;
    public SimpleAction(Calculator c,JTextField f,String action)
    {
        super(action);
        field=f;
        calc=c;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        active = true;
        calc.setStoredNumber(field.getText());
        field.setText("");
        System.out.println(action);
    }


    @Override
    public boolean doAction(String actionType) {


        double num1 = toInt(calc.getStoredNumber());
        double num2 = toInt(field.getText());
        if(action.equals("+"))
        {
            if(actionType.equals("=")) {
                field.setText((num1 + num2) + "");
            }
            if(actionType.equals("%"))
            {
                double num3 = num2/100;
                num3 = num3*num1;
                System.out.println(num3+"hye");
                field.setText((num1+num3)+"");

            }
        }

        if(action.equals("-"))
        {
            if(actionType.equals("=")) {
                field.setText((num1 - num2) + "");
            }
            if(actionType.equals("%"))
            {
                double num3 = num2/100;
                num3 = num3*num1;
                field.setText((num1-num3)+"");
            }
        }
        if(action.equals("*"))
        {
            if(actionType.equals("=")) {
                field.setText((num1 * num2) + "");
            }
            if(actionType.equals("%"))
            {
                double num3 = num2/100;
                num3 = num3*num1;
                System.out.println(num3+"hye");
                field.setText((num1*num3)+"");
            }
        }
        if(action.equals("/"))
        {
            if(num2==0)
            {
                field.setText(0+"");
                return false;
            }
            if(actionType.equals("=")) {
                field.setText((num1 / num2) + "");
            }
            if(actionType.equals("%"))
            {
                double num3 = num2/100;
                num3 = num3*num1;
                field.setText((num1/num3)+"");
            }
        }

        active=false;
        return false;
    }

    private double toInt(String theString)
    {
        double theInt=0;
        boolean type=true;
        if(theString.contains("-"))
        {
            theString=theString.substring(1);
            type=false;
        }

        theInt=Double.parseDouble(theString);

        if(!type)
        {
            theInt=theInt-theInt*2;
        }

        System.out.println(theInt);
        return theInt;
    }

}
