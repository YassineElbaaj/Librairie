package com.yassine.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yassine.models.Author;
import com.yassine.models.Book;
import com.yassine.models.Genre;

@WebServlet({ "/create", "/detail/books", "/detail/authors", "/detail/genres","/delete" })
public class FormServlet extends HttpServlet {

	private String entity = null;
	String id = null;
	private static SessionFactory factory;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		factory = new Configuration()
				.configure()
				.addPackage("com.yassine.models")
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Author.class)
				.addAnnotatedClass(Genre.class)
				
				.buildSessionFactory();

		try {
			if(request.getServletPath().equals("/create")) {

				entity = request.getParameter("entity");

				if(entity.equals("genres")) {

					request.setAttribute("entity","Genre");

				}
				else if(entity.equals("authors")) {

					request.setAttribute("entity","Author");

				}
				else if(entity.equals("books")) {

					request.setAttribute("entity", "Book");

					Session session = factory.openSession();
					Transaction tx = null;

					List authors = null;
					
					try {
						tx = session.beginTransaction();
						authors = (ArrayList<Author>) session.createQuery("FROM Author").list();

						tx.commit();
					}
					catch(HibernateException e) {
						if(tx != null) {
							tx.rollback();
							e.printStackTrace();
						}
					}
					finally {
						session.close();
					}
					request.setAttribute("authorList", authors);
				}
				else {

					request.setAttribute("error", "Error 404 : This page does not exist !");

				}

				this.getServletContext().getRequestDispatcher("/WEB-INF/forms.jsp").forward(request, response);

			}
			else if(request.getServletPath().equals("/delete")) {
				
				entity = request.getParameter("entity");
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
		
			}
			else if(request.getServletPath().equals("/detail/books")){

				entity = "Book";

				request.setAttribute("entity", entity);

				id = request.getParameter("id");

				Session session = factory.openSession();

				Book book = (Book) session.get(Book.class, Integer.parseInt(id));
				
				request.setAttribute("myBook", book);

				Author author = (Author) session.get(Author.class,book.getAuthor().getId() );

				request.setAttribute("authorNom", author.getNom());
				request.setAttribute("authorPrenom", author.getPrenom());

				Genre genre = (Genre) session.get(Genre.class, book.getGenre().getId());

				request.setAttribute("bookGenre", genre.getName());

				session.close();

				this.getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);

			}
			else if(request.getServletPath().equals("/detail/authors")) {

				entity = "Author";

				request.setAttribute("entity", entity);

				id = request.getParameter("id");

				Session session = factory.openSession();

				Author author = session.get(Author.class, Integer.parseInt(id));

				request.setAttribute("myAuthor", author);

				session.close();

				this.getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);
			}
			else if(request.getServletPath().equals("/detail/genres")) {

				entity = "Genre";

				request.setAttribute("entity", entity);

				id = request.getParameter("id");

				Session session = factory.openSession();

				Genre genre = session.get(Genre.class, Integer.parseInt(id));

				request.setAttribute("myGenre", genre);

				session.close();

				this.getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);

			}
		}
		catch(NullPointerException e) {

			request.setAttribute("error", "Error 404 : This page does not exist !");

			this.getServletContext().getRequestDispatcher("/WEB-INF/forms.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		entity = request.getParameter("entity");

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			if(entity.equals("genres")) {

				tx = session.beginTransaction();

				String name = request.getParameter("name");
				Genre genre = new Genre(name);
				int id = (int) session.save("Genre", genre);

				tx.commit();

				response.sendRedirect("http://localhost:8080/Librairie/detail/genres?id="+id);
			}
			else if(entity.equals("authors")) {
				tx = session.beginTransaction();

				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				Author author = new Author(nom,prenom);
				int id = (int) session.save("Author",author);

				tx.commit();

				response.sendRedirect("http://localhost:8080/Librairie/detail/authors?id="+id);	

			}
			else if(entity.equals("books")) {
				tx = session.beginTransaction();

			}
		}
		catch (HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		entity = request.getParameter("entity");
		
		id = request.getParameter("id");
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			if(entity.equals("books")) {
				tx = session.beginTransaction();
				Book book = session.get(Book.class, Integer.parseInt(id));
				session.delete(book);
				tx.commit();
			}
			
		}
		catch(HibernateException e) {
			 if (tx!=null) {
				 tx.rollback();
			 }
	         e.printStackTrace(); 
		}
		finally {
			session.close();
		}
		
	}

}
