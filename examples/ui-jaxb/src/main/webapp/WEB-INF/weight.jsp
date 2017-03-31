<jsp:useBean id="weights" type="java.util.List" scope="request" />
<%@ page import="com.microsoft.*,
	com.microsoft.hsg.thing.oxm.jaxb.base.DisplayValue,
	com.microsoft.hsg.thing.oxm.jaxb.base.WeightValue,
	com.microsoft.hsg.thing.oxm.jaxb.dates.Date,
	com.microsoft.hsg.thing.oxm.jaxb.dates.DateTime,
	com.microsoft.hsg.thing.oxm.jaxb.thing.Thing,
	com.microsoft.hsg.thing.oxm.jaxb.thing.ThingType,
	com.microsoft.hsg.thing.oxm.jaxb.weight.Weight" %>
<%@ page import="java.util.*" %>
<html>
<body>
<%@include file='header.jsp'%>
<form action="<%= request.getContextPath() %>/things/weight" 
	method="post">
  Weight: <input type="text" name="weight" /><br />
  <input type="submit" value="Submit" />
</form>
<table>
    		<tr>
    			<td>Id:</td>
    			<td>Value:</td>
    			<td>When:</td>
    			<td>Display:</td>
			</tr>
<%
Iterator iterator = weights.iterator();
while ( iterator.hasNext() ){
	Thing thing = (Thing)iterator.next();
	Weight weight = (Weight)thing.getData();
	out.println(
			"<tr><td>" + thing.getThingId().getValue() + "</td><td>" 
			+ weight.getValue().getKg() + "</td><td>" 
			+ weight.getWhen().toString() + "</td><td>"
			+ (weight.getValue().getDisplay() == null
			? "n/a"
			: weight.getValue().getDisplay().getValue()) + "</td></tr>");
}
%>
</table>
</body>
</html>