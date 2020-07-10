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
import model.AccountInfoLogic;

@WebServlet("/AccountInfo")
public class AccountInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet (HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("AccountInfoServlet here!");
        
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward( request, response );
    }

    protected void doPost (HttpServletRequest request,
                           HttpServletResponse response)
        throws ServletException, IOException {

        // loginOK.jspから userId を受け取る
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");

        // データベースに userId をキーにしてアカウント情報を問い合わせる
        Account account = AccountInfoLogic.execute( userId );

        // リクエストスコープにセット
        request.setAttribute( "account", account );

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/accountInfo.jsp");
        dispatcher.forward( request, response );
    }
}

// 修正時刻： Fri Jul 10 21:02:26 2020







