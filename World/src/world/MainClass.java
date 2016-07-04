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
	    JLabel lb;
	    JTextField tf;
	    JButton b;
	    JTable table;
	    CityDao dao=new CityDao();
	    CityTableModel cityTable=new CityTableModel();
	   //Creating Constructor for initializing JFrame components
	    MainClass() throws ClassNotFoundException, SQLException
	    {  
		    lb = new JLabel("Enter City Name:");
	        lb.setBounds(20,20, 100, 20);
	        
	        tf = new JTextField(20);
	        tf.setBounds(130,20,200, 20);
	 
	        b = new JButton("Submit");
            b.setBounds(350, 20, 100, 20);
	        b.addActionListener(this);
   	       
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
	       
	        List<City> cities=dao.loadCityName();
   	       
   	        cityTable.setCities(cities);
   	        setLayout(new BorderLayout(4,4));
	        add(scrollPane(cityTable),BorderLayout.SOUTH);
	        setVisible(true);
	     
	        //Set TextField Editable False
	        tf.setEditable(true);    
	        
                
	    }
	      public void actionPerformed(ActionEvent e)
	        {
	    	  String str = tf.getText();
	          ConnectionManager obj = new ConnectionManager();
	            try {
	              
	           //Create DataBase Connection and Fetching Records
	        	 Connection conn = ConnectionManager.connectivity();
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
	      
	      public JScrollPane scrollPane(AbstractTableModel model)
	      {
	    	JTable tb=new JTable(model);
	    	JScrollPane scrollPane=new JScrollPane(tb);
			return scrollPane;
	    	  
	      }
	      
  
}


