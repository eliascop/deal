package com.br.backend.service;

import java.beans.FeatureDescriptor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.backend.model.Campanha;
import com.br.backend.repository.CampanhaRepository;

@Service 
public class CampanhaService {
	
	@Autowired 
	private CampanhaRepository campanhaRepository;
	
	public Campanha insert(Campanha campanhaNova) {			
		List<Campanha> campanhasAtivas = findAll();
		Calendar dtUltimaCamp = Calendar.getInstance(); 
		dtUltimaCamp.setTime(campanhaNova.getDataFinal());
		
		for(Campanha campanhaAtiva:campanhasAtivas) {
			Calendar dtCampAtual = Calendar.getInstance();
			dtCampAtual.setTime(campanhaAtiva.getDataFinal()); 
			if(dtCampAtual.equals(dtUltimaCamp)) {
				dtUltimaCamp.add(Calendar.DATE, 1);
				campanhaAtiva.setDataFinal(dtUltimaCamp.getTime());
				campanhaRepository.save(campanhaAtiva);				
			}
			
		}
		
		return this.campanhaRepository.save(campanhaNova);
	}
	
	public Campanha update(Campanha campanha) {
		Campanha campanhaSaved = campanhaRepository.findById(campanha.getCodigo()).orElseThrow(() -> new RuntimeException("Campanha not found"));
		campanhaSaved.setUpdatedAt(new Date());
		
		String[] nullPropertyNames = getNullPropertyNames(campanha);
		BeanUtils.copyProperties(campanha, campanhaSaved, nullPropertyNames);
		
		return campanhaRepository.save(campanhaSaved);
	}
	
	public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
            .map(FeatureDescriptor::getName)
            .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
            .toArray(String[]::new);
    }

	public void delete(int codigo) {
		campanhaRepository.deleteById(codigo);
	}

	public List<Campanha> findAll(){
		return (List<Campanha>) this.campanhaRepository.listarCampanhas(new Date());
	}
	
	public Campanha findById(int codigo){
		return this.campanhaRepository.buscarCampanhaPorId(codigo, new Date());
	}
	
	public List<Campanha> findByName(String nome) {

		return (List<Campanha>) this.campanhaRepository.buscarCampanhaPorNome(nome, new Date());

	}
	
}
