package com.seed.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.seed.util.DateUtil;

import java.io.IOException;
import java.util.Date;

public class Date2StringSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        /*jsonGenerator.writeNumber(date.getTime() / 1000);*/
        jsonGenerator.writeString(DateUtil.COMMON_FULL.getDateText(date));
    }
}
