package dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbMarshaller {
	
	public void init (Class<?> classe, Object objeto, String file) {
		try {
			JAXBContext context = JAXBContext.newInstance(classe);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(objeto, new File(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
