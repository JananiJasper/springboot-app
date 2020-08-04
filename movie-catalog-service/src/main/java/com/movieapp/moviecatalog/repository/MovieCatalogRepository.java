package com.movieapp.moviecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.moviecatalog.model.MovieCatalog;

@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Long> {

}
