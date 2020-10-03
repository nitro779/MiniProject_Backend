package basicauth.demo.services;

import basicauth.demo.models.Product;
import basicauth.demo.models.Seller;
import basicauth.demo.repositories.ProductRepository;
import basicauth.demo.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public boolean addProduct(Product product){
        try {
            Seller seller = sellerRepository.findSellerBySellername(product.getSeller().getSellername());
            if (seller == null){
                seller = new Seller();
            }
            seller.setSellername(product.getSeller().getSellername());
            seller.getProducts().add(product);
            product.setSeller(seller);
            sellerRepository.save(seller);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Product> getSellerProducts(String username) {
        return productRepository.findProductBySellerSellername(username);
    }

    public List findAllProducts(String seller){
        List<Product> products =  productRepository.findProductBySellerSellernameNotContaining(seller);
        return products;
    }

    public boolean deleteProduct(int pid){
        try {
            productRepository.deleteById(pid);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean updateProduct(Product product) {
        try{
            productRepository.save(product);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public  Product getProductById(int prd_id){
        try{
            return productRepository.findProductByproductId(prd_id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
