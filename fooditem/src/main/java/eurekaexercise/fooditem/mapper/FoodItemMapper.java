package eurekaexercise.fooditem.mapper;

import org.mapstruct.Mapper;
import eurekaexercise.fooditem.DTO.FoodItemDTO;
import eurekaexercise.fooditem.entities.FoodItem;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItem mapDTOToEntity(FoodItemDTO dto);
    FoodItemDTO mapEntityToDTO(FoodItem entity);
}
