package com.sapiy.model.DAO.implement;

import com.sapiy.DatabaseConnector;
import com.sapiy.model.DAO.MedicineStorageDao;
import com.sapiy.model.entity.MedicineStorage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineStorageDaoImpl implements MedicineStorageDao {
    private static final String GET_ALL_QUERY = "SELECT * FROM third_lab_db.medicine_storage;";

    private static final String GET_ONE_QUERY = "SELECT * FROM third_lab_db.medicine_storage WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO third_lab_db.medicine_storage (id, storage) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE third_lab_db.medicine_storage SET storage = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM third_lab_db.medicine_storage WHERE id = ?;";

    @Override
    public List<MedicineStorage> findAll() {
        List<MedicineStorage> medicineStorages = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MedicineStorage medicineStorage = new MedicineStorage(
                        resultSet.getInt("id"),
                        resultSet.getString("storage") );
                        medicineStorages.add(medicineStorage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineStorages;
    }

    @Override
    public MedicineStorage findOne(Integer id) {
        MedicineStorage medicineStorage = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                medicineStorage = new MedicineStorage(
                        resultSet.getInt("id"),
                        resultSet.getString("storage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineStorage;
    }

    @Override
    public void create(MedicineStorage medicineStorage) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, -1);
            statement.setString(2, String.valueOf(medicineStorage.getStorage()));
            statement.executeUpdate();
            System.out.println(statement);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, MedicineStorage medicineStorage) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, medicineStorage.getStorage());
            statement.setInt(2, medicineStorage.getId());
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
