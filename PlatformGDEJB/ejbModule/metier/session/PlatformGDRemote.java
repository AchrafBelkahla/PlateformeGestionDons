package metier.session;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.*;
@Remote
public interface PlatformGDRemote {
	public void Faire_Un_Don(Don don, PhotoDon photo, Utilisateur donnateur, Etablisement beneficiaire);
	
	public List<DonEnNature> getAllDonsEnNature();
	//public List<DonEnNature> getAllDonsEnNature(int current, int nbRecords);
	public List<Reglement> getAllDonsReglement();
	//public List<Reglement> getAllDonsReglement(int current, int nbRecords);
	public List<DonEnNature> getDonEnNatureByDonnateur(String idD);
	public List<Reglement> getReglementByDonnateur(String idD);
	public List<Don> getDonByEtablissement(String nom_etabliessement);
	//public List<Don> getDonByEtablissement(String nom_etabliessement, int current, int nbRecords);
	public List<Don> getDonByDonnateur(String mail_donnateur);
	//public List<DonEnNature> getDonByDonnateur(String mail_donnateur, int current, int nbRecords);
	public List<Don> getDonEnNatureNotAcceptedByMinistere();
	public List<Don> getDonReglementNotAcceptedByMinistere();
	public List<Don> getDonEnNatureDeletedByMinistere();
	public List<Don> getDonReglementDeletedByMinistere();
	public List<Etablisement> getEtablissementsByGouvernorat(String gouvernorat);
	public List<Etablisement> getEtablissementsByGouvernorat(String gouvernorat, int current, int nbRecords);
	public List<Besoin> getBesoinsByGouvernorat(String gouvernorat);
	public List<Besoin> getBesoinsByGouvernorat(String gouvernorat, int current, int nbRecords);
	public List<DonEnNature> getAllDonsEnNatureByGouvernorat(String gouvernorat);
	//public List<DonEnNature> getAllDonsEnNatureByGouvernorat(String gouvernorat, int current, int nbRecords);
	public List<Reglement> getAllDonsReglementsByGouvernorat(String gouvernorat);
	//public List<DonEnNature> getAllDonsReglementsByGouvernorat(String gouvernorat, int current, int nbRecords);
	public List<DonEnNature> getAllDonsEnNatureByEtablissement(String idEtab);
	//public List<DonEnNature> getAllDonsEnNatureByEtablissement(String idEtab, int current, int nbRecords);
	public List<Reglement> getAllDonsReglementsByEtablissement(String idEtab);
	//public List<DonEnNature> getAllDonsReglementsByEtablissement(String idEtab, int current, int nbRecords);

	
	
	public DonEnNature getDonEnNatureById(String id_don);
	public Reglement getDonEnReglementById(String id_don);
	public void ajouterDonEnNature(DonEnNature don_en_nature);
	public void ajouterDonReglement(Reglement reglement);
	public void updateDonEnNature(DonEnNature don_en_nature);
	public void updateReglement(Reglement reglement);
	public void ajouterPhotoDon(String url_photo, String id_don);
	public void deletePhotoDon(String id_photo);
	public void updatePhotoDon(PhotoDon photo_don);
	
	public void updateTelephone(Telephone t);
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
		
		//update
		
		public void updateBesoin(Besoin b);
		public void updateProduit(Produit p);
		public void updateCategorie(Categorie c);
		public void updatePhotoBesoin(PhotoBesoin pB);
		public void updateUniteDeMesure(UniteDeMesure uM);
		public void updateFournisseur(Fournisseur f);
		public void updateEtablisement(Etablisement e);
		public void updateAdresse(Adresse a);

		//read
		
		public Produit getProduitById(String idP);
		public UniteDeMesure getUniteDeMesureById(String idU);
		public Categorie getCategorieById(String idC);
		public Besoin getBesoinById(String idB);
		public Fournisseur getFournisseurById(String idF);
		public PhotoBesoin getPhotoBesoinById(String idPb);


	public void deleteDon(String idDon);
	

	

	
	//read
	
	public long getNumberOfRows(String type);
	public long getNumberOfRowsHopitaux(String type);
	public long getNumberOfRowsIntermediaire(String type);
	public long getNumberOfRowsDRS(String type);
	
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

		
		public List<Besoin> getAllBesoin(int current, int nbRecords);

		public List<Categorie> getAllCategorie(int current, int nbRecords);

		public List<UniteDeMesure> getAllUniteDeMesure(int current, int nbRecords);

		

		public List<Besoin> getBesoinsByEtablissement(String idE, int current, int nbRecords);
		
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
		public List<Etablisement> getAllEtablissement(int current, int nbRecords);
		public List<Etablisement> getAllDrs();
		public List<Etablisement> getAllDrs(int current, int nbRecords);
		public List<Etablisement> getAllHospital();
		public List<Etablisement> getAllHospital(int current, int nbRecords);
		public List<Reclamation> getreclamation();

		public List<Etablisement> getAllIntermediaire();
		public List<Etablisement> getAllIntermediaire(int current, int nbRecords);
		
		//update

		public void updateReclamatiom(boolean codeReclamation, Reclamation reclamation);
		public void updateetatDecompte(Boolean etatDecompte, Utilisateur utilisateur);
		public void updateUtilisateur(Utilisateur utilisateur);

		public Etablisement authentification_Etablissement(String nom);
		public boolean veriff_nom_etablissement(String nom);
		public Utilisateur authentification_Utilisateur(String email);

		public List<Etablisement> getIntermediaireByGouvernorat(String gouvernorat, int current, int nbRecords);
		public List<Utilisateur> getAllDonnateurs();
}