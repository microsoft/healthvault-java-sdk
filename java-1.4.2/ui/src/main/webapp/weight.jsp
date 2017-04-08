<jsp:useBean id="weights" type="java.util.List" scope="request" />
<%@ page import="com.microsoft.hsg.things.*" %> 
<%@ page import="java.util.*" %>
<html>
<body>
<form action="<%= request.getContextPath() %>/things/weight" 
	method="post">
  Weight: <input type="text" name="weight" /><br />
  <input type="submit" value="Submit" />
</form>
<table>
    		<tr>
    			<td>Id:</td>
    			<td>Value:</td>
			</tr>
<%
Iterator iterator = weights.iterator();
while ( iterator.hasNext() ){
	Weight weight = (Weight)iterator.next();
	out.println("<tr><td>" + weight.getId() + "</td><td>" + weight.getValue() + "</td></tr>");
}
%>
</table>
</body>
</html>