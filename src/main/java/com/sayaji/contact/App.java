package com.sayaji.contact;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.sayaji.contact.model.Contact;

public class App 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory()
	{
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	public static void main(String[] args)
	{
		Contact newContact = new Contact("sayaji", "patil", "USA");
		save(newContact);
		
		for(Contact c : fetchAll())
		{
			System.out.println(c);
		}
		
		newContact = findContactById(1);
		System.out.println(newContact);
		
		delete(newContact);
		
		for(Contact c : fetchAll())
		{
			System.out.println(c);
		}
		
	}

	private static void delete(Contact newContact)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(newContact);
		session.getTransaction().commit();
		session.close();
	}

	private static void save(Contact c)
	{
		Session session = sessionFactory.openSession();
		session.save(c);
		session.close();
	}
	
	private static Contact findContactById(int id)
	{
		Session session = sessionFactory.openSession();
		Contact contact = session.get(Contact.class, id);
		session.close();
		return contact;
	}
	
	@SuppressWarnings("unchecked")
	private static List<Contact> fetchAll()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Contact.class);
		List<Contact> contacts = criteria.list();
		session.close();
		return contacts;
	}
}
