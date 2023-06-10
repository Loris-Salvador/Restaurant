package Model;


import java.util.Objects;

public abstract class MenuItem {
    private double prix;
    private String nom;

    public MenuItem(double prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    public MenuItem(){
        this(0, "pas de nom" );
    }

    public double getPrix() {
        return prix;
    }


    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.prix, prix) == 0 && Objects.equals(nom, menuItem.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prix, nom);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                ", prix=" + prix + "€" +
                ", nom='" + nom + '\'' +
                '}';
    }

    /*public static void main(String[] args) {
        MenuItem M1 = new MenuItem();

        System.out.println(M1.toString());

        M1.setNom("Liegeois");
        M1.setPrix(6.50);
        M1.setCategorie(Categorie.BOISSON);

        System.out.println("Après modification:");
        System.out.println(M1.toString());

        System.out.println("\nItem 2:");
        MenuItem M2 = new MenuItem(Categorie.PLAT, 10.20, "Margharita");
        System.out.println(M2.toString()+"\n");

        M1 = new MenuItem(Categorie.PLAT, 10.20, "Margharita"); System.out.println("M1 = M2");
        System.out.println(M1.toString());

        if(M1.equals(M2))
            System.out.println("C'est égale");
        else
            System.out.println("Différent");
    }*/
}
