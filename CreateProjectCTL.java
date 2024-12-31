/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controls;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.Projects;

/**
 *
 * @author gloryogunbunmi
 */
@WebServlet(name = "CreateProjectCTL", urlPatterns = {"/CreateProjectCTL"})
public class CreateProjectCTL extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String projectId = request.getParameter("projectId");
            String projectName = request.getParameter("projectName");
            String companyName = request.getParameter("companyName");
            String numStudents = request.getParameter("numStudents");
            String deliverables = request.getParameter("deliverables");
            String status = request.getParameter("status");
            String major = request.getParameter("major");
            String industry = request.getParameter("industry");
            String companyId = request.getParameter("companyId");
            String mentorId = request.getParameter("mentorId");
            String deadline = request.getParameter("deadline");
            String requirements = request.getParameter("requirements");
        //String projectType = request.getParameter("projectType");
        
        
        Projects project = new Projects(projectId, projectName, companyName, numStudents, deliverables, status, major, industry, companyId, mentorId , deadline, requirements);
        
        // Attempt to save the project to the database
    boolean isProjectSaved = project.saveProject(project);

        if (isProjectSaved) {
            response.sendRedirect("index.html"); // Redirect to the ProjectListCTL 
        } else {
            request.getSession().setAttribute("errorMessage", "There was an error saving the project. Please try again.");
            response.sendRedirect("CreateProject.jsp"); // Send back to the form with an error message
        }

        }catch (NumberFormatException e) {
        request.getSession().setAttribute("errorMessage", "Invalid input. Please check your entries and try again.");
        response.sendRedirect("CreateProject.jsp");
    }
}
    
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect POST requests to the form
        response.sendRedirect("CreateProject.jsp");
    }
}

