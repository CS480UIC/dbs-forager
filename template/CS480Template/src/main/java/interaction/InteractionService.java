package interaction;

import java.util.List;

public class InteractionService {
	private InteractionDao interactionDao = new InteractionDao();

	public void register(Interaction form)
			throws InteractionException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Interaction interaction = interactionDao.findByInteractionId(form.getInteractionId());
		if (interaction != null && interaction.getInteractionId() == form.getInteractionId())
			throw new InteractionException("This interaction id has been registered!");
		interactionDao.add(form);
	}

	public Interaction getInteraction(String interactionId) throws Exception {
		
		System.out.println(interactionId);
		
		Interaction interaction = interactionDao.findByInteractionId(Integer.parseInt(interactionId));
		if (interaction == null)
			throw new InteractionException("This interaction does not exist!");
		return interaction;
	}
	
	public Interaction updateInteraction(Interaction interaction) throws Exception {
		Interaction oldInteraction = interactionDao.findByInteractionId(interaction.getInteractionId());
		if (oldInteraction == null)
			throw new InteractionException("This interaction does not exist!");
		interactionDao.updateInteraction(interaction);
		return interaction;
	}
	
	public void deleteInteraction(int interactionId) throws Exception {
		Interaction interaction = interactionDao.findByInteractionId(interactionId);
		if (interaction == null)
			throw new InteractionException("This interaction does not exist!");
		interactionDao.deleteInteraction(interactionId);
	}
	
	public List<Object> getSimpleQuery() throws Exception{
		return interactionDao.simpleQuery();
	}
	
	public List<Object> getComplexQuery() throws Exception{
		return interactionDao.complexQuery();
	}
	
	public List<Object> getAggQuery() throws Exception{
		return interactionDao.aggQuery();
	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return interactionDao.findall();

	}
}
