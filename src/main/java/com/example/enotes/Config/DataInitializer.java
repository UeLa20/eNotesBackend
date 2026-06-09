package com.example.enotes.Config;

import com.example.enotes.Entity.*;
import com.example.enotes.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AdministrateurRepository administrateurRepository;
    private final EnseignantRepository enseignantRepository;
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;
    private final MatiereRepository matiereRepository;

    public DataInitializer(AdministrateurRepository administrateurRepository,
                           EnseignantRepository enseignantRepository,
                           EtudiantRepository etudiantRepository,
                           ClasseRepository classeRepository,
                           MatiereRepository matiereRepository) {
        this.administrateurRepository = administrateurRepository;
        this.enseignantRepository = enseignantRepository;
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
        this.matiereRepository = matiereRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (administrateurRepository.count() == 0) {
            Administrateur admin = new Administrateur();
            admin.setNom("Admin");
            admin.setPrenom("Super");
            admin.setEmail("admin@enotes.com");
            admin.setMotDePasse("admin123");
            admin.setRole("ADMIN");
            admin.setPrivileges("ALL");
            administrateurRepository.save(admin);
            System.out.println("✅ Admin créé: admin@enotes.com / admin123");
        }

        if (enseignantRepository.count() == 0) {
            Enseignant enseignant = new Enseignant();
            enseignant.setNom("Dupont");
            enseignant.setPrenom("Jean");
            enseignant.setEmail("jean.dupont@enotes.com");
            enseignant.setMotDePasse("enseignant123");
            enseignant.setRole("ENSEIGNANT");
            enseignantRepository.save(enseignant);
            System.out.println("✅ Enseignant créé: jean.dupont@enotes.com / enseignant123");
        }

        if (classeRepository.count() == 0) {
            Classe classe1 = new Classe();
            classe1.setNom("Licence 1");
            classe1.setPromotion("2024");
            classeRepository.save(classe1);

            Classe classe2 = new Classe();
            classe2.setNom("Licence 2");
            classe2.setPromotion("2024");
            classeRepository.save(classe2);
            System.out.println("✅ 2 classes créées");
        }

        if (matiereRepository.count() == 0) {
            Matiere matiere1 = new Matiere();
            matiere1.setNom("Mathématiques");
            matiere1.setDescription("Calcul et algèbre");
            matiereRepository.save(matiere1);

            Matiere matiere2 = new Matiere();
            matiere2.setNom("Physique");
            matiere2.setDescription("Mécanique et thermodynamique");
            matiereRepository.save(matiere2);

            Matiere matiere3 = new Matiere();
            matiere3.setNom("Informatique");
            matiere3.setDescription("Programmation et bases de données");
            matiereRepository.save(matiere3);
            System.out.println("✅ 3 matières créées");
        }

        if (etudiantRepository.count() == 0) {
            Etudiant etudiant = new Etudiant();
            etudiant.setNom("Martin");
            etudiant.setPrenom("Luc");
            etudiant.setEmail("luc.martin@enotes.com");
            etudiant.setMotDePasse("etudiant123");
            etudiant.setRole("ETUDIANT");
            etudiantRepository.save(etudiant);
            System.out.println("✅ Étudiant créé: luc.martin@enotes.com / etudiant123");
        }
    }
}
