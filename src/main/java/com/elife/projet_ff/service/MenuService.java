package com.elife.projet_ff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elife.projet_ff.model.Menu;
import com.elife.projet_ff.model.Repas;
import com.elife.projet_ff.repository.MenuRepository;

@Service

public class MenuService {
    @Autowired
    private final MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }



    public Menu createMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus(){
        return menuRepository.findAll();
    }

    public Menu getMenuById(String id){
        return menuRepository.findById(id).orElse(null);
    }

    public Menu updateMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public void deleteMenuById(String id){
        menuRepository.deleteById(id);
    }
    
    public double calculateTotalPrice(String id) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isPresent()) {
            Menu menu = menuOptional.get();
            List<Repas> repasList = menu.getRepas();
            double totalPrice = 0.0;
            for (Repas repas : repasList) {
                totalPrice += repas.getPrix();
            }
            return totalPrice;
        } else {
            throw new MenuNotFoundException("Menu not found with ID: " + id);
        }
    }
}
