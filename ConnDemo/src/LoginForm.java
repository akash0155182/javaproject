import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm
{   
    public static void main(String[] args) throws Exception 
    {
        LoginForm.login();
    }   
    public static  void Message()
    {
        JFrame f=new JFrame("LoginPage");
        f.getContentPane().setBackground(Color.red);
        JLabel l= new JLabel();
        l.setBounds(100,25,200,30);
        l.setText("Logged in successfullycongrats!!");
        l.setForeground(Color.yellow);
        f.add(l);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static  void register()
    {
        
    	JFrame f=new JFrame("LoginPage");
        JTextField tf3=new JTextField();
        JTextField tf4=new JTextField();
        JTextField email=new JTextField();
        JTextField phoneno=new JTextField();
        JTextField address=new JTextField();
        JButton d=new JButton("register");
        d.setBackground(Color.green);
        JLabel label1 = new JLabel("USERNAME");
        label1.setFont(new Font("verdana",Font.PLAIN,18));
        JLabel label2 = new JLabel("PASSWORD");
        label2.setFont(new Font("verdana",Font.PLAIN,18));
        JLabel label3 = new JLabel("EMAIL");
        label3.setFont(new Font("verdana",Font.PLAIN,18));
        JLabel label4 = new JLabel("PHONENO");
        label4.setFont(new Font("verdana",Font.PLAIN,18));
        JLabel label5 = new JLabel("ADDRESS");
        label5.setFont(new Font("verdana",Font.PLAIN,18));
        label1.setBounds(80,100,130,40);
        label2.setBounds(80,150,150,40);
        label3.setBounds(80,200,150,40);
        label4.setBounds(80,250,150,40);
        label5.setBounds(80,300,150,40);
        JLabel l=new JLabel();
        l.setBounds(70,20,250,30);
        d.setBounds(200,350,150,40);
        tf3.setBounds(200,100,150,40);
        tf4.setBounds(200,150,150,40);
        email.setBounds(200,200,150,40);
        phoneno.setBounds(200,250,150,40);
        address.setBounds(200,300,150,40);
        d.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   try{
            	 String url ="jdbc:mysql://localhost:3306/emp";
         	    String uname="root";
         	    String pass="1234";
         	    String query="insert into student3(username,password,email,phoneno,address) values(?,?,?,?,?)";
         	    Class.forName("com.mysql.cj.jdbc.Driver");
         		Connection con= DriverManager.getConnection(url,uname,pass);
         		PreparedStatement ps = con.prepareStatement(query);
         		ps.setString(1,tf3.getText());
         		ps.setString(2,tf4.getText());
         		ps.setString(3,email.getText());
         		ps.setString(4,phoneno.getText());
         		ps.setString(5,address.getText());
         		int count=ps.executeUpdate();
         		l.setText("signup successfully");
         		l.setForeground(Color.green);
         		ps.close();
         		con.close();
         		LoginForm.login();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            }
        });
        
        f.add(tf3);
        f.add(tf4);
        f.add(email);
        f.add(phoneno);
        f.add(address);
        f.add(d);
        f.add(l);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void login()throws Exception
    {
        JFrame f=new JFrame("LoginPage");
        
        JTextField tf1=new JTextField("username");
        JTextField tf2=new JTextField("password");
        
        JButton c=new JButton("sign up");
        c.setBounds(165,430,130,40);
        c.setBackground(Color.yellow);
        JButton b=new JButton("log in");
        JLabel l= new JLabel();
        l.setBounds(70,20,250,30);
        b.setBounds(295,430,150,40);
        b.setBackground(Color.green);
        tf1.setBounds(210,250,200,35);
        tf1.setBackground(Color.gray);
        tf1.setForeground(Color.cyan);
        tf2.setBounds(210,305,200,37);
        tf2.setForeground(Color.cyan);
        tf2.setBackground(Color.gray);
        
        c.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   try{
            	LoginForm.register();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            }
        });
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   try
                {
            	String url ="jdbc:mysql://localhost:3306/emp";
        	    String uname="root";
        	    String pass="1234";
        	    String query="select * from student3 where username='"+tf1.getText()+"'and password='"+tf2.getText()+"'";    
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		Connection con= DriverManager.getConnection(url,uname,pass);
        		Statement st = con.createStatement();
        		ResultSet rs= st.executeQuery(query);
         		
        	       if(rs.next())
        			{
        				LoginForm.Message();
        				f.dispose();
        			}
        	       else
                   {
                        l.setText("invalid creadentials.Try again");
                        l.setForeground(Color.red);
                   }   
        		st.close();
        		con.close();
                }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
            }
        });
        f.add(tf1);
        f.add(tf2);
        f.add(b);
        f.add(c);
        f.add(l);
        
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}




