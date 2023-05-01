package org.example.mvc.dao;

import org.example.mvc.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
//public class UserDaoImpl implements UserDao {
//
//    private SessionFactory sessionFactory;
//
//    public UserDaoImpl() {
//    }
//
//    public UserDaoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    @Transactional
//    public List<User> getAllUsers() {
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
//        return session.createQuery("from User", User.class).getResultList();
//    }
//
//    @Override
//    @Transactional
//    public void createUser(User user) {
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
//
//        session.saveOrUpdate(user);
//    }
//
//    @Override
//    @Transactional
//    public User getUser(int id) {
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
//
//        return session.get(User.class, id);
//
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(int id) {
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
//
//        Query<User> query = session.createQuery("delete from User where id =:userId");
//        query.setParameter("userId", id);
//        query.executeUpdate();
//    }
//}
