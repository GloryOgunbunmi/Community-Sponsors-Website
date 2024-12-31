/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import Utils.OracleConnection;
import java.sql.*;

/**
 *
 * @author gloryogunbunmi
 */

public class Projects {
    
    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private String projectId;
    private String projectName;
    private String companyName;
    private String numStudents; //new
    private String deliverables; //new
    private String status; //new
    private String industry; //new
    private String deadline;
    private String companyId;//new
    private String mentorId;//new
    private String requirements= "";// named SKILLREQUESTED
    private String major;
   
    private Connection conn = null;
   
    public Projects(String projectId, String projectName, String companyName, String numStudents, String deliverables, 
            String status, String industry, String deadline, String companyId, String mentorId, String requirements, String major){
        this.projectId = projectId;
        this.projectName = projectName;
        this.companyName = companyName;
        this.numStudents= numStudents;
        this.deliverables = deliverables;
        this.status = status;
        this.industry = industry;
        this.deadline = deadline;
        this.companyId = companyId;
        this.mentorId = mentorId;
        this.requirements = requirements;
        this.major = major;
    }
   
    
    //make some damn getters and setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(String numStudents) {
        this.numStudents = numStudents;
    }
    
    public String getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    
    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }
    
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    // Add to Projects.java model class

/*public static List<Projects> getAllProjects() {
    List<Projects> projectList = new ArrayList<>();
    String sql = "SELECT PROJECTID, TITLE, COMPANYNAME, NUMSTUDENTS, DELIVERABLES, STATUS, INDUSTRY, DEADLINE, COMPANYID, MENTORID, SKILLREQUESTED, MAJOR FROM PROJECT";

    try (Connection conn = OracleConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            try {
                //Date deadlineDate = rs.getDate("DEADLINE");
               // String formattedDeadline = deadlineDate != null ? dateFormat.format(deadlineDate) : "No Deadline Provided";
                
                Projects project = new Projects(
                    rs.getInt("PROJECTID"),
                    rs.getString("TITLE"),
                    rs.getString("COMPANYNAME"),
                    rs.getInt("NUMSTUDENTS"),
                    rs.getString("DELIVERABLES"),
                    rs.getInt("STATUS"),
                    rs.getString("INDUSTRY"),
                    rs.getString("DAEDLINE")),
                    rs.get("COMPANYID"),
                    rs.getInt("MENTORID"),
                    rs.getString("SKILLREQUESTED"),
                    rs.getString("MAJOR")
                );
                projectList.add(project);
            } catch (Exception e) {
                System.err.println("Error parsing project data: " + e.getMessage());
            }
        }
    } catch (SQLException e) {
        System.err.println("SQL Exception when fetching projects: " + e.getMessage());
    }
    return projectList;
}*/

    
    public boolean saveProject(Projects project) {
        boolean success = false;
        

        try {
            
            conn = OracleConnection.getConnection();
            
            String sql = "INSERT INTO PROJECT (PROJECTID, TITLE, COMPANYNAME, NUMSTUDENTS, DELIVERABLES, STATUS, MAJOR, INDUSTRY, SKILLREQUESTED, COMPANYID, MENTORID, DEADLINE) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, project.getProjectId());           // Index 1, PROJECTID
            pstmt.setString(2, project.getProjectName());      // Index 2, TITLE
            pstmt.setString(3, project.getCompanyName());      // Index 3, COMPANYNAME
            pstmt.setString(4, project.getNumStudents());         // Index 4, NUMSTUDENTS
            pstmt.setString(5, project.getDeliverables());     // Index 5, DELIVERABLES
            pstmt.setString(6, project.getStatus());              // Index 6, STATUS
            pstmt.setString(7, project.getMajor());            // Index 7, MAJOR
            pstmt.setString(8, project.getIndustry());         // Index 8, INDUSTRY
            pstmt.setString(9, project.getRequirements());     // Index 9, SKILLREQUESTED
            pstmt.setString(10, project.getCompanyId());          // Index 10, COMPANYID
            pstmt.setString(11, project.getMentorId());           // Index 11, MENTORID
            pstmt.setString(12, project.getDeadline());        // Index 12, MENTORID
            /*try {
            java.util.Date parsedDate = dateFormat.parse(project.getDeadline()); // Attempt to parse the string
            pstmt.setDate(12, new java.sql.Date(parsedDate.getTime())); // Set the date if parsing is successful
            } catch (ParseException e) {
            pstmt.setDate(12, null); // Set null or some default if parsing fails
            }*/
            
            pstmt.executeUpdate();
          
        } catch (SQLException e) {
            System.err.println("SQL Exception when saving project ");
            success = false;
        }
    
    return success;
}

}

