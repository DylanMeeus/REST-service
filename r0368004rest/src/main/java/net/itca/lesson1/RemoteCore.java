package net.itca.lesson1;

import java.util.ArrayList;

import javax.ejb.Remote;



@Remote
public interface RemoteCore
{
	public void setup();
	public void create(String _title);
	public void deleteAll();
	public ArrayList<Book> getBooks();
}
