package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import Model.Country;
import Services.CountryDao;



/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CountryDao cDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryServlet() {
        super();
        cDao=new CountryDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Country> countries;
		try {
			countries =cDao.listCountryRecords();
			Gson g = new Gson();
			response.setContentType("application/json");
			response.getWriter().write(g.toJson(countries));
			System.out.println("In Country Servlet...");
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private Model.Country parseRequest(HttpServletRequest request) 
	{
		Country country=new Country();
		
		country.setContryCode(request.getParameter("countryCode"));	
		country.setCountryName(request.getParameter("countryName"));
		country.setContinent(request.getParameter("continent"));
      	country.setRegion(request.getParameter("region"));	
		country.setPopulation(request.getParameter("population"));
		country.setHeadOfState(request.getParameter("headOfState"));
		country.setCapital(request.getParameter("capital"));
		return country; 
	}


}
