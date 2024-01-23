package org.jmez.bookingapi.controller;

import org.jmez.bookingapi.controller.dto.AirlinesDTO;
import org.jmez.bookingapi.persistence.entity.Airlines;
import org.jmez.bookingapi.service.AirlinesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlinesController {

    private final AirlinesService airlinesService;

    public AirlinesController(AirlinesService airlinesService) {
        this.airlinesService = airlinesService;
    }

    @PostMapping("/create")
    public ResponseEntity<Airlines> create(@RequestBody AirlinesDTO airlinesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(airlinesService.create(airlinesDTO));
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Airlines> findOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(airlinesService.getOne(id));

    }

    @GetMapping("/findAll")
    public Page<Airlines> paginate(@PageableDefault(sort = "name", size = 2) Pageable pageable ){
        return airlinesService.paginate(pageable);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Airlines> update(@PathVariable Long id, @RequestBody AirlinesDTO airlinesDTO){
        Airlines airlines = airlinesService.update(id, airlinesDTO);
        return ResponseEntity.ok().body(airlines);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        airlinesService.delete(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

}
