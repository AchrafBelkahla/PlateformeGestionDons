package metier.session;

import java.util.List;

import javax.ejb.Local;

import metier.entities.*;

@Local
public interface PlatformGDLocal {

	public void Faire_Un_Don(Don don, PhotoDon photo, Utilisateur donnateur, Etablisement beneficiaire);

	public List<DonEnNature> getAllDonsEnNature();
	public List<Reglement> getAllDonsReglement();
	public List<DonEnNature> getDonEnNatureByDonnateur(String idD);
	public List<Reglement> getReglementByDonnateur(String idD);
	public List<Don> getDonByEtablissement(String nom_etabliessement);
	public List<Don> getDonByDonnateur(String mail_donnateur);
	public List<Don> getDonEnNatureNotAcceptedByMinistere();
	public List<Don> getDonReglementNotAcceptedByMinistere();
	public List<Don> getDonEnNatureDeletedByMinistere();
	public List<Don> getDonReglementDeletedByMinistere();
	public List<Etablisement> getEtablissementsByGouvernorat(String gouvernorat);
	public List<Besoin> getBesoinsByGouvernorat(String gouvernorat);
	
	public List<DonEnNature> getAllDonsEnNatureByGouvernorat(String gouvernorat);
	public List<Reglement> getAllDonsReglementsByGouvernorat(String gouvernorat);
	public List<DonEnNature> getAllDonsEnNatureByEtablissement(String idEtab);
	public List<Reglement> getAllDonsReglementsByEtablissement(String idEtab);

	
	public DonEnNature getDonEnNatureById(String id_don);
	public Reglement getDonEnReglementById(String id_don);
	public void ajouterDonEnNature(DonEnNature don_en_nature);
	public void ajouterDonReglement(Reglement reglement);
	public void updateDonEnNature(DonEnNature don_en_nature);
	public void updateReglement(Reglement reglement);
	
	
	public void ajouterPhotoDon(String url_photo, String id_don);
	public void deletePhotoDon(String id_photo);
	public void updatePhotoDon(PhotoDon photo_don);
	
	
	public List<PhotoDon> getAllPhotoDon();
	public List<PhotoDon> getAllPhotoDonById(String id_don);


	public String getNomEtablissementById(String id_etablissement);
	public Etablisement getEtablissementById(String id_etablissement);
	public Utilisateur getUtilisateurById(String userId);

	// create
	public void ajoutBesoin(Besoin b);
	public void ajoutProduit(Produit p);
	public void ajoutCategorie(Categorie c);
	public void ajoutPhotoBesoin(PhotoBesoin pB);
	public void ajoutUniteDeMesure(UniteDeMesure uM);
	public void ajoutFournisseur(Fournisseur f);
	public void ajoutPhoto(Photo ph);

	//delete
	
	public void deleteBesoin(Besoin b);
	public void deleteProduit(Produit p);
	public void deleteCategorie(Categorie c);
	public void deletePhotoBesoin(PhotoBesoin pB);
	public void deleteUniteDeMesure(UniteDeMesure uM);
	public void deleteFournisseur(Fournisseur f);
	public void deletePhoto(Photo ph);
	public void deleteDon(String idDon);
	
	//update
	
	public void updateBesoin(Besoin b);
	public void updateProduit(Produit p);
	public void updateCategorie(Categorie c);
	public void updatePhotoBesoin(PhotoBesoin pB);
	public void updateUniteDeMesure(UniteDeMesure uM);
	public void updateFournisseur(Fournisseur f);
	public void updateEtablisement(Etablisement e);
	public void updateAdresse(Adresse a);
	public void updateTelephone(Telephone t);
	
	//read
	
	public long getNumberOfRows(String type);
	public Produit getProduitById(String idP);
	public UniteDeMesure getUniteDeMesureById(String idU);
	public Categorie getCategorieById(String idC);
	public Besoin getBesoinById(String idB);
	public Fournisseur getFournisseurById(String idF);
	public PhotoBesoin getPhotoBesoinById(String idPb);
	
	public List<Besoin> getAllBesoin();
	public List<Produit> getAllProduit(int current, int nbRecords);
	public List<Produit> getAllProduit();
	public List<Categorie> getAllCategorie();
	public List<PhotoBesoin> getAllPhotoBesoin();
	public List<UniteDeMesure> getAllUniteDeMesure();
	public List<Fournisseur> getAllFournisseur(int current, int nbRecords);
	public List<Fournisseur> getAllFournisseur();
	
	public List<Produit> getProduitByCategorie(String idc);
	public List<Produit> getProduitByFounisseur(String idF);
	public List<Fournisseur> getFournisseurByProduit(String idP);
	public List<Besoin> getBesoinsByEtablissement(String idE);
	
	
	// l'ajout
		public void ajouteUtilisateur(Utilisateur utilisateur);
		//public String ajouteUtilisateur(Utilisateur utilisateur);
		//public String ajouteadresse(Adresse adresse);
		public void ajouteadresse(Adresse adresse);
		//public void ajouteadresseEtablissement(List<Adresse> liste_adresses);
		//public void ajouteadresseEtablissement(String l1 ,String l2 ,String l3 ,String l4, String l5 );
		public void ajouteetablissement(Etablisement etablisement);
		//public String ajouteetablissement(Etablisement etablisement);
		public String ajoutereclamation(Reclamation reclamation);
		public void ajoutetelephone(Telephone telephone);
		//public String ajoutetelephone(Telephone telephone);
		public void ajout_ut_tel(String l1, String l2, String l3);
		//public Utilisateur getUtilisateurByEmail(String email );
		public Etablisement verification_du_compte(Utilisateur utilisateur);
		public Utilisateur authentification(String mail, String hashedPassword);
		public Utilisateur veriff(String mail);

		// delete
		
		public void deleteUtilisateur(Utilisateur utilisateur);
		public void deleteadresse(Adresse adresse);
		public void deleteetablissement(Etablisement etablisement);
		public void deletereclamation(Reclamation reclamation);
		public void deletetelephone(Telephone telephone);
		
		// affichage 
		
		public Utilisateur findUtilisateurById(String idut);
		public Adresse findadresse(String idAdresse);
		public Etablisement findetablissement(String idetablisement);
		public Reclamation findreclamation(String codeReclamation);
		public Telephone findtelephone(String idTel);
		public Utilisateur getDonnateurByEtablissement(String id_Etablissemment);
		
		//Get
		
		public List<Utilisateur> getUtilisateur();
		public List<Etablisement> getAllBeneficiaire();
		public List<Etablisement> getAllEtablissement();
		public List<Reclamation> getreclamation();
		
		//update

		public void updateReclamatiom(boolean codeReclamation, Reclamation reclamation);
		public void updateetatDecompte(Boolean etatDecompte, Utilisateur utilisateur);
		public void updateUtilisateur(Utilisateur utilisateur);

		



}