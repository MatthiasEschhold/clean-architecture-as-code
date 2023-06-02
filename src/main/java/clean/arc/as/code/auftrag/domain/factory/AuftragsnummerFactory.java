package clean.arc.as.code.auftrag.domain.factory;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftragsnummer;

import java.util.UUID;

public class AuftragsnummerFactory {

    public Auftragsnummer create() {
        return new Auftragsnummer(UUID.randomUUID().toString());
    }
}
