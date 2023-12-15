<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="db.dao.HobbyDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="db.dto.HobbyDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,tr,td{
border : 1px solid red
}
</style>
</head>
<body>
<% 
HobbyDAO hobbyDAO = new HobbyDAO();

List<HobbyDTO> hobbyList = hobbyDAO.findHobbyInfoList();

	%>
<%@ include file="navigation.jsp" %>
<h1>취미목록</h1>
<a href="./index.jsp">메인 페이지로</a>
<table>
	<tr>
		<th>아이디</th>
		<th>순번</th>
		<th>취미</th>
		<th>선호도</th>
	</tr>
	<%
	if(hobbyList != null){
		
	
	for(HobbyDTO hobbyDTO : hobbyList){
		%>

	<tr>
		<td> <%=hobbyDTO.getId()%></td>
		<td><%=hobbyDTO.getNo() %></td>
		<td><%=hobbyDTO.getHobby() %></td>
		<td> <%=hobbyDTO.getPrefer() %></td>
	</tr>
	<% 
		}
	}
	%>
	</table>		
	

</body>
</html>