package com.rent.repository;

import com.rent.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items, Long> {
}
