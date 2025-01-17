package ecommerce.cartservice.model;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "cart_entity")
public class CartEntity {
    @GeneratedValue
    @UuidGenerator
    @Id
    private String Cart_id;
    @Column(name = "user_username")
    private String userUsername;
    private Date CreatedDate;
    @OneToMany(mappedBy = "cartEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartItem> items;
    public CartEntity(String id, String user_Username, Date createdDate, List<CartItem> items) {
        this.Cart_id = id;
        userUsername = user_Username;
        CreatedDate = createdDate;
        this.items = items;
    }
    public CartEntity() {
    }

    public CartEntity(Date date, String username)
    {
        this.CreatedDate=date;
        this.userUsername= username;
    }

    public CartEntity(Date date, String username, List<CartItem> i)
    {
        this.CreatedDate = date;
        this.userUsername = username;
        this.items= i;

    }

    public String getId() {
        return Cart_id;
    }
    public void setId(String id) {
        this.Cart_id = id;
    }
    public String getUser_Username() {
        return userUsername;
    }
    public void setUser_Username(String user_Username) {
        userUsername = user_Username;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
        for (CartItem item : items) {
            item.setCartEntity(this);
        }
    }
}
