package com.codeid.eshoppay_backend.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeid.eshoppay_backend.model.dto.ShippersDto;
import com.codeid.eshoppay_backend.model.entity.Shippers;
import com.codeid.eshoppay_backend.repository.ShippersRepository;
import com.codeid.eshoppay_backend.service.ShippersService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShippersServiceImpl implements ShippersService {

    private final ShippersRepository shippersRepository;

    private static ShippersDto mapToDto(Shippers shippers) {
        return new ShippersDto(
            shippers.getShipperId(),
            shippers.getCompanyName(),
            shippers.getPhone()
        );
    }

    @Override
    public List<ShippersDto> findAll() {
        log.debug("Request fetching all shippers");
        return shippersRepository.findAll()
                .stream()
                .map(ShippersServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShippersDto findById(Long id) {
        log.debug("Request to get shipper by id: {}", id);
        return shippersRepository.findById(id)
                .map(ShippersServiceImpl::mapToDto)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found with id " + id));
    }

    @Override
    @Transactional
    public ShippersDto save(ShippersDto dto) {
        log.debug("Request to create shipper: {}", dto);

        Shippers shipper = new Shippers();
        shipper.setCompanyName(dto.getCompanyName());
        shipper.setPhone(dto.getPhone());

        return mapToDto(shippersRepository.save(shipper));
    }

    @Override
    @Transactional
    public ShippersDto update(Long id, ShippersDto dto) {
        log.debug("Request to update shipper with id: {}", id);

        Shippers shipper = shippersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found with id " + id));

        shipper.setCompanyName(dto.getCompanyName());
        shipper.setPhone(dto.getPhone());

        return mapToDto(shippersRepository.save(shipper));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete shipper with id: {}", id);

        Shippers shipper = shippersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found with id " + id));

        shippersRepository.delete(shipper);
    }
}
