package lv.javaguru.java2.realestate.core.domain;

import java.util.Objects;

public class Offer {
    private String offerType;
    private String propertyCategory;
    private String description;
    private Double price;
    private Integer id;

    public Offer(String offerType, String propertyCategory, String description, Double price) {
        this.offerType = offerType;
        this.propertyCategory = propertyCategory;
        this.description = description;
        this.price = price;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(String propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.price, price) == 0
                && Objects.equals(offerType, offer.offerType)
                && Objects.equals(propertyCategory, offer.propertyCategory)
                && Objects.equals(description, offer.description)
                && Objects.equals(id, offer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerType, propertyCategory, description, price);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerType='" + offerType + '\'' +
                ", propertyCategory='" + propertyCategory + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + "$" + '\'' +
                ", id='" + id + '}';
    }
}
