package com.leverx.pets.controller;

import com.leverx.pets.dto.request.create.CatCreateRequestDTO;
import com.leverx.pets.dto.request.update.CatUpdateRequestDTO;
import com.leverx.pets.dto.response.CatResponseDTO;
import com.leverx.pets.exception.EntityDoesNotExistException;
import com.leverx.pets.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j

@RestController
@RequestMapping(value = "api/v1/cats")
public class CatController {
    private final CatService catService;

    @GetMapping()
    public ResponseEntity<List<CatResponseDTO>> findAllCats() {
        log.trace("Method is invoked");
        
        List<CatResponseDTO> allCats = catService.findAll();
        return ResponseEntity.ok(allCats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatResponseDTO> findCatById(@PathVariable("id") Long catId) throws EntityDoesNotExistException {
        log.trace("Method is invoked");
        
        CatResponseDTO catResponseDTO = catService.findById(catId);
        return ResponseEntity.ok(catResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<CatResponseDTO> createCat(@Valid @RequestBody CatCreateRequestDTO catCreateRequestDTO) throws EntityDoesNotExistException {
        log.trace("Method is invoked");
        
        CatResponseDTO catResponseDTO = catService.create(catCreateRequestDTO);
        return ResponseEntity.status(CREATED).body(catResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CatResponseDTO> updateCat(@PathVariable("id") Long catId,
                                                    @Valid @RequestBody CatUpdateRequestDTO updateDto) throws EntityDoesNotExistException {
        log.trace("Method is invoked");
        
        CatResponseDTO catResponseDTO = catService.updateById(catId, updateDto);

        return ResponseEntity.ok(catResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCatById(@PathVariable("id") Long catId) throws EntityDoesNotExistException {
        log.trace("Method is invoked");
        
        catService.deleteById(catId);

        return ResponseEntity.noContent().build();
    }
}
