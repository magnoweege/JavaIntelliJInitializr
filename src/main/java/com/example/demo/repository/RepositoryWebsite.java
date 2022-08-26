package com.example.demo.repository;

import com.example.demo.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryWebsite extends JpaRepository<Website, Long>{
}
