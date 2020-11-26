package com.test.ibrax.bdd;


import com.test.ibrax.documents.Subscriber;
import com.test.ibrax.documents.User;
import com.test.ibrax.repositories.SubscriberRepository;
import com.test.ibrax.repositories.UserRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;


/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */


public class SubscriberStepDefinition {

    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private UserRepository userRepository;

    private Subscriber subscriber;

    @Given("a subscriber with an {string} main address in France")
    public void a_subscriber_with_an_active_main_address_in_France(String query) {
        this.subscriber = this.subscriberRepository.save(new Subscriber("0707070707", "92230", "Gennivilliers", "52 rue test", query));
    }

    @When("the advisor connected to {string} changes the subscriber address")
    public void the_advisor_connected_to_channel_changes_the_subscriber_address(String username) {
        User user = this.userRepository.findByUsername(username);
        if (user != null) {
            this.subscriber.setCity("Saint denis");
            this.subscriber.setZipCode("93200");
            this.subscriber.setStreet("22 rue test");
            this.subscriber.setStatus("inactive");
        }

    }

    @Then("the changed subscriber address is recorded on all of the subscriber contracts")
    public void the_changed_subscriber_address_is_recorded_on_all_of_the_subscriber_contracts() {
        this.subscriberRepository.save(this.subscriber);
    }

    @And("an address modification movement is created")
    public void an_address_modification_movement_is_created() {
        Subscriber subscriber1 = subscriberRepository.findByPhone("0707070707");
        Assert.assertTrue(subscriber1.getStatus().equals("inactive"));
    }


}
