package volunteer;

public class Volunteer {
	private int users_id;
	private String volunteer_name;
	private String preferred_location;
	private float location_radius;
	private String availability_date;
	
	public Volunteer() {
		
	}

	public Volunteer(String volunteer_name, String preferred_location, float location_radius, String availability_date) {
		super();
		this.volunteer_name = volunteer_name;
		this.preferred_location = preferred_location;
		this.location_radius = location_radius;
		this.availability_date = availability_date;
	}

	public Volunteer(int users_id, String volunteer_name, String preferred_location, float location_radius, String availability_date) {
		super();
		this.users_id = users_id;
		this.volunteer_name = volunteer_name;
		this.preferred_location = preferred_location;
		this.location_radius = location_radius;
		this.availability_date = availability_date;
	}


	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getVolunteer_name() {
		return volunteer_name;
	}

	public void setVolunteer_name(String volunteer_name) {
		this.volunteer_name = volunteer_name;
	}

	public String getPreferred_location() {
		return preferred_location;
	}

	public void setPreferred_location(String preferred_location) {
		this.preferred_location = preferred_location;
	}

	public float getLocation_radius() {
		return location_radius;
	}

	public void setLocation_radius(float location_radius) {
		this.location_radius = location_radius;
	}

	public String getAvailability_date() {
		return availability_date;
	}

	public void setAvailability_date(String availability_date) {
		this.availability_date = availability_date;
	}
	
}
