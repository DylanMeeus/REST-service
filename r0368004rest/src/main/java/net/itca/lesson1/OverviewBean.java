package net.itca.lesson1;
import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.itca.lesson1.Book;


@Named
@RequestScoped
public class OverviewBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	RemoteCore service; // Controller
	public OverviewBean()
	{
//		InitialContext context;
//		try
//		{
//			context = new InitialContext();
//			String jndiName = "java:global/lesson1/Core!net.itca.lesson1.RemoteCore";
//			service = (RemoteCore) context.lookup(jndiName);
//		} 
//		catch (NamingException e)
//		{
//			e.printStackTrace();
//		}
	}
	
	public ArrayList<Book> getBooks()
	{
		return service.getBooks();
	}
}
