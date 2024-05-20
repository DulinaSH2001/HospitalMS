package pharmacy.chackout;

public class cart {
	
	private int cartId;
	private int madicineId;
	private String mediname;
	private int patientId;
	private int qty;
	private  double price ;
	
	
	
	
	
	public cart(int madicineId, String mediname, int patientId, int qty, double price) {
		this.madicineId = madicineId;
		this.mediname = mediname;
		this.patientId = patientId;
		this.qty = qty;
		this.price = price;
		
		
	}
	
	

	
	public cart(int cartId, int madicineId, int patientId,String mediname, int qty,double price) {
		this.cartId = cartId;
		this.madicineId = madicineId;
		this.mediname = mediname;
		this.patientId = patientId;
		this.qty = qty;
		this.price = price;
	}


	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getMadicineId() {
		return madicineId;
	}
	public void setMadicineId(int madicineId) {
		this.madicineId = madicineId;
	}
	public String getMediname() {
		return mediname;
	}
	public void setMediname(String mediname) {
		this.mediname = mediname;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalprice() {
		return price*qty;
	}
	
	

}
