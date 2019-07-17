package hello.controllers;

import hello.entities.Application;
import hello.entities.Contact;
import hello.exceptions.ApplicationNotFoundException;
import hello.exceptions.ContactNotFoundException;
import hello.repositories.ApplicationRepository;
import hello.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Contact contact(@PathVariable long id) {
        return contactRepository.findById(id).orElseThrow(ContactNotFoundException::new);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}/last_application",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Application lastApplication(@PathVariable long id) {
        boolean contactExists = contactRepository.existsById(id);
        if (!contactExists) { throw new ContactNotFoundException(); }
        Application result = applicationRepository.findFirstByContactIdOrderByDtCreatedDesc(id);
        if (result == null) { throw new ApplicationNotFoundException(); }
        return result;
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handle(Exception e) {
        return ResponseEntity.status(500).body("database error");
    }
}
