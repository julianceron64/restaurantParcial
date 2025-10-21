package eurekaexercise.fooditem.controller;

import eurekaexercise.fooditem.DTO.FoodItemDTO;
import eurekaexercise.fooditem.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    private final FoodItemService service;

    @Autowired
    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<FoodItemDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public FoodItemDTO create(@RequestBody FoodItemDTO dto) {
        return service.addItem(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItemDTO> getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
