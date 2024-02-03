package Dao;

import java.util.List;

import modele.produit;

public interface IProduitDao {
	public produit save(produit p);
	public List<produit> getAllProduits();
	public List<produit> getProduit(String id);
	public produit updateProduit(produit p);
	public void deleteProduit(String id);
}
