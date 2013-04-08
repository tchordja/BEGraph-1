package core;

import java.util.Vector;

import base.Descripteur;

public class Noeud {
	public int index;
	private float latitude;
	private float longitude;
	private byte nbSuccesseur;
	private Vector<Successeur> successeurs = new Vector<Successeur>();
	
	public Noeud() {
		latitude = 0;
		longitude = 0;
		nbSuccesseur = 0;
		
	}
	
	public Noeud(int num_node,float lat, float lon, byte nb) {
		this.latitude = lat;
		this.longitude = lon;
		this.nbSuccesseur = nb;
		this.index = num_node; 
		
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public byte getNbSuccesseur() {
		return nbSuccesseur;
	}
	
	public boolean addSuccesseur(Noeud n,Descripteur d, int numZone, short longArete, short nbSegments){
		successeurs.add(new Successeur(n,d,numZone,longArete,nbSegments));
		return true;
	}
	
	
	
	public Successeur getLastSuccesseur() {
		return successeurs.lastElement();
	}
	
	public int getSizeSuccesseurs(){
		return successeurs.size();
	}
	
	public Vector<Successeur> getSuccesseurs() {
		return successeurs;
	}
	
}
