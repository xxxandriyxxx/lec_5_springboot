package owu2018.lec_5_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import owu2018.lec_5_springboot.models.User;



@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
    //CRUD

}
