package com.br.backend.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.backend.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Integer>{
	
	@Query("FROM Campanha WHERE dataFinal >= :dataHoje order by dataFinal asc")
    List<Campanha> listarCampanhas(@Param("dataHoje") Date hoje);

	@Query("FROM Campanha WHERE codigo = :codigo and dataFinal >= :dataHoje")
    Campanha buscarCampanhaPorId(@Param("codigo") Integer codigo, @Param("dataHoje") Date hoje);
	
	@Query("FROM Campanha WHERE nome like :nome% and dataFinal >= :dataHoje")
	List<Campanha> buscarCampanhaPorNome(@Param("nome") String nome,@Param("dataHoje") Date hoje);
}
