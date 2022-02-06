package pl.kosmider.dao;

import org.springframework.stereotype.Component;
import pl.kosmider.dbUtil.DbUtil;
import pl.kosmider.model.Cart;
import pl.kosmider.model.CartItem;

import java.math.BigDecimal;
import java.sql.*;

@Component
public class CartDao {
    private static final String CREATE_CART_QUERY = "INSERT into cart(product, quantity, price) VALUES (?,?,?)";
    private Cart cart;
    private CartItem cartItem;

    public Cart create(CartItem cartItem) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CART_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cartItem.product.getName());
            preparedStatement.setInt(2, cartItem.getQuantity());
            preparedStatement.setBigDecimal(3, BigDecimal.valueOf(12.21d));
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                cart.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
