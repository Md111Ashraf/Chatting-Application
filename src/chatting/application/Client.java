package chatting.application;

import static chatting.application.Server.dout;
import static chatting.application.Server.f;
import static chatting.application.Server.formateLabel;
import static chatting.application.Server.vertical;
import javax.swing.*; // importing swing pacakage
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Client  implements ActionListener { //Server is a public class .To build Frame we need a class called JFrame class and it is present under Swing package   
    
    
    JTextField text; //we are declearing the text field globally so that we can use it inside the constuctor as well as in another function
    static JPanel a1; // declearing the the panel "a1" globally 
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dout;
    
    Client(){
        f.setLayout(null); // we have different layout in swing pacakage which we can use over the frame but asof now we are not using non of those layout.
       
        //we are using our own custom layout by using Jpanel
        /*--------------------------This is the top-Panel which is of Green Colour--------------------------------------------------*/
        JPanel p1 = new JPanel();// to do something over the frame we use panel
        p1.setBackground(new Color(7,94,84));// we can also use setBackground(color.Green) but we are defining the color by using rba values
        p1.setBounds(0,0,450,70);//By using setBound()method we are passing the parameter of p1, 0,0 means the panel will starts from top-left corner, 450 is the length of panel p1 which we are keeping equal to the length of frame, and 70 is the height of panel p1.  
        p1.setLayout(null);
        f.add(p1);// By using add() we are set the panel p1 on the frame
        
        /*-----------------------------------Back Arrow Icon-----------------------------------------------*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);//we are scaling image i1 and store in to i2
        ImageIcon i3 = new ImageIcon(i2);// we can not directly pass i2 to JLabel therefore first we need to convert it in to image icon
        JLabel back = new JLabel(i3);// we are passing the object of image icon "i3" to JLabel
        back.setBounds(5,20,25,25);//now we are setting JLabel over Frame
        p1.add(back);// we are calling add() functioin by p1 so that the image appear on the panel p1
        
        back.addMouseListener( new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
        System.exit(0);
        }
                }
        );//we has add a mouse event such that on click our frame get close  
        
        
        
        /*--------------------------------Profile Picture---------------------------------------------------------*/
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);//we are scaling image i1 and store in to i2
        ImageIcon i6 = new ImageIcon(i5);// we can not directly pass i2 to JLabel therefore first we need to convert it in to image icon
        JLabel profile = new JLabel(i6);// we are passing the object of image icon "i3" to JLabel
        profile.setBounds(40,10,50,50);//now we are setting JLabel over Frame
        p1.add(profile);
        
        
        /*----------------------------------Video Icon---------------------------------------------------------------*/
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);//we are scaling image i1 and store in to i2
        ImageIcon i9 = new ImageIcon(i8);// we can not directly pass i2 to JLabel therefore first we need to convert it in to image icon
        JLabel video = new JLabel(i9);// we are passing the object of image icon "i3" to JLabel
        video.setBounds(300,20,30,30);//now we are setting JLabel over Frame
        p1.add(video);
        
       /*-------------------------------------Phone Icon------------------------------------------------------------*/

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);//we are scaling image i1 and store in to i2
        ImageIcon i12 = new ImageIcon(i11);// we can not directly pass i2 to JLabel therefore first we need to convert it in to image icon
        JLabel phone = new JLabel(i12);// we are passing the object of image icon "i3" to JLabel
        phone.setBounds(360,20,35,30);//now we are setting JLabel over Frame
        p1.add(phone);
        
        /*---------------------------------More OPtion--------------------------------------------------------------*/
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);//we are scaling image i1 and store in to i2
        ImageIcon i15 = new ImageIcon(i14);// we can not directly pass i2 to JLabel therefore first we need to convert it in to image icon
        JLabel morevert = new JLabel(i15);// we are passing the object of image icon "i3" to JLabel
        morevert.setBounds(420,20,10,25);//now we are setting JLabel over Frame
        p1.add(morevert);
        
        /*---------------------------------User1_Name----------------------------------------------------------------*/
        JLabel name =new JLabel("user2");
        name.setBounds(110,15,100,18);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        p1.add(name);
        
        /*-----------------------------------Activity status----------------------------------------------------------*/
        JLabel status =new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.white);
        status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(status);
        
        /*-------------------------------------Now we are adding the second panel for text area . This is the Panel which is of Light Gray Colour------------------------*/
        
        
        a1 = new JPanel();
        //a1.setBackground(Color.LIGHT_GRAY);
        a1.setBounds(5,75,440,570);
        f.setUndecorated(true);
        f.add(a1);
        
        /*---------------------------Now we are creating the textfield where users can write there text.--------------------------------*/
        
        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont( new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);
        
        /*--------------------------------Now we are creating the send Button-------------------------------------------------------------*/
        
        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));//setting the background color of button
        send.setForeground(Color.white); // color of Send
        send.addActionListener(this); // we are adding action listener to send button, so that on clicking send button some action must be performed
        send.setFont(new Font("SCAN_SERIF",Font.PLAIN,16));//setting the font and font color
        f.add(send);
        
        f.setSize(450, 700);// setSize is a function of JFrame which we use to define the size of frame we are using (Length=450, width=700)
        f.setLocation(800,50); //by defult the frame get open at origin (top-left corner). By sing setLocation() function we can define the coordinates  of the frame where shich we want to disply the frame
        f.getContentPane().setBackground(Color.white);//to target the whole frame we use the method "getContentPane()" and to change the background color we use the method setBackgtound() and class color . class color is present under "awt" pacakage.   
        f.setVisible(true);// Bydefult the visibility of the frame is hidden . therefore we ae using the function setVisible() function so that the frame get visible
    }
    public void actionPerformed(ActionEvent ae){
        
        try{
        String out = text.getText();// By using the function "getText()" we are exterecting the values of text field and storing the same in String varable "out"
                
        JPanel p2 = formateLabel(out);
        
        a1.setLayout(new BorderLayout());
        
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical, BorderLayout.PAGE_START);
        
        dout.writeUTF(out);
        text.setText("");
        f.repaint();
        f.invalidate();
        f.validate();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    public static JPanel formateLabel(String out){
        JPanel panel =new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        JLabel output =new JLabel("<html><p style= \"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma",Font.PLAIN,16));
        output.setBackground(new Color(37,211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf =new SimpleDateFormat ("HH:mm");
        
        JLabel time =new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    public static void main(String[] args){
       new Client(); 
       
       try{
       Socket s = new Socket("127.0.0.1",6001); // 127.0.0.====> means we are running our application on local host.  6001===> server is running on 6001
        DataInputStream din =new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                
                while(true){
                    a1.setLayout(new BorderLayout());
                   String msg = din.readUTF();
                   JPanel panel = formateLabel(msg);
                   
                   JPanel left = new JPanel (new BorderLayout());
                   left.add(panel, BorderLayout.LINE_START);
                   vertical.add(left);
                   
                   vertical.add(Box.createVerticalStrut(15));
                   a1.add(vertical, BorderLayout.PAGE_START);
                   f.validate();
                   
               }
       }catch(Exception e){
       e.printStackTrace();
       }
    }
}
 