package steps;

import com.odde.massivemailer.model.Course;
import com.odde.massivemailer.model.Participant;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.odde.massivemailer.model.ContactPerson;
import org.junit.Assert;
import steps.driver.WebDriverFactory;
import steps.driver.WebDriverWrapper;


public class SendPreviewMailTest {

   /* private WebDriverWrapper driver = WebDriverFactory.getDefaultDriver();
    private String adminEmail, studentEmail;*/



    @Given("^there is a course starting from \"([^\"]*)\"$")
    public void there_is_a_course_starting_from(String arg1) throws Throwable {
        //Course.CourseBuilder courseBuilder = new Course.CourseBuilder();

    }

    @Given("^there are students with email  loaded for this course$")
    public void there_are_students_with_email_loaded_for_this_course() throws Throwable {
        ContactPerson contact = new ContactPerson("john","student@odd-e.com","kumar","","Singapore");
        contact.save();
            Assert.assertNull(contact.getEmail());
    }

    @When("^i send preview email for this course$")
    public void i_send_preview_email_for_this_course() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^admin@odd-e\\.com should receive the preview email$")
    public void admin_odd_e_com_should_receive_the_preview_email() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^there are students with email student@odd-e\\.com loaded for this course$")
    public void there_are_students_with_email_student_odd_e_com_loaded_for_this_course() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
