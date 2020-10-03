package basicauth.demo.controller;

import basicauth.demo.models.Bids;
import basicauth.demo.models.Product;
import basicauth.demo.models.Seller;
import basicauth.demo.repositories.SellerRepository;
import basicauth.demo.repositories.UserRepository;
import basicauth.demo.services.BidsService;
import basicauth.demo.services.ProductService;
import basicauth.demo.utils.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BidsService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    SellerRepository  sellerRepository;

    @PostMapping("/products")
    private boolean auctionProduct(@RequestBody ProductDetails productDetails){
        Product product = new Product(productDetails);
        Seller seller = new Seller(productDetails.getSellerid());
        product.setSeller(seller);
        product.setBids(new ArrayList<>());
        return productService.addProduct(product);
    }

    @GetMapping("/products/{user}")
    private List getProducts(@PathVariable("user") String user){
        return productService.findAllProducts(user);
        //return productService.findAllProducts();
    }

    @GetMapping("/myproducts/{seller}")
    private  List<Product> getSellerProducts(@PathVariable("seller") String seller){
        return productService.getSellerProducts(seller);
    }

    @DeleteMapping("/products/{pid}")
    private boolean deleteProduct(@PathVariable("pid") int pid){
        return productService.deleteProduct(pid);
    }

    @PutMapping("/products")
    private boolean updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @GetMapping("/productby/{id}")
    private Product getProductById(@PathVariable("id") int productId){
        return productService.getProductById(productId);
    }

    @PostMapping("products/accept")
    private void acceptBidding(@RequestBody Bids bids){
        service.acceptBid(bids);
    }
}
