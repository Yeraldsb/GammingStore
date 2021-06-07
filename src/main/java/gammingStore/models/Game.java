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
   private Long year;
   private Float priceOriginal;
   private String etiqueta;
   private Long discount;
   private Float priceDiscount;
   private String category;
   private String publisher;
   private Long PEGI;
   private String PEGIcontent;

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

    public Long getYear() {
       return year;
    }

    public void setYear(Long year) {
       this.year = year;
    }

    public Float getPriceOriginal() {
       return priceOriginal;
    }

    public void setPriceOriginal(Float priceOriginal) {
       this.priceOriginal = priceOriginal;
    }

    public String getEtiqueta() {
       return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
       this.etiqueta = etiqueta;
    }

    public Long getDiscount() {
       return discount;
    }

    public void setDiscount(Long discount) {
       this.discount = discount;
    }

    public Float getPriceDiscount() {
       return priceDiscount;
    }

    public void setPriceDiscount(Float priceDiscount) {
       this.priceDiscount = priceDiscount;
    }

    public String getCategory() {
       return category;
    }
    public void setCategory(String category) {
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

    public void setPEGIcontent(String pegIcontent) {
       this.PEGIcontent = PEGIcontent;
    }

    @Override
    public String toString() {
       return "Game{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", platform='" + platform + '\'' +
               ", year='" + year + '\'' +
               ", priceOriginal='" + priceOriginal + '\'' +
               ", etiqueta='" + etiqueta + '\'' +
               ", discount='" + discount + '\'' +
               ", priceDiscount='" + priceDiscount + '\'' +
               ", category='" + category + '\'' +
               ", publisher='" + publisher + '\'' +
               ", PEGI='" + PEGI + '\'' +
               ", PEGIcontent='" + PEGIcontent + '\'' +
               '}';
    }
}
