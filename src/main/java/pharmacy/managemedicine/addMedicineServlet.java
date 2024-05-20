package pharmacy.managemedicine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMedicineServlet")
public class addMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String code = request.getParameter("code");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double price = Double.parseDouble(request.getParameter("price"));

		medicine medicine = new medicine(0, name, brand, code, quantity, price);
		MedicineUtil.addMedicine(medicine);

		response.sendRedirect("Listmedicine.jsp");
	}
}
