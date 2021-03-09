package com.liss;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class Storage {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("freight-storage-dir");
	
	/**
	 * @author Issofa
	 * sauvegarder le fichier dans le store du serveur
	 */
	public Boolean store (MultipartFile file) {
		 
			 try {
					Path fichier = this.rootLocation.resolve(file.getOriginalFilename());
					if(Files.notExists(fichier)) {
						Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		    			return true;
					}else return false;
				}catch (Exception e) {
					//throw new RuntimeException("ECHEC DE STOCKAGE DU FICHIER "+file.getOriginalFilename()+" !");
					throw new RuntimeException("ECHEC DE STOCKAGE DU FICHIER  !");
				} 
		
	}
 

}
