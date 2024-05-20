package pharmacy.managemedicine;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editMedicineServlet
 */
@WebServlet("/editMedicineServlet")
public class editMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	       try {
	            // Process the form submission to update the medicine
	            int id = Integer.parseInt(request.getParameter("id"));
	            String name = request.getParameter("name");
	            String brand = request.getParameter("brand");
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            double price = Double.parseDouble(request.getParameter("price"));

	            // Create a medicine object with updated details
	            medicine updatedMedicine = new medicine(id, name, brand, "", quantity, price);

	            // Call the update method from MedicineUtil
	            MedicineUtil.updateMedicine(updatedMedicine);

	            // Redirect the user to the medicine list page or display a success message
	            response.sendRedirect("Listmedicine.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}