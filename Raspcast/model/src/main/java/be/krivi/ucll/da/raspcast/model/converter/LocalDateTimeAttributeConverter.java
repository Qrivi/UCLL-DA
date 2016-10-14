package be.krivi.ucll.da.raspcast.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Krivi on 14/10/2016.
 */

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
