package eurekaexercise.fooditem.services;

import eurekaexercise.fooditem.DTO.FoodItemDTO;
import eurekaexercise.fooditem.entities.FoodItem;
import eurekaexercise.fooditem.mapper.FoodItemMapper;
import eurekaexercise.fooditem.repositories.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    private final FoodItemRepo repo;
    private final FoodItemMapper mapper;

    @Autowired
    public FoodItemService(FoodItemRepo repo, FoodItemMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<FoodItemDTO> findAll() {
        return repo.findAll().stream()
                .map(mapper::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public FoodItemDTO addItem(FoodItemDTO dto) {
        FoodItem saved = repo.save(mapper.mapDTOToEntity(dto));
        return mapper.mapEntityToDTO(saved);
    }

    public ResponseEntity<FoodItemDTO> findById(Long id) {
        Optional<FoodItem> food = repo.findById(id);
        return food.map(f -> new ResponseEntity<>(mapper.mapEntityToDTO(f), HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
