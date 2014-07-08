/**
 * 
 */
package utt.rec.projet.server.components.procedures;

import org.cocktail.fwkcktlwebapp.server.database._CktlBasicDataBus;
import utt.rec.projet.server.metier.admrec.EOTyppartenaire;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSValidation;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
@SuppressWarnings("all")
public class ProcedureCreerPartenaire extends ProjectPRC {
	
	private static final String PROCEDURE_NAME = "insPartenaire";
	
	public ProcedureCreerPartenaire() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean enregistrer(_CktlBasicDataBus dataBus, EOTyppartenaire partenaire) throws NSValidation.ValidationException{
	    return dataBus.executeProcedure(ProcedureCreerPartenaire.PROCEDURE_NAME, 
	    		ProcedureCreerPartenaire.construireDictionnaire(partenaire));
	}

	private static NSDictionary construireDictionnaire(EOTyppartenaire partenaire) {
		// TODO Auto-generated method stub
		NSMutableDictionary dico=new NSMutableDictionary();
		dico.takeValueForKey(null, "010_typartId");
		String tmpCleunik = autoPartCleunik(partenaire);
		if(!partenaire.partCleunik().equals(tmpCleunik)){
			partenaire.setPartCleunik(tmpCleunik);
		}
		dico.takeValueForKey(partenaire.partCleunik(), "020_partCleUnik");
		dico.takeValueForKey(partenaire.nomPartenaire().toUpperCase(), "030_nom_partenaire");
		dico.takeValueForKey(partenaire.toTpartenaire().primaryKey(), "040_c_t_partenaire");
		dico.takeValueForKey(partenaire.toStpart().primaryKey(), "050_c_st_partenaire");
		dico.takeValueForKey(partenaire.denomUsuelle().toUpperCase(), "060_denomUsuelle");
		return dico;
	}
	
	protected static String autoPartCleunik(EOTyppartenaire partenaire){
		NSArray<EOTyppartenaire> tmp = EOTyppartenaire.fetchAllEOTyppartenaires(partenaire.editingContext(), new NSArray(EOTyppartenaire.PART_CLEUNIK.desc()));
		EOTyppartenaire tmpz = tmp.objectAtIndex(0);
		Long calc = Long.parseLong(tmpz.partCleunik()) +1;
		String cal = calc.toString();
		String cleunik = tmpz.partCleunik().substring(0, tmpz.partCleunik().length()-cal.length());
		return cleunik + cal;
	}

}
