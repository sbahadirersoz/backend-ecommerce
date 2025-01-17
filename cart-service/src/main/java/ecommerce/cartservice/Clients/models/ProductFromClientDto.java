package ecommerce.cartservice.Clients.models;

public class ProductFromClientDto
{
    private String name;
    private Integer Stockamount;
    private Double productPrice;
    private String id;

    public ProductFromClientDto(String name, Integer stockamount, Double productPrice, String id) {
        this.name = name;
        Stockamount = stockamount;
        this.productPrice = productPrice;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStockamount() {
        return Stockamount;
    }

    public void setStockamount(Integer stockamount) {
        Stockamount = stockamount;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
