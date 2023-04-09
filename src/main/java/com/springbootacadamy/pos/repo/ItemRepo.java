package com.springbootacadamy.pos.repo;

import com.springbootacadamy.pos.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item> findAllByItemNameEqualsAndActiveStatus(String itemName, boolean b);

    Page<Item> findAllByActiveStatusEquals(boolean activeStatus, Pageable pageable);

    Long countAllByActiveStatusEquals(boolean activeStatus);
}
