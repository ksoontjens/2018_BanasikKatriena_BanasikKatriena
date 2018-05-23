package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.Color;
import java.awt.event.*;
import org.dvb.event.*;
import org.havi.ui.event.*;

/**
 *
 * @author student
 */

public class HelloTVXlet implements Xlet, UserEventListener {
    
    //default constructor without arguments
    public HelloTVXlet() {
    }
    
    //initialization
    public void initXlet(XletContext context) throws XletStateChangeException {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        // SCHERM = 720 x 576
        
        HStaticText hst=new HStaticText("Harry Potter Quiz",0,0,720,576); // tekst,x,y,w,h
        hst.setBackgroundMode(HVisible.BACKGROUND_FILL);
        hst.setBackground(Color.BLACK);
        scene.add(hst);
        
        scene.validate();
        scene.setVisible(true);
    }
 
    //start
    public void startXlet() {
        // EventManager aanvragen
        EventManager manager = EventManager.getInstance();
        
        // Repository
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        // Events toevoegen
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_ENTER);
        
        // Bekend maken bij EventManager
        manager.addUserEventListener((UserEventListener)this,repository );
    }
 
    //pauze (free resources, stop unnecessary threads, remove itself from the screen)
    public void pauseXlet() {
        
    }
 
    //destroy xlet
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }
    
    // --------------------------------------------------
    
    // Key Events Handler
    public void userEventReceived(org.dvb.event.UserEvent e) {
        //IF USER HITS ENTER
        if(e.getType() == KeyEvent.KEY_PRESSED){
            switch(e.getCode()) {
                case HRcEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    break;
                    
                case HRcEvent.VK_LEFT:
                    System.out.println("LEFT");
                    break;
                    
                case HRcEvent.VK_ENTER:
                    System.out.println("ENTER");
                    break;
            }
        }
    }
}


