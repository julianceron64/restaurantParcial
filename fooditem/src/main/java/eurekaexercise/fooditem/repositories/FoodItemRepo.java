package eurekaexercise.fooditem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eurekaexercise.fooditem.entities.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long> {
}
