package com.sapiy.model.DAO.implement;

import com.sapiy.HibernateUtil;
import com.sapiy.model.DAO.MedicineStorageDao;
import com.sapiy.model.entity.MedicineStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineStorageDaoImpl implements MedicineStorageDao {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<MedicineStorage> findAll() {
        List<MedicineStorage> medicineStorages = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            medicineStorages = session.createQuery("from MedicineStorage ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineStorages;
    }

    @Override
    public MedicineStorage findOne(Integer id) throws SQLException {
        MedicineStorage medicineStorage = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            medicineStorage = session.get(MedicineStorage.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineStorage;
    }

    @Override
    public void create(MedicineStorage medicineStorage) throws SQLException{
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(medicineStorage);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, MedicineStorage medicineStorage) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(medicineStorage);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            MedicineStorage medicineStorage = session.get(MedicineStorage.class, id);
            if (medicineStorage != null){
                session.delete(medicineStorage);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
