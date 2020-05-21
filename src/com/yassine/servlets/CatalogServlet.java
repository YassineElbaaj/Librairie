package com.yassine.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yassine.models.*;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

	private List entities;
	private String entity = null;
	private static SessionFactory factory;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			entity = request.getParameter("entity");
			
			if(entity.equals("books")) {

				request.setAttribute("entity", "Books");

				factory = new Configuration()
						.configure()
						.addPackage("com.yassine.models")
						.addAnnotatedClass(Book.class)
						.addAnnotatedClass(Genre.class)
						.addAnnotatedClass(Author.class)
						.buildSessionFactory();
				
				entities = getAllBooks();
			}
			
			else if(entity.equals("authors")) {
				
				request.setAttribute("entity","Authors");
				
				factory = new Configuration()
						.configure()
						.addPackage("com.yassine.models")
						.addAnnotatedClass(Author.class)
						.buildSessionFactory();
				
				entities = getAllAuthors();
						
			}
			else if(entity.equals("genres")) {
				
				request.setAttribute("entity", "Genres");
				
				factory = new Configuration()
						.configure()
						.addPackage("com.yassine.models")
						.addAnnotatedClass(Genre.class)
						.buildSessionFactory();
				
				entities = getAllGenres();
				
			}
			
			request.setAttribute("entities", entities);

		}
		catch(NullPointerException e) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		catch(Exception e) {

			System.out.println("Failed to create sessionFactory object." + e.getMessage() );
			
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/catalog.jsp").forward(request, response);

	}

	public ArrayList<Book> getAllBooks(){

		Session session = factory.openSession();
		Transaction tx = null;

		List books = null;

		try {
			tx = session.beginTransaction();
			books =(ArrayList<Book>)  session.createQuery("FROM Book").list();
			
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

		return  (ArrayList<Book>) books;
	}

	public ArrayList<Author> getAllAuthors(){

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
		return (ArrayList<Author>) authors;
	}
	
	public ArrayList<Genre> getAllGenres(){
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		List genres = null;
		
		try {
			tx = session.beginTransaction();
			genres = (ArrayList<Genre>) session.createQuery("FROM Genre").list();
			
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
		
		return (ArrayList<Genre>) genres ;
	}
}
