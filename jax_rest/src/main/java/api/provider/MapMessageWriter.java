package api.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
public class MapMessageWriter implements MessageBodyWriter<HashMap<String, String>>{

	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return mediaType.isCompatible(MediaType.APPLICATION_XML_TYPE);
	}

	public long getSize(HashMap<String, String> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	public void writeTo(HashMap<String, String> t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		
			StringBuffer sb = new StringBuffer("<map>");

			for (Entry<String, String> entry : t.entrySet()) {

				sb.append("<").append( entry.getKey() ).append(">");
				sb.append( entry.getValue() );
				sb.append("</").append( entry.getKey() ).append(">");
				
			}
			sb.append("</map>");
			entityStream.write(sb.toString().getBytes());
		
	} 
}
