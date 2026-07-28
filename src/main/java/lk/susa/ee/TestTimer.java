package lk.susa.ee;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lk.susa.ee.ejb.TimerSessionBean;


@WebServlet(value = "/test-timer")
public class TestTimer extends HttpServlet{

    @EJB
    private TimerSessionBean timerService;

    @Override
    protected void service(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) {
        timerService.createTimer();
    }

}
