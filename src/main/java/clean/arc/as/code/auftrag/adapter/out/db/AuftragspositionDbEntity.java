package clean.arc.as.code.auftrag.adapter.out.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuftragspositionDbEntity {
    private String typ;
    private String bezeichnung;
    private double menge;
    private double zeitbedarf;

}
