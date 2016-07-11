package Model;

public class City
{
	private String id;
	private String name;
	private String countryCode;
	private String district;
	private String population;
	
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String name, String district, String population) {
		super();
		this.name = name;
		this.district = district;
		this.population = population;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}

}
