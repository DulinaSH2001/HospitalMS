package pharmacy.addPatient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addPatient
 */
@WebServlet("/addPatient")
public class addPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    String name = request.getParameter("name");
	        String nic = request.getParameter("NIC");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");

	        // Check for duplicate NIC
	        if (PatientUtil.isDuplicateNIC(nic)) {
	            response.sendRedirect("errorNIC.jsp?error=duplicate_nic");
	        } else {
	            // If not a duplicate NIC, proceed to add the patient
	            Patient patient = new Patient(name, nic, email, phone);
	            boolean success = PatientUtil.addPatient(patient);

	            if (success) {
	                response.sendRedirect("AddPatient.jsp?success=true");
	            } else {
	                response.sendRedirect("addPatient.jsp?error=insert_failed");
	                
	            }
	        }
	    }

}
