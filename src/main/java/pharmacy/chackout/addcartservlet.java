package pharmacy.chackout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addcartservlet
 */
@WebServlet("/addcartservlet")
public class addcartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addcartservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));

		int patientId = Integer.parseInt(request.getParameter("patientId"));
		// System.out.println("patientId ="+patientId);
		String medicineName = request.getParameter("madiname");
		// System.out.println("medicineName ="+medicineName);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		// System.out.println("quantity ="+quantity);
		double price = Double.parseDouble(request.getParameter("price"));

		cart medicart = new cart(medicineId, medicineName, patientId, quantity, price);
		cartUtil.addCart(medicart);

		RequestDispatcher dp = request.getRequestDispatcher("medicineCart.jsp");
		dp.forward(request, response);

	}

}
