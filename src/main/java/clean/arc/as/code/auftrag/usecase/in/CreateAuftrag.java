package clean.arc.as.code.auftrag.usecase.in;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;
import clean.arc.as.code.auftrag.domain.model.auftrag.position.Auftragsposition;

import java.util.List;

public interface CreateAuftrag {
    Auftrag create(List<Auftragsposition> auftragspositionen);
}
