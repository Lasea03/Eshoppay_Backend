package com.codeid.eshoppay_backend.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeid.eshoppay_backend.model.dto.SuppliersDto;
import com.codeid.eshoppay_backend.model.entity.Suppliers;
import com.codeid.eshoppay_backend.repository.SuppliersRepository;
import com.codeid.eshoppay_backend.service.SuppliersService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuppliersServiceImpl implements SuppliersService {

    private final SuppliersRepository suppliersRepository;

    public static SuppliersDto mapToDto(Suppliers suppliers) {
        return new SuppliersDto(
            suppliers.getSupplierId(),
            suppliers.getCompanyName()
        );
    }

    @Override
    public List<SuppliersDto> findAll() {
        log.debug("Request to fetch all suppliers");
        return suppliersRepository.findAll()
                .stream()
                .map(SuppliersServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SuppliersDto findById(Long id) {
        log.debug("Request to get supplier : {}", id);
        return suppliersRepository.findById(id)
                .map(SuppliersServiceImpl::mapToDto)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id " + id));
    }

    @Override
    @Transactional
    public SuppliersDto save(SuppliersDto entity) {
        log.debug("Request to create supplier : {}", entity);
        Suppliers saved = suppliersRepository.save(new Suppliers(entity.getCompanyName()));
        return mapToDto(saved);
    }

    @Override
    @Transactional
    public SuppliersDto update(Long id, SuppliersDto entity) {
        log.debug("Request to update supplier : {}", id);
        Suppliers suppliers = suppliersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id " + id));

        suppliers.setCompanyName(entity.getCompanyName());
        return mapToDto(suppliersRepository.save(suppliers));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete supplier : {}", id);
        Suppliers suppliers = suppliersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id " + id));

        suppliersRepository.delete(suppliers);
    }
}
