package boutique.com.utiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Utiles {
	
	
	public Utiles(){
		
	}

	// SUMAR + 1 DIA
	public Date plusDay(Date dia) {
		
        Calendar cal = Calendar.getInstance();
        cal.setTime(dia);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
		
	}
	
	public String getDiaActual ()	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now(); 
		String actual = dtf.format(now);  
		
		return actual;
			
	}	
	

}
