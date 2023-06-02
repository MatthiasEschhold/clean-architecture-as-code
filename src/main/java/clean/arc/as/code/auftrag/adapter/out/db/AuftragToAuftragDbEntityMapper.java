package clean.arc.as.code.auftrag.adapter.out.db;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;
import clean.arc.as.code.auftrag.domain.model.auftrag.Auftragsnummer;
import clean.arc.as.code.auftrag.domain.model.auftrag.Erstellungsdatum;
import clean.arc.as.code.auftrag.domain.model.auftrag.position.*;
import clean.arc.as.code.auftrag.domain.model.auftrag.status.Auftragsstatus;
import clean.arc.as.code.auftrag.domain.model.auftrag.status.AuftragsstatusEnum;
import clean.arc.as.code.auftrag.domain.model.auftrag.zeit.Zeitbedarf;

import java.util.List;
import java.util.stream.Collectors;

public class AuftragToAuftragDbEntityMapper {

    public AuftragDbEntity mapAuftragToAuftragDbEntity(Auftrag auftrag) {
        var dbEntity = new AuftragDbEntity();
        dbEntity.setAblehnungsgrund(auftrag.getAuftragsfreigabe().getAblehnungsgrund().value());
        dbEntity.setAuftragsnummer(auftrag.getAuftragsnummer().value());
        dbEntity.setAuftragsstatus(auftrag.getAuftragsstatus().value().toString());
        dbEntity.setFreigabeStatus(auftrag.getAuftragsfreigabe().getFreigabeStatus().value());
        dbEntity.setErstellungsdatum(auftrag.getErstellungsdatum().value());
        dbEntity.setAuftragspositionen(auftrag.getAuftragspositionen().stream()
                .map(this::mapAuftragspositionToAuftragspositionDbEntity).collect(Collectors.toList()));
        return dbEntity;
    }

    private AuftragspositionDbEntity mapAuftragspositionToAuftragspositionDbEntity(Auftragsposition auftragsposition) {
        var dbEntity = new AuftragspositionDbEntity();
        dbEntity.setTyp(auftragsposition.typ().value().toString());
        dbEntity.setBezeichnung(auftragsposition.bezeichnung().value());
        dbEntity.setMenge(auftragsposition.menge().value());
        dbEntity.setZeitbedarf(auftragsposition.zeitbedarf().value());
        return dbEntity;
    }

    public Auftrag mapAuftragDbEntityToAuftrag(AuftragDbEntity auftragDbEntity) {
        Auftragsnummer auftragsnummer = new Auftragsnummer(auftragDbEntity.getAuftragsnummer());
        Erstellungsdatum erstellungsdatum = new Erstellungsdatum(auftragDbEntity.getErstellungsdatum());
        Auftragsstatus auftragsstatus = new Auftragsstatus(AuftragsstatusEnum.valueOf(
                auftragDbEntity.getAuftragsstatus()));
        return new Auftrag(auftragsnummer, erstellungsdatum, auftragsstatus,
                mapAuftragspositionDbEntitiesToAuftragspositionen(auftragDbEntity.getAuftragspositionen()));
    }

    private List<Auftragsposition> mapAuftragspositionDbEntitiesToAuftragspositionen(List<AuftragspositionDbEntity> auftragspositionDbEntities) {
        return auftragspositionDbEntities.stream().map(this::createAuftragsposition).collect(Collectors.toList());
    }

    private Auftragsposition createAuftragsposition(AuftragspositionDbEntity dbEntity) {
        return new Auftragsposition(
                new AuftragspositionsTyp(AuftragspositionsTypEnum.valueOf(dbEntity.getTyp())),
                new Bezeichnung(dbEntity.getBezeichnung()),
                new Menge(dbEntity.getMenge()),
                new Zeitbedarf(dbEntity.getZeitbedarf()));
    }
}
