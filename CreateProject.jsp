<%-- 
    Document   : CreateProject
    Created on : Apr 23, 2024, 9:15:04 PM
    Author     : gloryogunbunmi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Project</title>
    <link rel="stylesheet" type="text/css" href="CreateProject.css">
</head>
<body>
<div>
    <h1>Create Project</h1>
    <%--String errorMessage = (String) session.getAttribute("errorMessage");
       if (errorMessage != null) { %>
       <p style="color: red;"><%= errorMessage %></p>
    <% } --%>
    <form action="CreateProjectCTL" method="POST">
        <label for="projectId">Project ID</label>
        <input type="number" id="projectId" name="projectId" required>
        
        <label for="projectName">Project Name</label>
        <input type="text" id="projectName" name="projectName" required> 
        
        <label for="companyName">Company Name</label>
        <input type="text" id="companyName" name="companyName" required> 
        
        <label for="numStudents">Number of Students</label>
        <input type="number" id="numStudents" name="numStudents">
        
        <label for="deliverables">Deliverables</label>
        <input type="text" id="deliverables" name="deliverables">
        
        <label for="status">Status</label>
        <input type="number" id="status" name="status">

        <label for="major">Classification</label>
        <select id="major" name="major">
            <option value='computerScience'>Computer Science</option>
            <option value='iT'>Information Technology</option>
            <option value='business'>Business</option>
            <option value='healthSciences'>Health Sciences</option>
        </select>

        <label for="industry">Industry</label>
        <input type="text" id="industry" name="industry" required>
        
        <label for="companyId">Company ID</label>
        <input type="number" id="companyId" name="companyId">

        <label for="mentorId">Mentor ID</label>
        <input type="number" id="mentorId" name="mentorId">

        <label for="deadline">Deadline</label>
        <input type="text" id="deadline" name="deadline">
        
        <label for="requirements">Requirements (optional)</label>
        <input type="text" id="requirements" name="requirements">

        <input type="submit" value="Create Project" id="submit">
        <input type="button" value="Cancel" onclick="window.history.back();">
    </form>
</div>
</body>
</html>
