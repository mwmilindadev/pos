package com.springbootacadamy.pos.repo;

import com.springbootacadamy.pos.entity.Customar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomarRepo extends JpaRepository<Customar,Integer> {

    List<Customar> findAllByActiveStatusEquals(boolean status);

    List<Customar> findAllByActiveStatusEqualsAndCustomarIdEquals(boolean activeStatus, int customarId);
}
