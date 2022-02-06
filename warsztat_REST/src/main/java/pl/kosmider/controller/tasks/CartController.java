package pl.kosmider.controller.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.dao.CartDao;
import pl.kosmider.dao.ProductDao;
import pl.kosmider.model.Cart;
import pl.kosmider.model.CartItem;
import pl.kosmider.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

@Controller
@SessionAttributes("cartValue")
public class CartController {

    private final Cart cart;
    private final ProductDao productDao;
    private final CartDao cartDao;


    public CartController(Cart cart, ProductDao productDao, CartDao cartDao) {
        this.cart = cart;
        this.productDao = productDao;
        this.cartDao = cartDao;
    }

    @RequestMapping("/addToCart/{id}/{quantity}")
    @ResponseBody
    public String addToCart(@PathVariable long id, @PathVariable int quantity, Model model, HttpSession session) {

        List<Product> productList = productDao.getList();
        List<CartItem> cartItemList = cart.getCartItemList();

        Product product1 = productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);


        cartItemList.stream()
                .filter(cartItem -> cartItem.getProduct().getId() == product1.getId())
                .findFirst()
                .ifPresentOrElse(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity),
                        () -> cart.addToCart(new CartItem(quantity, product1)));


        DoubleStream doubleStream = cartItemList.stream().mapToDouble(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity());

        double[] doubles = doubleStream.toArray();
        double cartValue = 0;
        for (int i = 0; i < doubles.length; i++) {
            cartValue += doubles[i];
        }


        session.setAttribute("cartValue", cartValue);
        System.out.println("cart value: " + cartValue);
        return "ADDTOCART";

    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    //  @RequestMapping("/cart")
    //  @ResponseBody
    //  public List<CartItem> productList() {
    //    return cart.getCartItemList();
    // }

    @RequestMapping("/cart")
    public String cartItems(Model model) {
        List<CartItem> cartItemList = cart.getCartItemList();
        model.addAttribute("cartItems", cartItemList);
        return "cartItems";
    }

    @RequestMapping("/cartSummary")
    @ResponseBody
    public String cartSummary(Model model, HttpSession session) {
        Double cartValue = (Double) session.getAttribute("cartValue");

        return "cartSummary: " + cartValue;
    }

    @GetMapping("/cartController")
    public String addToCartFromForm() {
        return "cart";
    }

    @PostMapping("/cartController")
    @ResponseBody
    public String itemsFromUser(HttpServletRequest request) {
        Product product = new Product();
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Random random = new Random();
        double randomPrice = random.nextDouble() * 10063;

        product.setPrice(randomPrice);
        product.setName(productName);

        CartItem cartItem = new CartItem(quantity, product);
        cart.addToCart(cartItem);

        cartDao.create(cartItem);


        return "Product name: " + productName;
    }

    @GetMapping("/addProduct")
    @ResponseBody
    public String addProduct() {
        Product product = new Product(2, "papumy", 0.8);
        productDao.create(product);
        return "product added";
    }



}
