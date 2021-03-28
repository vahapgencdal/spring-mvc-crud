package com.helmes.repository;

import com.helmes.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Repository
public interface SectorRepository extends JpaRepository<Sector, Long>, JpaSpecificationExecutor<Sector> {

    List<Sector> findByIdIn(List<Long> idList);

    List<Sector> findByParentIsNull();
}
