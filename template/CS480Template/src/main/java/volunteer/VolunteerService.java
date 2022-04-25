package volunteer;

import java.util.List;

public class VolunteerService {
	private VolunteerDao volunteerDao = new VolunteerDao();
	
	public void addVolunteer(Volunteer volunteer)throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Volunteer v = volunteerDao.findByVolunteerId(volunteer.getUsers_id());
		if(v !=null && v.getUsers_id()==volunteer.getUsers_id()) throw new VolunteerException("This volunteer_id has been registered!");
		
		volunteerDao.insertVolunteer(volunteer);		
	}
	
	public void updateVolunteer(Volunteer volunteer)throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Volunteer v = volunteerDao.findByVolunteerId(volunteer.getUsers_id());
		if(v == null) throw new VolunteerException("There's no volunteer with this id");
		
		volunteerDao.updateVolunteer(volunteer);	
	}
	
	public void deleteVolunteer(int users_id) throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Volunteer v = volunteerDao.findByVolunteerId(users_id);
		if(v == null) throw new VolunteerException("There's no volunteer item with this id");
		volunteerDao.deleteVolunteer(users_id);
	}
	
	public Volunteer getVolunteer(String users_id) throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Volunteer v = volunteerDao.findByVolunteerId(Integer.parseInt(users_id));
		if(v == null) throw new VolunteerException("There's no volunteer item with this id");
		
		return v;
	}
	
	public List<Volunteer> getAll() throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return volunteerDao.findAll();
	}
	public List<VolunteerSimpleDTO> simple() throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return volunteerDao.simpleQuery();
	}
	public List<VolunteerAggregateDTO> aggregate() throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return volunteerDao.aggregateQuery();
	}
	public List<VolunteerComplexDTO> complex() throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return volunteerDao.complexQuery();
	}
}
