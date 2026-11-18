package objetos_TORNEOTRESREINOS;

import java.util.LinkedList;

public class TorneoTresReinos {
	String nombre;
	Campeon[] campeones;
	Artefacto[] catalogoArtefactos;
	
	public int poderAgregadoPorArtesano(Artesano artesano) {
		int acu=0;
		for(Campeon c:this.campeones) {
			for(Artefacto a:c.arsenal) {
				for(Mejora m:a.mejoras) {
					if(m.exitosa && m.responsable.equals(artesano)) {
						acu+= m.incrementoPoder;
					}
				}
			}
		}
		return acu;
	}
	
	public LinkedList<Campeon> campeonesConArsenalPreparado(){
		
	}
}
