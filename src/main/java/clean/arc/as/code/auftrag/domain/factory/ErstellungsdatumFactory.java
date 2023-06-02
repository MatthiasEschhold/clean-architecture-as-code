package clean.arc.as.code.auftrag.domain.factory;

import clean.arc.as.code.auftrag.domain.model.auftrag.Erstellungsdatum;

import java.time.LocalDateTime;

public class ErstellungsdatumFactory {
    public Erstellungsdatum create() {
        return new Erstellungsdatum(LocalDateTime.now().toString());
    }
}
