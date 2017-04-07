package api.model;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFrase {
	
	private static List<Frase> frases;
	private static Long cont = 0L;
	
	static {
		frases = new ArrayList<Frase>();

		frases.add( new Frase(1L , "Não é permitido irritarmo-nos com a verdade." ,                                             new Autor(1L , "Platão") ) );
		frases.add( new Frase(2L , "Se me apetece rir de um louco, não preciso de ir procurar muito longe; rio de mim mesmo." , new Autor(1L , "Sêneca") ) );
		frases.add( new Frase(3L , "Se um grande homem cair, mesmo depois da queda, ele continua grande." ,                     new Autor(1L , "Sêneca") ) );
		frases.add( new Frase(4L , "Se sofrer uma injustiça, console-se, a verdadeira infelicidade é cometê-la." ,              new Autor(1L , "Demócrito") ) );
		frases.add( new Frase(5L , "O começo é a parte mais difícil do trabalho." ,                                             new Autor(1L , "Platão") ) );
		cont = 5L;
	}

	public List<Frase> getFrases(){
		
		return frases;
	}
	
	public Frase buscarPorId(Long id){
		
		Frase f = new Frase();
		f.setId( id );
			
		int index = frases.indexOf( f );		
		
		if( index != -1){
			return frases.get( index );
		}
		return null;
	}

	public void save(Frase frase) {
		cont++;
		frase.setId( cont );
		frases.add( frase );
		
	}

	public void delete(Long id) {
		
		Frase f = new Frase();
		f.setId( id );
			
		int index = frases.indexOf( f );		
		
		frases.remove( index );
		
		
	}

	public void update(Frase frase) {
		
		Frase f = buscarPorId( frase.getId() );
		
		f.setFrase( frase.getFrase() );
		f.setAutor( frase.getAutor() );
		f.setCreated( frase.getCreated() );
		
	}
	
}
