<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h3>JDBC Kendo Assignment...</h3>

	<div>
		<kendo:grid name="CreateRequest" pageable="true" resizable="true">
              <kendo:grid-editable mode="popup" confirmation="Are You Surely want To Delete The Record..?"></kendo:grid-editable>
			<kendo:grid-pageable pageSizes="true" refresh="true" buttonCount="3"></kendo:grid-pageable>
			<kendo:grid-toolbar>
				<kendo:grid-toolbarItem name="create" />
			</kendo:grid-toolbar>

			<kendo:dataSource pageSize="5">
				<kendo:dataSource-transport>
					<kendo:dataSource-transport-read url="ServletDemo"/>
					<kendo:dataSource-transport-update url="ServletDemo?update" type="post"/>
					<kendo:dataSource-transport-create url="ServletDemo?create" type="post"/>
				    <kendo:dataSource-transport-destroy url="ServletDemo?destroy" type="post"/>
			    </kendo:dataSource-transport> 
				<kendo:dataSource-schema>
				
					<kendo:dataSource-schema-model id="id" >
					<kendo:dataSource-schema-model-fields>
				    <kendo:dataSource-schema-model-field name="name">
                      <kendo:dataSource-schema-model-field-validation required="true"/>
                       </kendo:dataSource-schema-model-field>
                      <kendo:dataSource-schema-model-field name="countryCode">
                      <kendo:dataSource-schema-model-field-validation required="true" />
                     </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="district">
                        <kendo:dataSource-schema-model-field-validation required="true" />
                       </kendo:dataSource-schema-model-field>
                        <kendo:dataSource-schema-model-field name="population">
                        <kendo:dataSource-schema-model-field-validation required="true" />
                      </kendo:dataSource-schema-model-field>
				</kendo:dataSource-schema-model-fields>
				</kendo:dataSource-schema-model>
				</kendo:dataSource-schema>
				  
			</kendo:dataSource>

			<kendo:grid-columns>
		
				<kendo:grid-column title="Name" field="name" />
				<kendo:grid-column title="CountryCode" field="countryCode" />
				<kendo:grid-column title="District" field="district" />
				<kendo:grid-column title="Population" field="population" />
				<kendo:grid-column>
				  <kendo:grid-column-command>
				  <kendo:grid-column-commandItem name="edit"></kendo:grid-column-commandItem>
				    <kendo:grid-column-commandItem name="destroy"></kendo:grid-column-commandItem>
				  </kendo:grid-column-command>
				</kendo:grid-column>
			</kendo:grid-columns>
		</kendo:grid>
	</div>
</body>
</html>