<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="projectsave" modelAttribute="project">    
        <table class ="pqr">  
         <tr>    
          <td><form:hidden path="id" /></td>  
         </tr>      
         <tr>    
          <td>Project Name :</td>    
          <td><form:input path="projectName"/></td>  
         </tr>   
            
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td> 
         </tr>    
        </table>    
       </form:form> 
</body>
</html>