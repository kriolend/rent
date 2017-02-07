package org.ua.model.realEstate;


import javax.persistence.*;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by u0100 on 02.07.2016.
 */

@Entity
@Table(name = "arenda_kvartir")
//@SQLInsert(sql="INSERT IGNORE INTO arenda_kvartir(data_id,link,title,raion,name_boss,addTime,price,koll_komnat,telephon) VALUES(?,?,?,?,?,?,?,?,?)")
public class Apartament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="data_id", unique=true, nullable=false)
    private String dataId;

    @NotEmpty
    @Column(name = "link", nullable = false)
    private String link;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "raion")
    private String raion;

    @Column(name = "name_boss")
    private String nameBoss;

    @NotEmpty
    @Column(name = "telephon", nullable = false)
    private String telephon;

    @Column(name = "addTime")
    private String addTime;

    @Column(name = "price")
    private String price;

    @Column(name = "koll_komnat")
    private String kollKomnat;
//
//    public Apartament() {
//    }
//
//    public Apartament(String dataId, String link, String title, String raion, String nameBoss, String telephon, String addTime, String price, String kollKomnat) {
//        this.dataId = dataId;
//        this.link = link;
//        this.title = title;
//        this.raion = raion;
//        this.nameBoss = nameBoss;
//        this.telephon = telephon;
//        this.addTime = addTime;
//        this.price = price;
//        this.kollKomnat = kollKomnat;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRaion() {
        return raion;
    }

    public void setRaion(String raion) {
        this.raion = raion;
    }

    public String getNameBoss() {
        return nameBoss;
    }

    public void setNameBoss(String nameBoss) {
        this.nameBoss = nameBoss;
    }

    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKollKomnat() {
        return kollKomnat;
    }

    public void setKollKomnat(String kollKomnat) {
        this.kollKomnat = kollKomnat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Apartament))
            return false;
        Apartament other = (Apartament) o;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (dataId == null) {
            if (other.dataId != null)
                return false;
        } else if (!dataId.equals(other.dataId))
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((dataId == null) ? 0 : dataId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "id=" + id +
                ", dataId='" + dataId + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", raion='" + raion + '\'' +
                ", nameBoss='" + nameBoss + '\'' +
                ", telephon='" + telephon + '\'' +
                ", addTime='" + addTime + '\'' +
                ", price='" + price + '\'' +
                ", kollKomnat='" + kollKomnat + '\'' +
                '}';
    }
}
