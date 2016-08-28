package main.com.timur.servlet;

import main.com.timur.service.MessageService;
import main.com.timur.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "GreetingsServlet", urlPatterns = "/greetings")
public class GreetingsServlet extends HttpServlet {

    private MessageService messageService = new MessageServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String nickname = request.getParameter("nickname");

        nickname = nickname != null && !nickname.trim().isEmpty() ? nickname : "Anonymous";

        String greetings = messageService.getGreetings(nickname);
        String htmlGreeting = String.format("<h2> %s </h2>", greetings);

        writer.append(greetings);

    }
}
