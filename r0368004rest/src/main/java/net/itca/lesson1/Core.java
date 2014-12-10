package net.itca.lesson1;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class Core implements Serializable, RemoteCore
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Book> books;
	
	@Resource(name = "mail/distributed")
	private Session session;
	public Core()
	{
		setup();
	}
	
	public void setup()
	{
		books = new ArrayList<Book>();
		create("Testboek");
		create("Testboek2");
	}
	
	public void create(String _title)
	{
		Book book = new Book(null);
		book.setTitle(_title); 
		book.generateID();
		books.add(book);
		String to = "meeusdylan@hotmail.com";
		try{
		    MimeMessage message = new MimeMessage(session);
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    message.setSubject("Distributed applications");
		    String messageText = "New object has been created";
		    message.setText(messageText);
		    Transport.send(message);
		} catch (MessagingException ex) {
		    ex.printStackTrace();
		}
	}
	
	public void deleteAll()
	{
		books = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getBooks()
	{
		return books;
	}


}
