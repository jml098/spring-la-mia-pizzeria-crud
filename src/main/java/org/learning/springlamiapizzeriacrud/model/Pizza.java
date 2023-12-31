package org.learning.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome della pizza non può essere vuoto.")
    private String name;

    @NotBlank(message = "La descrizione della pizza non può essere vuota.")
    private String description;

    @DecimalMin(value = "0.0", message = "Il prezzo non può essere negativo.")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    @URL(message = "L'URL dell'immagine non può essere vuoto.")
    @Column(name = "image_url")
    private String image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
