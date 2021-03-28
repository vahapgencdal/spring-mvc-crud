package com.helmes.service;


import com.helmes.dto.SectorFormDto;
import com.helmes.model.Sector;

import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
public interface SectorService {

    List<Sector> findAll();
    List<SectorFormDto> getMappedSectorList();
}
