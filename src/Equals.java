import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Created by william on 11/22/2015.
 */
public class Equals extends Buttons {
    List<SimpleAction> simpleActions;
    public Equals(String action, List<SimpleAction> simpleActions)
    {
        super(action);
        this.simpleActions=simpleActions;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int x=0;x<simpleActions.size();x++)
        {
            if(simpleActions.get(x).checkActive())
            {
                simpleActions.get(x).doAction(action);
            }
        }
    }
}
