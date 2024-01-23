package org.jmez.bookingapi.service.impl;

import org.jmez.bookingapi.controller.dto.AirlinesDTO;
import org.jmez.bookingapi.persistence.entity.Airlines;
import org.jmez.bookingapi.persistence.repository.AirlinesRepository;
import org.jmez.bookingapi.service.AirlinesService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AirlinesServiceImpl implements AirlinesService {

    private final AirlinesRepository airlinesRepository;

    public AirlinesServiceImpl(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }

    @Override
    public Airlines getOne(Long id) {
        return airlinesRepository.findById(id).orElseThrow();
    }

    @Override
    public Airlines create(AirlinesDTO airlinesDTO) {
        System.out.println(airlinesDTO.getNombre()+ " desde el controller 1");
        //Airlines airlines = new ModelMapper().map(airlinesDTO, Airlines.class);
        Airlines airlines = new Airlines();
        airlines.setName(airlinesDTO.getNombre());
        System.out.println(airlines+ " desde el controller 2");
        return airlinesRepository.save(airlines);
    }

    public Page<Airlines> paginate(Pageable pageable){
        return airlinesRepository.findAll(pageable);
    }

    @Override
    public Airlines update(Long id, AirlinesDTO airlinesDTO) {
        Airlines airlines = getOne(id);
        airlines.setName(airlinesDTO.getNombre());
        return airlinesRepository.save(airlines);

    }

    @Override
    public void delete(Long id) {
        airlinesRepository.deleteById(id);
    }
}
