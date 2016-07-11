package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import java.util.List;
import Model.City;
import Services.CityDao;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CityDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
	     dao=new CityDao();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<City> cities;
			try {
				cities = dao.listCityRecords();
				Gson g = new Gson();
				response.setContentType("application/json");
				response.getWriter().write(g.toJson(cities));

		
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
	    try
	    {
	     Gson g = new Gson();
		City city=parseRequest(request);
		String type= request.getQueryString();
		switch(type)
		{
		case "update": {
			            dao.doUpdate(city);
		                break;
			
		                }
		case "create": {
			            dao.doCreate(city);
						response.getWriter().write(g.toJson(city));
						break;
		               }
		case "destroy":{
			            dao.doDelete(city);
			             break;
	                 	}
					}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	    	
	    }
	} 
	private Model.City parseRequest(HttpServletRequest request) 
	{
		Model.City city=new Model.City();
		city.setId(request.getParameter("id"));
		//city.setId(request.getParameter("id"));
		city.setName(request.getParameter("name"));
		city.setCountryCode(request.getParameter("countryCode"));
		city.setDistrict(request.getParameter("district"));
		city.setPopulation(request.getParameter("population"));
		return city; 
	}

}
