package core;

import java.util.Vector;

public class Chemin {

	private int magic;
	private int version;
	private int numCarte;
	private int nombreNoeuds;
	private Noeud premierNoeud;
	private Noeud dernierNoeud;
	private int numPremiereZone;
	private int numDerniereZone;
	
	private Vector<Noeud> noeudsChemin = new Vector<Noeud>();
	
	public Chemin(int magic, int version, int numCarte, int nombreNoeuds, Noeud premierNoeud, Noeud dernierNoeud, int premiereZone, int derniereZone){
		this.magic=magic;
		this.version=version;
		this.numCarte=numCarte;
		this.nombreNoeuds=nombreNoeuds;
		this.premierNoeud=premierNoeud;
		this.dernierNoeud=dernierNoeud;
		this.numPremiereZone=premiereZone;
		this.numDerniereZone=derniereZone;
		//noeudsChemin.add(premierNoeud);
	}
	
	public void addNoeud(Noeud n)
	{
		System.out.println("Add Noeud "+n.index);
		noeudsChemin.add(n);
	}
	
	public double getCoutCheminTemps(){
		double temps = 0;
		double tempsArete=0;
		Vector<Successeur> liste = new Vector<Successeur>();
		for(int i=0; i<noeudsChemin.size()-1; i++)
		{
			Noeud position=noeudsChemin.get(i);
			System.out.println("Noeud Depart "+position.index);
			Noeud suivant=noeudsChemin.get(i+1);
			System.out.println("Noeud Arrivee "+suivant.index);
			for (int j=0;j<position.getSizeSuccesseurs();j++){
				Successeur iter = position.getSuccesseurs().get(j);
				System.out.println("bidon");
				if(iter.getSuccesseurByNode(suivant)) {					
					liste.add(iter);
					System.out.println("bidondon");
				}				
			}
			tempsArete=(double)(liste.get(0).getLongArete()*0.001*60)/(liste.get(0).getVitesseMax());
			for (int h=0 ; h<liste.size();h++)
			{
				double t=(double)(liste.get(h).getLongArete()*0.001*60)/(liste.get(h).getVitesseMax());
				if(t<tempsArete) {
					tempsArete=t;
				}
			}
			temps+=tempsArete;
			liste.clear();
		}
		return temps;
	}
	
	public Vector<Noeud> getNoeudsChemin() {
		return noeudsChemin;
	}
}
