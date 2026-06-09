package com.example.enotes.Service;

import com.example.enotes.Entity.Bulletin;
import java.util.List;
public interface BulletinService {
    List<Bulletin> getAllBulletins();
    Bulletin getBulletinById(Integer id);
    Bulletin getBulletinByEtudiantId(Integer etudiantId);
    Bulletin saveBulletin(Bulletin bulletin);
    void deleteBulletin(Integer id);
}
