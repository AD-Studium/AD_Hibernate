/**
 * 
 */
package hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojos.Clientes;
/**
 * @author Alvca
 *
 */
public class FactoryCRUD {
	private static SessionFactory getSessionFactory() { 
		SessionFactory sessionFactory = new
				Configuration().addAnnotatedClass(Clientes.class)
				.addAnnotatedClass(Clientes.class).configure().buildSessionFactory
				();
		return sessionFactory; 
	}
	public static void create(Persona p) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("Persona " + p.getIdPersona() + "
				insertada correctamente");
	}
	public static void create(Clientes p) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("Clientes " + p.getIdClientes() + "
				insertado correctamente");
	}
	public static List readClientess() {
		Session sessionObj = getSessionFactory().openSession();
		String query = "FROM Clientes";
		List resultado = sessionObj.createQuery(query).list();
		sessionObj.close();
		return resultado;
	} 
	public static List readPersonas() {
		Session sessionObj = getSessionFactory().openSession();
		String query = "FROM Persona";
		List resultado = sessionObj.createQuery(query).list();
		sessionObj.close();
		return resultado;
	}

	public static void updateClientes(Clientes Clientes) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes ClientesBD = (Clientes)
				ionObj.load(Clientes.class, Clientes.getIdClientes());

		/* Modificamos todos los atributos */
		ClientesBD.setAno(Clientes.getAno());
		ClientesBD.setDuracion(Clientes.getDuracion());
		ClientesBD.setTitulo(Clientes.getTitulo());

		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
	}

	public static void updatePersona(Persona persona) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Persona personaBD = (Persona)
				ionObj.load(Persona.class, persona.getIdPersona());

		/* Modificamos todos los atributos */

		onaBD.setFechaNacimiento(persona.getFechaNacimiento());
		personaBD.setNombre(persona.getNombre());

		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
	}

	public static void deleteClientes(Clientes Clientes) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes ClientesBD = (Clientes)
				ionObj.load(Clientes.class, Clientes.getIdClientes());
		sessionObj.delete(ClientesBD);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente");
	}

	public static void deletePersona(Persona persona) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Persona personaBD = (Persona)
				sessionObj.load(Persona.class, persona.getIdPersona());
		sessionObj.delete(personaBD);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente");
	} 
}
