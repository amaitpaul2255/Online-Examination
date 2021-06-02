import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.*;
import java.sql.*;

public class SelectQuestion extends JFrame implements ActionListener
{
	private JLabel question = new JLabel("QUESTION'S ");
	private JComboBox<String> questiontext = new JComboBox();
	private JPanel questionpanel = new JPanel();
	private JButton selectb = new JButton("SELECT ");
	private JButton backb = new JButton("BACK");
	private JButton logout = new JButton("LOGOUT ");

	private String question1;
	Connection con;
	Statement stm ;
	ResultSet rs;
	static String questions;
	String teacher;
	
	public SelectQuestion(String teacher)
	{
		this.teacher = teacher;
		this.setBounds(20,30,720,280);
		this.setTitle("QUESTION");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
		createregp();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        try
    	{
    		con = DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
    		stm = con.createStatement();
    		String s = "select Questionname from teachersquestion where Tname = '"+teacher+"'";
    		rs = stm.executeQuery(s);
    		while(rs.next()) {
    			questiontext.addItem(rs.getString(1));
    		}
      	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "ERROR");
    	}finally {
    		 try
    	        {
    	        stm.close();
    	        rs.close();
    	        con.close();
    	        }
    	        catch(Exception e)
    	        {
    	        	e.printStackTrace();
    	        	JOptionPane.showMessageDialog(null, "ERROR CLOSE");
    	        }
    		 questionpanel.add(questiontext);
    		 this.getContentPane().add(questionpanel);
    	        this.setVisible(true);
    		}
	}
	private void createregp()
	{
		questionpanel.setLayout(null);
		questionpanel.setBounds(0,0,720,280);
		question.setBounds(20,30,90,20);
		questionpanel.add(question);
		questiontext.setBounds(110,30,250,20);
		questionpanel.add(questiontext);
		logout.setBounds(600,10,100,30);
		logout.setBackground(Color.PINK);
		this.logout.addActionListener(this);
		questionpanel.add(logout);
		selectb.setBounds(180,60,100,30);
		questionpanel.add(selectb);
		this.selectb.addActionListener(this);
		backb.setBounds(180,100,100,30);
		questionpanel.add(backb);
		questionpanel.setBackground(Color.GRAY);
		this.backb.addActionListener(this);
		this.add(questionpanel);
	}
	public void actionPerformed(ActionEvent e)
    {
		Object src = e.getSource();
		
		if(src == selectb)
		{
			this.setVisible(false);
			System.out.println("Succesful work select question");
			System.out.println("Now here is the question");
			this.questions=(String) questiontext.getSelectedItem();
			System.out.println("selected question is "+questions);
			new Question(questions);

			//go to selected question to give exam
		}
		else if(src == backb)
		{
			this.setVisible(false);
			new UserSubject();

			//go to selected question to give exam
		}
    }
	/*public static void main(String[] args)
	{
		SelectQuestion obj = new SelectQuestion(questions);
	}*/
	

}
