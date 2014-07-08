package utt.rec.projet.server.components;

import org.cocktail.fwkcktlwebapp.common.util.StringCtrl;
import org.cocktail.fwkcktlwebapp.server.CktlWebAction;
import org.cocktail.fwkcktlwebapp.server.components.CktlWebComponent;

import utt.rec.projet.server.Session;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSLog;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class LoginCAS extends CktlWebComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5755033456952616125L;

	/** Le commentaire a afficher dans l'entete de al page. */
	private String titleComment = StringCtrl.emptyString();

	/** Le lien d'acces au serveur CAS. */
	private String casLoginLink;

	/**
	 * Le URL de l'image d'une ligne horisontale dans la page.
	 */
	public String imageLigneSrc() {
		return cktlApp.getImageDefaultURL("ligneApplisDegradee.gif");
	}

	/**
	 * Retourne le URL de l'image "cles" affiches a cote de lien d'acces au
	 * serveur CAS.
	 */
	public String imageClefsSrc() {
		return cktlApp.getImageDefaultURL("clefs.gif");
	}

	/**
	 * Cree un nouvel composant.
	 */
	public LoginCAS(WOContext context) {
		super(context);
		NSLog.out.appendln("LoginCAS");
	}

	/**
	 * Retourne la reference vers la session actuellement ouverte. Cree une
	 * nouvelle session si aucune n'est encore ouverte.
	 */
	public Session jefySession() {
		return (Session) session();
	}

	/**
	 * Retourne le lien d'acces au service CAS. Ce lien peut etre explicitement
	 * defini a l'aide de la methode <code>setCASLoginLink</code>.
	 * 
	 * @see #setCASLoginLink(String)
	 */
	public String lienLoginCAS() {
		if (casLoginLink == null)
			return CktlWebAction.getLoginActionURL(context(), false, null,
					true, null);
		else
			return casLoginLink;
	}

	/**
	 * Retourne le commentaire a afficher dans le titre de la page de login.
	 */
	public String titleComment() {
		if (StringCtrl.normalize(titleComment).length() > 0)
			return new StringBuffer("<br>(").append(titleComment).append(")")
					.toString();
		else
			return StringCtrl.emptyString();
	}

	/**
	 * Definit le commentaire a afficher dans le titre de la page de login. Le
	 * commentaire peut etre vide ou <em>null</em>.
	 */
	public void setTitleComment(String comment) {
		titleComment = comment;
	}

	/**
	 * Definit le lien d'acces au serveur de login.
	 */
	public void setCASLoginLink(String link) {
		casLoginLink = link;
	}
}