package volunteer;

public class VolunteerAggregateDTO {
	private String preferred_location;
	private float radius;
	
	public VolunteerAggregateDTO(String preferred_location, float radius) {
		super();
		this.preferred_location = preferred_location;
		this.radius = radius;
	}
	
	
	public String getPreferred_location() {
		return preferred_location;
	}
	public void setPreferred_location(String preferred_location) {
		this.preferred_location = preferred_location;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
}