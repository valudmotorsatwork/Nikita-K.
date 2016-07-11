<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Model.City" import="Model.CountryLanguage"%>	
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jdbc Kendo Assignment</title>
<link href="styles/kendo.common.min.css" rel="stylesheet">
<link href="styles/kendo.default.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>
<h3>Linking Country Table With City And Language...</h3>
<div>

<kendo:grid name="Country" pageable="true" resizable="true">
              <kendo:grid-editable mode="popup"></kendo:grid-editable>
			<kendo:grid-pageable pageSizes="true" refresh="true" buttonCount="3"></kendo:grid-pageable>
			<kendo:dataSource pageSize="5">
				<kendo:dataSource-transport>
					<kendo:dataSource-transport-read url="CountryServlet"/>
			    </kendo:dataSource-transport>
			    <kendo:dataSource-schema>
			    <kendo:dataSource-schema-model id="code">
			    
			     <kendo:dataSource-schema-model-fields>
			 <kendo:dataSource-schema-model-field name="city" defaultValue="<%=new City()%>"></kendo:dataSource-schema-model-field>
			 <kendo:dataSource-schema-model-field name="countryLanguage" defaultValue="<%=new CountryLanguage()%>"></kendo:dataSource-schema-model-field>
			    </kendo:dataSource-schema-model-fields> 
			    </kendo:dataSource-schema-model>
			    </kendo:dataSource-schema> 		  
			</kendo:dataSource>

			<kendo:grid-columns>
				<kendo:grid-column title="Country Name" field="name" />
                <kendo:grid-column title="Continent" field="continent" />
				<kendo:grid-column title="Region" field="region" />		
				<kendo:grid-column title="Population" field="population" />
				<kendo:grid-column title="HeadOfState" field="headOfState" />
				<kendo:grid-column title="Capital" field="capital" />
				
				<kendo:grid-column title="City Name" field="city" template="#: city.name #" editor="cityEditor"/>
				<kendo:grid-column title="District" field="city.district"/>
				<kendo:grid-column title="City Population" field="city.population"/>
				<kendo:grid-column title="Language" field="countryLanguage" template="#: countryLanguage.language #" editor="languageEditor"/>
				<kendo:grid-column title="IsOfficial" field="countryLanguage.isOfficial"/>
				<kendo:grid-column title="Percentage" field="countryLanguage.percentage"/>
				
				<kendo:grid-column>
				  <kendo:grid-column-command>
				  <kendo:grid-column-commandItem name="edit"></kendo:grid-column-commandItem>
				    <kendo:grid-column-commandItem name="destroy"></kendo:grid-column-commandItem>
				  </kendo:grid-column-command>
				</kendo:grid-column>
		</kendo:grid-columns>
	  </kendo:grid>
	</div>
	<script type="text/javascript">
	function cityEditor(container,options)
	{
		 $("<input data-text-field='city.name' data-value-field='city.name' data-bind='value: "+options.field+"'/>'")
		 .appendTo(container)
		 .kendoDropDownList({
			 dataSource: {
				 transport: {
					 read:"CountryServlet"
				 }
			 }
		 });
	}
	 function languageEditor(container,options)
	{
		 $("<input data-text-field='countryLanguage.language' data-value-field='countryLanguage.language' data-bind='value: "+options.field+"'/>'")
		 .appendTo(container)
		 .kendoDropDownList({
			 dataSource: {
				 transport: {
					 read:"CountryServlet"
				 }
			 }
		 });
	} 
	</script>

</body>
</html>