package be.krivi.ucll.da.raspcast.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/*  **************************************************************
         THIS CONVERTER IS NOT USED ANYMORE, MIGHT NOT WORK
        org.hibernate.hibernate-java8 supports LocalDateTime
    ************************************************************** */

@Converter( autoApply = true )
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn( LocalDateTime locDateTime ){
        return ( locDateTime == null ? null : Timestamp.valueOf( locDateTime ) );
    }

    @Override
    public LocalDateTime convertToEntityAttribute( Timestamp sqlTimestamp ){
        return ( sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime() );
    }
}
