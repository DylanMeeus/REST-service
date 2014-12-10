package net.itca.lesson1.generator;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.inject.Alternative;


@Alternative
public class NotSoRandomGenerator implements GeneratorBehaviour, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String generate()
	{
		String generated = "";
		for(int i = 0; i < 10; i++)
		{
			generated += i;
		}
		return generated;
	}
	
}
