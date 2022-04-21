package receiver;

import java.util.List;

public class ReceiverService {
	private ReceiverDao receiverDao = new ReceiverDao();

	public void register(Receiver form) throws Exception {
		Receiver receiver = receiverDao.findByReceiverId(form.getReceiverId());
		if (receiver != null && receiver.getReceiverId() == form.getReceiverId())
			throw new ReceiverException("This donor id has been registered!");
		receiverDao.add(form);
	}

	public Receiver getReceiver(String receiverId) throws Exception {
		Receiver receiver = receiverDao.findByReceiverId(Integer.parseInt(receiverId));
		if (receiver == null)
			throw new ReceiverException("This donor does not exist!");
		return receiver;
	}

	public Receiver updateReceiver(Receiver receiver) throws Exception {
		Receiver oldreceiver = receiverDao.findByReceiverId(receiver.getReceiverId());
		if (oldreceiver == null)
			throw new ReceiverException("This donor does not exist!");
		receiverDao.updateReceiver(receiver);
		return receiver;
	}

	public void deleteReceiver(int receiverId) throws Exception {
		Receiver receiver = receiverDao.findByReceiverId(receiverId);
		if (receiver == null)
			throw new ReceiverException("This donor does not exist!");
		receiverDao.deleteReceiver(receiverId);
	}

	public List<Object> findall() throws Exception {
		return receiverDao.findall();

	}
}
