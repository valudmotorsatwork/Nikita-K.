package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Country;

public class CountryDao 
{
	Connection conn;
	Country country=new Country();
	List<Country> countries;
	public List<Country> listCountryRecords() throws SQLException, ClassNotFoundException 
	{
		
		 conn= ConnectionManager.connectivity();
		 countries = new ArrayList<>();
		PreparedStatement pstmt=null;
		ResultSet rs;
		try
		{
		String sql="Select con.Code, con.Name, con.Continent, con.Region, con.Population, con.HeadOfState, con.Capital, city.Name, city.District,"
				+ " city.Population,language.Language,language.IsOfficial,language.Percentage "
				+ "From Country con "
				+ "Join City city ON con.code=city.countryCode "
				+ "Join CountryLanguage language ON con.code=language.countryCode";
				
		pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery( );
			while (rs.next()){
				Country country = new Country();
				country.setContryCode(rs.getString("Code"));
				country.setCountryName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setRegion(rs.getString("Region"));
				country.setPopulation(rs.getString("Population"));
				country.setHeadOfState(rs.getString("HeadOfState"));
				country.setCapital(rs.getString("Capital"));
				country.setCity(new Model.City(rs.getString("city.Name"),rs.getString("District"),rs.getString("city.Population")));
               country.setCountryLanguage(new Model.CountryLanguage(rs.getString("Language"),rs.getString("IsOfficial"),rs.getString("Percentage")));
				
          		countries.add(country);		
			}	
			//System.out.println(countries);
			System.out.println(" in Country Dao..");
		}
	finally
	{
		pstmt.close();
	}
		return countries;
	}
	
}
