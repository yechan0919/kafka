package com.kafaka.catalog.controller;

import com.kafaka.catalog.jpa.CatalogEntity;
import com.kafaka.catalog.service.CatalogService;
import com.kafaka.catalog.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalog(){
        Iterable<CatalogEntity> catalogList = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
