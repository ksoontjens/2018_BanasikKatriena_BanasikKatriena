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

public class HelloTVXlet implements Xlet, HActionListener {
    private HStaticText title, question;
    private HTextButton btn1,btn2,btn3,btn4;
    private int count = 1;
    private int score = 0;
    
    //default constructor without arguments
    public HelloTVXlet() {
    }
    
    //for HActionListener
    public void actionPerformed ( ActionEvent e )
    {
        int choice = Integer.parseInt(e.getActionCommand());
        
        switch (choice) {
            case 1:
                System.out.println("choice: 1");
                break;
            case 2:
                System.out.println("choice: 2");
                break;
            case 3:
                System.out.println("choice: 3");
                break;
            case 4:
                System.out.println("choice: 4");
                if (count == 1) {
                    score = score + 1;
                }
                break;
        }

        System.out.println("count before: " + count);
        count = count + 1;
        System.out.println("count now: " + count);
        System.out.println("YOUR SCORE SO FAR: " + score);
    }

    //initialization
    public void initXlet(XletContext context) throws XletStateChangeException {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        // SCHERM = 720 x 576
        
        //text
        title=new HStaticText("Harry Potter Quiz",0,0,720,76); // tekst,x,y,w,h
        title.setBackgroundMode(HVisible.BACKGROUND_FILL);
        title.setBackground(Color.BLACK);
        scene.add(title);
        
        question=new HStaticText("1: What's the title of the first book? Harry Potter and...",0,76,720,300); // tekst,x,y,w,h
        question.setBackgroundMode(HVisible.BACKGROUND_FILL);
        question.setBackground(Color.BLACK);
        scene.add(question);
        
        //buttons
        btn1 = new HTextButton("The Chamber of Secrets");
        btn1.setLocation(0,376);
        btn1.setSize (360,100);
        btn1.setBackground(Color.WHITE);
        btn1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        btn1.setForeground(Color.BLACK);
        
        btn2 = new HTextButton("Voldemort");
        btn2.setLocation(360,376);
        btn2.setSize (360,100);
        btn2.setBackground(Color.WHITE);
        btn2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        btn2.setForeground(Color.BLACK);
        
        btn3 = new HTextButton("The Order of the Phoenix");
        btn3.setLocation(0,476);
        btn3.setSize (360,100);
        btn3.setBackground(Color.WHITE);
        btn3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        btn3.setForeground(Color.BLACK);
        
        btn4 = new HTextButton("The Philosopher's Stone");
        btn4.setLocation(360,476);
        btn4.setSize (360,100);
        btn4.setBackground(Color.WHITE);
        btn4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        btn4.setForeground(Color.BLACK);
        
        //set focus
        btn1.setFocusTraversal(null,btn3,null,btn2);
        btn2.setFocusTraversal(null,btn4,btn1,null);
        btn3.setFocusTraversal(btn1,null,null,btn4);
        btn4.setFocusTraversal(btn2,null,btn3,null);
        
        //add btns to scene
        scene.add(btn1);
        scene.add(btn2);
        scene.add(btn3);
        scene.add(btn4);
        
        btn1.requestFocus();
        
        //btn press action
        btn1.setActionCommand("1");
        btn1.addHActionListener(this);
        
        btn2.setActionCommand("2");
        btn2.addHActionListener(this);
        
        btn3.setActionCommand("3");
        btn3.addHActionListener(this);
        
        btn4.setActionCommand("4");
        btn4.addHActionListener(this);
        
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
}


