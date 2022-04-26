package users;

public class Users {
	private int ID;
	private String username;
	private String password;
	private String name_of_organization;
	private int org_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private long contact_number;
	private String address;
	
	public Users() {
		
	}

	public Users(String username, String password, String name_of_organization,  int org_id, String first_name, String last_name, String email_id, long contact_number, String address) {
		super();
		this.username = username;
		this.password = password;
		this.name_of_organization = name_of_organization;
		this.org_id = org_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.contact_number = contact_number;
		this.address = address;
	}

	public Users(int ID, String username, String password, String name_of_organization, int org_id, String first_name, String last_name, String email_id, long contact_number, String address) {
		super();
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.name_of_organization = name_of_organization;
		this.org_id = org_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.contact_number = contact_number;
		this.address = address;
	}



	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName_of_organization() {
		return name_of_organization;
	}

	public void setName_of_organization(String name_of_organization) {
		this.name_of_organization = name_of_organization;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
