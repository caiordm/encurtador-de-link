package com.caio.encurtador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caio.encurtador.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long>{
	// List<Url> findByHash(String hash);
	
	@Query(value = "SELECT url_original FROM url WHERE url.hash = ?1", nativeQuery = true)
	String findByHashManual(@Param("hash") String hash);
}

