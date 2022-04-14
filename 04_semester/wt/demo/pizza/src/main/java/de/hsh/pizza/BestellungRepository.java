package de.hsh.pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jakarta.inject.Singleton;

@Singleton
public class BestellungRepository {
    
    private HashMap<Long, Bestellung> bestellungen = new HashMap<>();

    public BestellungRepository(){
        for (int i=0; i<10; i++){
            Bestellung bestellung = new Bestellung();
            List<Pizza> pizzas = new ArrayList<Pizza>();
            for (int j=0; j<3; j++){
                Pizza pizza = new Pizza(PizzaSize.M, Arrays.asList("salami", "pilze"));
                pizzas.add(pizza);
            }
            bestellung.setPizzas(pizzas);
            bestellung.setId(Long.valueOf(i));
            this.bestellungen.put(Long.valueOf(i), bestellung);
        }
    }

    public HashMap<Long, Bestellung> list(){
        return this.bestellungen;
    }

    public Bestellung create(Bestellung bestellung){
        this.bestellungen.put(bestellung.getId(), bestellung);
        return bestellung;
    }

    public Bestellung read(Long id) {
        return this.bestellungen.get(id);
    }

    public Bestellung update(Long id, Bestellung bestellung){
        if (id != bestellung.getId()){
            throw new RuntimeException("Id must match entities id");
        }
        this.bestellungen.put(id, bestellung);
        return bestellung;
    }

    public void delete(Long id) {
        this.bestellungen.remove(id);
    }

}
