package net.itca.lesson1;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import net.itca.lesson1.generator.GeneratorBehaviour;

@Default
public class IDGenerator implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	GeneratorBehaviour genStyle;
	public IDGenerator(GeneratorBehaviour gb)
	{
		genStyle = gb;
	}
	
	public String generate()
	{
		return genStyle.generate();
	}
}

