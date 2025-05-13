package com.codeid.eshoppay_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codeid.eshoppay_backend.model.dto.CategoryDto;
import com.codeid.eshoppay_backend.service.BaseCrudService;
import com.codeid.eshoppay_backend.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/category")
@Slf4j
@RequiredArgsConstructor
public class CategoryController extends BaseCrudController<CategoryDto, Long> {

    private final CategoryService categoryService;

    @Override
    protected BaseCrudService<CategoryDto, Long> getService() {
        return categoryService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto entity) {
        return super.create(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        return super.getById(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @Valid @RequestBody CategoryDto entity) {
        return super.update(id, entity);
    }
}
