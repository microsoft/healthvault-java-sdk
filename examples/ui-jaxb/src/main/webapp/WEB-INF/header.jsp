<%@ page import="com.microsoft.hsg.applications.*" %>
<%@ page import="com.microsoft.hsg.*" %>
<table cellspacing="10">
   <tr>
      <td><a href="<%= request.getContextPath() %>/things/home">Home</a></td>
      <td><a href="<%= request.getContextPath() %>/things/new">Change Selected Record</a></td>
      <td><a href="<%= request.getContextPath() %>/things/create">Create New Account</a></td>
      <td><a href="<%= request.getContextPath() %>/things/createrecord">Create New Record</a></td>
      <td><a href="<%= request.getContextPath() %>/things/help">Help</a></td>
      <td><a href="<%= request.getContextPath() %>/things/privacy">Privacy</a></td>
      <td><a href="<%= request.getContextPath() %>/things/service">Service Agreement</a></td>
      <td><a href="<%= request.getContextPath() %>/things/signout">Log Out</a></td>
   </tr>
</table><hr>
<%
PersonInfo personInfo = (PersonInfo)session.getAttribute("wcperson");
String personName = (personInfo == null ? "" : personInfo.getPersonName());
String recordName = (personInfo == null ? "" : personInfo.getRecordName());
String personId = (personInfo == null ? "" : personInfo.getPersonId());
String recordId = (personInfo == null ? "" : personInfo.getRecordId());
String instance = (personInfo == null ? "" : HVInstanceResolver.getInstanceResolver().getInstanceForId(personInfo.getInstanceId()).getName());

%>

<table cellspacing="20">
   <tr>
   
      <td><%= "Person : " + personName %></td>
      <td><%= "Record : " + recordName %></td>
      <td><%= "HV Instance : " + instance %></td>
   </tr>
   <tr>
   
      <td><%= "PersonId : " + personId %></td>
      <td><%= "RecordId : " + recordId %></td>
   </tr>
</table><hr>

