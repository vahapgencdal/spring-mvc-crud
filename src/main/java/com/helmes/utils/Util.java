package com.helmes.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmes.dto.SectorFormDto;
import com.helmes.model.Sector;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
public class Util {

    private Util(){}

    public static final String SPACE = "&nbsp;&nbsp;&nbsp;&nbsp;";

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8
    );


    public static String leftPad(final String str, final int size) {
            StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <size; i++) {
            stringBuilder.append(SPACE);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void mapSectorToForm(List<Sector> sectors, final List<SectorFormDto> sortedList){
        sectors.stream().forEach(sector -> {
            SectorFormDto sectorFormDto = new SectorFormDto();
            StringBuilder tempStr = new StringBuilder();
            Sector temp= sector.getParent();
            while (temp!=null){
                tempStr.append(Util.SPACE);
                temp = temp.getParent();
            }
            tempStr.append(sector.getName());
            sectorFormDto.setName(tempStr.toString());
            sectorFormDto.setId(sector.getId());
            sortedList.add(sectorFormDto);
            mapSectorToForm(new ArrayList<>(sector.getSectors()), sortedList);
        });
    }

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < length; index++) {
            builder.append("a");
        }

        return builder.toString();
    }
}
