package metier.session;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import metier.entities.*;

@Stateless(name = "BK")
public class PlatformGDImpl implements PlatformGDLocal, PlatformGDRemote {
	@javax.persistence.PersistenceContext(unitName = "PlatformGD")
	private EntityManager em;

	@Override
	public void Faire_Un_Don(Don don, PhotoDon photo, Utilisateur donnateur, Etablisement beneficiaire) {
		// TODO Auto-generated method stub

	}
///////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////
//////////Get Dons
	@Override
	public List<DonEnNature> getAllDonsEnNature() {
		Query req = em.createQuery("select d from DonEnNature d");
		return req.getResultList();
	}
	
	@Override
	public List<Don> getAllDonsEnNature(int current, int nbRecords) {
		int start = current * nbRecords - nbRecords;
		Query req = em.createQuery("SELECT d FROM DonEnNature d");
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}

	@Override
	public List<DonEnNature> getAllDonsEnNature(int current, int nbRecords, String order, String direction) {

		int start = current * nbRecords - nbRecords;
		String q ="";
		if((order != null)&&(direction!=null))
			 q = "SELECT b FROM DonEnNature b ORDER BY "+order+" "+direction;
		else
			 q = "SELECT b FROM Besoin b ORDER BY b.utilisateur.Nom desc";
		Query req = em.createQuery(q);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	
	@Override
	public List<Reglement> getAllDonsReglement() {
		Query req = em.createQuery("select r from Reglement r");
		return req.getResultList();
	}

	@Override
	public List<Reglement> getAllDonsReglement(int current, int nbRecords, String order, String direction) {

		int start = current * nbRecords - nbRecords;
		String q ="";
		if((order != null)&&(direction!=null))
			 q = "SELECT b FROM DonEnNature b ORDER BY "+order+" "+direction;
		else
			 q = "SELECT b FROM Besoin b ORDER BY b.utilisateur.Nom desc";
		Query req = em.createQuery(q);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	
	@Override
	public List<Don> getDonByEtablissement(String nom_etabliessement) {
		Query req = em.createQuery("select d from don d where d.etablissement.NomEtabliessement=:x");
		req.setParameter("x", nom_etabliessement);
		return req.getResultList();
	}
	@Override
	public List<Don> getDonByDonnateur(String mail_donnateur) {
		Query req = em.createQuery("select d from don d where d.utilisateur.email=:x");
		req.setParameter("x", mail_donnateur);
		return req.getResultList();
	}
	@Override
	public List<Don> getDonEnNatureNotAcceptedByMinistere(){
		Query req = em.createQuery("select d from DonEnNature d where estAcceptee = false");
		return req.getResultList();
	}
	@Override
	public List<Don> getDonReglementNotAcceptedByMinistere(){
		Query req = em.createQuery("select r from Reglement r where estAcceptee = false");
		return req.getResultList();		
	}
	@Override
	public List<Don> getDonEnNatureDeletedByMinistere(){
		Query req = em.createQuery("select d from DonEnNature d where estSupprimee = true");
		return req.getResultList();	
	}
	public List<Don> getDonReglementDeletedByMinistere(){
		Query req = em.createQuery("select r from Reglement r where estSupprimee = true");
		return req.getResultList();	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////Photo dons

	@Override
	public List<PhotoDon> getAllPhotoDonById(String id_don) {
		Query req = em.createQuery("select ph from PhotoDon ph where ph.idDon=:x");
		req.setParameter("x", id_don);
		return req.getResultList();
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public DonEnNature getDonEnNatureById(String id_don) {
		DonEnNature a = em.find(DonEnNature.class, id_don);
		if (a == null)
			throw new RuntimeException("Don est introuvable");
		return a;
	}
	@Override
	public Reglement getDonEnReglementById(String id_don) {
		Reglement a = em.find(Reglement.class, id_don);
		if (a == null)
			throw new RuntimeException("Don est introuvable");
		return a;
	}
	@Override
	public void ajouterDonEnNature(DonEnNature don_en_nature) {
		if (!don_en_nature.equals(null))
			em.persist(don_en_nature);
		//Query req = em.createQuery("UPDATE besoin SET quantite_restante = quantite_initiale - "
		//		+ don_en_nature.getQuantite() + ", etat = 'en cours' WHERE id_besoin =" + id_besoin);
	//	req.executeUpdate();
	}

	@Override
	public void ajouterDonReglement(Reglement reglement) {
		if (!reglement.equals(null))
			em.persist(reglement);
	}

	@Override
	public void updateDonEnNature(DonEnNature don_en_nature) {
		// TODO Auto-generated method stub
		if (!don_en_nature.equals(null))
			em.merge(don_en_nature);
	}

	@Override
	public void updateReglement(Reglement reglement) {
		// TODO Auto-generated method stub
		if (!reglement.equals(null))
			em.merge(reglement);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void ajouterPhotoDon(String url_photo, String id_don) {
		// TODO Auto-generated method stub
		Query req = em
				.createQuery("INSERT INTO photodon (urlPhoto, codeDon) VALUES ( " + url_photo + " , " + id_don + " )");
		req.executeUpdate();
	}

	@Override
	public void deletePhotoDon(String id_photo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePhotoDon(PhotoDon photo_don) {
		// TODO Auto-generated method stub
		if (!photo_don.equals(null))
			em.merge(photo_don);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String getNomEtablissementById(String id_etablissement) {
		Etablisement a = em.find(Etablisement.class, id_etablissement);
		if (a == null)
			throw new RuntimeException("Don est introuvable");
		return a.getNomEtablissement();
	}
	@Override
	public List<PhotoDon> getAllPhotoDon() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void ajoutBesoin(Besoin b) 
	{

			
		if(!b.equals(null))
		{
			em.persist(b);

		}
		
	}

	@Override
	public void ajoutProduit(Produit p) 
	{
		if(!p.equals(null))
		{
			em.persist(p);
		}
			
		
	}

	@Override
	public void ajoutCategorie(Categorie c) {
		if(!c.equals(null))
			em.persist(c);
		
	}

	@Override
	public void ajoutPhotoBesoin(PhotoBesoin pB) 
	{
		if(!pB.equals(null))
			em.persist(pB);
		
	}

	@Override
	public void ajoutUniteDeMesure(UniteDeMesure uM) 
	{
		if(!uM.equals(null))
			em.persist(uM);
		
	}

	@Override
	public void ajoutFournisseur(Fournisseur f) 
	{
		if(!f.equals(null))
			em.persist(f);
		
	}
	@Override
	public void ajoutPhoto(Photo ph)
	{
		if(!ph.equals(null))
			em.persist(ph);
	}
	
	@Override
	public void deleteBesoin(Besoin b) 
	{
		
		em.remove(em.find(Besoin.class, b.getIdBesoin()));
	}

	@Override
	public void deleteProduit(Produit p)
	{
		em.remove(em.find(Produit.class, p.getIdProduit()));		
	}

	@Override
	public void deleteCategorie(Categorie c) 
	{
		em.remove(em.find(Categorie.class, c.getIdC()));
		
	}

	@Override
	public void deletePhotoBesoin(PhotoBesoin pB) 
	{
		em.remove(em.find(PhotoBesoin.class, pB.getIdPB()));		
	}

	@Override
	public void deleteUniteDeMesure(UniteDeMesure uM) 
	{
		em.remove(em.find(UniteDeMesure.class, uM.getIdUnite()));		
		
	}

	@Override
	public void deleteFournisseur(Fournisseur f) 
	{
		em.remove(em.find(Fournisseur.class, f.getIdF()));		
		
	}

	@Override
	public void deletePhoto(Photo ph)
	{
		em.remove(em.find(Photo.class, ph.getIdP()));
	}
	
	@Override
	public void updateBesoin(Besoin b) 
	{
		if(!b.equals(null))
			em.merge(b);
		
	}

	@Override
	public void updateProduit(Produit p) 
	{
		if(!p.equals(null))
			em.merge(p);
		
	}

	@Override
	public void updateCategorie(Categorie c) {
		if(!c.equals(null))
			em.merge(c);
		
	}

	@Override
	public void updatePhotoBesoin(PhotoBesoin pB) 
	{
		if(!pB.equals(null))
			em.merge(pB);
		
	}

	@Override
	public void updateUniteDeMesure(UniteDeMesure uM) 
	{
		if(!uM.equals(null))
			em.merge(uM);
		
	}

	@Override
	public void updateFournisseur(Fournisseur f) 
	{
		if(!f.equals(null))
			em.merge(f);
		
	}

	@Override
	public List<Besoin> getAllBesoin() {
		return em.createNamedQuery("Besoin.findAll",Besoin.class).getResultList();

	}

	@Override
	public List<Produit> getAllProduit(int current, int nbRecords) 
	{
		int start = current * nbRecords - nbRecords;
		return em.createNamedQuery("Produit.findAll",Produit.class).setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}

	@Override
	public List<Categorie> getAllCategorie() {
		return em.createNamedQuery("Categorie.findAll",Categorie.class).getResultList();
	}

	@Override
	public List<PhotoBesoin> getAllPhotoBesoin() {
		return em.createNamedQuery("PhotoBesoin.findAll",PhotoBesoin.class).getResultList();

	}

	@Override
	public List<UniteDeMesure> getAllUniteDeMesure() {
		return em.createNamedQuery("UniteDeMesure.findAll",UniteDeMesure.class).getResultList();
	}

	@Override
	public List<Fournisseur> getAllFournisseur(int current, int nbRecords) 
	{
		int start = current * nbRecords - nbRecords;
		return em.createNamedQuery("Fournisseur.findAll",Fournisseur.class).setFirstResult(start).setMaxResults(nbRecords).getResultList();

	}
	

	@Override
	public List<Produit> getProduitByCategorie(String idc) {
		
		TypedQuery<Produit> q = (TypedQuery<Produit>) 
				em.createNamedQuery("Produit.findAll",Produit.class);
		
		List<Produit> produits = (List<Produit>) q.getResultList().
				stream().filter(p->p.getCategorie().getIdC()==idc).collect(Collectors.toList());
		
		return produits;
	}
	
	

	

	@Override
	public List<Produit> getProduitByFounisseur(String idF)
	{
	    	Query req= em.createQuery("select p from Produit p join fetch p.fournisseurs ps where ps.idF =:x");
	    	req.setParameter("x", idF);
	    	return req.getResultList();
	}	
	

	
	@Override
	public List<Fournisseur> getFournisseurByProduit(String idP) 
	{
    	Query req= em.createQuery("select f from Fournisseur f join fetch f.produits ps where ps.idProduit =:x");
    	//Query req= entityManager.createQuery("select f from Fournisseur f where  f.produits.idProduit=:x");
    	req.setParameter("x", idP);
    	return req.getResultList();
	}

	@Override
	public Produit getProduitById(String idP) 
	{
		Produit produit = em.find(Produit.class, idP);
		return produit;
	}
	@Override
	public UniteDeMesure getUniteDeMesureById(String idU) {
		UniteDeMesure uniteDeMesure = em.find(UniteDeMesure.class,idU);
		return uniteDeMesure;
	}

	@Override
	public Categorie getCategorieById(String idC) 
	{
		Categorie categorie = em.find(Categorie.class, idC);
		return categorie;
	}

	@Override
	public Besoin getBesoinById(String idB) {
		Besoin besoin =em.find(Besoin.class, idB);
		return besoin;
	}

	@Override
	public Fournisseur getFournisseurById(String idF) 
	{
		Fournisseur fournisseur =em.find(Fournisseur.class, idF);
		return fournisseur;
	}



	
	
	
	@Override
	public void ajouteUtilisateur(Utilisateur utilisateur)
	{
		if(!utilisateur.equals(null))
			em.persist(utilisateur);
	}
	/*@Override
	public String ajouteUtilisateur(Utilisateur utilisateur) {
		em.persist(utilisateur);
		em.flush();
		return utilisateur.getIdut();
	}*/
	@Override
	public void ajouteadresse(Adresse adresse)
	{
		if(!adresse.equals(null))
			em.persist(adresse);
	}
	/*@Override
	public String ajouteadresse(Adresse adresse) {
		em.persist(adresse);
		em.flush();
		return adresse.getIdAdresse();
	}*/

	@Override
	public String ajoutereclamation(Reclamation reclamation) {
		em.persist(reclamation);
		em.flush();
		return reclamation.getCodeReclamation();
	}
	@Override
	public void ajoutetelephone(Telephone telephone)
	{
		if(!telephone.equals(null))
			em.persist(telephone);
	}
	/*@Override
	public String ajoutetelephone(Telephone telephone) {
		em.persist(telephone);
		em.flush();
		return telephone.getIdTel();
	}*/

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		utilisateur = em.merge(utilisateur);
		em.remove(utilisateur);
	}

	@Override
	public void deleteadresse(Adresse adresse) {
		adresse = em.merge(adresse);
		em.remove(adresse);
	}

	@Override
	public void deleteetablissement(Etablisement etablisement) {
		etablisement = em.merge(etablisement);
		em.remove(etablisement);
	}

	@Override
	public void deletereclamation(Reclamation reclamation) {
		reclamation = em.merge(reclamation);
		em.remove(reclamation);
	}

	@Override
	public void deletetelephone(Telephone telephone) {
		telephone = em.merge(telephone);
		em.remove(telephone);
	}

	@Override
	public Adresse findadresse(String idAdresse) {
		Adresse a = em.find(Adresse.class, idAdresse);
		return a;
	}

	@Override
	public Etablisement findetablissement(String idetablisement) {
		Etablisement a = em.find(Etablisement.class, idetablisement);
		return a;
	}

	@Override
	public Reclamation findreclamation(String codeReclamation) {
		Reclamation a = em.find(Reclamation.class, codeReclamation);
		return a;
	}

	@Override
	public Telephone findtelephone(String idTel) {
		Telephone a = em.find(Telephone.class, idTel);
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getUtilisateur() {

		Query req = em.createNativeQuery("SELECT * FROM Utilisateur", Utilisateur.class);
		return req.getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Reclamation> getreclamation() {

		Query req = em.createNativeQuery("SELECT * FROM Reclamation", Reclamation.class);
		return req.getResultList();
	}

	@Override
	public void updateReclamatiom(boolean estTr, Reclamation reclamation) {

		Query req = em.createQuery("UPDATE Reclamation SET estTraitee=" + estTr + "WHERE codeReclamation="
				+ reclamation.getCodeReclamation());
		req.executeUpdate();
	}

	@Override
	public void updateetatDecompte(Boolean etatDecompte, Utilisateur utilisateur) {
		Query req = em.createQuery(
				"UPDATE Reclamation SET etatDecompte=" + etatDecompte + "WHERE idut=" + utilisateur.getIdut());
		req.executeUpdate();

	}

	@Override
	public void ajout_ut_tel(String l1, String l2, String l3) {

		em.createNativeQuery("INSERT INTO t_utilisateur_telephone (idut, IdTel) VALUES (?,?)")
				.setParameter(1, l3).setParameter(2, l1).executeUpdate();
		em.createNativeQuery("INSERT INTO t_utilisateu_adresse( idAdresse, idut) VALUES (?,?)")
				.setParameter(1, l2).setParameter(2, l3).executeUpdate();
	
	}
	@Override
	public void ajouteetablissement(Etablisement etablisement)
	{
		if(!etablisement.equals(null))
			em.persist(etablisement);
	}
	/*@Override
	public String ajouteetablissement(Etablisement etablisement) {
		em.persist(etablisement);
		em.flush();
		return etablisement.getIdEtablissement();
	}*/
	
	/*@Override
	public void ajouteadresseEtablissement(String l1, String l2, String l3, String l4, String l5) {
		em.createNativeQuery("INSERT INTO t_etablissement_utilisateur(IdEtablissement, idut) VALUES (?,?)")
				.setParameter(1, l5).setParameter(2, l1).executeUpdate();
		em.createNativeQuery("INSERT INTO t_telephone_etablissement(IdEtablissement, IdTel) VALUES (?,?)")
				.setParameter(1, l5).setParameter(2, l2).executeUpdate();
		em.createNativeQuery("INSERT INTO t_telephone_etablissement(IdEtablissement, IdTel) VALUES (?,?)")
				.setParameter(1, l5).setParameter(2, l3).executeUpdate();
		em.createNativeQuery("INSERT INTO t_etablissement_adresse(IdEtablissement, idAdresse) VALUES (?,?)")
				.setParameter(1, l5).setParameter(2, l4).executeUpdate();
//		Query req = em.createQuery("INSERT INTO t_etablissement_utilisateur(IdEtablissement, idut) VALUES ( '" + l5 + "' , '" + l1 + "' )");
//		req.executeUpdate();
//		Query req1 = em.createQuery("INSERT INTO t_telephone_etablissement(IdEtablissement, IdTel) VALUES ( '" + l5 + "' , '" + l2 + "' )");
//		req1.executeUpdate();
//		Query req2 = em.createQuery("INSERT INTO t_telephone_etablissement(IdEtablissement, IdTel) VALUES ( '" + l5 + "' , '" + l3 + "' )");
//		req2.executeUpdate();
//		Query req3 = em.createQuery("INSERT INTO t_etablissement_adresse(IdEtablissement, idAdresse) VALUES ( '" + l5 + "' , '" + l4 + "' )");
//		req3.executeUpdate();
		
		
	}*/

//	public Utilisateur getUtilisateurByEmail(String email) {
//		try {
//			Query tq = em.createQuery("select u from Utilisateur u WHERE email=? ", Utilisateur.class);
//			tq.setParameter(1, email);
//			Utilisateur utilisateur = (Utilisateur) tq.getSingleResult();
//			em.merge(utilisateur);
//			return utilisateur;
//		} catch (Exception noresult) {
//			return null;
//		}
//	}

	
	
	@Override
	public Etablisement verification_du_compte(Utilisateur utilisateur) {
		Query query1 = em.createQuery("SELECT E.IdEtablissement FROM t_etablissement_utilisateur E WHERE E.idut  = '"
						+ utilisateur.getIdut() + "'");
		if (query1.getSingleResult().equals(null) == false) {
			long l = (long) query1.getSingleResult();

			Query query = em.createQuery("SELECT E FROM Etablisement E WHERE E.IdEtablissement = '" + l + "'");
			return (Etablisement) query.getSingleResult();
		}
		return null;
	}

	@Override
	public Utilisateur findUtilisateurById(String idut) {
		Utilisateur a = em.find(Utilisateur.class, idut);
		return a;
	}

	@Override
	public Utilisateur getDonnateurByEtablissement(String id_Etablissemment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etablisement> getAllBeneficiaire() {
		Query req = em.createNativeQuery(
				"SELECT * FROM Etablisement where drs=0 and Intermediaire=0 and Intermediaire=0", Etablisement.class);
		return req.getResultList();
	}

	@Override
	public Utilisateur authentification(String mail, String hashedPassword) {
			Query tq = em.createQuery("select u from Utilisateur u WHERE u.email =:x and u.mdp =:y ",Utilisateur.class);
			tq.setParameter("x", mail);
			tq.setParameter("y", hashedPassword);
			Utilisateur utilisateur = null;
			try{
				utilisateur = (Utilisateur) tq.getSingleResult();
			}
				catch (NoResultException nre){
				
				}
			return utilisateur;
	}


	@Override
	public List<Besoin> getBesoinsByEtablissement(String idE) {
		
//		TypedQuery<Besoin> q = (TypedQuery<Besoin>) 
//				em.createNamedQuery("Besoin.findAll",Besoin.class);
//		
//		List<Besoin> besoins = (List<Besoin>) q.getResultList().
//				stream().filter(b->b.getEtablisement().getIdEtablissement()==idE).collect(Collectors.toList());
//		
//		return besoins;
		
    	Query req= em.createQuery("select b from Besoin b where b.etablisement.IdEtablissement =:x");
    	req.setParameter("x", idE);
    	return req.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Etablisement> getAllEtablissement() {

		Query req = em.createNativeQuery("SELECT * FROM Etablisement", Etablisement.class);
		return req.getResultList();
	}

	@Override
	public PhotoBesoin getPhotoBesoinById(String idPb) {
		PhotoBesoin photoBesoin =em.find(PhotoBesoin.class, idPb);
		return photoBesoin;
	}

	@Override
	public void updateEtablisement(Etablisement e) 
	{
		if(!e.equals(null))
			em.merge(e);
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) {
		if(!utilisateur.equals(null))
			em.merge(utilisateur);
	}

	@Override
	public Etablisement getEtablissementById(String id_etablissement) {
		Etablisement etablisement =em.find(Etablisement.class, id_etablissement);
		return etablisement;
	}

	@Override
	public List<DonEnNature> getDonEnNatureByDonnateur(String idD) {
		Query req = em.createQuery("select d from DonEnNature d where d.utilisateur.idut=:x");
		req.setParameter("x", idD);
		return req.getResultList();
	}

	@Override
	public List<Reglement> getReglementByDonnateur(String idD) {
		Query req = em.createQuery("select d from Reglement d where d.utilisateur.idut=:x");
		req.setParameter("x", idD);
		return req.getResultList();
	}

	@Override
	public void deleteDon(String idDon) {
		em.remove(em.find(Don.class, idDon));
		
	}
	@Override
	public void updateAdresse(Adresse a) {
		if(!a.equals(null))
			em.merge(a);
		
	}

	@Override
	public void updateTelephone(Telephone t) {
		if(!t.equals(null))
			em.merge(t);
		
	}

	@Override
	public List<Etablisement> getEtablissementsByGouvernorat(String gouvernorat) {
		Query req = em.createQuery("select e from Etablisement e where e.adresse.gouvernorat=:x");
		req.setParameter("x", gouvernorat);
		return req.getResultList();
	}
	@Override
	public List<Etablisement> getEtablissementsByGouvernorat(String gouvernorat, int current, int nbRecords) {
		int start = current * nbRecords - nbRecords;
		Boolean hospital = true;
		Query req = em.createQuery("select e from Etablisement e where e.hospital=:x and e.adresse.gouvernorat=:y");
		req.setParameter("x", hospital);
		req.setParameter("y", gouvernorat);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Etablisement> getIntermediaireByGouvernorat(String gouvernorat, int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Boolean intermediaire = true;
		Query req = em.createQuery("select e from Etablisement e where e.Intermediaire=:x and e.adresse.gouvernorat=:y");
		req.setParameter("x", intermediaire);
		req.setParameter("y", gouvernorat);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Besoin> getBesoinsByGouvernorat(String gouvernorat) {
		Query req = em.createQuery("select b from Besoin b where b.etablisement.adresse.gouvernorat=:x");
		req.setParameter("x", gouvernorat);
		return req.getResultList();
	}
	
	
	@Override
	public List<Utilisateur> getAllDonnateurs(){
		String role = "donateur";
		Query req = em.createQuery("SELECT u FROM Utilisateur u where u.role=:x");
		req.setParameter("x", role);
		return req.getResultList();
	}

	@Override
	public List<Utilisateur> getAllDonnateurs(int current, int nbRecords) {
		int start = current * nbRecords - nbRecords;
		String role = "donateur";
		Query req = em.createQuery("SELECT u FROM Utilisateur u where u.role=:x");
		req.setParameter("x", role);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	
	@Override
	public List<DonEnNature> getAllDonsEnNatureByGouvernorat(String gouvernorat) {
		Query req = em.createQuery("select d from DonEnNature d where d.etablissement.adresse.gouvernorat=:x");
		req.setParameter("x", gouvernorat);
		return req.getResultList();
	}

	@Override
	public List<Reglement> getAllDonsReglementsByGouvernorat(String gouvernorat) {
		Query req = em.createQuery("select d from Reglement d where d.etablissement.adresse.gouvernorat=:x");
		req.setParameter("x", gouvernorat);
		return req.getResultList();
	}

	@Override
	public List<DonEnNature> getAllDonsEnNatureByEtablissement(String idEtab) {
		Query req = em.createQuery("select d from DonEnNature d where d.etablissement.IdEtablissement=:x");
		req.setParameter("x", idEtab);
		return req.getResultList();
	}

	@Override
	public List<Reglement> getAllDonsReglementsByEtablissement(String idEtab) {
		Query req = em.createQuery("select d from Reglement d where d.etablissement.IdEtablissement=:x");
		req.setParameter("x", idEtab);
		return req.getResultList();
	}
	@Override
	public long getNumberOfRows(String type)
	{
        long numOfRows = 0;
        String reqString = "SELECT COUNT(*) FROM "+type;
        Query req = em.createQuery(reqString);
		numOfRows = (long) req.getSingleResult();
        return numOfRows;
	}
	@Override
	public long getNumberOfRowsDRS(String type)
	{
        long numOfRows = 0;
        String reqString = "SELECT COUNT(*) FROM "+type + " where drs=1";
        Query req = em.createQuery(reqString);
		numOfRows = (long) req.getSingleResult();
        return numOfRows;
	}
	@Override
	public long getNumberOfRowsIntermediaire(String type)
	{
        long numOfRows = 0;
        String reqString = "SELECT COUNT(*) FROM "+type + " where Intermediaire=1";
        Query req = em.createQuery(reqString);
		numOfRows = (long) req.getSingleResult();
        return numOfRows;
	}
	@Override
	public long getNumberOfRowsHopitaux(String type)
	{
        long numOfRows = 0;
        String reqString = "SELECT COUNT(*) FROM "+type + " where hospital=1";
        Query req = em.createQuery(reqString);
		numOfRows = (long) req.getSingleResult();
        return numOfRows;
	}
	
	@Override
	public long getNumberOfRowsDonateurs(String type)
	{
        long numOfRows = 0;
        String reqString = "SELECT COUNT(*) FROM "+type + " where role=:x";
        Query req = em.createQuery(reqString);
        req.setParameter("x", "donateur");
		numOfRows = (long) req.getSingleResult();
        return numOfRows;
	}

	@Override
	public Utilisateur getUtilisateurById(String userId) 
	{
		Utilisateur utilisateur = em.find(Utilisateur.class, userId);
		return utilisateur;
	}

	@Override
	public List<UniteDeMesure> getAllUniteDeMesure(int current, int nbRecords) {

		int start = current * nbRecords - nbRecords;
		return em.createNamedQuery("UniteDeMesure.findAll",UniteDeMesure.class).setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}

	@Override
	public List<Fournisseur> getAllFournisseur() {
		return em.createNamedQuery("Fournisseur.findAll",Fournisseur.class).getResultList();

	}

	@Override
	public List<Besoin> getAllBesoin(int current, int nbRecords, String order, String direction) {

		int start = current * nbRecords - nbRecords;
		String q ="";
//		return em.createNamedQuery("Besoin.findAll",Besoin.class).setFirstResult(start).setMaxResults(nbRecords).getResultList();
		if((order != null)&&(direction!=null))
			 q = "SELECT b FROM Besoin b ORDER BY "+order+" "+direction;
		else
			 q = "SELECT b FROM Besoin b ORDER BY b.dateBesoin desc";
		Query req = em.createQuery(q);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}

	@Override
	public List<Produit> getAllProduit() {
		return em.createNamedQuery("Produit.findAll",Produit.class).getResultList();

	}

	@Override
	public List<Categorie> getAllCategorie(int current, int nbRecords) {

		int start = current * nbRecords - nbRecords;
		return em.createNamedQuery("Categorie.findAll",Categorie.class).setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Besoin> getBesoinsByEtablissement(String idE, int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Query req= em.createQuery("select b from Besoin b where b.etablisement.IdEtablissement =:x");
    	req.setParameter("x", idE);
    	return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Besoin> getBesoinsByGouvernorat(String gouvernorat, int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Query req = em.createQuery("select b from Besoin b where b.etablisement.adresse.gouvernorat=:x");
		req.setParameter("x", gouvernorat);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Etablisement> getAllEtablissement(int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Query req = em.createQuery("select e from Etablisement e");
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Etablisement> getAllDrs(){
		Boolean drs = true;
		Query req = em.createQuery("select e from Etablisement e where e.drs=:x");
		req.setParameter("x", drs);
		return req.getResultList();
	}
	@Override
	public List<Etablisement> getAllDrs(int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Boolean drs = true;
		Query req = em.createQuery("select e from Etablisement e where e.drs=:x");
		req.setParameter("x", drs);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Etablisement> getAllHospital(){
		Boolean hospital = true;
		Query req = em.createQuery("select e from Etablisement e where e.hospital=:x");
		req.setParameter("x", hospital);
		return req.getResultList();
	}
	@Override
	public List<Etablisement> getAllHospital(int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Boolean hospital = true;
		Query req = em.createQuery("select e from Etablisement e where e.hospital=:x");
		req.setParameter("x", hospital);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}
	@Override
	public List<Etablisement> getAllIntermediaire(){
		Boolean hospital = true;
		Query req = em.createQuery("select e from Etablisement e where e.Intermediaire=:x");
		req.setParameter("x", hospital);
		return req.getResultList();
	}
	@Override
	public List<Etablisement> getAllIntermediaire(int current, int nbRecords){
		int start = current * nbRecords - nbRecords;
		Boolean intermediaire = true;
		Query req = em.createQuery("select e from Etablisement e where e.Intermediaire=:x");
		req.setParameter("x", intermediaire);
		return req.setFirstResult(start).setMaxResults(nbRecords).getResultList();
	}

	
	@Override
	public Utilisateur authentification_Utilisateur(String email) {
		try {
			Query tq = em.createQuery("select u from Utilisateur u WHERE email=? ", Utilisateur.class);
			tq.setParameter(1, email);
			Utilisateur utilisateur = (Utilisateur) tq.getSingleResult();
			em.merge(utilisateur);
			return utilisateur;
		} catch (Exception noresult) {
			return null;
		}
	}

	
	@Override
	public Utilisateur veriff(String mail) {
		try {
			Query tq = em.createQuery("select u from Utilisateur u WHERE u.email =:x", Utilisateur.class);
			tq.setParameter("x", mail);
			Utilisateur utilisateur = (Utilisateur) tq.getSingleResult();
			return utilisateur;
		} catch (Exception noresult) {
			return null;
		}
	}		
	
	@Override
	public Etablisement authentification_Etablissement(String nom) {
		try {
			Query tq = em.createQuery("select u from Etablisement u WHERE u.NomEtablissement=:x ", Etablisement.class);
			tq.setParameter("x", nom);
			Etablisement etablisement = (Etablisement) tq.getSingleResult();	
			return etablisement;
		} catch (Exception noresult) {
			return null;
		}
	}
	@Override
	public boolean veriff_nom_etablissement(String nom) {
		try {
			Query tq = em.createQuery("select u from Etablisement u WHERE u.NomEtablissement=?", Etablisement.class);
			tq.setParameter(1, nom);
			Etablisement etablisement = (Etablisement) tq.getSingleResult();
			return true;
		} catch (Exception noresult) {
			return false;
		}
	}
	
	@Override
	public Etablisement findMinistere() {
		String etablissement = "ministere";
		Query req=em.createQuery("select e from Etablisement e where e.libelle =:x");
		req.setParameter("x", etablissement);
		return (Etablisement) req.getSingleResult();
	}
}