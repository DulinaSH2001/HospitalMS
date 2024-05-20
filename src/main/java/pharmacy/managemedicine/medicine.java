package pharmacy.managemedicine;

public class medicine {

	private  int id;
	private String name ;
	private String brand ;
	private String code;
	private int quantity;
	private double price;
	
	public medicine(int id, String name, String band, String code, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.brand = band;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	}
	public medicine( String name, String band, String code, int quantity, double price) {
		
		this.name = name;
		this.brand = band;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String band) {
		this.brand = band;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
