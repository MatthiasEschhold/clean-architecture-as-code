package clean.arc.as.code.auftrag.adapter.in.web;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;
import clean.arc.as.code.auftrag.domain.model.auftrag.position.*;
import clean.arc.as.code.auftrag.domain.model.auftrag.zeit.Zeitbedarf;

import java.util.List;
import java.util.stream.Collectors;

public class AuftragToAuftragResourceMapper {

    public List<Auftragsposition> mapAuftragspostionResourceListToAuftragspositionen(List<AuftragspositionResource> auftragspositionResourceList) {
        return auftragspositionResourceList.stream().map(this::mapAuftragspositionResourceToAuftragsposition).collect(Collectors.toList());
    }

    public AuftragResource mapAuftragToAuftragResource(Auftrag auftrag) {
        return new AuftragResource(auftrag.getAuftragsnummer().value(),
                auftrag.getErstellungsdatum().value(),
                auftrag.getAuftragspositionen().stream().map(this::mapAuftragspositionToAuftragspositionResource).collect(Collectors.toList()),
                auftrag.getGesamtzeit().value(),
                auftrag.getAuftragsstatus().value().toString(),
                new AuftragsfreigabeResource(auftrag.getAuftragsfreigabe().getFreigabeStatus().value(),
                        auftrag.getAuftragsfreigabe().getAblehnungsgrund().value())
        );
    }

    private Auftragsposition mapAuftragspositionResourceToAuftragsposition(AuftragspositionResource resource) {
        return new Auftragsposition(
                new AuftragspositionsTyp(AuftragspositionsTypEnum.valueOf(resource.typ())),
                new Bezeichnung(resource.bezeichnung()),
                new Menge(resource.menge()),
                new Zeitbedarf(resource.zeitbedarf()));
    }

    private AuftragspositionResource mapAuftragspositionToAuftragspositionResource(Auftragsposition entity) {
        return new AuftragspositionResource(entity.typ().value().toString(), entity.bezeichnung().value(),
                entity.menge().value(), entity.zeitbedarf().value());
    }
}


