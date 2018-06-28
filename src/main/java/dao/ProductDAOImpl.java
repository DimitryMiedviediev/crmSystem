package dao;

import entity.Product;
import entity.User;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public List<Product> getProductList() throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                Product product = new Product(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("title")),
                        frames.integerNVL(resultSet.getObject("price")),
                        frames.integerNVL(resultSet.getObject("title_price"))
                );
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return productList;
    }
}
