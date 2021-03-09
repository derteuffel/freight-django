package com.liss.repositories.translate;


import com.liss.entities.translate.TranslateStaticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslateStaticRepository extends JpaRepository<TranslateStaticEntity, String> {
}
