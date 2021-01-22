import java.util.Random;
import java.util.ArrayList;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    ArrayList<String> array;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        array = new ArrayList<>();
        array.add("Muy interesante, cuentame más.");
        array.add("Ya veo cual es el problema.");
        array.add("Necesito hablarlo con mi jefe.");
        array.add("Le voy a pasar con mis superiores.");
        array.add("Dejame pensar cual podría ser el problema.");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int respuesta = aleatorio.nextInt(5);
        return array.get(respuesta);
    }
}
