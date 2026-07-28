package lk.jiat.ee;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.susa.ee.ejb.TimerSessionBean;

import java.io.IOException;

@WebServlet("/cancel-timer")
public class CancelTimer extends HttpServlet {

    @EJB
    private TimerSessionBean timerSessionBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        timerSessionBean.cancelTimer("b3967278-3eb9-456d-b5aa-28c85a3c5606");
    }
}