package dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbUnMarshaller {
	
	public Object init (Class<?> classe, String file) {
		Object object = null;
		try {
			JAXBContext context = JAXBContext.newInstance(classe);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			object = (Object) unmarshaller.unmarshal(new File(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		if (object == null) System.out.println("ERROR MARSHALLING");
		return object;
	}
}
