package de.hsh.pizza;

import java.util.List;

public class Pizza {
    
    private PizzaSize size;

    private List<String> ingredients;

    public Pizza(){

    }

    public Pizza(PizzaSize size, List<String> ingredients){
        this.size = size;
        this.ingredients = ingredients;
    }

    public PizzaSize getSize() {
        return this.size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public String toString() {
        return "{" +
            ", size='" + getSize() + "'" +
            ", ingredients='" + getIngredients() + "'" +
            "}";
    }
    
}
