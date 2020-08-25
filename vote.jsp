<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>vote page</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
                 <script src="JS/bootstrap.min.js"></script>
                 <script src="JQUERY/jquery-1.11.3.min.js"></script>
	</head>
	<body class="is-preload">

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="index.html">E-Voting</a></h1>
						<nav id="nav">
							<ul>
								<li class="special">
									<a href="#menu" class="menuToggle"><span>Menu</span></a>
									<div id="menu">
										<ul>
											<li><a href="newindex.html">Home</a></li>
											<li><a href="vote.jsp">RESULTS</a></li>
<!--											<li><a href="elements.html">Elements</a></li>-->
											<li><a href="signup.html">Sign Up</a></li>
											<li><a href="login.html">Log In</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<header>
							<h2>WELCOME </h2>
							<p>To E-Voting System</p>
						</header>
						<section class="wrapper style5">
							<div class="inner">

								<section>
									<h4>Vote</h4>
									<p>This is <b>Result </b> area  . This is were you <i>see </i><em>results of elections</em>.
                                                                            <%
    
String usercnic = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("cnic")) usercnic = cookie.getValue();
}
}
if(usercnic == null) response.sendRedirect("login.html");

String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "webproject";
String userId = "root";
String password = "asad1234";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;


connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM candidtes";
try{ 
%>   
                                                                        
<table align="center" cellpadding="6" cellspacing="5" border="1">
                                                                                                                                                <tr bgcolor="#A52A2A">
<tr bgcolor="green">

<td><b>Candidate Name</b></td>
<td><b>NA</b></td>
<td><b>Votes</b></td>

</tr>
<%  resultSet = statement.executeQuery(sql);
   sql = "Select * from candidtes ";
            resultSet= statement.executeQuery(sql);
           while(resultSet.next()){
               %>
     <tr>          
    <td><%=resultSet.getString("name") %></td>       
    <td><%=resultSet.getString("NA") %></td>   
    <td><%=resultSet.getString("votes") %></td>   
    </tr>
 <%          }
}
catch (Exception e) {
e.printStackTrace();
}
%>
</table>









<form action="logout" method="post">
<input type="button" value="Logout"  style="position:absolute;right:0;">
</form>

<script>
	function openWin() {
        var a= document.getElementById("s1").value;    
        var b= document.getElementById("s2").value;    
        document.getElementById("na").innerHTML=a;
        document.getElementById("nm").innerHTML=b;
//       if(nm.equals("nom")){
//        response.sendRedirect("vote.jsp");      
//    } else{ 
//          alert("invalid candidate or NA");
//        response.sendRedirect("afterlogin.jsp");   
          }
        }
</script>
</section>

							</div>
						</section>
					</article>

				 
					<footer id="footer">
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
						</ul>
						<ul class="copyright">
							
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>