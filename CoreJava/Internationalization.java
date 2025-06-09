package CoreJava;
import java.lang.module.ResolvedModule;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
public class Internationalization {
	public static void main(String[] args) {
		//Number Formation
		Locale locale=new Locale.Builder().setLanguage("it")
				.setRegion("IT").build();
		NumberFormat nf=NumberFormat.getInstance(locale);//Static factory method
		System.out.println(nf.format(123456768.345678) );

		//Date Formation
		Locale DateLocale=new Locale.Builder().setLanguage("hi")
				.setRegion("IN").build();
		DateFormat date=DateFormat.getDateInstance(3,DateLocale);
		System.out.println(date.format(new Date()));

		//Message Formation:
		Locale MessageLocale=new Locale.Builder().setLanguage("it").setRegion("IT").build();
		ResourceBundle resource=ResourceBundle.getBundle("abc",MessageLocale);
		System.out.println(resource.getString("Welcome"));
	}

}