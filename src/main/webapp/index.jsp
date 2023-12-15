<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="db.dao.PersonInfoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="db.dto.PersonInfoDTO" %>
<%@ page import="db.dao.HobbyDAO" %>
<%@ page import="db.dto.HobbyDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		PersonInfoDAO personInfoDAO = new PersonInfoDAO();	
		
		List<PersonInfoDTO> personList = personInfoDAO.findPersonInfoList();
		
		HobbyDAO hobbyDAO = new HobbyDAO();
		
		List<HobbyDTO> hobbyList = hobbyDAO.findHobbyInfoList();
	%>
	
	<%@ include file="navigation.jsp" %>
	
	<h1>index.jsp 페이지</h1>
	
	<hr/>
	<%
		for(PersonInfoDTO personInfo : personList){
	%>		
			<p> <%=personInfo.getId()%> 
			<a href="./personInfo.jsp?id=<%=personInfo.getId()%>"><%=personInfo.getName() %></a> </p>
	<% 
		}
	%>
	
	
	
</body>
</html>