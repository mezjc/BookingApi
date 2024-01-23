package org.jmez.bookingapi.service;

import org.jmez.bookingapi.controller.dto.AirlinesDTO;
import org.jmez.bookingapi.persistence.entity.Airlines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AirlinesService {

    Airlines getOne (Long id);

    Airlines create (AirlinesDTO airlinesDTO);


    Page<Airlines> paginate(Pageable pageable);

    Airlines update(Long id, AirlinesDTO airlinesDTO);

    void delete(Long id);
}

