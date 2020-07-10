package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteLogic;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet (HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("DeleteServlet here!");
        
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
        dispatcher.forward( request, response );
    }

    protected void doPost (HttpServletRequest request,
                           HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");

        boolean result = DeleteLogic.execute( userId );

        // 成功
        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute( "userId", userId );

            System.out.println("削除成功");

            RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
            dispatcher.forward( request, response );
        }
        // 登録失敗
        else {
            System.out.println("削除失敗");
            response.sendRedirect("/sukkiriShop/WelcomeServlet");
        }
    }
}

// 修正時刻： Fri Jul 10 20:10:13 2020
