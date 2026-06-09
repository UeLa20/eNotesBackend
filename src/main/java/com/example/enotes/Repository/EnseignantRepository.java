package com.example.enotes.Repository;

import com.example.enotes.Entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
}
