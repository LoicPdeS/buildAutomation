package fr.imie.emanagerws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.imie.emanagerws.entity.Contact;


public class Service {
	
	/**
	 * Collection of contacts
	 */
	private final static List<Contact> contacts = new ArrayList<Contact>();
    private static long lastId = 4;
    
	/**
	 * The default constructor 
	 * 
	 * This adds some data for testing purpose
	 */
    public Service (){
    	// Add some testing data
    	if ( contacts.size() == 0){
    		contacts.add( new Contact (1L, "Nantes, France", "03838386"));
        	contacts.add( new Contact (2L, "Rennes, France", "03838385"));
        	contacts.add( new Contact (3L, "Paris, France", "03838384"));
        	contacts.add( new Contact (4L, "Mans, France", "03838383"));
    	}
    }

    /**
     * Gets the list of contacts
     * 
     * Makes copy for immutability
     * @return
     */
	public List<Contact> getContacts() {
		return new ArrayList<Contact>(contacts);
	}
    
	/**
	 * Gets contact by id
	 * 
	 * Note : Makes use of Java8 streams
	 * 
	 * @param id : the id of the contact to get
	 * @return {@link Contact}}
	 */
    public Contact findContactById ( final long id ){
    	Optional<Contact> contact = contacts.stream().filter(cont -> { return cont.getId() == id ;}).findFirst();
    	
    	if (contact.isPresent()){
    		return new Contact (contact.get().getId(), contact.get().getAddress(), contact.get().getPhone());
    	}
    	
    	return null;
    }
    
    /**
     * Adds a new contact
     * @param contact : the contact to be added
     * @return {@link Contact} the added contact
     */
    public Contact addContact ( Contact contact ){
    	lastId ++;
    	contact.setId( lastId );
    	contacts.add(contact);
    	return contact;
    }
    
    /**
     * Updates the contact 
     * @param contact : the contact to be updated
     */
    public void updateContact ( final Contact contact ){
    	// TODO : should update the contact
    }
    
    /**
     * Deletes the contact 
     * @param contact : the contact to be deleted
     */
    public void deleteContact ( final Contact contact ){
    	contacts.remove(contact);
    }
    
    /**
     * Gets the contacts in string
     */
    public String toString (){
    	StringBuilder sb = new StringBuilder();
    	
    	contacts.stream().forEach(contact -> {
    		sb.append(contact.toString());
    	});
    	
    	return sb.toString();
    }
}
