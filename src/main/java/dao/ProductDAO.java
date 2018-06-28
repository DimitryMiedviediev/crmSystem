package dao;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductDAO {

    List<Product> getProductList() throws IOException;

}
