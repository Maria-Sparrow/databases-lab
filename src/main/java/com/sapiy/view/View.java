package com.sapiy.view;

import com.sapiy.controller.impl.*;
import com.sapiy.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {
  private static final Scanner SCANNER = new Scanner(System.in);
  private final MedicineCategoriesController medicineCategoriesController = new MedicineCategoriesController();
  private final MedicineController medicineController = new MedicineController();
  private final MedicineStorageController medicineStorageController = new MedicineStorageController();
  private final ProducerController producerController = new ProducerController();
  private final TypeOfPackingController typeOfPackingController = new TypeOfPackingController();
  private final UseInLifeController useInLifeController = new UseInLifeController();

  private final Map<String, Printable> menu = new LinkedHashMap<>();


  public View() {

    menu.put("11", this::getAllMedicineCategories);
    menu.put("12", this::getMedicineCategoriesById);
    menu.put("13", this::createMedicineCategories);
    menu.put("14", this::updateMedicineCategories);
    menu.put("15", this::deleteMedicineCategories);

    menu.put("21", this::getAllMedicine);
    menu.put("22", this::getMedicineById);
    menu.put("23", this::createMedicine);
    menu.put("24", this::updateMedicine);
    menu.put("25", this::deleteMedicine);

    menu.put("31", this::getAllMedicineStorage);
    menu.put("32", this::getMedicineStorageById);
    menu.put("33", this::createMedicineStorage);
    menu.put("34", this::updateMedicineStorage);
    menu.put("35", this::deleteMedicineStorage);

    menu.put("41", this::getAllProducer);
    menu.put("42", this::getProducerById);
    menu.put("43", this::createProducer);
    menu.put("44", this::updateProducer);
    menu.put("45", this::deleteProducer);

    menu.put("51", this::getAllTypeOfPacking);
    menu.put("52", this::getTypeOfPackingById);
    menu.put("53", this::createTypeOfPacking);
    menu.put("54", this::updateTypeOfPacking);
    menu.put("55", this::deleteTypeOfPacking);

    menu.put("61", this::getAllUseInLife);
    menu.put("62", this::getUseInLifeById);
    menu.put("63", this::createUseInLife);
    menu.put("64", this::updateUseInLife);
    menu.put("65", this::deleteUseInLife);
  }

  public void displayMenu() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("                 Enter XY to choose the option, where:");
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("X - entity number:                 |       Y - CRUD number:");
    System.out.println("  1 - medicine                     |         1 - GET ALL");
    System.out.println("  2 - medicine category            |         2 - GET ONE");
    System.out.println("  3 - medicine storage             |         3 - CREATE");
    System.out.println("  4 - producer                     |         4 - UPDATE");
    System.out.println("  5 - type of packing              |         5 - DELETE");
    System.out.println("  6 - use in life");
    System.out.println("------------------------------------------------------------------------");
  }

  public final void show() {
    String input;
    displayMenu();
    System.out.println("\nChoose your fighter:\n");
    do {
      try {
        input = SCANNER.next();
        menu.get(input).print();
      } catch (Exception ignored) {
      }
    } while (SCANNER.hasNext());
  }

  private void getAllMedicineCategories() throws SQLException {
    System.out.println("\n[Medicine Categories / GET]");
    System.out.println(medicineCategoriesController.findAll() + "\n");
  }

  private void getMedicineCategoriesById() throws SQLException {
    System.out.println("\n[Medicine Categories / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(medicineCategoriesController.findOne(id) + "\n");
  }

  private MedicineCategories getMedicineCategoriesInputs() throws SQLException {
    System.out.println("\nEnter  ID: ");
    Integer id = SCANNER.nextInt();

    return new MedicineCategories(id, null);
  }

  private void createMedicineCategories() throws SQLException {
    System.out.println("\n[Medicine Categories / CREATE]");
    MedicineCategories medicineCategories = new MedicineCategories();
    medicineCategoriesController.create(medicineCategories);
    System.out.println("Medicine Category successfully created\n");
  }

  private void updateMedicineCategories() throws SQLException {
    System.out.println("\n[Medicine Categories / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    MedicineCategories medicineCategories = getMedicineCategoriesInputs();
    medicineCategories.setId(id);

    medicineCategoriesController.update(medicineCategories.getId(), medicineCategories);
    System.out.println("Medicine Categories with ID=" + id + " successfully updated\n");
  }

  private void deleteMedicineCategories() throws SQLException {
    System.out.println("\n[Medicine Categories / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    medicineCategoriesController.delete(id);
    System.out.println("Medicine Categories with ID=" + id + " successfully deleted\n");
  }


  private void getAllMedicine() throws SQLException {
    System.out.println("\n[Medicine / GET]");
    System.out.println(medicineController.findAll() + "\n");
  }

  private void getMedicineById() throws SQLException {
    System.out.println("\n[Medicine / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(medicineController.findOne(id) + "\n");
  }

  private Medicine getMedicineInputs() throws SQLException {
    System.out.println("Enter Medicine's ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println("Enter name: ");
    String name = SCANNER.next();
    System.out.println("Enter price: ");
    String price = SCANNER.next();
    System.out.println("Enter medicine_storage_id: ");
    MedicineStorage medicineStorage = medicineStorageController.findOne(id);
    System.out.println("Enter medicine_categories_id: ");
    MedicineCategories medicineCategories = medicineCategoriesController.findOne(id);
    System.out.println("Enter using_in_life_id: ");
    UsingInLife usingInLife = useInLifeController.findOne(id);

    return new Medicine(id, name, price, medicineStorage, medicineCategories, usingInLife);
  }

  private void createMedicine() throws SQLException {
    System.out.println("\n[Medicine / CREATE]");
    Medicine medicine = getMedicineInputs();
    medicineController.create(medicine);
    System.out.println("Medicine successfully created\n");
  }

  private void updateMedicine() throws SQLException {
    System.out.println("\n[Medicine / UPDATE]");
    Medicine medicine = getMedicineInputs();

    medicineController.update(medicine.getId(),
        medicine);
    System.out.println("Medicine with ID=" + medicine.getId()
        + " successfully updated\n");
  }

  private void deleteMedicine() throws SQLException {
    System.out.println("\n[Medicine / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    medicineController.delete(id);
    System.out.println("Medicine with ID=" + id + " successfully deleted\n");
  }


  private void getAllMedicineStorage() throws SQLException {
    System.out.println("\n[Medicine Storage / GET]");
    System.out.println(medicineStorageController.findAll() + "\n");
  }

  private void getMedicineStorageById() throws SQLException {
    System.out.println("\n[Medicine Storage / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(medicineStorageController.findOne(id) + "\n");
  }

  private MedicineStorage getMedicineStorageInputs() throws SQLException {
    System.out.println("\nEnter  ID: ");
    Integer id = SCANNER.nextInt();

    return new MedicineStorage(0, null);
  }

  private void createMedicineStorage() throws SQLException {
    System.out.println("\n[Medicine Storage / CREATE]");
    MedicineStorage medicineStorage = getMedicineStorageInputs();
    medicineStorageController.create(medicineStorage);
    System.out.println("Medicine Storage successfully created\n");
  }

  private void updateMedicineStorage() throws SQLException {
    System.out.println("\n[Medicine Storage / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    MedicineStorage medicineStorage = getMedicineStorageInputs();
    medicineStorage.setId(id);

    medicineStorageController.update(medicineStorage.getId(), medicineStorage);
    System.out.println("Medicine Storage with ID=" + id + " successfully updated\n");
  }

  private void deleteMedicineStorage() throws SQLException {
    System.out.println("\n[Medicine Storage / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    medicineStorageController.delete(id);
    System.out.println("Medicine Storage with ID=" + id + " successfully deleted\n");
  }


  private void getAllProducer() throws SQLException {
    System.out.println("\n[Producer / GET]");
    System.out.println(producerController.findAll() + "\n");
  }

  private void getProducerById() throws SQLException {
    System.out.println("\n[Producer / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(producerController.findOne(id) + "\n");
  }

  private Producer getProducerInputs() {
    System.out.println("\nEnter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println("Enter name of producer: ");
    String nameProducer = SCANNER.next();

    return new Producer(id, nameProducer);
  }

  private void createProducer() throws SQLException {
    System.out.println("\n[Producer / CREATE]");
    Producer producer = getProducerInputs();
    producerController.create(producer);
    System.out.println("Producer successfully created\n");
  }

  private void updateProducer() throws SQLException {
    System.out.println("\n[Producer / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Producer producer = getProducerInputs();
    producer.setId(id);

    producerController.update(producer.getId(), producer);
    System.out.println("Producer with ID=" + id + " successfully updated\n");
  }

  private void deleteProducer() throws SQLException {
    System.out.println("\n[Producer / DELETE] Enter ID: ");
    Integer id = SCANNER.nextInt();

    producerController.delete(id);
    System.out.println("Producer with ID=" + id + " successfully deleted\n");
  }


  private void getAllTypeOfPacking() throws SQLException {
    System.out.println("\n[Type of Packing / GET]");
    System.out.println(typeOfPackingController.findAll() + "\n");
  }

  private void getTypeOfPackingById() throws SQLException {
    System.out.println("\n[Type of Packing / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(typeOfPackingController.findOne(id) + "\n");
  }

  private TypeOfPacking getTypeOfPackingInputs() {
    System.out.println("\nEnter name: ");
    String type = SCANNER.next();

    return new TypeOfPacking(-1, type);
  }

  private void createTypeOfPacking() throws SQLException {
    System.out.println("\n[Type of Packing / CREATE]");
    TypeOfPacking typeOfPacking = getTypeOfPackingInputs();
    typeOfPackingController.create(typeOfPacking);
    System.out.println("Type of Packing successfully created\n");
  }

  private void updateTypeOfPacking() throws SQLException {
    System.out.println("\n[Type of Packing / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    TypeOfPacking typeOfPacking = getTypeOfPackingInputs();
    typeOfPacking.setId(id);

    typeOfPackingController.update(typeOfPacking.getId(), typeOfPacking);
    System.out.println("Type of Packing with ID=" + id + " successfully updated\n");
  }

  private void deleteTypeOfPacking() throws SQLException {
    System.out.println("\n[Type of Packing / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    typeOfPackingController.delete(id);
    System.out.println("Type of Packing with ID=" + id + " successfully deleted\n");
  }


  private void getAllUseInLife() throws SQLException {
    System.out.println("\n[PLATFORM / GET]");
    System.out.println(useInLifeController.findAll() + "\n");
  }

  private void getUseInLifeById() throws SQLException {
    System.out.println("\n[Use In Life / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(useInLifeController.findOne(id) + "\n");
  }

  private void createUseInLife() throws SQLException {
    System.out.println("[Use In Life / CREATE]");
    UsingInLife usingInLife = new UsingInLife();
    useInLifeController.create(usingInLife);
    System.out.println("Use In Life successfully created\n");
  }

  private void updateUseInLife() throws SQLException {
    System.out.println("\n[Use In Life / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    UsingInLife usingInLife = new UsingInLife();
    usingInLife.setId(id);

    useInLifeController.update(usingInLife.getId(), usingInLife);
    System.out.println("Use In Life with ID=" + id + " successfully updated\n");
  }

  private void deleteUseInLife() throws SQLException {
    System.out.println("\n[Use In Life / DELETE] Enter ID: ");
    Integer id = SCANNER.nextInt();

    useInLifeController.delete(id);
    System.out.println("Use In Life with ID=" + id + " successfully deleted\n");
  }
}
