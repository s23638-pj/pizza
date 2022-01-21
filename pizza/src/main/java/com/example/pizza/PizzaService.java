package com.example.pizza;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository PizzaRepository;

    public PizzaService(com.example.pizza.PizzaRepository pizzaRepository) {
        PizzaRepository = pizzaRepository;
    } //wstrzykiwanie zależności

    public Pizza pizza(String nazwa, int rozmiar, String skladnik1, String skladnik2, String skladnik3,
                       boolean czy_sos, boolean czy_cienkie, int min_w_piecu, int dni_fermentacji) {
        Pizza pizza = new Pizza(nazwa, rozmiar, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji);
        return PizzaRepository.save(pizza);
    }

    public Pizza pizza30cm(String nazwa, String skladnik1, String skladnik2, String skladnik3,
                           boolean czy_sos, boolean czy_cienkie, int min_w_piecu, int dni_fermentacji) {
        Pizza pizza = new Pizza(nazwa, 30, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji);
        return PizzaRepository.save(pizza);
    }

    public Pizza pizza60cm(String nazwa, String skladnik1, String skladnik2, String skladnik3,
                           boolean czy_sos, boolean czy_cienkie, int min_w_piecu, int dni_fermentacji) {
        Pizza pizza = new Pizza(nazwa, 60, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji);
        return PizzaRepository.save(pizza);
    }

    public Pizza pizzaSerowa(String nazwa, boolean czy_sos, boolean czy_cienkie, int min_w_piecu, int dni_fermentacji) {
        Pizza pizza = new Pizza(nazwa, 60, "mozzarella", "parmezan", "gorgonzola", czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji);
        return PizzaRepository.save(pizza);
    }

    public void clearSkladnik1(Pizza pizza) {
        if (pizza.getSkladnik1().isBlank()) {
            pizza.setSkladnik1("Brak");
        }
    }

    public void clearSkladnik2(Pizza pizza) {
        if (pizza.getSkladnik2().isBlank()) {
            pizza.setSkladnik2("Brak");
        }
    }

    public void clearSkladnik3(Pizza pizza) {
        if (pizza.getSkladnik3().isBlank()) {
            pizza.setSkladnik3("Brak");
        }
    }

    public void adjustTime(Pizza pizza) {
        if (pizza.isCzy_cienkie()) {
            pizza.setMin_w_piecu(pizza.getMin_w_piecu() - 5);
        }
    }

    public String changeName(Pizza pizza, String name) {
        if (pizza.getNazwa() == null || pizza.getNazwa().isBlank()) {
            pizza.setNazwa(name);
        }
        return pizza.getNazwa();
    }

    public void zmienRozmiar(Pizza pizza) {
        if (pizza.getRozmiar() <= 0) {
            pizza.setRozmiar(30);
        } else if (pizza.getRozmiar() == 60) {
            int roz = pizza.getRozmiar() * 2;
            pizza.setRozmiar(roz);
        } else {
            pizza.setRozmiar(pizza.getRozmiar() + 5);
        }
    }

    public void bezSosu(Pizza pizza) {
        if(!pizza.isCzy_sos())
        {
            pizza.setNazwa("Chleb");
        }
        pizza.getNazwa();
    }

//    public List<Pizza> findAllByID(){
//        return PizzaRepository.findAll();
//    }

    public void deleteByID(Long id){
        PizzaRepository.deleteById(id);
    }

    public void delete(Pizza pizza){
        PizzaRepository.delete(pizza);
    }

    public Pizza findByID(Long id){
        Optional<Pizza> findByID = PizzaRepository.findById(id);
        return findByID.orElse(null); //zabezpieczenie przed błędem
    }

    public boolean isPizzaExists(Long id){
        return PizzaRepository.existsById(id);
    }

    public Long countByID(Long id){
        return PizzaRepository.count();
    }

}
