// src/main/controller/ApiController.java
package com.example.demo.controller;

import com.example.demo.domain.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ProductoRepository repo;

    public ApiController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Producto> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice)
            .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());
    }

    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String category
    ) {
        DoubleSummaryStatistics statistics = repo.findAll().stream()
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .mapToDouble(Producto::getPrice)
            .summaryStatistics();

        return Map.of(
            "count", (double) statistics.getCount(),
            "avgPrice", statistics.getAverage(),
            "minPrice", stat
        );
    }
}