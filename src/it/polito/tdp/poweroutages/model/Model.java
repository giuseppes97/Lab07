package it.polito.tdp.poweroutages.model;

import java.util.*;


import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {
   private int ANNO_INIZIALE=2000;
	PowerOutageDAO podao;
	List<Blackout> soluzionebest=new ArrayList<Blackout>();
	List<Blackout> temporanea=new ArrayList<Blackout>();
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	public List<Blackout> getWorst(int idnerc,int maxore,int maxanni){
		
		List<Blackout> listab=new ArrayList<Blackout>();
		List<Blackout> listatotale=podao.gettuttiblackout(idnerc);
		this.ricorsione(idnerc,maxore,maxanni,0,listab,listatotale);
		return listab;
	}

	private List<Blackout> ricorsione(int idnerc, int maxore, int maxanni,int livello,List<Blackout> parziale,List<Blackout> totale) {
		if(livello==maxanni)
		{   System.out.println("ciao");
			return parziale;
		}
		
		for(Blackout b:totale)
		{
			parziale.add(b);
			this.ricorsione(idnerc, maxore, maxanni, livello+1, parziale, totale);
			parziale.remove(parziale.size()-1);
		}
		
		return null;
	}
	

}
