package Dao;

import java.util.List;

import modele.utilisateur;

public interface IUtilisateurDao {
	public utilisateur add(utilisateur u);
	public utilisateur update(utilisateur u);
	public boolean exist(utilisateur u);
	public List<utilisateur> getUsers(String s);
	
}
