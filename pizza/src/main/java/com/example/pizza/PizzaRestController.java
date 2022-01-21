package com.example.pizza;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizza")
public class PizzaRestController {
    private final PizzaService PizzaService;

    public PizzaRestController(com.example.pizza.PizzaService pizzaService) { //Wstrzykiwanie zależności (bean)
        PizzaService = pizzaService;
    }
    @GetMapping("/xyz")
    public ResponseEntity<String> witam(){
        return ResponseEntity.ok("Działa");
    }

    @GetMapping("/pizza1/{nazwa}/{rozmiar}/{skladnik1}/{skladnik2}/{skladnik3}/{czy_sos}/{czy_cienkie}/{min_w_piecu}/{dni_fermentacji}")
    public ResponseEntity<Pizza> tworzenie(@PathVariable String nazwa, @PathVariable int rozmiar, @PathVariable String skladnik1, @PathVariable String skladnik2, @PathVariable String skladnik3,
                                           @PathVariable boolean czy_sos, @PathVariable boolean czy_cienkie, @PathVariable int min_w_piecu, @PathVariable int dni_fermentacji){
        return ResponseEntity.ok(PizzaService.pizza(nazwa, rozmiar, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji));
    } //mapowanie1 / Pathvariable("xyz") zmiana nazwy ścieżki

    @GetMapping("/pizza2")
    public ResponseEntity<Pizza> tworzenie2(@RequestParam String nazwa, @RequestParam int rozmiar, @RequestParam String skladnik1, @RequestParam String skladnik2, @RequestParam String skladnik3,
                                            @RequestParam boolean czy_sos, @RequestParam boolean czy_cienkie, @RequestParam int min_w_piecu, @RequestParam int dni_fermentacji){
        return ResponseEntity.ok(PizzaService.pizza(nazwa, rozmiar, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji));
    } //mapowanie2


    @GetMapping("/pizza30cm/{nazwa2}/{skladnik1}/{skladnik2}/{skladnik3}/{czy_sos}/{czy_cienkie}/{min_w_piecu}/{dni_fermentacji}")
    public ResponseEntity<Pizza> tworzeniePizza30cm(@PathVariable("nazwa2") String nazwa, @PathVariable String skladnik1, @PathVariable String skladnik2, @PathVariable String skladnik3,
                                           @PathVariable boolean czy_sos, @PathVariable boolean czy_cienkie, @PathVariable int min_w_piecu, @PathVariable int dni_fermentacji){
        return ResponseEntity.ok(PizzaService.pizza30cm(nazwa, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji));
    } //mapowanie1 / Pathvariable("xyz") zmiana nazwy ścieżki


    @GetMapping("/pizza60cm/{nazwa2}/{skladnik1}/{skladnik2}/{skladnik3}/{czy_sos}/{czy_cienkie}/{min_w_piecu}/{dni_fermentacji}")
    public ResponseEntity<Pizza> tworzeniePizza60cm(@PathVariable("nazwa2") String nazwa, @PathVariable String skladnik1, @PathVariable String skladnik2, @PathVariable String skladnik3,
                                                    @PathVariable boolean czy_sos, @PathVariable boolean czy_cienkie, @PathVariable int min_w_piecu, @PathVariable int dni_fermentacji){
        return ResponseEntity.ok(PizzaService.pizza60cm(nazwa, skladnik1, skladnik2, skladnik3, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji));
    } //mapowanie1 / Pathvariable("xyz") zmiana nazwy ścieżki


    @GetMapping("/pizzaSerowa/{nazwa2}/{czy_sos}/{czy_cienkie}/{min_w_piecu}/{dni_fermentacji}")
    public ResponseEntity<Pizza> tworzeniePizzaSerowa(@PathVariable("nazwa2") String nazwa,
                                                    @PathVariable boolean czy_sos, @PathVariable boolean czy_cienkie, @PathVariable int min_w_piecu, @PathVariable int dni_fermentacji){
        return ResponseEntity.ok(PizzaService.pizzaSerowa(nazwa, czy_sos, czy_cienkie, min_w_piecu, dni_fermentacji));
    } //mapowanie1 / Pathvariable("xyz") zmiana nazwy ścieżki

}
