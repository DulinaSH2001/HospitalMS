package pharmacy.chackout;
import pharmacy.addPatient.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pharmacy.addPatient.Patient;

/**
 * Servlet implementation class searchPatientServlet
 */
@WebServlet("/searchPatientServlet")
public class searchPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public searchPatientServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String nicNumber = request.getParameter("searchInput");
        System.out.println("Search input: " + nicNumber);

        // Search patients based on the NIC number
        List<Patient> searchResults = PatientUtil.searchPatientsByNIC(nicNumber);
        System.out.println("Number of search results: " + searchResults.size());//debug
        request.setAttribute("searchResults", searchResults);//debug
		RequestDispatcher dp =request.getRequestDispatcher("selectPatient.jsp");
		dp.forward(request, response);
		
    }
}