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
   private Long yearr;
   private double cost;
   private int discount;
   private double offer;
   private String photo;


   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;

   @ManyToOne
   @JoinColumn(name = "publisher_id")
   private Publisher publisher;

   @ManyToOne
   @JoinColumn(name="platform_id")
   private Platform platform;

   @ManyToOne
   @JoinColumn(name ="etiquetas_id")
   private Etiqueta etiqueta;

   @ManyToOne
   @JoinColumn(name ="pegi_id")
   private Pegi pegi;

   @ManyToOne
   @JoinColumn(name ="PEGIcontent_id")
   private PEGIcontent PEGIcontent;

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

    public Platform getPlatform() {

       return platform;
    }

    public void setPlatform(Platform platform) {

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

    public Etiqueta getEtiqueta() {

       return etiqueta;
    }
    public void setEtiqueta(Etiqueta etiqueta) {

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

    public Publisher getPublisher() {

       return publisher;
    }

    public void setPublisher(Publisher publisher) {

       this.publisher = publisher;
    }

    public Pegi getPegi() {

       return pegi;
    }

    public void setPegi(Pegi pegi) {

       this.pegi = pegi;
    }

    public PEGIcontent getPEGIcontent() {

       return PEGIcontent;
    }

    public void setPEGIcontent(PEGIcontent PEGIcontent) {

       this.PEGIcontent = PEGIcontent;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
               ", pegi='" + pegi + '\'' +
               ", PEGIcontent='" + PEGIcontent + '\'' +
               ", photo='" + photo + '\'' +
               '}';
    }
    public String getPhotoImagePath() {
        if (photo == null || id == null) return null;
        return "/game-photo/" + id + "/" + photo;
    }


}
