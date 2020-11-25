package com.sapiy.model.DAO.implement;

import com.sapiy.DatabaseConnector;
import com.sapiy.model.DAO.ProducerDao;
import com.sapiy.model.entity.Producer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProducerDaoImpl implements ProducerDao {
    private static final String GET_ALL_QUERY = "SELECT * FROM third_lab_db.producer;";

    private static final String GET_ONE_QUERY = "SELECT * FROM third_lab_db.producer WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO third_lab_db.producer (id, name_producer) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE third_lab_db.producer SET name_producer = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM third_lab_db.producer WHERE id = ?;";

    @Override
    public List<Producer> findAll() {
        List<Producer> producers= new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Producer producer = new Producer(
                        resultSet.getInt("id"),
                        resultSet.getString("name_producer") );
                producers.add(producer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producers;
    }

    @Override
    public Producer findOne(Integer id) {
        Producer producer = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
           statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                producer = new Producer(
                        resultSet.getInt("id"),
                        resultSet.getString("name_producer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producer;
    }

    @Override
    public void create(Producer producer) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, -1);
            statement.setString(2, String.valueOf(producer.getName_producer()));

            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Producer producer) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, producer.getName_producer());
            statement.setInt(2, producer.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
