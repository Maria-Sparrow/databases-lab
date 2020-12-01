package com.sapiy.model.DAO.implement;

import com.sapiy.HibernateUtil;
import com.sapiy.model.DAO.MedicineDao;
import com.sapiy.model.entity.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {
  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Medicine> findAll() {
    List<Medicine> medicines = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      medicines = session.createQuery("from Medicine").getResultList();
      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return medicines;
  }

  @Override
  public Medicine findOne(Integer id) throws SQLException {
    Medicine medicine = null;
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      medicine = session.get(Medicine.class, id);
      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return medicine;
  }

  @Override
  public void create(Medicine medicine) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(medicine);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Medicine medicine) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(medicine);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Medicine medicine = session.get(Medicine.class, id);
      if (medicine != null) {
        session.delete(medicine);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}



