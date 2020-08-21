package com.algawork.oswork.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algawork.oswork.domain.model.OrdemServico;



@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
