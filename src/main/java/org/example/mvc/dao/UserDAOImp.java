package org.example.mvc.dao;

import org.example.mvc.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDAOImp implements UserDao {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public Optional<User> getUser(int id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public void deleteUserById(int id) {
        User user = getUser(id).get();
        em.remove(user);
    }

}
