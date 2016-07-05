package world;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import world.dao.CityDao;
import world.domain.City;
import world.ConnectionManager;



public class MainClass extends JFrame implements ActionListener
{
	
		JFrame f=new JFrame();//creating instance of JFrame  
	    //Initializing Components
	    JLabel lb,lb1,lb2,lb3,lb4,lb5;
	    JTextField tf,tf1,tf2,tf3,tf4,tf5;
	    JButton b,b1,b2,b3;
	    JTable table;
	    CityDao dao=new CityDao();
	    CityTableModel cityTable=new CityTableModel();
	   //Creating Constructor for initializing JFrame components
	    //Create DataBase Connection and Fetching Records
  	  Connection conn = ConnectionManager.connectivity();
	    MainClass() throws ClassNotFoundException, SQLException
	    {  
		    lb = new JLabel("Enter City Name:");
	        lb.setBounds(20,20, 100, 20);
	       	        
	        tf = new JTextField(20);
	        tf.setBounds(130,20,200, 20);     
	        
	        lb1 = new JLabel("ID:");
	        lb1.setBounds(20, 60, 100, 20);
	        
	        tf1 = new JTextField(20);
	        tf1.setBounds(130,60,200, 20);
	        
	         lb2 = new JLabel("City Name :");
	        lb2.setBounds(20,80, 100, 20);
	        
	        tf2 = new JTextField(20);
	        tf2.setBounds(130,80,200, 20);
	          
	        lb3 = new JLabel("Country Code:");
	        lb3.setBounds(20, 100, 100, 20);
	         
	        tf3 = new JTextField(20);
	        tf3.setBounds(130,100,200, 20);
	        
	        lb4 = new JLabel("District :");
	        lb4.setBounds(20,120, 100, 20);
	        
	        tf4 = new JTextField(20);
	        tf4.setBounds(130,120,200, 20);
	        
	        lb5 = new JLabel("Population :");
	        lb5.setBounds(20,140, 100, 20);
	          
	        tf5 = new JTextField(20);
	        tf5.setBounds(130,140,200, 20);
	        
	        
	        b = new JButton("Search");
            b.setBounds(350, 20, 100, 20);
	        b.addActionListener(this);
   	       
	        b3 = new JButton("Delete");
            b3.setBounds(460,20, 100, 20);
	        b3.addActionListener(this);
	        
	        b1 = new JButton("Save");
            b1.setBounds(80,180, 100, 20);
	        b1.addActionListener(this);
	        
	        b2 = new JButton("Update");
            b2.setBounds(180,180, 100, 20);
	        b2.addActionListener(this);
	        
	        table=new JTable();
	        table.setBounds(300,20,200,20);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1000, 1000);
	        setLayout(null);
	        //Add components to the JFrame
	        add(lb);
	        add(tf);
	        add(b);
	        
	        add(lb1);
	        add(tf1);
	        add(lb2);
	        add(tf2);
	        add(lb3);
	        add(tf3);
	        add(lb4);
	        add(tf4);
	        add(lb5);
	        add(tf5);
	        
	        add(b1);
	        add(b2);
	        add(b3);
	     List<City> cities=dao.loadCityName();
   	       
   	        cityTable.setCities(cities);
   	        setLayout(new BorderLayout(4,4));
	        add(scrollPane(cityTable),BorderLayout.SOUTH);
	        setVisible(true);
	     
	        //Set TextField Editable False
	        tf.setEditable(true);    
	        tf1.setEditable(true);    
	        tf2.setEditable(true);
	        tf3.setEditable(true);    
	        tf4.setEditable(true);   
	        tf5.setEditable(true);
	    }
	      public void actionPerformed(ActionEvent e)
	        {
	    	 String action=e.getActionCommand();
	          ConnectionManager obj = new ConnectionManager();
	            
	          if(action.equals("Search"))
	        	 forSearch();  
	          
	          else if(action.equals("Save"))
	        	   forInsert();
	         
	          else if(action.equals("Update"))
	        	   forUpdate();
	          
	          else if(action.equals("Delete"))
	        	   forDelete();
	         
	        } //End Of actionPerformed() Method
	        
	      private void forDelete()
	         {
			// TODO Auto-generated method stub
	        	 int ans = JOptionPane.showConfirmDialog(null,"Are you sure to delete the Record ?", "Delete Record",

                         JOptionPane.YES_NO_OPTION);

              if (ans == JOptionPane.YES_OPTION) {
             try {
                         String sql = "Delete FROM City where name = '" + tf1.getText() + "'";

                         Statement st = conn.createStatement();

                         st.execute(sql);
                         System.out.println("record deleted successfully");

              } 
             catch (Exception e)
              {
                         JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }
                JOptionPane.showMessageDialog(null, "Record Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
           else
            {
         JOptionPane.showMessageDialog(null, "Operation Canceled", "Cancel",JOptionPane.INFORMATION_MESSAGE);
             }
			}//End Of forDelete() Method
			private void forUpdate() 
			{
			try
			{ 
	                		String sql = "Update city " + "SET id = '"+tf1.getText()+"'," +
		                            "name = '"+tf2.getText()+"'," +
		                            "countrycode = '"+tf3.getText()+"'," +
		                            "district = '"+tf4.getText()+"'," +
		                            "population = '"+tf5.getText()+"'" +
		                            "Where id = '"+tf1.getText()+"'";

	                              Statement st = conn.createStatement();
	                              st.execute(sql);
	                              JOptionPane.showMessageDialog(null, "Record Updated Succesfully.", "Record Added",
	                                                              JOptionPane.INFORMATION_MESSAGE);
	                              clearControls();
	              } catch (Exception e) {
	                              JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	             }
			
		     }
			private void forSearch()
	          {
	          try {
	        	  String str = tf.getText();
	         
	            // compose the SQL we want to use       
                 PreparedStatement pstmt = conn.prepareStatement("select * from city where name=?");
                 pstmt.setString(1, str);
                 
					ResultSet rs = pstmt.executeQuery();

	                if (rs.next()) 
	                {
	                	List<City> list=dao.findByName(tf.getText());
	                	cityTable.setCities(list);
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null, "Name not Found");
	                }

	            //Create Exception Handler
	            } catch (Exception ex) 
	            {
	     
	                System.out.println(ex);
	            }  
	          }
	         
	      private void forInsert()
          {
	    	  try
              {
                  String sql = "INSERT INTO City (id,name,countrycode,district,population) " + "Values ('" + tf1.getText() + "',"
                                                              + "'" + tf2.getText() + "'," + "'" + tf3.getText() + "'," + "'" + tf4.getText()
                                                              + "'," + "'" + tf5.getText() + "')";
                              Statement st = conn.createStatement();
                              st.execute(sql);
                              JOptionPane.showMessageDialog(null, "Record Added Succesfully.", "Record Added",
                                                              JOptionPane.INFORMATION_MESSAGE);
                              clearControls();
              } catch (Exception e) {
                              JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
          }
	      private void clearControls()
          {
                          tf1.setText("");
                          tf2.setText("");
                          tf3.setText("");
                          tf4.setText("");
                          tf5.setText("");
          }

	      public JScrollPane scrollPane(AbstractTableModel model)
	      {
	    	JTable tb=new JTable(model);
	    	JScrollPane scrollPane=new JScrollPane(tb);
			return scrollPane;
	       }	       
}


