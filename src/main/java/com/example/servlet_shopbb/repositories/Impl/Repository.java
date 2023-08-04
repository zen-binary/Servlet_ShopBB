package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.repositories.IRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> implements IRepository<T> {

    private Class<T> entityType;

    public Repository(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query<T> query = session.createQuery("FROM " + entityType.getSimpleName());
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public T getById(Integer id) {
        T t = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "FROM " + entityType.getSimpleName() + " WHERE id = :id";
            Query<T> query = session.createQuery(hql, entityType);
            query.setParameter("id", id);
            t = (T) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean save(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
