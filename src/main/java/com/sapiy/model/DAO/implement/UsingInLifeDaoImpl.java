package com.sapiy.model.DAO.implement;

import com.sapiy.DatabaseConnector;
import com.sapiy.model.DAO.UsingInLifeDao;
import com.sapiy.model.entity.TypeOfPacking;
import com.sapiy.model.entity.UsingInLife;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsingInLifeDaoImpl implements UsingInLifeDao{
    private static final String GET_ALL_QUERY = "SELECT * FROM third_lab_db.using_in_life;";

    private static final String GET_ONE_QUERY = "SELECT * FROM third_lab_db.using_in_life WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO third_lab_db.using_in_life (id, using_in) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE third_lab_db.using_in_life SET using_in = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM third_lab_db.using_in_life WHERE id = ?;";

    @Override
    public List<UsingInLife> findAll() {
        List<UsingInLife> usingInLives= new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UsingInLife usingInLife = new UsingInLife(
                        resultSet.getInt("id"),
                        resultSet.getString("using_in") );
                usingInLives.add(usingInLife);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usingInLives;
    }

    @Override
    public UsingInLife findOne(Integer id) {
        UsingInLife usingInLife = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                usingInLife = new UsingInLife(
                        resultSet.getInt("id"),
                        resultSet.getString("using_in"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usingInLife;
    }

    @Override
    public void create(UsingInLife usingInLife) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, -1);
            statement.setString(2, String.valueOf(usingInLife.getUsing_in()));

            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, UsingInLife usingInLife) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, usingInLife.getUsing_in());
            statement.setInt(2, usingInLife.getId());
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
