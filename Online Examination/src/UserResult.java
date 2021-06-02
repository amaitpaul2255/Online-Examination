import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.*;

public class UserResult extends JFrame implements ActionListener
{
	private JButton exit = new JButton("EXIT");
	private JPanel resultp = new JPanel();
	private JLabel resultl = new JLabel("Your Mark's For This Exam Is : ");
	
	public UserResult() 
	{
		this.setBounds(20,30,720,720);
		this.setTitle("EXAMINATION RESULT ");
        this.setLayout(null);
		create();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        this.setVisible(true);
	}
	private void create()
	{
		resultp.setLayout(null);
		resultp.setBounds(0,0,720,720);
		resultl.setBounds(50,40,600,30);
		//resultl.setText("");//add the number here of the exam
		resultp.add(resultl);
		exit.setBounds(70,80,90,20);
		resultp.add(exit);
		this.exit.addActionListener(this);

		this.add(resultp);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	public static void main(String[] args)
	{
		UserResult obj = new UserResult();
	}
}
