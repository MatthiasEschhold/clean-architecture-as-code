package clean.arc.as.code.auftrag.domain.model.auftrag.status;

public record Auftragsstatus(AuftragsstatusEnum value) {
    public Auftragsstatus {
        if (value == null) {
            throw new IllegalStateException("Der Wert des Auftragsstatus darf nicht null sein");
        }
    }
}
