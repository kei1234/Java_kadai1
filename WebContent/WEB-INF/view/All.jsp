<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.Keepaccount"%>
<%@page import="dto.ReturnI" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<%ReturnI i= (ReturnI) request.getAttribute("inum"); %>
<table border="1">
<tr>
<th>収入</th>
<th>支出</th>
</tr>
<%String strH[] = new String[i.getI()];
for(int h = 0;h < strH.length;h++){
String str = "rs" + h;
strH[h] = str;}%>
<%for(int j = 0;j < strH.length;j++){%>
<%Keepaccount data = (Keepaccount) request.getAttribute(strH[j]); %>
<tr>

<td><%=data.getIncome() %></td>
<td><%=data.getSpending() %></td>

</tr>
<%} %>
</table>

</body>
</html>