package lab9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vizualizare
 */
@WebServlet("/Vizualizare")
public class Vizualizare extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vizualizare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // Adăugare persoana în colecția de persoane
		PrintWriter out = response.getWriter();

       
        out.println("<html><head><title>Tabel Persoane</title></head><body>");
        out.println("Persoanele introduse");
        out.println("<table border=1>");
        out.println("<tr><th>Nume</th><th>Prenume</th><th>Data nasterii</th><th>Adresa</th><th>Telefon</th></tr>");
        
       
        
        out.println("</table>");
        
        out.println("<tr><td><input type='submit' value = 'Vizualizare' name='Vizualizare'> </td></tr>");
	}

}
