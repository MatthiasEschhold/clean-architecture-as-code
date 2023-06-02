package clean.arc.as.code.auftrag.domain.model.auftrag.zeit;

public record Zeitbedarf(Double value) {
    public Zeitbedarf {
        if (value < 0.25) {
            throw new IllegalStateException("Der kleinste erlaubte Wert für den Zeitbedarf beträgt 15 Minuten!");
        }
    }
}
