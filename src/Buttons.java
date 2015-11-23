import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by william on 11/22/2015.
 */
public abstract class Buttons implements ActionListener {
    public boolean active=false;
    public String action="";
    public Buttons(String action)
    {
        this.action=action;
    }
    @Override
    public abstract void actionPerformed(ActionEvent e);
    public boolean doAction(String actionType)
    {

        return false;
    }
    public boolean checkActive()
    {
        return active;
    }
    public void setActive(boolean set)
    {
        active=set;
    }

}
