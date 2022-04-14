package de.hsh.pizza;

import java.util.List;

/**
 * Klasse Bestellungen
 */
public class Bestellung {
    
    private Long id;

    private List<Pizza> pizzas;

    public Bestellung() {
    }


    public Bestellung(Long id, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", pizzas='" + getPizzas() + "'" +
            "}";
    }
    
}
