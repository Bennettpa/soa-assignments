package fastrack.persons;

import fastrack.persons.dao.PersonDao;
import fastrack.persons.entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Person person = PersonDao.get(0);
        System.out.println( "Hello my name is " + person.getFirstName() );
    }
}
