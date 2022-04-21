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

	
//	public void login(Donor form)
//			throws DonorException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		Donor donor = donorDao.findByDonorId(form.getDonorId());
//		if (user.getUsername() == null)
//			throw new UserException("The user is not in the database");
//
//		String password = user.getPassword();
//
//		if (password != null && !password.equals(form.getPassword()))
//			throw new UserException(" The password is not right");
//
//	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return donorDao.findall();

	}
}
