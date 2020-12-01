package com.sapiy.model.DAO.implement;

import com.sapiy.HibernateUtil;
import com.sapiy.model.DAO.ProducerDao;
import com.sapiy.model.entity.Producer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerDaoImpl implements ProducerDao {
  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Producer> findAll() {
    List<Producer> producers = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      producers = session.createQuery("from Producer ").getResultList();
      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return producers;
  }

  @Override
  public Producer findOne(Integer id) throws SQLException {
    Producer producer = null;
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      producer = session.get(Producer.class, id);
      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return producer;
  }

  @Override
  public void create(Producer producer) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(producer);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Producer producer) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(producer);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Producer producer = session.get(Producer.class, id);
      if (producer != null) {
        session.delete(producer);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
