package be.kdg.teamf.model.component;

import org.cloudfoundry.org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 8/03/13
 * Time: 2:07
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JsonDateSerializer extends JsonSerializer<Date> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy - HH:mm:ss");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, org.codehaus.jackson.map.SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String formattedDate = dateFormat.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}