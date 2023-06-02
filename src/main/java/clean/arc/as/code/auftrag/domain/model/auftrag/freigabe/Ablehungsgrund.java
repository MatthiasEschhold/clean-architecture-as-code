package clean.arc.as.code.auftrag.domain.model.auftrag.freigabe;

public record Ablehungsgrund(String value) {
    public Ablehungsgrund {
        if (!value.isBlank()) {
            throw new IllegalStateException("Ablehungsgrund darf nicht leer sein!");
        }
    }
}
