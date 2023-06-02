package clean.arc.as.code.auftrag.domain.model.auftrag.position;

import clean.arc.as.code.auftrag.domain.model.auftrag.zeit.Zeitbedarf;

public record Auftragsposition(AuftragspositionsTyp typ, Bezeichnung bezeichnung, Menge menge, Zeitbedarf zeitbedarf) {
    public Auftragsposition {
        if (typ == null || bezeichnung == null || menge == null || zeitbedarf == null) {
            throw new IllegalStateException("Auftragsposition kann nicht mit NULL-Werten erzeugt werden!");
        }
    }
}
