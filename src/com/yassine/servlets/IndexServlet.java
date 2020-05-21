package com.yassine.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.yassine.models.Author;
import com.yassine.models.Book;
import com.yassine.models.Genre;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static SessionFactory factory;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			factory = new Configuration()
					.configure()
					.addPackage("com.yassine.models")
					.addAnnotatedClass(Book.class)
					.addAnnotatedClass(Author.class)
					.addAnnotatedClass(Genre.class)
					.buildSessionFactory();
			
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Long authors =  (Long) session.createQuery("select count(*) from Author").uniqueResult();
			request.setAttribute("authors", authors.longValue());
			
			Long books = (Long) session.createQuery("select count(*) from Book").uniqueResult();
			request.setAttribute("books",books.longValue());
			
			Long genres = (Long) session.createQuery("select count(*) from Genre").uniqueResult();
			request.setAttribute("genres", genres.longValue());
			
			tx.commit();
			session.close();
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
