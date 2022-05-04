package com.springbackEnd;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbackEnd.domain.Categoria;
import com.springbackEnd.domain.Cidade;
import com.springbackEnd.domain.Estado;
import com.springbackEnd.domain.Produto;
import com.springbackEnd.repositories.CategoriaRepository;
import com.springbackEnd.repositories.CidadeRepository;
import com.springbackEnd.repositories.EstadoRepository;
import com.springbackEnd.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUdemySpringApplication implements CommandLineRunner{
	

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoUdemySpringApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 200.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2,c3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		
	}

}
