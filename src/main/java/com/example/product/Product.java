package com.example.product;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int amt;
    private int stock;

    @PostPersist
    public void onPostPersist(){
        ProductDecresed productDecresed = new ProductDecresed();
        BeanUtils.copyProperties(this, productDecresed);
        productDecresed.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        ProductIncresed productIncresed = new ProductIncresed();
        BeanUtils.copyProperties(this, productIncresed);
        productIncresed.publishAfterCommit();


    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmt() {
        return this.amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
