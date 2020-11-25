package com.sapiy.model.DAO.implement;

import com.sapiy.DatabaseConnector;
import com.sapiy.model.DAO.TypeOfPackingDao;
import com.sapiy.model.entity.TypeOfPacking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeOfPackingDaoImpl implements TypeOfPackingDao {
    private static final String GET_ALL_QUERY = "SELECT * FROM third_lab_db.type_of_packing;";

    private static final String GET_ONE_QUERY = "SELECT * FROM third_lab_db.type_of_packing WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO third_lab_db.type_of_packing (id, type) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE third_lab_db.type_of_packing SET type = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM third_lab_db.type_of_packing WHERE id = ?;";

    @Override
    public List<TypeOfPacking> findAll() {
        List<TypeOfPacking> typeOfPackings= new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TypeOfPacking typeOfPacking = new TypeOfPacking(
                        resultSet.getInt("id"),
                        resultSet.getString("type") );
                typeOfPackings.add(typeOfPacking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeOfPackings;
    }

    @Override
    public TypeOfPacking findOne(Integer id) {
        TypeOfPacking typeOfPacking = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                typeOfPacking = new TypeOfPacking(
                        resultSet.getInt("id"),
                        resultSet.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeOfPacking;
    }

    @Override
    public void create(TypeOfPacking typeOfPacking) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, -1);
            statement.setString(2, String.valueOf(typeOfPacking.getType()));

            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, TypeOfPacking typeOfPacking) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, typeOfPacking.getType());
            statement.setInt(2, typeOfPacking.getId());
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

