package clean.arc.as.code.auftrag.adapter.in.web;

import java.util.List;

public record AuftragResource(String auftragsnummer, String erstellungsdatum,
                              List<AuftragspositionResource> auftragspositionen,
                              double gesamtzeit, String auftragsstatus,
                              AuftragsfreigabeResource auftragsfreigabe) {
}
