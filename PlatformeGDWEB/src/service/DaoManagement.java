package service;

import javax.ejb.EJB;
import java.nio.charset.StandardCharsets;
import javax.ejb.NoSuchEJBException;
import javax.naming.Context;
import javax.naming.InitialContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Hashtable;

import metier.entities.Utilisateur;
import metier.session.PlatformGDLocal;
import metier.session.PlatformGDRemote;

public class DaoManagement {
	@EJB
	private PlatformGDLocal metier;
	
	public DaoManagement() {
//		try {
//			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
//			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//			final Context context = new InitialContext(jndiProperties);
//			metier = (PlatformGDLocal) context
//					.lookup("java:global/PlatformeGDEAR/PlatformGDEJB/BK!metier.session.PlatformGDLocal");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
	public Utilisateur checkUser(String username, String clearPassword) {
		MessageDigest digest = null;
		try {
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] hash = digest.digest(clearPassword.getBytes(StandardCharsets.UTF_8));
			String hashedPassword = Base64.getEncoder().encodeToString(hash);
			return metier.authentification(username, hashedPassword);
		} catch (NoSuchEJBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void ajouteUtilisateur(Utilisateur utilisateur) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] hash = digest.digest(utilisateur.getMdp().getBytes(StandardCharsets.UTF_8));
		String hashedPassword = Base64.getEncoder().encodeToString(hash);
		utilisateur.setMdp(hashedPassword);
		metier.ajouteUtilisateur(utilisateur);
	}
	
	public String hashPassword(String clearPassword)
	{
		MessageDigest digest = null;
		try {
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] hash = digest.digest(clearPassword.getBytes(StandardCharsets.UTF_8));
			String hashedPassword = Base64.getEncoder().encodeToString(hash);
			return hashedPassword;
		} catch (NoSuchEJBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
