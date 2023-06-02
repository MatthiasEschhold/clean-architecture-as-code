package clean.arc.as.code.auftrag.adapter.in.web;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;
import clean.arc.as.code.auftrag.usecase.in.CreateAuftrag;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AuftragController {
    final CreateAuftrag createAuftrag;
    final AuftragToAuftragResourceMapper mapper;

    public AuftragResource create(List<AuftragspositionResource> auftragspositionen) {
        Auftrag createdAuftrag = createAuftrag.create(mapper.mapAuftragspostionResourceListToAuftragspositionen(auftragspositionen));
        return mapper.mapAuftragToAuftragResource(createdAuftrag);
    }
}
