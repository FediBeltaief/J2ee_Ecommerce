	package modele;
	
	public class produit {
		private String id;
		private String nom;
		private float prix;
		private String four;
		private String description;
		private String img;
		

		public produit(String id, String nom, float prix, String four, String description, String img) {
			super();
			this.id = id;
			this.nom = nom;
			this.prix = prix;
			this.four = four;
			this.description = description;
			this.img = img;
		}
		
		public produit() {
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public float getPrix() {
			return prix;
		}
		public void setPrix(float prix) {
			this.prix = prix;
		}
		public String getFour() {
			return four;
		}
		public void setFour(String four) {
			this.four = four;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		@Override
		public String toString() {
			return "produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", four=" + four + "]";
		}
		 
	
	}
	
