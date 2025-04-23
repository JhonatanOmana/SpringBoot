public class producto {
    private long id;
    private String name;
    private String category;
    private Double Price;
    private Integer stock;

    public producto(long id, String name, String category, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        Price = price;
        this.stock = stock;
    }


    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getCategory() {
        return category;
    }


    public Double getPrice() {
        return Price;
    }


    public Integer getStock() {
        return stock;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public void setPrice(Double price) {
        Price = price;
    }


    public void setStock(Integer stock) {
        this.stock = stock;
    }

    

    
}
