package mapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorHandler {

	private static final int NBIMPORTANT = 57;
	final List<List<String>> listAuthors = new ArrayList<List<String>>();
	final List<List<String>> listeA = new ArrayList<List<String>>();
	final List<List<String>> listeB = new ArrayList<List<String>>();
	final List<List<String>> listeC = new ArrayList<List<String>>();
	final List<List<String>> listeD = new ArrayList<List<String>>();
	final List<List<String>> listeE = new ArrayList<List<String>>();
	final List<List<String>> listeF = new ArrayList<List<String>>();
	final List<List<String>> listeG = new ArrayList<List<String>>();
	final List<List<String>> listeH = new ArrayList<List<String>>();
	final List<List<String>> listeI = new ArrayList<List<String>>();
	final List<List<String>> listeJ = new ArrayList<List<String>>();
	final List<List<String>> listeK = new ArrayList<List<String>>();
	final List<List<String>> listeL = new ArrayList<List<String>>();
	final List<List<String>> listeM = new ArrayList<List<String>>();
	final List<List<String>> listeN = new ArrayList<List<String>>();
	final List<List<String>> listeO = new ArrayList<List<String>>();
	final List<List<String>> listeP = new ArrayList<List<String>>();
	final List<List<String>> listeQ = new ArrayList<List<String>>();
	final List<List<String>> listeR = new ArrayList<List<String>>();
	final List<List<String>> listeS = new ArrayList<List<String>>();
	final List<List<String>> listeT = new ArrayList<List<String>>();
	final List<List<String>> listeU = new ArrayList<List<String>>();
	final List<List<String>> listeV = new ArrayList<List<String>>();
	final List<List<String>> listeW = new ArrayList<List<String>>();
	final List<List<String>> listeX = new ArrayList<List<String>>();
	final List<List<String>> listeY = new ArrayList<List<String>>();
	final List<List<String>> listeZ = new ArrayList<List<String>>();
	final List<List<String>> listeAccent = new ArrayList<List<String>>();
	
	final List<Integer> listeIndiceOrdonnee = new ArrayList<>();

	final List<String> listeIndice = new ArrayList<>();

	final List<Integer> listeIndiceTemp = new ArrayList<>();

	public AuthorHandler() {
		listeIndice.add("Gilles Audemard");
		listeIndice.add("Sihem Belabbes");
		listeIndice.add("Salem Benferhat");
		listeIndice.add("Yazid Boumarafi");
		listeIndice.add("Zied Bouraoui");
		listeIndice.add("Frédéric Boussemart");
		listeIndice.add("Anasse Chafik");
		listeIndice.add("Fahima Cheik-Alili");
		listeIndice.add("Nathalie Chetcuti-Sperandio");
		listeIndice.add("François Chevalier");
		listeIndice.add("Assef Chmeiss");
		listeIndice.add("Jean-François Condotta");
		listeIndice.add("Sylvie Coste-Marquis");
		listeIndice.add("Cyrulle D'halluin");
		listeIndice.add("Virginie Delahaye");
		listeIndice.add("Tiago de Lima");
		listeIndice.add("Fabien Delorme");
		listeIndice.add("Vincent Dubois");
		listeIndice.add("Anis Gargouri");
		listeIndice.add("Gaël Glorian");
		listeIndice.add("Alux Goudyme");
		listeIndice.add("Éric Grégoire");
		listeIndice.add("Marwa Harzi");
		listeIndice.add("Fred Hemery");
		listeIndice.add("Yacine Izza");
		listeIndice.add("Saïd Jabbour");
		listeIndice.add("Sébastien Konieczny");
		listeIndice.add("Frédéric Koriche");
		listeIndice.add("Jean-Marie Lagniez");
		listeIndice.add("Daniel Le Berre");
		listeIndice.add("Christophe Lecoutre");
		listeIndice.add("Emmanuel Lonca");
		listeIndice.add("Jerry Loniac Konlac");
		listeIndice.add("Fatima Ezzahra Mana");
		listeIndice.add("Pierre Marquis");
		listeIndice.add("Bertrand Mazure");
		listeIndice.add("Stefan Mengel");
		listeIndice.add("Mensi Ali");
		listeIndice.add("Mhadhbi Nizar");
		listeIndice.add("Ikram Nekkache");
		listeIndice.add("Imen Ouled Dlala");
		listeIndice.add("Anastasia Paparrizou");
		listeIndice.add("Anne Parrain");
		listeIndice.add("Cédric Piette");
		listeIndice.add("Frédéric Renard");
		listeIndice.add("Olivier Roussel");
		listeIndice.add("Lakhdar Saïs");
		listeIndice.add("Sandrine Saitzek");
		listeIndice.add("Yakoub Salhi");
		listeIndice.add("Mouny Samy Modeliar");
		listeIndice.add("Nicolas Szczepanski");
		listeIndice.add("Sébastien Tabary");
		listeIndice.add("Karim Tabia");
		listeIndice.add("Ivan Varzinczak");
		listeIndice.add("Srdjan Vesic");
		listeIndice.add("Romain Wallon");
		listeIndice.add("Hugues Wattez");
	}

	private int getIndice(String author) {
		for (int i = 0; i < listeIndice.size(); i++)
			if (listeIndice.get(i).equals(author))
				return i;
		return listeIndice.size();
	}

	public List<String> getListe(int indice) {
		if (indice < listAuthors.size())
			return listAuthors.get(indice);
		return null;
	}

	public String getFirstAuthor(int indice) {
		if (indice < listAuthors.size())
			return listAuthors.get(indice).get(0);
		else
			return null;
	}

	public void erase() {
		listeIndiceTemp.clear();
	}

	private void addCoAuthor(String author, int indice) {
		int inc = 0;
		int indiceLu = 0;
		/// indice : l'indice de l'auteur qu'on rajoute et author son nom
		while (inc < listeIndiceTemp.size()) /// on parcoure tous les auteurs du paper
		{
			indiceLu = listeIndiceTemp.get(inc);
			if (!listAuthors.get(indiceLu).contains(author)) {
				// on ajoute à chacun des auteurs de la liste temporaire le nouvel auteur
				listAuthors.get(indiceLu).add(author);
				// on ajoute à cet auteur tous les auteurs de la liste
				listAuthors.get(indice).add(listAuthors.get(indiceLu).get(0));
			}
			inc++;
		}
		listeIndiceTemp.add(indice);
	}

	public void addAuthor(String author) {
		boolean trouve = false;
		int inc = 0;
		//int inc = getIndice(author);
		if (inc == listeIndice.size()) /// si l'auteur n'était pas encore dans la bdd
		{
			listeIndice.add(author);
			//tri(inc, author);
			listAuthors.add(new ArrayList<String>());
			listAuthors.get(inc).add(author);
		}
		addCoAuthor(author, inc);
	}

	private void tri(int inc, String author) {
		if (listeIndiceOrdonnee.size() == NBIMPORTANT) {
			listeIndiceOrdonnee.add(inc);
			return;
		}
		boolean place = false;
		int indiceTemp = 0;
		int indiceAEcrire = inc;

		for (int i = NBIMPORTANT; i < listeIndiceOrdonnee.size(); i++) {
			if (place && (author.compareTo(listeIndice.get(i)) < 0)) {
				indiceTemp = listeIndiceOrdonnee.get(i);
				listeIndiceOrdonnee.set(i, indiceAEcrire);
				indiceAEcrire = indiceTemp;
				if (!place)
					place = true;
			}
		}
		listeIndiceOrdonnee.add(indiceAEcrire);
	}

	public List<Integer> getOrdre() {
		return listeIndiceOrdonnee;
	}
	
	public void ecrireFichier()
	{
		
		
	}
			
			
	public void ajoutPaper(List<String> liste)
	{
		int inc = 0;
		boolean trouve = false;
		String name ;
		for(int i = 0 ; i < liste.size() ; i++, trouve = false, inc = 0)
		{
			name = liste.get(i);
			switch(name.charAt(0))
			{
				case 'A' : 
				{	
					while(!trouve && listeA.size() > 0 && inc < listeA.size())
					{
						if(listeA.get(inc).equals(name)) trouve = true;  else inc++;
					}
					if(!trouve) 
					{ 
						listeA.add(new ArrayList<String>());
						listeA.get(inc).add(name);
					}
				} break;
				case 'B' : 
				{
					while(!trouve && listeB.size()>0&& inc < listeB.size() )
					{	if(listeB.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeB.add(new ArrayList<String>());
						listeB.get(inc).add(name);
					}
				} break;
				case 'C' : 
				{
					while(!trouve && listeC.size()>0&& inc < listeC.size() )
					{	if(listeC.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeC.add(new ArrayList<String>());
						listeC.get(inc).add(name);
					}
				} break;
				case 'D' : 
				{
					while(!trouve && listeD.size()>0 && inc < listeD.size())
					{	if(listeD.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeD.add(new ArrayList<String>());
						listeD.get(inc).add(name);
					}
				} break;
				case 'E' : 
				{
					while(!trouve && listeE.size()>0&& inc < listeE.size())
					{	if(listeE.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeE.add(new ArrayList<String>());
						listeE.get(inc).add(name);
					}
				} break;
				case 'F' : 
				{
					while(!trouve && listeF.size()>0 && inc < listeF.size())
					{	if(listeF.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeF.add(new ArrayList<String>());
						listeF.get(inc).add(name);
					}
				} break;
				case 'G' : 
				{
					while(!trouve && listeG.size()>0 && inc < listeG.size())
					{	if(listeG.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeG.add(new ArrayList<String>());
						listeG.get(inc).add(name);
					}
				} break;
				case 'H' : 
				{
					while(!trouve && listeH.size()>0 && inc < listeH.size())
					{	if(listeH.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeH.add(new ArrayList<String>());
						listeH.get(inc).add(name);
					}
				} break;
				case 'I' : 
				{
					while(!trouve && listeI.size()>0 && inc < listeI.size())
					{	if(listeI.get(inc).equals(name)) trouve = true;  
						else inc++;
					}
					if(!trouve) 
					{
						listeI.add(new ArrayList<String>());
						listeI.get(inc).add(name);
					}
				} break;
				case 'J' : 
				{
					while(!trouve && listeJ.size()>0 && inc < listeJ.size())
					{	if(listeJ.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeJ.add(new ArrayList<String>());
						listeJ.get(inc).add(name);
					}
				} break;
				case 'K' : 
				{
					while(!trouve && listeK.size()>0 && inc < listeK.size())
					{	if(listeK.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeK.add(new ArrayList<String>());
						listeK.get(inc).add(name);
					}
				} break;
				case 'L' : 
				{
					while(!trouve && listeL.size()>0 && inc < listeL.size())
					{	if(listeL.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeL.add(new ArrayList<String>());
						listeL.get(inc).add(name);
					}
				} break;
				case 'M' : 
				{
					while(!trouve && listeM.size()>0 && inc < listeM.size())
					{	if(listeM.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeM.add(new ArrayList<String>());
						listeM.get(inc).add(name);
					}
				} break;
				case 'N' : 
				{
					while(!trouve&& listeN.size()>0 && inc < listeN.size())
					{	if(listeN.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeN.add(new ArrayList<String>());
						listeN.get(inc).add(name);
					}
				} break;
				case 'O' : 
				{
					while(!trouve&& listeO.size()>0 && inc < listeO.size())
					{	if(listeO.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeO.add(new ArrayList<String>());
						listeO.get(inc).add(name);
					}
				} break;
				case 'P' : 
				{
					while(!trouve&& listeP.size()>0 && inc < listeP.size())
					{	if(listeP.get(inc).equals(name)) trouve = true;  
						else inc++;
					} if(!trouve) 
					{
						listeP.add(new ArrayList<String>());
						listeP.get(inc).add(name);
					}
				} break;
				case 'Q' : 
				{
					while(!trouve&& listeQ.size()>0 && inc < listeQ.size())
					{	if(listeQ.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeQ.add(new ArrayList<String>());
						listeQ.get(inc).add(name);
					}
				} break;
				case 'R' : 
				{
					while(!trouve&& listeR.size()>0 && inc < listeR.size())
						if(listeR.get(inc).equals(name)) trouve = true;  
						else inc++;
					if(!trouve) 
					{
						listeR.add(new ArrayList<String>());
						listeR.get(inc).add(name);
					}
				} break;
				case 'S' : 
				{
					while(!trouve&& listeS.size()>0 && inc < listeS.size())
						if(listeS.get(inc).equals(name)) trouve = true;  
						else inc++;
					if(!trouve) 
					{
						listeS.add(new ArrayList<String>());
						listeS.get(inc).add(name);
					}
				} break;
				case 'T' : 
				{
					while(!trouve&& listeT.size()>0 && inc < listeT.size())
						if(listeT.get(inc).equals(name)) trouve = true;  
						else inc++;
					if(!trouve) 
					{
						listeT.add(new ArrayList<String>());
						listeT.get(inc).add(name);
					}
				} break;
				case 'U' : 
				{
					while(!trouve && listeU.size()>0 && inc < listeU.size())
						if(listeU.get(inc).equals(name)) trouve = true;  
						else inc++;
					if(!trouve) 
					{
						listeU.add(new ArrayList<String>());
						listeU.get(inc).add(name);
					}
				} break;
				case 'V' : 
				{
					while(!trouve && listeV.size() > 0 && inc < listeV.size())
					{	if(listeV.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeV.add(new ArrayList<String>());
						listeV.get(inc).add(name);
					}
				} break;
				case 'W' : 
				{
					while(!trouve && listeW.size() > 0 && inc < listeW.size() )
					{	if(listeW.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeW.add(new ArrayList<String>());
						listeW.get(inc).add(name);
					}
				} break;
				case 'X' : 
				{
					while(!trouve && listeX.size() > 0 &&  inc < listeX.size())
					{	if(listeX.get(inc).equals(name)) trouve = true;  
						else inc++;
					}if(!trouve) 
					{
						listeX.add(new ArrayList<String>());
						listeX.get(inc).add(name);
					}
				} break;
				case 'Y' : 
				{
					while(!trouve && listeY.size() > 0 &&  inc < listeY.size())
					{
						if(listeY.get(inc).equals(name)) trouve = true;  else inc++;
					}
					if(!trouve) 
					{
						listeY.add(new ArrayList<String>());
						listeY.get(inc).add(name);
					}
				} break;
				case 'Z' : 
				{
					while(!trouve && listeZ.size() > 0 && inc < listeZ.size())
					{	if(listeZ.get(inc).equals(name)) trouve = true;  
						else inc++;
					} 
					if(!trouve) 
					{
						listeZ.add(new ArrayList<String>());
						listeZ.get(inc).add(name);
					}
				} break;
				default : {
					while(!trouve && listeAccent.size() > 0 && inc < listeAccent.size())
					{
						if(listeAccent.get(inc).equals(name)) trouve = true;  else inc++;
					}
					if(!trouve) 
					{
						listeAccent.add(new ArrayList<String>());
						listeAccent.get(inc).add(name);
					}
				} break;
			}
		/*	for (int j = 0 ; j < liste.size() ; j++)
			{
				if(i != j)
				{
					switch(name.charAt(0))
					{
					case 'A' : listeA.get(inc).add(liste.get(j)); break;
					case 'B' : listeB.get(inc).add(liste.get(j)); break;
					case 'C' : listeC.get(inc).add(liste.get(j)); break;
					case 'D' : listeD.get(inc).add(liste.get(j)); break;
					case 'E' : listeE.get(inc).add(liste.get(j)); break;
					case 'F' : listeF.get(inc).add(liste.get(j)); break;
					case 'G' : listeG.get(inc).add(liste.get(j)); break;
					case 'H' : listeH.get(inc).add(liste.get(j)); break;
					case 'I' : listeI.get(inc).add(liste.get(j)); break;
					case 'J' : listeJ.get(inc).add(liste.get(j)); break;
					case 'K' : listeK.get(inc).add(liste.get(j)); break;
					case 'L' : listeL.get(inc).add(liste.get(j)); break;
					case 'M' : listeM.get(inc).add(liste.get(j)); break;
					case 'N' : listeN.get(inc).add(liste.get(j)); break;
					case 'O' : listeO.get(inc).add(liste.get(j)); break;
					case 'P' : listeP.get(inc).add(liste.get(j)); break;
					case 'Q' : listeQ.get(inc).add(liste.get(j)); break;
					case 'R' : listeR.get(inc).add(liste.get(j)); break;
					case 'S' : listeS.get(inc).add(liste.get(j)); break;
					case 'T' : listeT.get(inc).add(liste.get(j)); break;
					case 'U' : listeU.get(inc).add(liste.get(j)); break;
					case 'V' : listeV.get(inc).add(liste.get(j)); break;
					case 'W' : listeW.get(inc).add(liste.get(j)); break;
					case 'X' : listeX.get(inc).add(liste.get(j)); break;
					case 'Y' : listeY.get(inc).add(liste.get(j)); break;
					case 'Z' : listeZ.get(inc).add(liste.get(j)); break;
					default : listeAccent.get(inc).add(liste.get(j)); break;
					}
				}
			}*/
			
		}
	}
}
