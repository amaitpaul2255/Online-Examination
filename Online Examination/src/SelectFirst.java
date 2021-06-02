import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.*;
import java.sql.*;

public class SelectFirst extends JFrame implements ActionListener
{
    private JPanel p1 = new JPanel(); //home page panel or main frame
    private JPanel createp = new JPanel();
    private JPanel D = new JPanel();
    
    private JPanel userp = new JPanel(); //user login or registration panel
    
    private JPanel teacherp = new JPanel(); //teacher registration panel
    
    private JPanel adminp = new JPanel();  //admin login panel
    
    private JButton Button1 = new JButton("STUDENT");
    private JButton Button2 = new JButton("TEACHER");
    private JButton Button3 = new JButton("ADMINISTRATOR");
    
    private JLabel idl = new JLabel("ST-ID ");
    private JLabel passl = new JLabel("ST-PASSWORD ");
    private JTextField idt = new JTextField();
	private JPasswordField passt = new JPasswordField();           //student panel part
	private JButton loginuserb = new JButton("LOGIN");
	private JButton registerb = new JButton("REGISTER");
	private JButton backub = new JButton("Back");
	
	private JLabel tidl = new JLabel("T-ID ");
    private JLabel tpassl = new JLabel("T-PASSWORD ");
    private JTextField tidt = new JTextField();
	private JPasswordField tpasst = new JPasswordField();           //teacher part
	private JButton loginteacherb = new JButton("LOGIN");
	private JButton tregisterb = new JButton("REGISTER");
	private JButton backtb = new JButton("Back");
	
	private JLabel aidl = new JLabel("ADMIN-ID ");
    private JLabel apassl = new JLabel("ADMIN-PASSWORD ");
    private JTextField aidt = new JTextField();				//admin login part
	private JPasswordField apasst = new JPasswordField();           
	private JButton loginadminb = new JButton("LOGIN");
	private JButton backab = new JButton("Back");
	private static int counts;
	private static int countt;
	private JButton dl = new JButton("ONLINE EXAMINATION");
	
	Connection conn;
	Statement stmt ;

    public SelectFirst()
    {    
    	this.setTitle("ONLINE EXAMINATION");
        this.setBounds(20,30,720,480);
        dl.setBounds(0,0,720,150);
        dl.setIcon((new ImageIcon("C:\\Users\\Asif\\eclipse-workspace\\JavaProject\\src\\OnlineE.jpg")));
        this.add(dl);
    	createp();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //constructor
        try
    	{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		System.out.println("connected"+conn);
    	}
    	catch(SQLException e4)
    	{
    		e4.printStackTrace();
    	}
        try
        {
        	stmt = conn.createStatement();
        }
        catch(SQLException e3)
        {
        	e3.printStackTrace();
        }
        this.setBackground(Color.GRAY);
        this.setVisible(true);
    }
    
    private void createp()
    {
    	createp.setLayout(null);
        createp.setBounds(0,-150,720,600);
        Button1.setBounds(260,330,160,35);
        Button1.setBackground(Color.CYAN);
        createp.add(Button1);
        Button1.addActionListener(this);
        Button2.setBounds(260,370,160,35);
        Button2.setBackground(Color.CYAN);
        createp.add(Button2);							//home panel or main panel
        Button2.addActionListener(this);
        Button3.setBounds(260,410,160,35);
        Button3.setBackground(Color.CYAN);
        createp.add(Button3);
        Button3.addActionListener(this);
        createp.setBackground(Color.GRAY);
        this.add(createp);
    }
    public void userp()
    {
    	removehome();
    	userp.setLayout(null);
    	userp.setBounds(0,-150,720,600);
    	idl.setBounds(20,330,80,20);
    	userp.add(idl);
    	idt.setBounds(120,330,120,20);
    	userp.add(idt);
    	passl.setBounds(20,360,100,20);
    	userp.add(passl);
    	passt.setBounds(120,360,120,20);
    	userp.add(passt);
    	loginuserb.setBounds(150,390,90,30);
    	userp.add(loginuserb);								//student panel part
    	this.loginuserb.addActionListener(this);
    	registerb.setBounds(150,430,90,30);
    	userp.add(registerb);
    	this.registerb.addActionListener(this);
    	backub.setBounds(150,470,90,30);
    	userp.add(backub);
    	this.backub.addActionListener(this);
    	userp.setBackground(Color.GRAY);
    	this.add(userp);
    }
    public void teacherp()
    {
    	removehome();
    	teacherp.setLayout(null);
    	teacherp.setBounds(0,-150,720,600);
    	tidl.setBounds(20,330,70,20);
    	teacherp.add(tidl);
    	tidt.setBounds(120,330,120,20);
    	teacherp.add(tidt);
    	tpassl.setBounds(20,360,90,20);
    	teacherp.add(tpassl);
    	tpasst.setBounds(120,360,120,20);
    	teacherp.add(tpasst);
    	loginteacherb.setBounds(150,390,90,30);
    	teacherp.add(loginteacherb);								//teacher panel part
    	this.loginteacherb.addActionListener(this);
    	tregisterb.setBounds(150,430,90,30);
    	teacherp.add(tregisterb);
    	this.tregisterb.addActionListener(this);
    	backtb.setBounds(150,470,90,30);
    	teacherp.add(backtb);
    	this.backtb.addActionListener(this);
    	teacherp.setBackground(Color.GRAY);
    	this.add(teacherp);
    }
    public void adminpanel()
    {
    	removehome();
    	adminp.setLayout(null);
    	adminp.setBounds(0,-150,720,600);
    	aidl.setBounds(20,330,70,20);
    	adminp.add(aidl);
    	aidt.setBounds(150,330,150,20);
    	adminp.add(aidt);
    	apassl.setBounds(20,360,140,20);
    	adminp.add(apassl);
    	apasst.setBounds(150,360,150,20);
    	adminp.add(apasst);
    	loginadminb.setBounds(150,390,90,30);
    	adminp.add(loginadminb);								//admin panel part
    	this.loginadminb.addActionListener(this);
    	backab.setBounds(150,430,90,30);
    	adminp.add(backab);
    	this.backab.addActionListener(this);
    	adminp.setBackground(Color.GRAY);
    	this.add(adminp);
    }
    private void removehome()
    {
        this.remove(p1);
        this.remove(createp);
        this.repaint();
    }
    
    
    public void actionPerformed(ActionEvent e)
    {    	
        Object src = e.getSource();

        if(src == Button1)
        {
        	removehome();
            userp();
        }
        else if(src ==  Button2)
        {
        	removehome();
            teacherp();
        }
        else if(src ==  Button3)
        {
        	removehome();
            adminpanel();
        }
        else if(src == backub)
        {
        	this.remove(userp);
        	this.repaint();
        	createp();
        }
        else if(src == backtb)
        {
        	this.remove(teacherp);
        	this.repaint();
        	createp();
        }
        else if(src == backab)
        {
        	this.remove(adminp);
        	this.repaint();
        	createp();
        }
        else if(src == registerb)
    	{
        	this.setVisible(false);
        	counts++;
    		new UserRegistration(counts);
    	}
        else if(src == tregisterb)
    	{
        	this.setVisible(false);
        	countt++;
    		new TeacherRegistration(countt);
    	}
        else if (src == loginuserb)
        {
        	try
            {
            	String iduserq = "select Sid, Password from studentreg where Sid ='"+idt.getText()+"'";
            	ResultSet rs= stmt.executeQuery(iduserq);
            	rs.next();
            	System.out.println(new String(passt.getPassword())+"\t"+rs.getString("Password"));
            	if(rs.getString("Password").equals(new String(passt.getPassword()))) 
            	{
            		System.out.println("success");
            		this.setVisible(false);
            		new UserSubject();
            	}           	
            }
            catch(SQLException e2)
            {
            	e2.printStackTrace();
        		JOptionPane.showMessageDialog(null,"Login Faild");
            }
    	}
        else if (src == loginteacherb)
        {
        	try
            {
            	String tiduserq = "select Tid, Password from teacherreg where Tid ='"+tidt.getText()+"'";
            	ResultSet rs= stmt.executeQuery(tiduserq);
            	rs.next();
            	System.out.println(new String(tpasst.getPassword())+"\t"+rs.getString("Password"));
            	if(rs.getString("Password").equals(new String(tpasst.getPassword()))) 
            	{
            		System.out.println("success");
            		this.setVisible(false);
            		new Updateqselect();
            	}
            }
            catch(SQLException e2)
            {
            	e2.printStackTrace();
        		JOptionPane.showMessageDialog(null,"Login Faild");
            }
        }
        else if (src == loginadminb)
        {
        	try
            {
            	String tiduserq = "select AdminId, AdminPassword from admin where AdminId ='"+aidt.getText()+"'";
            	
            	ResultSet rs= stmt.executeQuery(tiduserq);
            	rs.next();
            	System.out.println(new String(apasst.getText())+"\t"+rs.getString("AdminPassword"));
            	if(rs.getString("AdminPassword").equals(new String(apasst.getText()))) {
            		System.out.println("success");
            		this.setVisible(false);
            		new Admin1st();
            	} 
            }
            catch(SQLException e2)
            {
            	e2.printStackTrace();
        		JOptionPane.showMessageDialog(null,"Login Faild");
            }
        }
    }

    public static void main(String[] args)
    {
        SelectFirst obj = new SelectFirst();
    }
}
