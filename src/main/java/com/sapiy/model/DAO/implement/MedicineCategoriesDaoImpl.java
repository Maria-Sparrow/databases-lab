package com.sapiy.model.DAO.implement;

import com.sapiy.model.DAO.MedicineCategoriesDao;
import com.sapiy.model.entity.MedicineCategories;
import com.sapiy.DatabaseConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineCategoriesDaoImpl implements MedicineCategoriesDao {


    private static final String GET_ALL_QUERY = "SELECT * FROM third_lab_db.medicine_categories;";

    private static final String GET_ONE_QUERY = "SELECT * FROM third_lab_db.medicine_categories WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO third_lab_db.medicine_categories (id, categories) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE third_lab_db.medicine_categories SET categories = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM third_lab_db.medicine_categories WHERE id = ?;";

    @Override
    public List<MedicineCategories> findAll() {
        List<MedicineCategories> medicineCategory = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MedicineCategories medicineCategories = new MedicineCategories(
                        resultSet.getInt("id"),
                        resultSet.getString("categories")
                );
                medicineCategory.add(medicineCategories);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineCategory;
    }

    @Override
    public MedicineCategories findOne(Integer id) {
        MedicineCategories medicineCategories = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                medicineCategories = new MedicineCategories(
                        resultSet.getInt("id"),
                        resultSet.getString("username")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineCategories;
    }

    @Override
    public void create(MedicineCategories medicineCategories) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, -1);
            statement.setString(2, String.valueOf(medicineCategories.getCategories()));
            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, MedicineCategories medicineCategories) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, medicineCategories.getCategories());
            statement.setInt(2, medicineCategories.getId());
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


