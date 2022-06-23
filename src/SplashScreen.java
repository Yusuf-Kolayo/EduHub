import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
import javax.swing.border.Border;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends JFrame {


    SplashScreen()  {
        ImageIcon image = new ImageIcon("assets/pics/edu_hub.jpg");
		Border border = BorderFactory.createLineBorder(Color.decode("#46C7F1"),3);
		
		JLabel label = new JLabel(); //create a label
		label.setText(""); //set text of label
		label.setIcon(image);
		// label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		// label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		label.setForeground(new Color(0x00FF00)); //set font color of text
		label.setFont(new Font("MV Boli",Font.PLAIN,100)); //set font of text
		label.setIconTextGap(-25); //set gap of text to image
		label.setBackground(Color.black); //set background color
		label.setOpaque(true); //display background color
		label.setBorder(border); //sets border of label (not image+text)
		// label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		// label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		// label.setBounds(10, 10, 200, 200); //set x,y position within frame as well as dimensions


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		// this.setLayout(null);
		this.setVisible(true);	 
		this.add(label);
		this.pack();



        Timer timer = new Timer(); 
		TimerTask task = new TimerTask() {
			
			int counter = 10;
			@Override
			public void run() {
				if(counter>0) {
					System.out.println(counter+" seconds");
					counter--;
				}
				else {
					System.out.println("OPEN THE DASHBOARD");
                    new Dashboard();
					timer.cancel();
                    dispose(); 
				}
			}		
		};
		
	 
		
		// timer.schedule(task, 0);
		// timer.schedule(task, date.getTime());
		 timer.scheduleAtFixedRate(task, 0, 1000);
    }


}
