import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.*;
import java.*;

public class TeacherQuestion extends JFrame implements ActionListener
{

	private JPanel qpanel = new JPanel();
	private JPanel qpanel2 = new JPanel();
	
	private JButton back = new JButton("BACK ");
	private JButton logout = new JButton("LOGOUT ");
    private JLabel number = new JLabel("NUMBER ");
	private JLabel question = new JLabel("QUESTION ");
	private JLabel optiona = new JLabel("OPTION A ");
	private JLabel optionb = new JLabel("OPTION B ");
	private JLabel optionc = new JLabel("OPTION C ");
	private JLabel optiond = new JLabel("OPTION D ");
	private JLabel answer = new JLabel("ANSWER ");
	private JLabel heading = new JLabel();
	
	private JButton more = new JButton("MORE ");
	private JButton done = new JButton("DONE ");
	private JButton logout2 = new JButton("LOGOUT ");
	
	private JTextField numbert = new JTextField();
	private JTextField questiont = new JTextField();
	private JTextField optionat = new JTextField();
	private JTextField optionbt = new JTextField();
	private JTextField optionct = new JTextField();
	private JTextField optiondt = new JTextField();
	private JTextField answert = new JTextField();
	Connection con;
	Statement stm ;
	boolean rs;
	String questionname;
	

	
	public TeacherQuestion(String b)
	{
		this.questionname=b;
		this.setBounds(20,30,720,500);
		this.setTitle("TEACHER QUESTION'S SETTING");
        this.setLayout(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    		qupdatepanel();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR");
    	}
        this.setVisible(true);
		
	}
	
	private void qupdatepanel()
	{
		qpanel2.setLayout(null);
		qpanel2.setBounds(0,0,720,500);
		
		heading.setBounds(250,0,300,20);
		heading.setText("You Upading "+questionname+" Question");
		qpanel2.add(heading);
		logout.setBounds(590, 10, 100, 30);
		logout.setBackground(Color.PINK);
		qpanel2.add(logout);
		this.logout.addActionListener(this);
		
		number.setBounds(30,30,80,20);
		qpanel2.add(number);
		numbert.setBounds(120,30,60,20);
		qpanel2.add(numbert);
		
		question.setBounds(30,60,80,20);
		qpanel2.add(question);
		questiont.setBounds(120,60,250,50);
		qpanel2.add(questiont);
		
		optiona.setBounds(30,120,100,20);
		qpanel2.add(optiona);
		optionat.setBounds(120,120,150,20);
		qpanel2.add(optionat);
		
		optionb.setBounds(310,120,80,20);
		qpanel2.add(optionb);
		optionbt.setBounds(380,120,150,20);
		qpanel2.add(optionbt);
		
		optionc.setBounds(30,150,100,20);
		qpanel2.add(optionc);
		optionct.setBounds(120,150,150,20);
		qpanel2.add(optionct);
		
		optiond.setBounds(310,150,80,20);
		qpanel2.add(optiond);
		optiondt.setBounds(380,150,150,20);
		qpanel2.add(optiondt);
		answer.setBounds(30,200,100,20);
		qpanel2.add(answer);
		answert.setBounds(120, 200, 200, 20);
		qpanel2.add(answert);
		
		more.setBounds(120, 250, 100, 30);
		qpanel2.add(more);
		this.more.addActionListener(this);

		done.setBounds(240, 250, 100, 30);
		qpanel2.add(done);
		this.done.addActionListener(this);
		
		back.setBounds(600,300,100,30);
		qpanel2.add(back);
		this.back.addActionListener(this);
		
		this.add(qpanel2);
		
		
	}
	private void cleartext()
	{
		numbert.setText(null);
		questiont.setText(null);
		optionat.setText(null);
		optionbt.setText(null);
		optionct.setText(null);
		optiondt.setText(null);
		answert.setText(null);
	}
	public void actionPerformed(ActionEvent e)
    {
		Object src = e.getSource();
		
		if(src == more)
		{
			if(numbert.getText() != null)
			{
				if(questiont.getText() != null)
				{
					if(optionat.getText() != null)
					{
						if(optionbt.getText() != null)
						{
							if(answert.getText() != null)
							{
								try
								{
									con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
						    		stm = con.createStatement();
									String b = "insert into "+questionname+" values ('"+numbert.getText()+
											"','"+questiont.getText()+"','"+optionat.getText()+"','"+optionbt.getText()+
											"','"+optionct.getText()+"','"+optiondt.getText()+
											"','"+answert.getText()+"')";
				
									rs = stm.execute(b);
									this.setVisible(false);
									new TeacherQuestion(questionname);
									JOptionPane.showMessageDialog(null,"Successfully Inserted Question");
								}
								catch(Exception e4)
								{
									e4.printStackTrace();
									JOptionPane.showMessageDialog(null,"ERROR in sql");

								}
								finally 
								{
						    		 try
						    	        {
						    	        stm.close();
						    	       // rs.close();
						    	        con.close();
						    	        }
						    	        catch(Exception e4)
						    	        {
						    	        	e4.printStackTrace();
						    	        	JOptionPane.showMessageDialog(null, "ERROR CLOSE finaly");
						    	        }
								}
							}
							else
								JOptionPane.showMessageDialog(null,"Option Field Can't Be Null");
						}
						else
							JOptionPane.showMessageDialog(null,"Option Field Can't Be Null");
					}
					else
						JOptionPane.showMessageDialog(null,"Option Field Can't Be Null");
				}
				else
					JOptionPane.showMessageDialog(null,"Question Field Can't Be Null");
			}
			else
				JOptionPane.showMessageDialog(null,"Give Apropiate Number Of The Question");
		}
		else if(src == done)
		{
			if(numbert.getText() != null)
			{
				if(questiont.getText() != null)
				{
					if(optionat.getText() != null)
					{
						if(optionbt.getText() != null)
						{
							if(answert.getText() != null)
							{
								try
								{
									con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
						    		stm = con.createStatement();
									String b = "insert into "+questionname+" values ('"+numbert.getText()+
											"','"+questiont.getText()+"','"+optionat.getText()+"','"+optionbt.getText()+
											"','"+optionct.getText()+"','"+optiondt.getText()+
											"','"+answert.getText()+"')";
				
									rs = stm.execute(b);
									this.remove(qpanel2);
									this.setVisible(false);
									this.repaint();
									new Updateqselect();
									JOptionPane.showMessageDialog(null,"Successfully Inserted Question");
								}
								catch(Exception e4)
								{
									e4.printStackTrace();
									JOptionPane.showMessageDialog(null,"ERROR in sql");

								}
								finally 
								{
						    		 try
						    	        {
						    	        stm.close();
						    	       // rs.close();
						    	        con.close();
						    	        }
						    	        catch(Exception e4)
						    	        {
						    	        	e4.printStackTrace();
						    	        	JOptionPane.showMessageDialog(null, "ERROR CLOSE finaly");
						    	        }
								}								
							}
							else
								JOptionPane.showMessageDialog(null,"Option Field Can't Be Null");
						}
						else
							JOptionPane.showMessageDialog(null,"Option Field Can't Be Null");
					}
					else
						JOptionPane.showMessageDialog(null,"Option Field Can't Be Null");
				}
				else
					JOptionPane.showMessageDialog(null,"Question Field Can't Be Null");
			}
			else
				JOptionPane.showMessageDialog(null,"Give Apropiate Number Of The Question");
			
		}
		else if(src == logout)
		{
			this.setVisible(false);
			new SelectFirst().teacherp();
		}
		else if(src == back)
		{
			this.setVisible(false);
			new Updateqselect();
		}
		
    }
	/*public static void main(String[] args)
	{
		TeacherQuestion obj = new TeacherQuestion("javaquestion1");
	}*/

}
