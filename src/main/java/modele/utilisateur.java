package modele;

public class utilisateur {
	private String login;
	private String password;
	


	public utilisateur(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public utilisateur() {
	}


	public String getLogin() {
		return login;
	}
	

	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean verif() {
		if ((this.login.equals("admin")) && (this.password.equals("admin"))){
			return true;
			
		}else {
			return false;
		}
	}

}
