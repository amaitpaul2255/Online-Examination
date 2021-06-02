import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.*;
import java.*;

public class Teacherupdate extends JFrame implements ActionListener
{
	private JPanel createregp = new JPanel();
	
	private JLabel loginid = new JLabel("LOGIN ID ");
	private JTextField logintext = new JTextField();
	private static int countt = 0;

	
	private JLabel firstname = new JLabel("FIRST NAME ");
	private JTextField fntext = new JTextField();

	private JLabel lastname = new JLabel("LAST NAME ");
	private JTextField lntext = new JTextField();

	private JLabel pass1 = new JLabel("PASSWORD ");
	private JTextField pass1text = new JTextField();

	private JLabel pass2 = new JLabel("RE-PASSWORD");
	private JTextField pass2text = new JTextField();

	private JLabel gender = new JLabel("GENDER ");
	private JTextField gendertext = new JTextField();
	
	private JLabel mailid = new JLabel("MAIL-ID ");
	private JTextField mailtext = new JTextField();
	
	private JLabel sub = new JLabel("SUBJECT ");
	private JTextField subtext = new JTextField();
	
	private JButton save = new JButton("SAVE");
	private JButton clear = new JButton("CLEAR");
	private JButton back = new JButton("BACK");
	private JButton save2 = new JButton("SAVE");
	private JButton back2 = new JButton("BACK");
	private JLabel d = new JLabel();
	String updateid;
	Connection con;
	Statement stm ;
	boolean rs;

	
	public Teacherupdate(String a)
	{
		this.updateid = a;
		this.setBounds(20,30,720,480);
		this.setTitle("TEACHER REGISTRATION");
        this.setLayout(null);
		createregp();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR");
    	}
        this.setBackground(Color.GRAY);
        this.setVisible(true);
	}
	private void createregp()
	{
		createregp.setLayout(null);
		createregp.setBounds(0,0,720,600);
		loginid.setBounds(20,30,80,20);
		createregp.add(loginid);
		logintext.setBounds(120,30,120,20);
		logintext.setText("T-");
		createregp.add(logintext);
		firstname.setBounds(20,60,80,20);
		createregp.add(firstname);
		fntext.setBounds(120,60,120,20);
		createregp.add(fntext);
		lastname.setBounds(20,90,80,20);
		createregp.add(lastname);
		lntext.setBounds(120,90,120,20);
		createregp.add(lntext);
		pass1.setBounds(20,120,80,20);
		createregp.add(pass1);
		pass1text.setBounds(120,120,120,20);
		createregp.add(pass1text);
		pass2.setBounds(20,150,110,20);
		createregp.add(pass2);
		pass2text.setBounds(120,150,120,20);
		createregp.add(pass2text);
		gender.setBounds(20,180,80,20);
		createregp.add(gender);
		gendertext.setBounds(120,180,120,20);
		createregp.add(gendertext);
		mailid.setBounds(20,210,80,20);
		createregp.add(mailid);
		mailtext.setBounds(120,210,120,20);
		createregp.add(mailtext);
		sub.setBounds(20,240,80,20);
		createregp.add(sub);
		subtext.setBounds(120,240,120,20);
		createregp.add(subtext);		
		clear.setBounds(50,300,90,30);
		createregp.add(clear);
		this.clear.addActionListener(this);
		save.setBounds(150,300,90,30);
		createregp.add(save);
		this.save.addActionListener(this);
		back.setBounds(50,340,190,30);
		createregp.add(back);
		this.back.addActionListener(this);
		createregp.setBackground(Color.GRAY);
		this.add(createregp);
	}
	private void cleartext()
	{
		logintext.setText(null);
		fntext.setText(null);
		lntext.setText(null);
		pass1text.setText(null);
		pass2text.setText(null);
		gendertext.setText(null);
		mailtext.setText(null);
		subtext.setText(null);
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		if(src == back)
		{
			this.setVisible(false);
			new Admin1st().createpage2teacher();
		}
		else if(src == save)
		{
			try
	    	{
	    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
	    		stm = con.createStatement();
	    		//String tidd = tidt.getText();
	    		String s = "UPDATE teacherreg SET Tid='"+logintext.getText()+"',Fname='"+fntext.getText()+"',Lname='"+lntext.getText()+"',Password='"+pass1text.getText()+"',RePassword='"+pass2text.getText()+"',Gender='"+gendertext.getText()+"',MailId='"+mailtext.getText()+"',Subject='"+subtext.getText()+"' WHERE Tid='"+updateid+"'";
	    		rs = stm.execute(s);
	    		JOptionPane.showMessageDialog(null, "Successfuly Updated '"+updateid+"'");

	    	}
	    	catch(Exception e2)
	    	{
	    		e2.printStackTrace();
	    		JOptionPane.showMessageDialog(null, "ERROR");
	    	}
		}
		else if(src == clear)
		{
			cleartext();
		}
	}
	
}