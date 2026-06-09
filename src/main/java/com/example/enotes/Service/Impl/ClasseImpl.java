package com.example.enotes.Service.Impl;
import com.example.enotes.Entity.Classe;
import com.example.enotes.Repository.ClasseRepository;
import com.example.enotes.Service.ClasseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseImpl implements ClasseService {
    private final ClasseRepository classeRepository;

    public ClasseImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @Override
    public Classe getClasseById(Integer id) {
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }
    @Override
    public void deleteClasse(Integer id) {
        classeRepository.deleteById(id);
    }
}
