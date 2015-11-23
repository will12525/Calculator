import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by william on 11/22/2015.
 */
public class Numbers extends Buttons {
    private String num;
    JTextField field;
    public Numbers(String num, JTextField field)
    {
        super("");
        this.num=num;
        this.field=field;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        field.setText(field.getText()+num);

    }

    @Override
    public boolean doAction(String actionType) {
        return false;
    }
}
