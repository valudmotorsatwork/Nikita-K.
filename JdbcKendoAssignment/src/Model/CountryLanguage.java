package Model;

public class CountryLanguage 
{	

public CountryLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}
String language;
String isOfficial;
String percentage;

public CountryLanguage(String language, String isOfficial, String percentage) {
	super();
	this.language = language;
	this.isOfficial = isOfficial;
	this.percentage = percentage;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getIsOfficial() {
	return isOfficial;
}
public void setIsOfficial(String isOfficial) {
	this.isOfficial = isOfficial;
}
public String getPercentage() {
	return percentage;
}
public void setPercentage(String percentage) {
	this.percentage = percentage;
}

@Override
public String toString() {
	return "CountryLanguage [language=" + language + ", isOfficial=" + isOfficial + ", percentage=" + percentage
			+ "]";
}
}
