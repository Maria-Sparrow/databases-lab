package com.sapiy.model.DAO.implement;

import com.sapiy.HibernateUtil;
import com.sapiy.model.DAO.TypeOfPackingDao;
import com.sapiy.model.entity.TypeOfPacking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfPackingDaoImpl implements TypeOfPackingDao {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<TypeOfPacking> findAll() {
        List<TypeOfPacking> typeOfPackings = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            typeOfPackings = session.createQuery("from TypeOfPacking ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeOfPackings;
    }

    @Override
    public TypeOfPacking findOne(Integer id) throws SQLException {
        TypeOfPacking typeOfPacking = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            typeOfPacking = session.get(TypeOfPacking.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeOfPacking;
    }

    @Override
    public void create(TypeOfPacking typeOfPacking) throws SQLException{
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(typeOfPacking);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, TypeOfPacking typeOfPacking) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(typeOfPacking);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            TypeOfPacking typeOfPacking = session.get(TypeOfPacking.class, id);
            if (typeOfPacking != null){
                session.delete(typeOfPacking);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

