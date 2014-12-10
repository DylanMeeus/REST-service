package net.itca.lesson1;

import java.io.Serializable;





import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Named
@RequestScoped
public class FormBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	RemoteCore service; // Controller
	
	String title;
	public FormBean()
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
	
	public void setTitle(String _title)
	{
		title = _title;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String createBook()
	{
		service.create(title);
		return "overview.xhtml";
	}
}
