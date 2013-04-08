package core;

import java.util.Vector;

import base.Descripteur;

public class Successeur {
	private Noeud destination;
	private Descripteur description;
	private int numZone;
	private short longArete;
	private short nbSegments;
	Vector<Segment> segments;

	public Successeur() {
		destination = new Noeud();
		numZone = 0;
		longArete = 0;
		nbSegments = 0;
		segments = new Vector<Segment>();
	}
	
	public Successeur(Noeud n){ 
		destination= n;
		numZone = 0;
		longArete = 0;
		nbSegments = 0;
		segments = new Vector<Segment>();	
	}
	
	public Successeur(Noeud n,Descripteur d, int numZone, short longArete, short nbSegments){
		destination= n;
		description = d;
		this.numZone = numZone;
		this.longArete = longArete;
		this.nbSegments = nbSegments;
		segments = new Vector<Segment>();	
	}
	
	public boolean getSuccesseurByNode(Noeud n)
	{
		if(n == destination) {
			return true;
		}
		return false;
	}
	
	public short getLongArete() {
		return longArete;
	}
	
	public int getVitesseMax() {
		return description.vitesseMax();
	}
	
	public void addSegment(Segment s) {
		segments.add(s);
	}

}
