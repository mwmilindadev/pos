package com.springbootacadamy.pos.repo;

import com.springbootacadamy.pos.dto.queryinterface.OrderDetailsInterface;
import com.springbootacadamy.pos.dto.response.ResponseOrderDtailsDTO;
import com.springbootacadamy.pos.entity.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders,Integer> {
    @Query(value = "select  c.customar_name,c.customar_address,c.conatct_numbers,d.order_date,d.total from  customar c,orders d where active_status=?1 and c.customar_id=d.customar_id ",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean b, Pageable pageable);
}
