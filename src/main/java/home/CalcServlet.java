package home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Answer")

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        int num1, num2;

        pw.println("<center>");
        pw.println("""
                <style>
                    body{background: palegreen}
                </style>""");
        pw.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\n");
        String str = req.getParameter("operation");
        num1 = Integer.parseInt(req.getParameter("first"));
        num2 = Integer.parseInt(req.getParameter("second"));
        switch (str) {
            case "+" -> pw.println("<h1>Result: " + (num1 + num2) + "</h1>");
            case "-" -> pw.println("<h1>Result: " + (num1 - num2) + "</h1>");
            case "*" -> pw.println("<h1>Result: " + (num1 * num2) + "</h1>");
            case "%" -> {
                if (num1 % num2 != 0) {
                    pw.println("<h1>Result: " + ((float)num1 / num2) + "</h1>");
                }
                else {
                    pw.println("<h1>Result: " + (num1 / num2) + "</h1>");
                }
            }
        }
        pw.println("<a href=index.html>BACK</a>");
        pw.println("</center>");
    }
}
