package com.sapiy.model.DAO.implement;

import com.sapiy.HibernateUtil;
import com.sapiy.model.DAO.UsingInLifeDao;

import com.sapiy.model.entity.UsingInLife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsingInLifeDaoImpl implements UsingInLifeDao{
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<UsingInLife> findAll() {
        List<UsingInLife> usingInLives = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            usingInLives = session.createQuery("from UsingInLife ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usingInLives;
    }

    @Override
    public UsingInLife findOne(Integer id) throws SQLException {
        UsingInLife usingInLife = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            usingInLife = session.get(UsingInLife.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usingInLife;
    }

    @Override
    public void create(UsingInLife usingInLife) throws SQLException{
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(usingInLife);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, UsingInLife usingInLife) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(usingInLife);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            UsingInLife usingInLife = session.get(UsingInLife.class, id);
            if (usingInLife != null){
                session.delete(usingInLife);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
