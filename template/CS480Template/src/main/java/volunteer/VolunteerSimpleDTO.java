package volunteer;

public class VolunteerSimpleDTO {
	private int users_id;
	private float radius;
	
	public VolunteerSimpleDTO(int users_id, float radius) {
		super();
		this.users_id = users_id;
		this.radius = radius;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	
	
}