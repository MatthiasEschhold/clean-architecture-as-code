package clean.arc.as.code.auftrag.adapter.out.db;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuftragDbEntity {
    private String auftragsnummer;
    private String erstellungsdatum;
    private String auftragsstatus;
    private String freigabeStatus;
    private String ablehnungsgrund;
    private List<AuftragspositionDbEntity> auftragspositionen;
}
