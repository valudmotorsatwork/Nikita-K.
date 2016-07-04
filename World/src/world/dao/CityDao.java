package world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import world.ConnectionManager;
import world.domain.City;

public class CityDao 
   {
	Connection conn;
	
public List<City> findByName(String name) throws ClassNotFoundException, SQLException 
	{
		ConnectionManager connectionManager=new ConnectionManager();
		conn=ConnectionManager.connectivity();
		List<City> results = new ArrayList<>();
		List cities = null;
		if (name == null) return cities;
		try {
			PreparedStatement pstmt =(PreparedStatement) conn.prepareStatement( "SELECT * FROM City WHERE name=?" );
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery( );
			while ( rs.next() ) results.add( resultToCity(rs) );
			rs.close();
		} catch (SQLException sqle) {
			throw new RuntimeException( sqle );
		}
		return results;
	}

public List<City> loadCityName() throws ClassNotFoundException, SQLException 
{
	ConnectionManager connectionManager=new ConnectionManager();
	conn=ConnectionManager.connectivity();
	List<City> results = new ArrayList<>();
	List cities = null;
	
	try {
		PreparedStatement pstmt =(PreparedStatement) conn.prepareStatement( "SELECT * FROM City" );
		ResultSet rs = pstmt.executeQuery( );
		while ( rs.next() ) results.add( resultToCity(rs) );
		rs.close();
	} catch (SQLException sqle) {
		throw new RuntimeException( sqle );
	}
	return results;
}

	private City resultToCity( ResultSet rs ) {
		City city = new City();
		try {
			city.setName( rs.getString("name") );
			city.setDistrict( rs.getString("district") );
			city.setPopulation( rs.getInt("population") );
		    city.setCountryCode( rs.getString("countrycode") );
			city.setId( rs.getInt("id") );
		} catch (SQLException sqle) {
			throw new RuntimeException( sqle );
		}
		return city;
	}
public void save(City city) throws SQLException
{
	String sql = "INSERT INTO city (name,district,countrycode,population)" 
			+ "  VALUES(?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS);
    String name;
//	pstmt.setString(1,city.setId(););
}
	
	
   }
