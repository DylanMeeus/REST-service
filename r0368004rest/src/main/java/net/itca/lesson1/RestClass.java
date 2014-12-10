package net.itca.lesson1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

@Path("r0368004restclass")
public class RestClass
{

	String REST_SERVICE_URL = "http:/localhost:8080/tutorial/rs/book";

	public RestClass()
	{

	}

	Client client = ClientBuilder.newClient().register(JacksonFeature.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void sendBookJSON()
	{
		Book book = new Book();
		Book bookPersisted = client.target(REST_SERVICE_URL).request()
				.post(Entity.entity(book, MediaType.APPLICATION_JSON), Book.class);

		String bookId = bookPersisted.getID();

		// 2. Fetch book by id
		Book book2 = client.target(REST_SERVICE_URL).path("/{bookId}").resolveTemplate("bookId", bookId).request()
				.get(Book.class);

		// 3. Fetch all books
		GenericType<List<Book>> bookType = new GenericType<List<Book>>()
		{
		}; // generic type to wrap a generic list of books
		List<Book> books = client.target(REST_SERVICE_URL).request().get(bookType);
//
		// 4. Delete a book
		client.target(REST_SERVICE_URL).path("/{bookId}").resolveTemplate("bookId", bookId).request().delete();
		List<Book> books2 = client.target(REST_SERVICE_URL).request().get(bookType);
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getBookJSON()
	{
		Book book = new Book();
		Book bookPersisted = client.target(REST_SERVICE_URL).request()
				.post(Entity.entity(book, MediaType.APPLICATION_JSON), Book.class);

		String bookId = bookPersisted.getID();

		// 2. Fetch book by id
		Book book2 = client.target(REST_SERVICE_URL).path("/{bookId}").resolveTemplate("bookId", bookId).request()
				.get(Book.class);

		// 3. Fetch all books
		GenericType<List<Book>> bookType = new GenericType<List<Book>>()
		{
		}; // generic type to wrap a generic list of books
		List<Book> books = client.target(REST_SERVICE_URL).request().get(bookType);
//
		// 4. Delete a book
		client.target(REST_SERVICE_URL).path("/{bookId}").resolveTemplate("bookId", bookId).request().delete();
		List<Book> books2 = client.target(REST_SERVICE_URL).request().get(bookType);
	
	}
}
