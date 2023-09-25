package com.fssa.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptPassword {
	
	public class Password {
		public static String encryptPassword(String plainPassword) {
			return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
		}
	} 
}
