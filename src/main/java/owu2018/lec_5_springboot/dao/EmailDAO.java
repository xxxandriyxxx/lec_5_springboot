package owu2018.lec_5_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import owu2018.lec_5_springboot.models.Email;


@Repository
public interface EmailDAO extends JpaRepository<Email, Integer> {
}
