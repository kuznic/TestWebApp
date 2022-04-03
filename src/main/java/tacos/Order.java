package tacos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Date placedAt;

    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();
    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @ManyToOne
    private User user;
    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}