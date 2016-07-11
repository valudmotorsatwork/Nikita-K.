package Model;

public class Country 
{
	private String contryCode;
	private String name;
	private String continent;
	private String region;
	private String population;
	private String headOfState;
	private String capital;
	private Model.City city;
	private Model.CountryLanguage countryLanguage;
	
	
	
	
	public Model.City getCity() {
		return city;
	}
	public void setCity(Model.City city) {
		this.city = city;
	}
	public Model.CountryLanguage getCountryLanguage() {
		return countryLanguage;
	}
	public void setCountryLanguage(Model.CountryLanguage countryLanguage) {
		this.countryLanguage = countryLanguage;
	}
	
	
	
	public String getContryCode() {
		return contryCode;
	}
	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}
	public String getName() {
		return name;
	}
	public void setCountryName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getHeadOfState() {
		return headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@Override
	public String toString() {
		return "Country [contryCode=" + contryCode + ", countryName=" + name + ", continent=" + continent
				+ ", region=" + region + ", population=" + population + ", headOfState=" + headOfState + ", capital="
				+ capital + ", city=" + city + ", countryLanguage=" + countryLanguage + "]";
	}
	
	
}