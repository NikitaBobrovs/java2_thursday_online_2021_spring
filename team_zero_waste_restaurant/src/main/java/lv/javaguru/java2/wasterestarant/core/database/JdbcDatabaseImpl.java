package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
class JdbcDatabaseImpl implements Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Dish dish) {
        jdbcTemplate.update(
                "INSERT INTO dish(name, description, type, weight, price)"
                        + "VALUES (?, ?, ?, ?, ?)",
                dish.getName(), dish.getDescription(), dish.getType(), dish.getWeight(), dish.getPrice()
        );
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(
                "INSERT INTO product(name, quantity, price, expiryDate)"
                        + "VALUES (?, ?, ?, ?)",
                product.getName(), product.getQuantity(), product.getPrice(), product.getExpiryDate()
        );
    }

    @Override
    public void save(Client client) {
        jdbcTemplate.update(
                "INSERT INTO client_list(name)"
                        + "VALUES (?)",
                client.getName()
        );
    }

    @Override
    public void save(Ingredient ingredient) {

    }

    @Override
    public void save(Order order) {

    }

    @Override
    public boolean deleteDishByName(String name) {
        String sql = "DELETE FROM dish WHERE name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public boolean deleteProductByName(String name) {
        return false;
    }

    @Override
    public boolean deleteDishByID(Long dishID) {
//        String sql = "DELETE FROM dish WHERE id = ?"; // No such function in program menu. Only delete by name
//        Object[] args = new Object[] {dishID};
//        return jdbcTemplate.update(sql, args) == 1;
        return false;
    }

    @Override
    public List<Ingredient> findIngredientByName(String name) {
        return null;
    }

    @Override
    public List<Dish> getAllDishes() {
        return null;
    }

    @Override
    public List<Dish> findDishByName(String name) {
        return null;
    }

    @Override
    public List<Dish> findDishByType(String type) {
        return null;
    }

    @Override
    public List<Dish> findDishByPrice(Double price) {
        return null;
    }

    @Override
    public List<Dish> findDishByNameAndType(String name, String type) {
        return null;
    }

    @Override
    public List<Dish> findDishByNameAndPrice(String name, Double price) {
        return null;
    }

    @Override
    public List<Dish> findDishByTypeAndPrice(String type, Double price) {
        return null;
    }

    @Override
    public List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Dish> getRestaurantMenu() {
        return null;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }

    @Override
    public Optional<Client> clientByID(Long clientID) {
        return Optional.empty();
    }

    @Override
    public List<OrderItem> getWishlistByClientID(Long clientID) {
        return null;
    }

    @Override
    public OrderItem selectedOrderItem(String dishName, int quantity) {
        return null;
    }

    @Override
    public void addDishToWishlist(Long clientID, String dishName, int quantity) {

    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> searchOrdersByClientID(Long clientID) {
        return null;
    }

    @Override
    public List<Order> searchOrderByDate(Date orderDate) {
        return null;
    }

    @Override
    public List<Order> searchOrderByClientIDAndDate(Long clientID, Date orderDate) {
        return null;
    }
}