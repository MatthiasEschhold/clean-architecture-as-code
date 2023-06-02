package clean.arc.as.code.auftrag.usecase.out;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;

public interface SaveAuftrag {
    Auftrag save(Auftrag auftrag);
}
