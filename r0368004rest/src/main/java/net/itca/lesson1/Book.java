package net.itca.lesson1;

import java.io.Serializable;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import net.itca.lesson1.generator.GeneratorBehaviour;
import net.itca.lesson1.generator.RandomID;

/**
 * Javabean (Public getters/setters)
 * 
 * @author r0368004
 * 
 */
public class Book implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="title can not be null!")
	public String title;
	public String ID;
	
	@Inject
	public GeneratorBehaviour IDGen;
	
	public Book()
	{
		
	}
	
	@Inject
	public Book(GeneratorBehaviour generator)
	{
		IDGen = generator;
	}
	
	public void generateID()
	{
		ID = IDGen.generate();
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void setTitle(String _title)
	{
		title = _title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public boolean equals(Book b)
	{
		if(b.title == this.title)
		{
			return true;
		}
		return false;
	}
	
	@Inject
	public void setIDGenerator(GeneratorBehaviour generator)
	{
		IDGen = generator;
	}
}
