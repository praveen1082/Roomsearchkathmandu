import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

class room_info {
    String location,price,noofrooms,name,description,available;
    public void set(String location,String price,String noofrooms,String name,String description,String available){
        this.location = location; 
        this.price=price;
        this.noofrooms = noofrooms;
        this.name = name;
        this.description = description;
        this.available = available;
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
    public String getavailable() {
    	return available;
    }
}

public class userDemo extends JFrame{
		JButton search;
		JTextField searchtxt;
		JPanel jp1,jp2;
		JLabel lbl[] = new JLabel[3];
		JLabel lbla[] = new JLabel[3];
		JLabel lblb[] = new JLabel[3];
		JLabel lblc[] = new JLabel[3];
		JLabel lbld[] = new JLabel[3];
		JLabel lble[] = new JLabel[3];
		JButton Book[]= new JButton[3];
		JButton Next = new JButton("Next");
		int i = 0,j=0;
		room_info rr;
		ArrayList<room_info> rlist = new ArrayList<room_info>();
		public userDemo(){
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
			JPanel jp2a = new JPanel();
			JPanel jp2b = new JPanel();
			JPanel jp2c = new JPanel();
			search.setFont(new Font("Open Sans", Font.BOLD + Font.ITALIC, 12));
			searchtxt.setFont(new Font("Open Sans", Font.BOLD + Font.ITALIC, 12));
			jp1.add(searchtxt);
			searchtxt.setBounds(30, 20, 240, 25);
			search.setBounds(280, 20, 80, 25);
			jp1.add(search);
			jp1.setLayout(null);
			add(jp1);
			jp2.setBackground(Color.WHITE);
			jp1.setBounds(0,0,400,60);
			jp2.setLayout(new GridLayout(3,1,5,5));
			Next.setFont(new Font("Open Sans", Font.BOLD + Font.ITALIC, 12));
			jp2a.setLayout(null);
			jp2b.setLayout(null);
			jp2c.setLayout(null);
			Color col = new Color(250, 250, 250);
			jp2a.setBackground(col);
			jp2b.setBackground(col);
			jp2c.setBackground(col);
			jp2.setBounds(20,60,355,470);
			setVisible(true);
			//DefaultListModel dlm = new DefaultListModel();
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rooms","root","");
				PreparedStatement pstmt = conn.prepareStatement("select name,price,location,description,noofrooms,avstatus from rooms_info");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					room_info r = new room_info();
					r.set(rs.getString(3),rs.getString(2),rs.getString(5),rs.getString(1),rs.getString(4),rs.getString(6));
					rlist.add(r);
					System.out.println(r.getname());
				}
			}catch(SQLException sc) {
				System.out.println(sc.getMessage());
			}
			room_info rr;
			for(int a = 0;a<3;a++) {
					 lbl[a]=new JLabel("");
					 lbla[a]=new JLabel("");
					 lblb[a]=new JLabel("");
					 lblc[a] = new JLabel("");
					 lbld[a]= new JLabel("");
					 lble[a] = new JLabel("");
					 Book[a] = new JButton("Book");
					 lbla[a].setForeground(Color.GRAY);
					 Book[a].setBackground(Color.GRAY);
					 Book[a].setForeground(Color.WHITE);
					 lbl[a].setForeground(Color.GRAY);
					 lblb[a].setForeground(Color.GRAY);
					 lblc[a].setForeground(Color.GRAY);
					 lbld[a].setForeground(Color.GRAY);
					 lble[a].setForeground(Color.GRAY);
					 lbl[a].setFont(new Font("Open Sans", Font.BOLD + Font.ITALIC, 16));
					 lbla[a].setFont(new Font("Open Sans", Font.BOLD, 12));
					 lblb[a].setFont(new Font("Open Sans", Font.BOLD, 12));
					 lblc[a].setFont(new Font("Open Sans",Font.BOLD,12));
					 lbld[a].setFont(new Font("Open Sans", Font.BOLD, 12));
					 lble[a].setFont(new Font("Open Sans", Font.BOLD, 11));
					 lbl[a].setBounds(20,10,300,20);
					 lbla[a].setBounds(20,40,140,20);
					 lblb[a].setBounds(100,40,195,20);
					 lblc[a].setBounds(260,40,100,20);
					 lbld[a].setBounds(20,60,150,20);
					 lble[a].setBounds(10,70,330,40);
					 Book[a].setBounds(138,120,80,30);
					 
				 
			}
			jp2a.add(lbl[0]);
			jp2b.add(lbl[1]);
			jp2c.add(lbl[2]);
			jp2a.add(lbla[0]);
			jp2b.add(lbla[1]);
			jp2c.add(lbla[2]);
			jp2a.add(lblb[0]);
			jp2b.add(lblb[1]);
			jp2c.add(lblb[2]);
			jp2a.add(lblc[0]);
			jp2b.add(lblc[1]);
			jp2c.add(lblc[2]);
			jp2a.add(lbld[0]);
			jp2b.add(lbld[1]);
			jp2c.add(lbld[2]);
			jp2a.add(lble[0]);
			jp2b.add(lble[1]);
			jp2c.add(lble[2]);
			jp2a.add(Book[0]);
			jp2b.add(Book[1]);
			jp2c.add(Book[2]);
			jp2.add(jp2a);
			jp2.add(jp2b);
			jp2.add(jp2c);
			add(jp2);

			abatawmilnayaar(j);
			if(rlist.size()>3) {
				add(Next);
				Next.setBounds(295,535,80,25);
				}
				Next.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						if(j==(rlist.size())-3) {
							Next.setEnabled(false);
						}else {
							j++;
							abatawmilnayaar(j);
						}
					}
				});
			}
			
		public void abatawmilnayaar(int j) {
			this.j = j;
			System.out.println(j);
			for(i=j;i<=j;i++) {
				rr = rlist.get(i);
				lbl[0].setText(capitalize(rr.getname()));
				lbla[0].setText(" Price : "+rr.getprice()+"  ");
				lblb[0].setText("|  Location : "+rr.getlocation()+"  ");
				lblc[0].setText("|  Rooms : "+rr.getnoofrooms()+"  ");
				lbld[0].setText(" Status : "+capitalize(rr.getavailable()));
				lble[0].setText(" Description : "+rr.getdescription());
				rr = rlist.get(i+1);
				lbl[1].setText(capitalize(rr.getname()));
				lbla[1].setText(" Price : "+rr.getprice()+"  ");
				lblb[1].setText("|  Location : "+rr.getlocation()+"  ");
				lblc[1].setText("|  Rooms : "+rr.getnoofrooms()+"  ");
				lbld[1].setText(" Status : "+capitalize(rr.getavailable()));
				lble[1].setText(" Description : "+rr.getdescription());
				rr = rlist.get(i+2);
				lbl[2].setText(capitalize(rr.getname()));
				lbla[2].setText(" Price : "+rr.getprice()+"  ");
				lblb[2].setText("|  Location : "+rr.getlocation()+"  ");
				lblc[2].setText("|  Rooms : "+rr.getnoofrooms()+"  ");
				lbld[2].setText(" Status : "+capitalize(rr.getavailable()));
				lble[2].setText(" Description : "+rr.getdescription());
				j++;
				i = j;
			}
		}
		public String capitalize(String str) {
		    if(str == null || str.isEmpty()) {
		        return str;
		    }

		    return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		public static void main (String args[]) {
			userDemo ud = new userDemo();
		}
	}
