package com.odde.massivemailer.controller;

import com.google.gson.Gson;
import com.odde.massivemailer.exception.EventAlreadyExistsException;
import com.odde.massivemailer.model.Event;
import com.odde.massivemailer.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EventsController extends HttpServlet {
    private EventService eventService;

    public EventsController(EventService eventService) {
        setEventService(eventService);
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String convertedContactToJSON = new Gson().toJson(eventService.getAll());

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print(convertedContactToJSON);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resultMsg = "";

        Event event = buildEventObject(req);
        try {
            if (eventService.addEvent(event) > 0) {
                resultMsg = "status=success&msg=Add event successfully";
            }
        } catch (EventAlreadyExistsException e) {
            resultMsg = "status=failed&msg=" + e.getMessage();
        }

        resp.sendRedirect("eventlist.jsp?" + resultMsg);
    }

    private Event buildEventObject(HttpServletRequest req) {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        return new Event(title, content);
    }
}
