<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="db.dao.PersonInfoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="db.dto.PersonInfoDTO" %>
<!DOCTYPE html>s
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	PersonInfoDAO personInfoDAO = new PersonInfoDAO();
	
	List<PersonInfoDTO> personList = personInfoDAO.findPersonInfoList();
	%>
	<h1>index2.jsp 페이지</h1>
	
	<a href="./addPerson2.jsp">신규 인원 추가</a>
	
	</hr>
	
	<%
		for(PersonInfoDTO personInfo : personList){
	%>		
		<p><%=personInfo.getId() %>
		<a href="./personInfo2.jsp?id=<%=personInfo.getId() %>"><%=personInfo.getName() %></a></p>
	<% 
		}
	%>
	
	
	
</body>
</html>