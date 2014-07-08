/**
 * 
 */
package utt.rec.projet.server.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Raymond NANEON <raymond.naneon at utt.fr>
 *
 */
public class FixedCalendar extends GregorianCalendar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4357514218826190395L;

	public FixedCalendar() {
		super();
		setFirstDayOfWeek(Calendar.MONDAY);
		setMinimalDaysInFirstWeek(4); // le premier Jeudi de Janvier...
	}
}
