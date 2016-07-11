package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.City;

public class CityDao
{
	Connection conn;
	City city=new City();
	
	public List<City> listCityRecords() throws SQLException, ClassNotFoundException 
	{
		
		 conn= ConnectionManager.connectivity();
		List<City> cities = new ArrayList<>();
		
		PreparedStatement pstmt = conn.prepareStatement( "SELECT * FROM City" );
			ResultSet rs = pstmt.executeQuery( );
			while (rs.next()){
				Model.City city = new Model.City();
				city.setId(rs.getString("id"));
				city.setName(rs.getString("name"));
				city.setCountryCode(rs.getString("countryCode"));
				city.setDistrict(rs.getString("district"));
				city.setPopulation(rs.getString("population"));
				cities.add(city);
				
			}
						
		
		return cities;
	}
 public void doUpdate(City city) throws SQLException, ClassNotFoundException
 { conn= ConnectionManager.connectivity();
	 PreparedStatement pstmt=null;
		try
		{
			
		String sql = "Update City SET name = ?,countryCode =?,district = ?,population = ? Where id =?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,city.getName());
		pstmt.setString(2,city.getCountryCode() );
		pstmt.setString(3,city.getDistrict());
		pstmt.setString(4,city.getPopulation());
		pstmt.setString(5,city.getId() );
		pstmt.executeUpdate();
		}
		finally
		  {
			  pstmt.close();
		  }
 }
		
 public void doDelete(City city) throws SQLException, ClassNotFoundException
 { 
	 conn= ConnectionManager.connectivity();
	 PreparedStatement pstmt=null;
	  try {
          pstmt=conn.prepareStatement("Delete FROM City where id = ?");
          pstmt.setString(1,city.getId());
           pstmt.execute();
           }
	  finally{
		  pstmt.close();
	  }
 
 }
 public int doCreate(City city) throws SQLException, ClassNotFoundException
 {
	 int id=0;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 conn= ConnectionManager.connectivity();
	 try
	 {
		 String sql="INSERT INTO City(name,countryCode,district,population) values(?,?,?,?)";
		  pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,city.getName());
			pstmt.setString(2,city.getCountryCode() );
			pstmt.setString(3,city.getDistrict());
			pstmt.setString(4,city.getPopulation());
			
		  int rows=pstmt.executeUpdate();
		 if(rows==0)
			 throw new SQLException("Unable To Create....");
		 rs=pstmt.getGeneratedKeys();
		 if(rs.next())
			 id=rs.getInt(1);
		 else
			 throw new SQLException("Unable To Create City....");
	 }
	 finally
	 {
		// rs.close();
		 pstmt.close(); 
	 }
	return 0;
	 
 }
 
}
