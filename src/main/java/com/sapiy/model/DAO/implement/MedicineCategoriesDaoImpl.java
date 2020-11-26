package com.sapiy.model.DAO.implement;

import com.sapiy.HibernateUtil;
import com.sapiy.model.DAO.MedicineCategoriesDao;
import com.sapiy.model.entity.MedicineCategories;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineCategoriesDaoImpl implements MedicineCategoriesDao {


    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<MedicineCategories> findAll() {
        List<MedicineCategories> medicineCategories = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
          session.beginTransaction();
          medicineCategories = session.createQuery("from MedicineCategories").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineCategories;
    }

    @Override
    public MedicineCategories findOne(Integer id) throws SQLException {
        MedicineCategories medicineCategory = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            medicineCategory = session.get(MedicineCategories.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineCategory;
    }

    @Override
    public void create(MedicineCategories medicineCategory) throws SQLException{
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(medicineCategory);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, MedicineCategories medicineCategory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(medicineCategory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            MedicineCategories medicineCategory = session.get(MedicineCategories.class, id);
            if (medicineCategory != null){
                session.delete(medicineCategory);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


