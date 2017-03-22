package fr.imie.emanagerws.service;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;

import fr.imie.emanagerws.entity.Contact;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {
	private Service service = null;
	
	@Before
	public void before (){
		service = new Service();
	}
	
	@Test
	public void shouldGetContactById (){
		Contact contact = service.findContactById(2);
		
		assertThat(contact.getId()).isNotNull(); 
		assertThat(service.findContactById(2)).isEqualTo(contact);
	}
	
	@Test
	public void shouldAddContact (){
		
		Contact contact = new Contact ();
		contact.setAddress("Brest, France");
		contact.setPhone("040506060");
		
		contact = service.addContact(contact);

		assertThat(contact.getId() > 0).isTrue();
		
		Contact addedContact = service.findContactById(contact.getId());
		
		assertThat(addedContact).isEqualTo(contact);
	}
	
	@Test
	public void shouldDeleteContact(){
		// getting a contact
		Contact contact = service.findContactById(1);
		
		// deleting it
		service.deleteContact(contact);
		
		// assert it's null ( no more existing )
		assertThat(service.findContactById(1)).isNull();
	}
	
	@After
	public void after (){
		service = null;
	}
}
