import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;

public class room_info {
    String location,price,noofrooms,name,description;
    public void set(String location,String price,String noofrooms,String name,String description){
        this.location = location; 
        this.price=price;
        this.noofrooms = noofrooms;
        this.name = name;
        this.description = description;
    }
    public String getlocation(){
        return location;
    }
    public String getprice(){
        return price;
    }
    public String getnoofrooms(){
        return noofrooms;
    }
    public String getname() {
    	return name;
    }
    public String getdescription() {
    	return description;
    }
}

public class userDemo extends JFrame{
		JButton search;
		JTextField searchtxt;
		JPanel jp1,jp2;
		int i = 0;
		userDemo(){
			//setSize(500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setResizable(false);
			setBounds(450,80,400,600);
			setTitle("Search rooms near you");
			
			search = new JButton("Search");
			searchtxt = new JTextField(20);
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp1.add(searchtxt);
			searchtxt.setBounds(30, 20, 240, 25);
			search.setBounds(280, 20, 80, 25);
			jp1.add(search);
			jp1.setLayout(null);
			jp1.setBounds(0,0,400,60);
			add(jp1);
			jp2.setLayout(new GridLayout(5,1));
			jp2.setBackground(Color.WHITE);
			jp2.setBounds(20,30,355,520);
			//DefaultListModel dlm = new DefaultListModel();
			ArrayList<room_info> rlist = new ArrayList<room_info>();
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rooms","root","");
				PreparedStatement pstmt = conn.prepareStatement("select name,price,location,description,noofrooms from rooms_info");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					rate r = new room_info();
					r.set(rs.getString(3),rs.getString(2),rs.getInt(5),rs.getString(1),rs.getString(4));
					rlist.add(r);
				}
			}catch(SQLException sc) {
				System.out.println(sc.getMessage());
			}
			add(jp2);
			setVisible(true);
		}
		public static void main (String args[]) {
			new userDemo();
		}
	}