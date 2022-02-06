package pl.kosmider.dao;

import org.springframework.stereotype.Component;
import pl.kosmider.dbUtil.DbUtil;
import pl.kosmider.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {

    private static final String CREATE_PRODUCT_QUERY = "INSERT into kosmiderRest.product(name, price) VALUES (?,?)";
    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getList() {
        Product product = new Product(1, "worek", 1.00);
        Product product1 = new Product(2, "kot", 2.00);
        Product product2 = new Product(3, "młot", 3.00);
        Product product3 = new Product(4, "rower", 4.00);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        return products;
    }

    public Product create(Product product) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                product.setId(resultSet.getInt(1));
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
