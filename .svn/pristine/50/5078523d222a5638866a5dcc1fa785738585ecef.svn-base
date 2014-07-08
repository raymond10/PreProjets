/**
 * 
 */
package utt.rec.projet.server.exception;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class FactoryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3359767759101107786L;
	public static String objetNull   = " NULL";
    public static String tableauVide = " TABLEAU VIDE";
    public static String messageErreur = "vous ne pouvez pas enregistrer cet objet via cette application";

    private String       message;
    private Exception ExcepMessage;
    private boolean      bloquant;
    
    public FactoryException() {
        super();
        bloquant=true;
    }

    public FactoryException(String s) {
        super();
        this.setMessage(s);
        bloquant=true;
    }
    
    public FactoryException(Exception s) {
        super();
        this.setExcepMessage(s);
        bloquant=true;
    }

    public FactoryException(String s, boolean yn) {
        super();
        this.setMessage(s);
        bloquant=yn;
    }
    
    public boolean isBloquant() {
    	return bloquant;
    }
    
    /**
	 * @return the excepMessage
	 */
	public Exception getExcepMessage() {
		return ExcepMessage;
	}

	/**
	 * @param excepMessage the excepMessage to set
	 */
	public void setExcepMessage(Exception excepMessage) {
		ExcepMessage = excepMessage;
	}

	/**
     * Indique si l'exception est une exception grave
     * ou si il s'agit d'une exception d'information
     */
    public boolean isInformatif() {
    	boolean isInformatif = false;
    	String message = getMessageFormatte();
    	if (message != null) {
			int index = message.indexOf("ORA-");
			if (index > -1) {
				index = message.indexOf("ORA-");
				if (index>-1) {
					// Exception Oracle renvoyee par les procedures
					// Message informatif pour l'utilisateur
					isInformatif = true;
				} else {
					// Exception Oracle renvoyee par les procedures
					// Exception "non controlee" par les procedures
					isInformatif = false;
				}
			} else {
				// Erreur de validation
				// Message informatif pour l'utilisateur
				isInformatif = true;
			}
    	}
    	return isInformatif;
    }
    
    /**
     * Renvoie un message reformatte si possible
     */
   public String getMessageFormatte() {    	
    	String message = getMessage();
		if (message != null) {
			message = message.replaceAll("\n", " ");
			message = message.replaceAll("\"", "''");
			
			int index = message.indexOf("ORA-");
			if (index > -1) {
				message = message.substring(index+10);
				index = message.indexOf("ORA-0");
				if (index > -1) {
					message = message.substring(0, index);
				}
				index = message.indexOf("ORA-1");
				if (index > -1) {
					message = message.substring(0, index);
				}
				index = message.indexOf("ORA-2");
				if (index > -1) {
					message = message.substring(0, index);
				}
				index = message.indexOf("ORA-3");
				if (index > -1) {
					message = message.substring(0, index);
				}
				index = message.indexOf("ORA-4");
				if (index > -1) {
					message = message.substring(0, index);
				}
				index = message.indexOf("ORA-5");
				if (index > -1) {
					message = message.substring(0, index);
				}
			}
		}
		return message;
    }
		
    /**
     * renvoie une cause message pour l execepeion
     * 
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * affecte une cause message pour l execepeion
     * 
     * @param string
     */
    public void setMessage(String string) {
        message = string;
    }

}
