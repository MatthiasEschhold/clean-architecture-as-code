package clean.arc.as.code.auftrag.domain.model.auftrag.position;

public record AuftragspositionsTyp(AuftragspositionsTypEnum value) {

    public AuftragspositionsTyp {
        if (value == null) {
            throw new IllegalStateException("AuftragspositionsTyp dar nicht NULL sein!");
        }
    }
}
