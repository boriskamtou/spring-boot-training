package com.bk.tacocloud.data;

import com.bk.tacocloud.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
