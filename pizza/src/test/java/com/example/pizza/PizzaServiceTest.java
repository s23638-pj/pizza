package com.example.pizza;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {
    @Mock
    private PizzaRepository PizzaRepository;

    @InjectMocks
    private PizzaService PizzaService;

    @Test
    void zmienRozmiar(){
        Pizza pizza = new Pizza("Capriciosa", -23, "weef", "wf", "wef",
                true, false, 12, 2);
        PizzaService.zmienRozmiar(pizza);
        assertThat(pizza.getRozmiar()).isEqualTo(30);
    }

    @Test
    void zmienRozmiar2(){
        Pizza pizza = new Pizza("Capriciosa", 60, "weef", "wf", "wef",
                true, false, 12, 2);
        PizzaService.zmienRozmiar(pizza);
        assertThat(pizza.getRozmiar()).isEqualTo(120);
    } ///zrobić testy

    @Test
    void zmienRozmiar3(){
        Pizza pizza = new Pizza("Capriciosa", 61, "weef", "wf", "wef",
                true, false, 12, 2);
        PizzaService.zmienRozmiar(pizza);
        assertThat(pizza.getRozmiar()).isEqualTo(66);
    }

    @Test
    void bezSosu(){
        Pizza pizza = new Pizza("Capriciosa", 60, "weef", "wf", "wef",
                false, false, 12, 2);
        PizzaService.bezSosu(pizza);
        assertThat(pizza.getNazwa()).isEqualTo("Chleb");
    }

    @Test
    void adjustTime(){
        Pizza pizza = new Pizza("Capriciosa", 60, "weef", "wf", "wef",
                true, true, 12, 2);
        PizzaService.adjustTime(pizza);
        assertThat(pizza.getMin_w_piecu()).isEqualTo(7);
    }

    @Test
    void clearSkladnik1(){
        Pizza pizza = new Pizza("Capriciosa", 60, "", "wf", "wef",
                true, false, 12, 2);
        PizzaService.clearSkladnik1(pizza);
        assertThat(pizza.getSkladnik1()).isEqualTo("Brak");
    }

    @Test
    void clearSkladnik2(){
        Pizza pizza = new Pizza("Capriciosa", 60, "gh", "", "hgjg",
                true, false, 12, 2);
        PizzaService.clearSkladnik2(pizza);
        assertThat(pizza.getSkladnik2()).isEqualTo("Brak");
    }

    @Test
    void clearSkladnik3(){
        Pizza pizza = new Pizza("Capriciosa", 60, "", "wf", " ",
                true, false, 12, 2);
        PizzaService.clearSkladnik3(pizza);
        assertThat(pizza.getSkladnik3()).isEqualTo("Brak");
    }

    @Test
    void deleteByID(){
        PizzaService.deleteByID(4L);
        verify(PizzaRepository).deleteById(4L);
    }

    @Test
    void delete(){
        Pizza pizza = new Pizza();
        PizzaService.delete(pizza);
        verify(PizzaRepository).delete(pizza);
    }

    @Test
    void findByID() {
        Mockito.when(PizzaRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.of(new Pizza()));
        Pizza Pizza = PizzaService.findByID(3L);
        assertThat(Pizza).isNotNull();
    }

    @Test
    void isPizzaExists() {
        Mockito.when(PizzaRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        boolean Pizza = PizzaService.isPizzaExists(3L);
        assertThat(Pizza).isEqualTo(true);
    }

    @Test
    void countByID(){
        PizzaService.countByID(1L);
        verify(PizzaRepository).count();
    }



}
