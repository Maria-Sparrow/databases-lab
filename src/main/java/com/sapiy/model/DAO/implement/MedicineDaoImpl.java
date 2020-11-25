package com.sapiy.model.DAO.implement;

import com.sapiy.DatabaseConnector;
import com.sapiy.model.DAO.MedicineDao;
import com.sapiy.model.entity.Medicine;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {
    private static final String GET_ALL_QUERY = "SELECT * FROM third_lab_db.medicine;";

    private static final String GET_ONE_QUERY = "SELECT * FROM third_lab_db.medicine WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO third_lab_db.medicine (id, name, price, medicine_storage_id, medicine_categories_id,using_in_life_id) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE third_lab_db.medicine SET price = ?,medicine_storage_id = ?, medicine_categories_id = ?, using_in_life_id = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM third_lab_db.medicine WHERE id = ?;";

    @Override
    public List<Medicine> findAll() {
        List<Medicine> medicines = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name") ,
                        resultSet.getString("price"),
                        resultSet.getInt("medicine_storage_id"),
                        resultSet.getInt("medicine_categories_id"),
                        resultSet.getInt("using_in_life_id")
                );

                medicines.add(medicine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public Medicine findOne(Integer id) {
        Medicine medicine = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name") ,
                        resultSet.getString("price"),
                        resultSet.getInt("medicine_storage_id"),
                        resultSet.getInt("medicine_categories_id"),
                        resultSet.getInt("using_in_life_id")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicine;
    }

    @Override
    public void create(Medicine medicine) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, -1);
            statement.setString(2, String.valueOf(medicine.getName()));
            statement.setString(3, String.valueOf(medicine.getPrice()));
            statement.setString(4, String.valueOf(medicine.getMedicine_storage_id()));
            statement.setString(5, String.valueOf(medicine.getMedicine_categories_id()));
            statement.setString(6, String.valueOf(medicine.getUsing_in_life_id()));

            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Medicine medicine) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, medicine.getName());
            statement.setInt(2, medicine.getId());
            statement.setString(3, String.valueOf(medicine.getPrice()));
            statement.setString(4, String.valueOf(medicine.getMedicine_storage_id()));
            statement.setString(5, String.valueOf(medicine.getMedicine_categories_id()));
            statement.setString(6, String.valueOf(medicine.getUsing_in_life_id()));

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



