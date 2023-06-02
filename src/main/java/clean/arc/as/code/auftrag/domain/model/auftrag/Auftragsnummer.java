package clean.arc.as.code.auftrag.domain.model.auftrag;

public record Auftragsnummer(String value) {
    public Auftragsnummer {
        //implement self-validation within object creation
        if (!value.matches("([A-Z]{2})-([0-9]{7})-([0-9]{4})")) {
            throw new IllegalStateException("Auftragsnummer ist nicht valide!");
        }
    }
}
