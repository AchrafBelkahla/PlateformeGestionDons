package service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.*;
import java.util.List;
import metier.session.PlatformGDLocal;

@Stateless
public class PlatformGDService {
	
	@EJB
	private PlatformGDLocal metier;
	
	public Etablisement findetablissement(String idetablisement) {
		return metier.findetablissement(idetablisement);
	}
	public void ajoutBesoin(Besoin b) {
		metier.ajoutBesoin(b);
	}
	public void ajoutProduit(Produit p) {
		metier.ajoutProduit(p);
	}
	public void ajoutCategorie(Categorie c) {
		metier.ajoutCategorie(c);
	}
	public void ajoutPhotoBesoin(PhotoBesoin pB) {
		metier.ajoutPhotoBesoin(pB);
	}
	public void ajoutUniteDeMesure(UniteDeMesure uM) {
		metier.ajoutUniteDeMesure(uM);
	}
	public void ajoutFournisseur(Fournisseur f) {
		metier.ajoutFournisseur(f);
	}
	public void ajoutPhoto(Photo ph) {
		metier.ajoutPhoto(ph);
	}
	public void deleteBesoin(Besoin b) {
		metier.deleteBesoin(b);
	}
	public void deleteProduit(Produit p) {
		metier.deleteProduit(p);
	}
	public void deleteCategorie(Categorie c) {
		metier.deleteCategorie(c);
	}
	public void deletePhotoBesoin(PhotoBesoin pB) {
		metier.deletePhotoBesoin(pB);
	}
	public void deleteUniteDeMesure(UniteDeMesure uM) {
		metier.deleteUniteDeMesure(uM);
	}
	public void deleteFournisseur(Fournisseur f) {
		metier.deleteFournisseur(f);
	}
	public void deletePhoto(Photo ph) {
		metier.deletePhoto(ph);
	}
	public void updateBesoin(Besoin b) {
		metier.updateBesoin(b);
	}
	public void updateProduit(Produit p) {
		metier.updateProduit(p);
	}
	public void updateCategorie(Categorie c) {
		metier.updateCategorie(c);
	}
	public void updatePhotoBesoin(PhotoBesoin pB) {
		metier.updatePhotoBesoin(pB);
	}
	public void updateUniteDeMesure(UniteDeMesure uM) {
		metier.updateUniteDeMesure(uM);
	}
	public void updateFournisseur(Fournisseur f) {
		metier.updateFournisseur(f);
	}
	public Produit getProduitById(String idP) {
		return metier.getProduitById(idP);
	}
	public UniteDeMesure getUniteDeMesureById(String idU) {
		return metier.getUniteDeMesureById(idU);
	}
	public Categorie getCategorieById(String idC) {
		return metier.getCategorieById(idC);
	}
	public Besoin getBesoinById(String idB) {
		return metier.getBesoinById(idB);
	}
	public Fournisseur getFournisseurById(String idF) {
		return metier.getFournisseurById(idF);
	}
	public List<Produit> getAllProduit() {
		return metier.getAllProduit();
	}
	public List<Categorie> getAllCategorie() {
		return metier.getAllCategorie();
	}
	public List<PhotoBesoin> getAllPhotoBesoin() {
		return metier.getAllPhotoBesoin();
	}
	public List<UniteDeMesure> getAllUniteDeMesure() {
		return metier.getAllUniteDeMesure();
	}
	public List<Fournisseur> getAllFournisseur() {
		return metier.getAllFournisseur();
	}
	public List<Produit> getProduitByCategorie(String idc) {
		return metier.getProduitByCategorie(idc);
	}
	public List<Produit> getProduitByFounisseur(String idF) {
		return metier.getProduitByFounisseur(idF);
	}
	public List<Fournisseur> getFournisseurByProduit(String idP) {
		return metier.getFournisseurByProduit(idP);
	}
	public DonEnNature getDonEnNatureById(String id_don) {
		return metier.getDonEnNatureById(id_don);
	}
	public Reglement getDonEnReglementById(String id_don) {
		return metier.getDonEnReglementById(id_don);
	}
	public String getNomEtablissementById(String id_etablissement) {
		return metier.getNomEtablissementById(id_etablissement);
	}
	public List<Reglement> getAllDonsReglement() {
		return metier.getAllDonsReglement();
	}
	public List<Don> getDonEnNatureNotAcceptedByMinistere() {
		return metier.getDonEnNatureNotAcceptedByMinistere();
	}
	public List<Don> getDonReglementNotAcceptedByMinistere() {
		return metier.getDonReglementNotAcceptedByMinistere();
	}
	public List<Don> getDonEnNatureDeletedByMinistere() {
		return metier.getDonEnNatureDeletedByMinistere();
	}
	public List<Don> getDonReglementDeletedByMinistere() {
		return metier.getDonReglementDeletedByMinistere();
	}
	public List<Besoin> getAllBesoin() {
		return metier.getAllBesoin();
	}
	public void updateDonEnNature(DonEnNature don_en_nature) {
		metier.updateDonEnNature(don_en_nature);
	}
	public void updateReglement(Reglement reglement) {
		metier.updateReglement(reglement);
	}
	public void deletePhotoDon(String id_photo) {
		metier.deletePhotoDon(id_photo);
	}
	public void updatePhotoDon(PhotoDon photo_don) {
		metier.updatePhotoDon(photo_don);
	}
	public void ajouterDonEnNature(DonEnNature don_en_nature) {
		metier.ajouterDonEnNature(don_en_nature);
	}
	public void ajouterDonReglement(Reglement reglement) {
		metier.ajouterDonReglement(reglement);
	}
	@WebMethod
	public void Faire_Un_Don(Don don, PhotoDon photo, Utilisateur donnateur, Etablisement beneficiaire) {
		metier.Faire_Un_Don(don, photo, donnateur, beneficiaire);
	}
	@WebMethod
	public List<DonEnNature> getAllDonsEnNature() {
		return metier.getAllDonsEnNature();
	}
	@WebMethod
	public List<Don> getDonByEtablissement(String nom_etabliessement) {
		return metier.getDonByEtablissement(nom_etabliessement);
	}
	@WebMethod
	public List<Don> getDonByDonnateur(String mail_donnateur) {
		return metier.getDonByDonnateur(mail_donnateur);
	}
	@WebMethod
	public List<PhotoDon> getAllPhotoDon() {
		return metier.getAllPhotoDon();
	}
	@WebMethod
	public List<PhotoDon> getAllPhotoDonById(String id_don) {
		return metier.getAllPhotoDonById(id_don);
	}
	@WebMethod
	public void ajouterPhotoDon(String url_photo, String id_don) {
		metier.ajouterPhotoDon(url_photo, id_don);
	}
}
