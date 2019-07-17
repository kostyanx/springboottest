package hello.repositories;

import hello.entities.Application;
import hello.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findFirstByContactIdOrderByDtCreatedDesc(Long contactId);
}
