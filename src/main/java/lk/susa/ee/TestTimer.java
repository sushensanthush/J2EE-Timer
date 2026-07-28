package lk.susa.ee;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.susa.ee.ejb.TimerSessionBean;
import lk.susa.ee.Task;

import java.io.IOException;

@WebServlet("/test-timer")
public class TestTimer extends HttpServlet {

    @EJB
    private TimerSessionBean timerSessionBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = timerSessionBean.createTimer();
        resp.getWriter().write("Task created : "+task.getTaskId());
    }
}