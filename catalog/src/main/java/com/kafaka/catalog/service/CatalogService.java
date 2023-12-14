package com.kafaka.catalog.service;

import com.kafaka.catalog.jpa.CatalogEntity;
import com.kafaka.catalog.jpa.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
