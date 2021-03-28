package com.helmes.service;

import com.helmes.dto.SectorFormDto;
import com.helmes.model.Sector;
import com.helmes.repository.SectorRepository;
import com.helmes.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Service
public class SectorServiceImpl implements SectorService{

    @Autowired
    private SectorRepository sectorRepository;


    @Override
    public List<Sector> findAll() {
        return sectorRepository.findAll();
    }

    @Override
    public List<SectorFormDto> getMappedSectorList() {

        List<Sector> allSectors = sectorRepository.findAll();

        final List<SectorFormDto> sortedList= new ArrayList<>();

        Util.mapSectorToForm(allSectors,sortedList);

        return sortedList;
    }




}
