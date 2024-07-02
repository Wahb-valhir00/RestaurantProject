package com.elife.projet_ff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elife.projet_ff.model.Avis;
import com.elife.projet_ff.repository.AvisRepository;
@Service
public class AvisService {
@Autowired
    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }
    public List<Avis> getAllAvis (){
        return avisRepository.findAll();
    }
    public Avis createAvis(Avis avis){
        return avisRepository.save(avis);
    }


    
}
