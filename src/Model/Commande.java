package Model;

import java.util.ArrayList;

public class Commande {
    private int NumeroTable;
    private int NumeroCommande;
    private Statut statut;
    private ArrayList<MenuItem> ListeItem;


    public Commande()
    {
        this.NumeroCommande = -1;
        this.NumeroTable = -1;
        this.statut = Statut.EnPreparation;

        this.ListeItem = new ArrayList<MenuItem>();
    }

    public ArrayList<MenuItem> getListeItem() {
        return ListeItem;
    }
    public void setListeItem(ArrayList<MenuItem> listeItem) {
        ListeItem = listeItem;
    }


    public int getNumeroCommande() {
        return NumeroCommande;
    }
    public void setNumeroCommande(int numeroCommande) {
        NumeroCommande = numeroCommande;
    }

    public int getNumeroTable() {
        return NumeroTable;
    }
    public void setNumeroTable(int numeroTable) {
        NumeroTable = numeroTable;
    }

    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void AjouterItem(MenuItem Item)
    {
        getListeItem().add(Item);
    }

    @Override
    public String toString() {
//        return "Commande{" +
//                "NumeroTable=" + NumeroTable +
//                ", NumeroCommande=" + NumeroCommande +
//                ", statut=" + statut +
//                ", ListeItem=" + ListeItem +
//                '}';
        return "test Commande";
    }
}
