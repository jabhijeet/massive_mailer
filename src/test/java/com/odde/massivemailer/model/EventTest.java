package com.odde.massivemailer.model;

import com.odde.TestWithDB;
import com.odde.massivemailer.service.LocationProviderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(TestWithDB.class)
public class EventTest {

    private final Event singaporeEvent = new Event("Scrum In Singapore", "", "Singapore");
    private final Event singaporeEventTwo = new Event("A-TDD In Singapore", "", "Singapore");
    private final Event bangkokEvent = new Event("Code Smells In Bangkok", "", "Bangkok");
    private final Event tokyoEvent = new Event("Code Refactoring In Tokyo", "", "Tokyo");

    private final ContactPerson singaporeContact = new ContactPerson("testName1", "test1@gmail.com", "test1LastName", "", "Singapore");
    private final ContactPerson singaporeContactTwo = new ContactPerson("testName2", "test2@gmail.com", "test2LastName", "", "Singapore");
    private final ContactPerson tokyoContact = new ContactPerson("testName3", "test3@gmail.com", "test3LastName", "", "Tokyo");
    private final ContactPerson noLocContact= new ContactPerson("testName4", "test4@gmail.com", "test4LastName", "", null);

    @Test
    public void shouldCreateEventWithTitleAsTest() {
        Event event = new Event("test","content","Singapore");
        Assert.assertEquals("test", event.getTitle());
        Assert.assertEquals("content", event.getContent());
        Assert.assertEquals("Singapore", event.getLocation());

        event.setTitle("test2");
        Assert.assertEquals("test2", event.getTitle());
    }

    @Test
    public void numberOfEventsSendToAllContacts() throws Exception {
        singaporeEvent.saveIt();
        bangkokEvent.saveIt();
        singaporeContact.saveIt();

        assertEquals(2, Event.numberOfEventsNear(ContactPerson.findValidLocations(), new LocationProviderService()));


    }
}
