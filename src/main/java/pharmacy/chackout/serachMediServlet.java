package pharmacy.chackout;
import pharmacy.managemedicine.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serachMediServlet
 */
@WebServlet("/serachMediServlet")
public class serachMediServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serachMediServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String searchInput = request.getParameter("code");
		   System.out.println("code id :"+searchInput);

	        // Perform the search and retrieve the search results
	        List<medicine> searchResults = MedicineUtil.medicodeSearch(searchInput);
	        System.out.println("return  legnth :"+searchResults.size());//debug

	        
	        request.setAttribute("searchResults", searchResults);

	       
	        RequestDispatcher dp =request.getRequestDispatcher("medicineCart.jsp");
			dp.forward(request, response);
	    }

}
