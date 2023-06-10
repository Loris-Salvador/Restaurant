package Model;


import java.io.Serializable;
import java.util.Objects;

public class Plat extends MenuItem implements Serializable {
    private Categorie categorie;

    public Plat(Categorie categorie, double prix, String nom) {
        super(prix, nom);
        this.categorie = categorie;
    }

    public Plat(){
        this(Categorie.PLAT, 0, "pas de nom" );
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return Double.compare(plat.getPrix(), getPrix()) == 0 && categorie == plat.categorie && Objects.equals(plat.getNom(), getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorie, getPrix(), getNom());
    }

    @Override
    public String toString() {
        return "Plat{" +
                "categorie=" + categorie +
                ", prix=" + getPrix() + "€" +
                ", nom='" + getNom() + '\'' +
                '}';
    }

    /*public static void main(String[] args) {
        Plat M1 = new Plat();

        System.out.println(M1.toString());

        M1.setNom("Liegeois");
        M1.setPrix(6.50);
        M1.setCategorie(Categorie.BOISSON);

        System.out.println("Après modification:");
        System.out.println(M1.toString());

        System.out.println("\nItem 2:");
        Plat M2 = new Plat(Categorie.PLAT, 10.20, "Margharita");
        System.out.println(M2.toString()+"\n");

        M1 = new Plat(Categorie.PLAT, 10.20, "Margharita"); System.out.println("M1 = M2");
        System.out.println(M1.toString());

        if(M1.equals(M2))
            System.out.println("C'est égale");
        else
            System.out.println("Différent");
    }*/
}
