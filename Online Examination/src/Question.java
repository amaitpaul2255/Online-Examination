import javax.swing.*;
import java.sql.*;
//import javax.swing.Color;

import java.awt.event.*;
import java.awt.*;
import java.*;
import java.sql.*;

public class Question extends JFrame implements ActionListener
{
	private JPanel downpanel = new JPanel();
	int count =1;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();

	private JButton back = new JButton("BACK ");
	private JButton next = new JButton("NEXT ");
	private JButton submit = new JButton("SUBMIT ");
	
	private JRadioButton b1 = new JRadioButton();
	private JRadioButton b2 = new JRadioButton();
	private JRadioButton b3 = new JRadioButton();
	private JRadioButton b4 = new JRadioButton();
	
	private JRadioButton b5 = new JRadioButton();
	private JRadioButton b6 = new JRadioButton();
	private JRadioButton b7 = new JRadioButton();
	private JRadioButton b8 = new JRadioButton();
	
	private JRadioButton b9 = new JRadioButton();
	private JRadioButton b10 = new JRadioButton();
	private JRadioButton b11 = new JRadioButton();
	private JRadioButton b12 = new JRadioButton();
	
	private JRadioButton b13 = new JRadioButton();
	private JRadioButton b14 = new JRadioButton();
	private JRadioButton b15 = new JRadioButton();
	private JRadioButton b16 = new JRadioButton();
	
	private JRadioButton b17 = new JRadioButton();
	private JRadioButton b18 = new JRadioButton();
	private JRadioButton b19 = new JRadioButton();
	private JRadioButton b20 = new JRadioButton();
	
	private JRadioButton b21 = new JRadioButton();
	private JRadioButton b22 = new JRadioButton();
	private JRadioButton b23 = new JRadioButton();
	private JRadioButton b24 = new JRadioButton();
	
	private JRadioButton b25 = new JRadioButton();
	private JRadioButton b26 = new JRadioButton();
	private JRadioButton b27 = new JRadioButton();
	private JRadioButton b28 = new JRadioButton();
	
	private JRadioButton b29 = new JRadioButton();
	private JRadioButton b30 = new JRadioButton();
	private JRadioButton b31 = new JRadioButton();
	private JRadioButton b32 = new JRadioButton();
	
	private JRadioButton b33 = new JRadioButton();
	private JRadioButton b34 = new JRadioButton();
	private JRadioButton b35 = new JRadioButton();
	private JRadioButton b36 = new JRadioButton();
	
	private JRadioButton b37 = new JRadioButton();
	private JRadioButton b38 = new JRadioButton();
	private JRadioButton b39 = new JRadioButton();
	private JRadioButton b40 = new JRadioButton();
	
	private JLabel q0 = new JLabel();
	private JLabel q1 = new JLabel();
	private JLabel q2 = new JLabel();
	private JLabel q3 = new JLabel();
	private JLabel q4 = new JLabel();
	
	private JLabel q5 = new JLabel();
	private JLabel q6 = new JLabel();
	private JLabel q7 = new JLabel();
	private JLabel q8 = new JLabel();
	private JLabel q9 = new JLabel();
	
	
	Connection con;
	Statement stm ;
	ResultSet rs4;
	
	String selectedquestion;

	public Question(String questions)
	{
		this.setBounds(20,30,720,630);
		this.setTitle("QUESTION");
        this.setLayout(null);
        this.selectedquestion = questions;
		this.setBackground(Color.PINK);
		createpage();
		panel1();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    		System.out.println("connected"+con);
    		      		
      	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR");
    	}
        this.setVisible(true);
	}
	public void createpage()
	{
		downpanel.setLayout(null);
		downpanel.setBounds(0,500,720,220);
		downpanel.setBackground(Color.GRAY);
		back.setBounds(390,30,90,45);
    	this.back.addActionListener(this);

		downpanel.add(back);
		next.setBounds(490,30,90,45);
		this.next.addActionListener(this);

		downpanel.add(next);
		submit.setBounds(590,30,90,45);
		downpanel.add(submit);
		this.submit.addActionListener(this);
		this.add(downpanel);
	}
	public void panel1()
	{
		panel1.setLayout(null);
		panel1.setBounds(0,0,720,500);
		panel1.setBackground(Color.LIGHT_GRAY);
		this.repaint();
		//q1.setBounds(20,30,600,30);
		try
    	{
			panel1.setLayout(null);
			panel1.setBounds(0,0,720,500);
    		try
        	{
        		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
        		stm = con.createStatement();
        		String s1 = "select * from "+selectedquestion+" where number = '1'";
        		ResultSet rs4 =  stm.executeQuery(s1);
        		rs4.next();
        		q0.setBounds(20,30,600,30);
        		q0.setText("Q-1: "+rs4.getString("question")+" ");
        		String o1 = rs4.getString("option1");
        		b1.setBounds(50,65+20,20,20);
        		panel1.add(b1);
        		q1.setBounds(80,60+20,600,30);
        		q1.setText(o1);
        		b2.setBounds(50,95+20,20,20);
        		panel1.add(b2);
        		String o2 = rs4.getString("option2");
        		q2.setBounds(80,90+20,600,30);
        		q2.setText(o2);
        		b3.setBounds(50,125+20,20,20);
        		panel1.add(b3);
        		String o3 = rs4.getString("option3");
        		q3.setBounds(80,120+20,600,30);
        		q3.setText(o3);
        		b4.setBounds(50,155+20,20,20);
        		panel1.add(b4);
        		String o4 = rs4.getString("option4");
        		q4.setBounds(80,150+20,600,30);
        		q4.setText(o4);
            	panel1.add(q0);
            	panel1.add(q1);
            	panel1.add(q2);
            	panel1.add(q3);
            	panel1.add(q4);
            	this.repaint();
            	////////////////////////////////////
            	String s2 = "select * from "+selectedquestion+" where number = '2'";
        		ResultSet rs3 =  stm.executeQuery(s2);
        		rs3.next();
        		q5.setBounds(20,150+30+30,600,30);
        		q5.setText("Q-2: "+rs3.getString("question")+" ");
        		String o5 = rs3.getString("option1");
        		b5.setBounds(50,150+65+50,20,20);
        		panel1.add(b5);
        		q6.setBounds(80,150+60+50,600,30);
        		q6.setText(o5);
        		b6.setBounds(50,150+95+50,20,20);
        		panel1.add(b6);
        		String o6 = rs3.getString("option2");
        		q7.setBounds(80,150+90+50,600,30);
        		q7.setText(o6);
        		b7.setBounds(50,150+125+50,20,20);
        		panel1.add(b7);
        		String o7 = rs3.getString("option3");
        		q8.setBounds(80,150+120+50,600,30);
        		q8.setText(o7);
        		b8.setBounds(50,150+155+50,20,20);
        		panel1.add(b8);
        		String o8 = rs3.getString("option4");
        		q9.setBounds(80,150+150+50,600,30);
        		q9.setText(o8);
            	panel1.add(q5);
            	panel1.add(q6);
            	panel1.add(q7);
            	panel1.add(q8);
            	panel1.add(q9);
            	this.repaint();
            	this.add(panel1);       		
          	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		JOptionPane.showMessageDialog(null, "ERROR");
        	}
      	}
    	catch(Exception e2)
    	{
    		e2.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR sql");
    	}	
	}
	public void panel2()
	{
		panel2.setLayout(null);
		panel2.setBounds(0,0,720,500);
		panel2.setBackground(Color.LIGHT_GRAY);
		this.repaint();
		//q1.setBounds(20,30,600,30);
		try
    	{
			panel2.setLayout(null);
			panel2.setBounds(0,0,720,500);
    		try
        	{
        		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
        		stm = con.createStatement();
        		String s1 = "select * from "+selectedquestion+" where number = '3'";
        		ResultSet rs4 =  stm.executeQuery(s1);
        		rs4.next();
        		q0.setBounds(20,30,600,30);
        		q0.setText("Q-3: "+rs4.getString("question")+" ");
        		String o1 = rs4.getString("option1");
        		b9.setBounds(50,65+20,20,20);
        		panel2.add(b9);
        		q1.setBounds(80,60+20,600,30);
        		q1.setText(o1);
        		b10.setBounds(50,95+20,20,20);
        		panel2.add(b10);
        		String o2 = rs4.getString("option2");
        		q2.setBounds(80,90+20,600,30);
        		q2.setText(o2);
        		b11.setBounds(50,125+20,20,20);
        		panel2.add(b11);
        		String o3 = rs4.getString("option3");
        		q3.setBounds(80,120+20,600,30);
        		q3.setText(o3);
        		b12.setBounds(50,155+20,20,20);
        		panel2.add(b12);
        		String o4 = rs4.getString("option4");
        		q4.setBounds(80,150+20,600,30);
        		q4.setText(o4);
        		panel2.add(q0);
        		panel2.add(q1);
        		panel2.add(q2);
        		panel2.add(q3);
        		panel2.add(q4);
            	this.repaint();
            	////////////////////////////////////
            	String s2 = "select * from "+selectedquestion+" where number = '4'";
        		ResultSet rs3 =  stm.executeQuery(s2);
        		rs3.next();
        		q5.setBounds(20,150+30+30,600,30);
        		q5.setText("Q-4: "+rs3.getString("question")+" ");
        		String o5 = rs3.getString("option1");
        		b13.setBounds(50,150+65+50,20,20);
        		panel2.add(b13);
        		q6.setBounds(80,150+60+50,600,30);
        		q6.setText(o5);
        		b14.setBounds(50,150+95+50,20,20);
        		panel2.add(b14);
        		String o6 = rs3.getString("option2");
        		q7.setBounds(80,150+90+50,600,30);
        		q7.setText(o6);
        		b15.setBounds(50,150+125+50,20,20);
        		panel2.add(b15);
        		String o7 = rs3.getString("option3");
        		q8.setBounds(80,150+120+50,600,30);
        		q8.setText(o7);
        		b16.setBounds(50,150+155+50,20,20);
        		panel2.add(b16);
        		String o8 = rs3.getString("option4");
        		q9.setBounds(80,150+150+50,600,30);
        		q9.setText(o8);
        		panel2.add(q5);
        		panel2.add(q6);
        		panel2.add(q7);
            	panel2.add(q8);
            	panel2.add(q9);
            	this.repaint();
            	this.add(panel2);       		
          	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		JOptionPane.showMessageDialog(null, "ERROR");
        	}
      	}
    	catch(Exception e2)
    	{
    		e2.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR sql");
    	}		
	}
	public void panel3()
	{
		panel3.setLayout(null);
		panel3.setBounds(0,0,720,500);
		panel3.setBackground(Color.LIGHT_GRAY);
		this.repaint();
		//q1.setBounds(20,30,600,30);
		try
    	{
			panel3.setLayout(null);
			panel3.setBounds(0,0,720,500);
    		try
        	{
        		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
        		stm = con.createStatement();
        		String s1 = "select * from "+selectedquestion+" where number = '5'";
        		ResultSet rs4 =  stm.executeQuery(s1);
        		rs4.next();
        		q0.setBounds(20,30,600,30);
        		q0.setText("Q-5: "+rs4.getString("question")+" ");
        		String o1 = rs4.getString("option1");
        		b17.setBounds(50,65+20,20,20);
        		panel3.add(b17);
        		q1.setBounds(80,60+20,600,30);
        		q1.setText(o1);
        		b18.setBounds(50,95+20,20,20);
        		panel3.add(b18);
        		String o2 = rs4.getString("option2");
        		q2.setBounds(80,90+20,600,30);
        		q2.setText(o2);
        		b19.setBounds(50,125+20,20,20);
        		panel3.add(b19);
        		String o3 = rs4.getString("option3");
        		q3.setBounds(80,120+20,600,30);
        		q3.setText(o3);
        		b20.setBounds(50,155+20,20,20);
        		panel3.add(b20);
        		String o4 = rs4.getString("option4");
        		q4.setBounds(80,150+20,600,30);
        		q4.setText(o4);
        		panel3.add(q0);
        		panel3.add(q1);
        		panel3.add(q2);
        		panel3.add(q3);
        		panel3.add(q4);
            	this.repaint();
            	////////////////////////////////////
            	String s2 = "select * from "+selectedquestion+" where number = '6'";
        		ResultSet rs3 =  stm.executeQuery(s2);
        		rs3.next();
        		q5.setBounds(20,150+30+30,600,30);
        		q5.setText("Q-6: "+rs3.getString("question")+" ");
        		String o5 = rs3.getString("option1");
        		b21.setBounds(50,150+65+50,20,20);
        		panel3.add(b21);
        		q6.setBounds(80,150+60+50,600,30);
        		q6.setText(o5);
        		b22.setBounds(50,150+95+50,20,20);
        		panel3.add(b22);
        		String o6 = rs3.getString("option2");
        		q7.setBounds(80,150+90+50,600,30);
        		q7.setText(o6);
        		b23.setBounds(50,150+125+50,20,20);
        		panel3.add(b23);
        		String o7 = rs3.getString("option3");
        		q8.setBounds(80,150+120+50,600,30);
        		q8.setText(o7);
        		b24.setBounds(50,150+155+50,20,20);
        		panel3.add(b24);
        		String o8 = rs3.getString("option4");
        		q9.setBounds(80,150+150+50,600,30);
        		q9.setText(o8);
        		panel3.add(q5);
        		panel3.add(q6);
        		panel3.add(q7);
        		panel3.add(q8);
        		panel3.add(q9);
            	this.repaint();
            	this.add(panel3);       		
          	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		JOptionPane.showMessageDialog(null, "ERROR");
        	}
      	}
    	catch(Exception e2)
    	{
    		e2.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR sql");
    	}	
	}
	public void panel4()
	{
		panel4.setLayout(null);
		panel4.setBounds(0,0,720,500);
		panel4.setBackground(Color.LIGHT_GRAY);
		this.repaint();
		//q1.setBounds(20,30,600,30);
		try
    	{
			panel4.setLayout(null);
			panel4.setBounds(0,0,720,500);
    		try
        	{
        		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
        		stm = con.createStatement();
        		String s1 = "select * from "+selectedquestion+" where number = '7'";
        		ResultSet rs4 =  stm.executeQuery(s1);
        		rs4.next();
        		q0.setBounds(20,30,600,30);
        		q0.setText("Q-7: "+rs4.getString("question")+" ");
        		String o1 = rs4.getString("option1");
        		b25.setBounds(50,65+20,20,20);
        		panel4.add(b25);
        		q1.setBounds(80,60+20,600,30);
        		q1.setText(o1);
        		b26.setBounds(50,95+20,20,20);
        		panel4.add(b26);
        		String o2 = rs4.getString("option2");
        		q2.setBounds(80,90+20,600,30);
        		q2.setText(o2);
        		b27.setBounds(50,125+20,20,20);
        		panel4.add(b27);
        		String o3 = rs4.getString("option3");
        		q3.setBounds(80,120+20,600,30);
        		q3.setText(o3);
        		b28.setBounds(50,155+20,20,20);
        		panel4.add(b28);
        		String o4 = rs4.getString("option4");
        		q4.setBounds(80,150+20,600,30);
        		q4.setText(o4);
        		panel4.add(q0);
        		panel4.add(q1);
        		panel4.add(q2);
        		panel4.add(q3);
        		panel4.add(q4);
            	this.repaint();
            	////////////////////////////////////
            	String s2 = "select * from "+selectedquestion+" where number = '8'";
        		ResultSet rs3 =  stm.executeQuery(s2);
        		rs3.next();
        		q5.setBounds(20,150+30+25,600,30);
        		q5.setText("Q-8: "+rs3.getString("question")+" ");
        		String o5 = rs3.getString("option1");
        		b29.setBounds(50,150+65+50,20,20);
        		panel4.add(b29);
        		q6.setBounds(80,150+60+50,600,30);
        		q6.setText(o5);
        		b30.setBounds(50,150+95+50,20,20);
        		panel4.add(b30);
        		String o6 = rs3.getString("option2");
        		q7.setBounds(80,150+90+50,600,30);
        		q7.setText(o6);
        		b31.setBounds(50,150+125+50,20,20);
        		panel4.add(b31);
        		String o7 = rs3.getString("option3");
        		q8.setBounds(80,150+120+50,600,30);
        		q8.setText(o7);
        		b32.setBounds(50,150+155+50,20,20);
        		panel4.add(b32);
        		String o8 = rs3.getString("option4");
        		q9.setBounds(80,150+150+50,600,30);
        		q9.setText(o8);
        		panel4.add(q5);
        		panel4.add(q6);
        		panel4.add(q7);
        		panel4.add(q8);
        		panel4.add(q9);
            	this.repaint();
            	this.add(panel4);       		
          	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		JOptionPane.showMessageDialog(null, "ERROR");
        	}
      	}
    	catch(Exception e2)
    	{
    		e2.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR sql");
    	}
	}
	public void panel5()
	{
		panel5.setLayout(null);
		panel5.setBounds(0,0,720,500);
		panel5.setBackground(Color.LIGHT_GRAY);
		this.repaint();
		//q1.setBounds(20,30,600,30);
		try
    	{
			panel5.setLayout(null);
			panel5.setBounds(0,0,720,500);
    		try
        	{
        		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
        		stm = con.createStatement();
        		String s1 = "select * from "+selectedquestion+" where number = '9'";
        		ResultSet rs4 =  stm.executeQuery(s1);
        		rs4.next();
        		q0.setBounds(20,30,600,30);
        		q0.setText("Q-9: "+rs4.getString("question")+" ");
        		String o1 = rs4.getString("option1");
        		b33.setBounds(50,65+20,20,20);
        		panel5.add(b33);
        		q1.setBounds(80,60+20,600,30);
        		q1.setText(o1);
        		b34.setBounds(50,95+20,20,20);
        		panel5.add(b34);
        		String o2 = rs4.getString("option2");
        		q2.setBounds(80,90+20,600,30);
        		q2.setText(o2);
        		b35.setBounds(50,125+20,20,20);
        		panel5.add(b35);
        		String o3 = rs4.getString("option3");
        		q3.setBounds(80,120+20,600,30);
        		q3.setText(o3);
        		b36.setBounds(50,155+20,20,20);
        		panel5.add(b36);
        		String o4 = rs4.getString("option4");
        		q4.setBounds(80,150+20,600,30);
        		q4.setText(o4);
        		panel5.add(q0);
        		panel5.add(q1);
        		panel5.add(q2);
        		panel5.add(q3);
        		panel5.add(q4);
            	this.repaint();
            	////////////////////////////////////
            	String s2 = "select * from "+selectedquestion+" where number = '10'";
        		ResultSet rs3 =  stm.executeQuery(s2);
        		rs3.next();
        		q5.setBounds(20,150+30+25,600,30);
        		q5.setText("Q-10: "+rs3.getString("question")+" ");
        		String o5 = rs3.getString("option1");
        		b37.setBounds(50,150+65+50,20,20);
        		panel5.add(b37);
        		q6.setBounds(80,150+60+50,600,30);
        		q6.setText(o5);
        		b38.setBounds(50,150+95+50,20,20);
        		panel5.add(b38);
        		String o6 = rs3.getString("option2");
        		q7.setBounds(80,150+90+50,600,30);
        		q7.setText(o6);
        		b39.setBounds(50,150+125+50,20,20);
        		panel5.add(b39);
        		String o7 = rs3.getString("option3");
        		q8.setBounds(80,150+120+50,600,30);
        		q8.setText(o7);
        		b40.setBounds(50,150+155+50,20,20);
        		panel5.add(b40);
        		String o8 = rs3.getString("option4");
        		q9.setBounds(80,150+150+50,600,30);
        		q9.setText(o8);
        		panel5.add(q5);
        		panel5.add(q6);
        		panel5.add(q7);
        		panel5.add(q8);
        		panel5.add(q9);
            	this.repaint();
            	this.add(panel5);       		
          	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		JOptionPane.showMessageDialog(null, "ERROR");
        	}
      	}
    	catch(Exception e2)
    	{
    		e2.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR sql");
    	}
	}
	public void actionPerformed(ActionEvent e) 
	{
		
		Object src = e.getSource();
		
		if (src== back)
		{
			this.setVisible(false);
			new Question(selectedquestion);
			/*count--;
			if(count==1)
			{
				panel2.setVisible(false);
				panel1();
			}
			else if(count==2)
			{
				panel3.setVisible(false);
				panel2();
			}
			else if(count==3)
			{
				panel4.setVisible(false);
				panel3();
			}
			else if(count==4)
			{
				panel5.setVisible(false);
				panel4();
			}
			else if(count <= 0)
			{
				System.out.println("Question Is First");
			}*/
		}
		else if (src== submit)
		{
			this.setVisible(false);
			new Result(7);
		}
		else if (src== next)
		{
			count++;
			if(count==2)
			{
				panel1.setVisible(false);
				panel2();
			}
			else if(count==3)
			{
				panel2.setVisible(false);
				panel3();
			}
			else if(count==4)
			{
				panel3.setVisible(false);
				panel4();
			}
			else if(count==5)
			{
				panel4.setVisible(false);
				panel5();
			}
			else if(count <= 6)
			{
				System.out.println("Question Is Over");
			}
		}
	}
}
