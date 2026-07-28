package lk.susa.ee;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lk.susa.ee.ejb.TimerSessionBean;

@WebServlet(value = "/cancel-timer")
public class CancelTimer extends HttpServlet {

    @EJB
    private TimerSessionBean timerSessionBean;

    @Override
    protected void service(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp){
        timerSessionBean.cancelTimer();
    }
}
