import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Admin1st extends JFrame implements ActionListener
{

	JButton teacherb = new JButton("UPDATE/DELETE ");
	JButton studentb = new JButton("UPDATE/DELETE ");
	JButton addt = new JButton("ADD ");
	JButton adds = new JButton("ADD ");
	JPanel step1 = new JPanel();
	JPanel step2 = new JPanel();
	JPanel step3 = new JPanel();
	
	JLabel tid = new JLabel("TEACHER-ID");
	JLabel sid = new JLabel("STUDENT-ID");
	JLabel teacher = new JLabel("TEACHER "); 
	JLabel student = new JLabel("STUDENT ");
	JTextField tidt = new JTextField();
	JTextField sidt = new JTextField();
	JButton tupdate = new JButton("UPADTE ");
	JButton supdate = new JButton("UPDATE ");
	JButton tdelete = new JButton("DELETE ");
	JButton sdelete = new JButton("DELETE ");
	JButton back = new JButton("BACK ");
	JButton back2 = new JButton("BACK ");
	JButton back3 = new JButton("BACK ");
	JButton logout = new JButton("LOGOUT ");
	Connection con;
	Statement stm ;
	boolean rs;
	String selectq;

	

	
	public Admin1st()
	{
		this.setTitle("ADMINISTRATOR PANEL");
        this.setBounds(20,30,620,400);
    	createpage();
        this.setLayout(null);
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
        this.setVisible(true);
	}
	private void createpage()
	{
		step1.setLayout(null);
		step1.setBounds(0,0,620,400);
		step1.setBackground(Color.GRAY);
		teacher.setBounds(100,100,100,20);
		step1.add(teacher);
		teacherb.setBounds(200, 100, 160, 20);
		step1.add(teacherb);
		this.teacherb.addActionListener(this);
		addt.setBounds(380, 100, 120, 20);
		step1.add(addt);
		this.addt.addActionListener(this);
		student.setBounds(100,150,100,20);
		step1.add(student);
		studentb.setBounds(200, 150, 160, 20);
		step1.add(studentb);
		this.studentb.addActionListener(this);
		adds.setBounds(380, 150, 120, 20);
		step1.add(adds);
		this.adds.addActionListener(this);
		back3.setBounds(500,250,90,30);
		step1.add(back3);
		this.back3.addActionListener(this);
		logout.setBounds(500, 20, 100, 30);
		step1.add(logout);
		logout.setBackground(Color.PINK);
		this.logout.addActionListener(this);
		this.add(step1);
	}
	public void createpage2teacher()
	{
		step2.setLayout(null);
		step2.setBounds(0,0,620,400);
		step2.setBackground(Color.GRAY);
		
		tid.setBounds(20,40,120,20);
		step2.add(tid);
		tidt.setBounds(160,40,120,20);
		step2.add(tidt);
		tupdate.setBounds(320,40, 100,20);
		step2.add(tupdate);
		this.tupdate.addActionListener(this);
		tdelete.setBounds(440,40, 100,20);
		step2.add(tdelete);
		this.tdelete.addActionListener(this);
		
		back.setBounds(440,120,100,20);
		step2.add(back);
		this.back.addActionListener(this);
		this.add(step2);
	}
	public void createpage2student()
	{
		step3.setLayout(null);
		step3.setBounds(0,0,620,400);
		step3.setBackground(Color.GRAY);

		sid.setBounds(20,80,120,20);
		step3.add(sid);
		sidt.setBounds(160,80,120,20);
		step3.add(sidt);
		supdate.setBounds(320,80, 100,20);
		step3.add(supdate);
		this.supdate.addActionListener(this);
		sdelete.setBounds(440,80, 100,20);
		step3.add(sdelete);
		this.sdelete.addActionListener(this);
		
		back2.setBounds(440,120,100,20);
		step3.add(back2);
		this.back2.addActionListener(this);
		this.add(step3);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		if(src == teacherb)
		{
			this.remove(step1);
			this.repaint();
			createpage2teacher();
		}
		else if(src == studentb)
		{
			this.remove(step1);
			this.repaint();
			createpage2student();
		}
		else if(src == addt)
		{
			this.setVisible(false);
			new TeacherRegistration(2.0,2);		
		}
		else if(src == adds)
		{
			this.setVisible(false);
			new UserRegistration(2.0,2);
		}
		else if(src == back)
		{
			//this.setVisible(false);
			this.remove(step2);
			this.add(step1);
			this.repaint();
			createpage();	
		}
		else if(src == back2)
		{
			//this.setVisible(false);
			this.remove(step3);
			this.add(step1);
			this.repaint();
			createpage();	
		}
		else if(src == back3)
		{
			//this.setVisible(false);
			this.repaint();
			new SelectFirst().adminpanel();	
			this.repaint();
		}
		else if(src == tupdate)
		{
			this.setVisible(false);
			new Teacherupdate(tidt.getText());
			
			//by searching the teacher id find the teacher 
			//give all value of the teacher into the box and press done button to update the teacher bio.
			
		}
		else if(src == tdelete)
		{
			try
	    	{
	    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
	    		stm = con.createStatement();
	    		String tidd = tidt.getText();
	    		String s = "delete from teacherreg where Tid='"+tidd+"'";
	    		rs = stm.execute(s);
	    		JOptionPane.showMessageDialog(null, "Successfuly Deleted '"+tidd+"'");

	    	}
	    	catch(Exception e2)
	    	{
	    		e2.printStackTrace();
	    		JOptionPane.showMessageDialog(null, "ERROR");
	    	}
		}
		else if(src == supdate)
		{
			this.setVisible(false);
			new Studentupdate(sidt.getText());
			
			//by searching the student id find the student 
			//give all value of the student into the box and press done button to update the student bio.
		}
		else if(src == sdelete)
		{
			try
	    	{
	    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
	    		stm = con.createStatement();
	    		String sidd = sidt.getText();
	    		String s = "delete from studentreg where Sid='"+sidd+"'";
	    		rs = stm.execute(s);
	    		JOptionPane.showMessageDialog(null, "Successfuly Deleted '"+sidd+"'");

	    	}
	    	catch(Exception e2)
	    	{
	    		e2.printStackTrace();
	    		JOptionPane.showMessageDialog(null, "ERROR");
	    	}
		}

	}
	/*public static void main(String[] args)
	{
		new Admin1st();
	}*/

}
