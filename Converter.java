import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Converter", urlPatterns = {"/Converter"})
public class Converter extends HttpServlet {
    private double exchangeRate = 1.0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String amountString = request.getParameter("amount");
            String rateString = request.getParameter("rate");

            double amount = Double.parseDouble(amountString);
            double rate = rateString.isEmpty() ? this.exchangeRate : Double.parseDouble(rateString);

            this.exchangeRate = rate;
            double result = amount * rate;

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Currency Converter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The result is: " + result + "</h1>");
            out.println("<form action=\"/converter/servlet/Converter\" method=\"post\">");
            out.println("<input type=\"text\" name=\"amount\" placeholder=\"Amount\" />");
            out.println("<input type=\"text\" name=\"rate\" placeholder=\"Exchange rate (leave empty to use the last one)\" />");
            out.println("<input type=\"submit\" value=\"Convert!\" />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}