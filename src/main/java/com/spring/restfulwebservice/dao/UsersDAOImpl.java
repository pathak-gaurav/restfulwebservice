package com.spring.restfulwebservice.dao;

import com.spring.restfulwebservice.entity.Users;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Repository
@Transactional
public class UsersDAOImpl implements UsersDAO {

    private EntityManager entityManager;

    public UsersDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Users> getUsers() {
        Session session = entityManager.unwrap(Session.class);
        List<Users> resultList = session.createNamedQuery("users.get_all_users", Users.class).getResultList();
        if (resultList.isEmpty()) {
            session.save(new Users("zackandreson", "Zack", "Anderson",
                    LocalDate.of(1990, Month.JANUARY, 22)));
            session.save(new Users("zoella", "Zoella", "Sugg",
                    LocalDate.of(1990, Month.AUGUST, 17)));
            session.save(new Users("alfiedeyes", "Alfie", "Deyes",
                    LocalDate.of(1990, Month.MARCH, 05)));
        }
        return resultList;
    }

    @Override
    public Users getUser(Long userId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Users.class, userId);
    }

    @Override
    public void deleteUser(Users user) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(user);
    }

    @Override
    public void saveUser(Users users) {
        Session session = entityManager.unwrap(Session.class);
        session.save(users);
    }

    @Override
    public void updateUsers(Users users) {
        Session session = entityManager.unwrap(Session.class);
        session.update(users);
    }
}
