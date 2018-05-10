package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.Color;

/**
 *
 * @author student
 */

public class HelloTVXlet implements Xlet {
    
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
        
    }
 
    //pauze (free resources, stop unnecessary threads, remove itself from the screen)
    public void pauseXlet() {
        
    }
 
    //destroy xlet
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }
}


