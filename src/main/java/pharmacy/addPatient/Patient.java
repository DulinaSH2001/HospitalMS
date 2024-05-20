package pharmacy.addPatient;

public class Patient {
	private int patientid;
	private String name ;
	private String nic ;
	private String email;
	private String phone;
	
	private int status ;
	
 
	public Patient(String name, String nic, String email, String phone) {
		this.name = name;
		this.nic = nic;
		this.email = email;
		this.phone = phone;
	
		
		
	}
 
	public Patient(int patientid, String name, String nic, String email, String phone, int status) {
		this.patientid = patientid;
		this.name = name;
		this.nic = nic;
		this.email = email;
		this.phone = phone;
	
		this.status = status;
		
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	
	
	
	
	

}
