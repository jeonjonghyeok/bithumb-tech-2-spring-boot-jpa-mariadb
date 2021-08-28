package jjh.api.item.repository;

import jjh.api.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository<Entity, ID>
public interface ItemRepository extends JpaRepository<Item,Long> {

}
