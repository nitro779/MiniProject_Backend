package basicauth.demo.utils;

import org.springframework.stereotype.Component;

import javax.persistence.Lob;

@Component
public class ProductDetails {
    private String productname;
    private String category;
    private String description;
    private int initialbid;
    @Lob
    private String imageurl;
    private String sellerid;

    public ProductDetails() {
    }

    public ProductDetails(String productname, String category, String description, int intialbid, String imageurl, String sellerid) {
        this.productname = productname;
        this.category = category;
        this.description = description;
        this.initialbid = intialbid;
        this.imageurl = imageurl;
        this.sellerid = sellerid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInitialbid() {
        return initialbid;
    }

    public void setInitialbid(int intialbid) {
        this.initialbid = intialbid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productname='" + productname + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", intialbid=" + initialbid +
                ", imageurl='" + imageurl + '\'' +
                ", sellerid='" + sellerid + '\'' +
                '}';
    }
}
