package gammingStore.models;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table (name = "games")
public class Game implements Serializable {
   @Id
   @GeneratedValue(strategy = SEQUENCE)
   private Long id;
   private String title;
   private String platform;
   private Long yearr;
   private double cost;
   private String etiqueta;
   private int discount;
   private double offer;
   private String publisher;
   private Long PEGI;
   private String PEGIcontent;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;

   public Long getId() {

       return id;
   }

   public void setId(Long id) {

       this.id =id;
   }

    public String getTitle() {

       return title;
    }

    public void setTitle(String title) {

       this.title = title;
    }

    public String getPlatform() {

       return platform;
    }

    public void setPlatform(String platform) {

       this.platform = platform;
    }

    public Long getYearr() {

       return yearr;
    }

    public void setYearr(Long yearr) {

       this.yearr = yearr;
    }

    public double getCost() {

       return cost;
    }

    public void setCost(double cost) {

       this.cost = cost;
    }

    public String getEtiqueta() {

       return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {

       this.etiqueta = etiqueta;
    }

    public int getDiscount() {

       return discount;
    }

    public void setDiscount(int discount) {

       this.discount = discount;
    }

    public double getOffer() {

       return offer;
    }

    public void setOffer(double offer)
    {

        this.offer = offer;
    }

    public Category getCategory() {

       return category;
    }
    public void setCategory(Category category) {

       this.category = category;
    }

    public String getPublisher() {

       return publisher;
    }

    public void setPublisher(String publisher) {

       this.publisher = publisher;
    }

    public Long getPEGI() {

       return PEGI;
    }

    public void setPEGI(Long PEGI) {

       this.PEGI = PEGI;
    }

    public String getPEGIcontent() {

       return PEGIcontent;
    }

    public void setPEGIcontent(String PEGIcontent) {

       this.PEGIcontent = PEGIcontent;
    }

    @Override
    public String toString() {
       return "Game{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", platform='" + platform + '\'' +
               ", year='" + yearr + '\'' +
               ", cost='" + cost + '\'' +
               ", etiqueta='" + etiqueta + '\'' +
               ", discount='" + discount + '\'' +
               ", offer='" + offer + '\'' +
               ", category='" + category + '\'' +
               ", publisher='" + publisher + '\'' +
               ", PEGI='" + PEGI + '\'' +
               ", PEGIcontent='" + PEGIcontent + '\'' +
               '}';
    }
}
