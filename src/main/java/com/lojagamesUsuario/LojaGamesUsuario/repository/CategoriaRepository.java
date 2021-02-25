package com.lojagamesUsuario.LojaGamesUsuario.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lojagamesUsuario.LojaGamesUsuario.model.Categoria;







public interface CategoriaRepository  extends JpaRepository <Categoria, Long > 
{
	
	public List<Categoria> findAllBytipoDeAreaContainingIgnoreCase(String tipoDeArea);
}