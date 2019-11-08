package com.ocr.noel.escalade2.repository;

import com.ocr.noel.escalade2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

//@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByFirstName(String firstName);

    List<User> findAllByLastName(String lastName);
}