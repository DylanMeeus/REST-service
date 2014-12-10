package net.itca.lesson1.generator;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;


@Default
public class RandomID implements GeneratorBehaviour, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String generate()
	{
		String generated = "";
		Random rand = new Random();
		for(int character=0;character<10;character++)
		{
			generated += rand.nextInt();
		}
		return generated;
	}
	
}
