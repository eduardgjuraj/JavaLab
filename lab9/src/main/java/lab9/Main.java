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
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Set<Persoana> setPersoane = new HashSet<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		if(request.getParameter("adauga")==null) {
			out.println("<html><head><title></title><body>");
			out.println("<form method ='POST'>");
			out.println("<table>");
			out.println("<tr><td>Nume</td><td><input type='text' name='nume'></td></tr>");
			out.println("<tr><td>Prenume</td><td><input type='text' name='prenume'></td></tr>");

			out.println("<tr><td>Data nasterii</td>");
			out.println("<td><input type='text' name='zi' placeholder='Zi'></td>");
			out.println("<td><input type='text' name='luna' placeholder='Luna'></td>");
			out.println("<td><input type='text' name='an' placeholder='An'></td></tr>");;
		
			out.println("<tr><td>Adresa</td><td><input type='text' name='adresa'> </td></tr>");
		
			out.println("<tr><td>Telefon</td><td><input type='text' name='telefon'> </td></tr>");
		
			out.println("<tr><td><input type='submit' value = 'Adaugare' name='adauga'></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();  
		
		if(request.getParameter("adauga") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String zi = request.getParameter("zi");
			String luna = request.getParameter("luna");
			String an = request.getParameter("an");
			String adresa = request.getParameter("adresa");
			String telefon = request.getParameter("telefon");
			Persoana persoana = new Persoana(nume, prenume, zi, luna, an, adresa, telefon);
		setPersoane.add(persoana);
		}
		
           out.println("<html><head><title>Tabel Persoane</title></head><body>");
           out.println("Persoanele introduse");
           
          
           
           out.println("<table border=1>");
           out.println("<tr><th>Nume</th><th>Prenume</th><th>Data nasterii</th><th>Adresa</th><th>Telefon</th></tr>");
           
           String selectedMonth = request.getParameter("selectedMonth");
           
           		for(Persoana p : setPersoane) {
           			if(request.getParameter("vizualizare")!=null){
           				if(selectedMonth.equals(p.getLuna()))
           				{
           					out.println(p.toString());
           				}
           				else if(selectedMonth.equals("default"))
           				{
           					out.println(p.toString());
           				}
           			}else 
       					out.println(p.toString());
           		}
            
            	out.println("</table>");
           
 
            	out.println("<form method='POST'>");
                out.println("<input type='submit' value='Vizualizare' name='vizualizare'>");
                out.println("<select name='selectedMonth'>");
                out.println("<option value='default'>Select month </option>");
                out.println("<option value='1'>ianuarie</option>");
                out.println("<option value='2'>februarie</option>");
                out.println("<option value='3'>martie</option>");
                out.println("<option value='4'>aprilie</option>");
                out.println("<option value='5'>mai</option>");
                out.println("<option value='6'>iunie</option>");
                out.println("<option value='7'>iulie</option>");
                out.println("<option value='8'>august</option>");
                out.println("<option value='9'>septembrie</option>");
                out.println("<option value='10'>octombrie</option>");
                out.println("<option value='11'>noiembrie</option>");
                out.println("<option value='12'>decembrie</option>");
                out.println("</select>");
                out.println("</form>");
            	
        out.println("</body></html>");
        
	}
}
