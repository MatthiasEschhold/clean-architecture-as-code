package clean.arc.as.code.auftrag.domain.model.auftrag.zeit;

public record Gesamtzeit(Double value) {
    public Gesamtzeit {
        if (value <= 0.25) {
            throw new IllegalStateException("Der kleinste erlaubte Wert für die Gesamtzeit beträgt 15 Minuten.");
        }
    }
}
