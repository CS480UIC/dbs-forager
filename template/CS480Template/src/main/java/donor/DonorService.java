package donor;

import java.util.List;

public class DonorService {
	private DonorDao donorDao = new DonorDao();

	public void register(Donor form)
			throws DonorException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Donor donor = donorDao.findByDonorId(form.getDonorId());
		if (donor != null && donor.getDonorId() == form.getDonorId())
			throw new DonorException("This donor id has been registered!");
		donorDao.add(form);
	}

	public Donor getDonor(String donorId) throws Exception {
		Donor donor = donorDao.findByDonorId(Integer.parseInt(donorId));
		if (donor == null)
			throw new DonorException("This donor does not exist!");
		return donor;
	}
	
	public Donor updateDonor(Donor donor) throws Exception {
		Donor oldDonor = donorDao.findByDonorId(donor.getDonorId());
		if (oldDonor == null)
			throw new DonorException("This donor does not exist!");
		donorDao.updateDonor(donor);
		return donor;
	}
	
	public void deleteDonor(int donorId) throws Exception {
		Donor donor = donorDao.findByDonorId(donorId);
		if (donor == null)
			throw new DonorException("This donor does not exist!");
		donorDao.deleteDonor(donorId);
	}
	
	public List<Object> getSimpleQuery() throws Exception{
		return donorDao.simpleQuery();
	}
	
	public List<Object> getComplexQuery() throws Exception{
		return donorDao.complexQuery();
	}
	
	public List<Object> getAggQuery() throws Exception{
		return donorDao.aggQuery();
	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return donorDao.findall();

	}
}
