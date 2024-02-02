package pl.kosmider.dao;

import org.springframework.stereotype.Component;
import pl.kosmider.controller.Product;

import java.util.List;

@Component
public class ProductDao {
    private List<Product> productList;

    private Product buty = new Product(1L, "buty", 22.3);
    private Product kask = new Product(2L, "kask", 44.55);
    private Product sandaly = new Product(3L, "sandaly", 102.3);
    private Product miotla = new Product(4L, "miotla", 22.75);

    public List<Product> addToProductList() {
        productList.add(buty);
        productList.add(kask);
        productList.add(sandaly);
        productList.add(miotla);

        return productList;
    }


    public ProductDao(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getList() {
        return addToProductList();
    }
}
