package com.springbootacadamy.pos.repo;

import com.springbootacadamy.pos.entity.OrderDetais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailsRepo extends JpaRepository<OrderDetais,Integer> {
}
