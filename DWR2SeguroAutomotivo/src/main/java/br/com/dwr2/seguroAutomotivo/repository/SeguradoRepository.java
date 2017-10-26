package br.com.dwr2.seguroAutomotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dwr2.seguroAutomotivo.entidades.Segurado;

@Repository
public interface SeguradoRepository extends JpaRepository<Segurado, Long>{
	
}
