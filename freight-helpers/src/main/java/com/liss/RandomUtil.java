package com.liss;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomUtil {
	
	private static final int DEF_COUNT = 20;
	
	/**
     * @author Issofa
     * cette fonction me permet de générer un password lors d la création d'un compte de 20 caratères
     * @return the generated password
     */
    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }

    /**
      @author Issofa
     * cette fonction me permet de générer un token d'activation du compte de 20 chiffres
     * @return the generated activation key
     */
    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }


}
