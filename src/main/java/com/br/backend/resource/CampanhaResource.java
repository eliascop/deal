package com.br.backend.resource;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backend.model.Campanha;
import com.br.backend.service.CampanhaService;

@RestController
@RequestMapping("campanha")
public class CampanhaResource {
	
	@Autowired
	private CampanhaService campanhaService;
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(this.campanhaService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody Campanha campanha) {
		campanha.setCreatedAt(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(campanhaService.insert(campanha));
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<?> update(@PathVariable int codigo, @Valid @RequestBody Campanha campanha) {
		campanha.setCodigo(codigo);
		return ResponseEntity.ok(campanhaService.update(campanha));  
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete(@PathVariable int codigo) {
		campanhaService.delete(codigo);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<?> find(String nome) 	{
		return ResponseEntity.ok(campanhaService.findByName(nome));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> find(@PathVariable int codigo) {
		return ResponseEntity.ok(campanhaService.findById(codigo));
	}

}
