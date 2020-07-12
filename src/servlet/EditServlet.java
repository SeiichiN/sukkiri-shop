package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.AccountLogic;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet (HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("EditServlet here!");
        
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/accountInfo.jsp");
        dispatcher.forward( request, response );
    }

    protected void doPost (HttpServletRequest request,
                           HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        int age = Integer.parseInt( request.getParameter("age") );

        Account account = new Account( userId, pass, mail, name, age);
        boolean result = AccountLogic.execute( account );

        // 登録成功
        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute( "userId", userId );

            System.out.println("登録成功");

            RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
            dispatcher.forward( request, response );
        }
        // 登録失敗
        else {
            System.out.println("登録失敗");
            response.sendRedirect("/sukkiriShop/WelcomeServlet");
        }
        
    }
    
}

// 修正時刻： Sun Jul 12 10:42:26 2020
