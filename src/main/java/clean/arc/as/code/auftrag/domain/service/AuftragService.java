package clean.arc.as.code.auftrag.domain.service;

import clean.arc.as.code.auftrag.domain.factory.AuftragsnummerFactory;
import clean.arc.as.code.auftrag.domain.factory.ErstellungsdatumFactory;
import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;
import clean.arc.as.code.auftrag.domain.model.auftrag.Auftragsnummer;
import clean.arc.as.code.auftrag.domain.model.auftrag.Erstellungsdatum;
import clean.arc.as.code.auftrag.domain.model.auftrag.position.Auftragsposition;
import clean.arc.as.code.auftrag.domain.model.route.WerkstattRouten;
import clean.arc.as.code.auftrag.usecase.in.CreateAuftrag;
import clean.arc.as.code.auftrag.usecase.out.SaveAuftrag;
import clean.arc.as.code.auftrag.usecase.out.SaveWerkstattRouten;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AuftragService implements CreateAuftrag {

    final ErstellungsdatumFactory erstellungsdatumFactory;
    final AuftragsnummerFactory auftragsnummerFactory;
    final SaveAuftrag saveAuftrag;
    final SaveWerkstattRouten saveWerkstattRouten;
    final WerkstattRoutenService werkstattRoutenService;

    @Override
    public Auftrag create(List<Auftragsposition> auftragspositionen) {
        Auftragsnummer auftragsnummer = auftragsnummerFactory.create();
        Erstellungsdatum erstellungsdatum = erstellungsdatumFactory.create();
        Auftrag auftrag = new Auftrag(auftragsnummer, erstellungsdatum, auftragspositionen);
        auftrag = saveAuftrag.save(auftrag);
        saveWerkstattRouten.save(new WerkstattRouten(auftragsnummer.value(),
                werkstattRoutenService.determineWerkstattRouten(auftragspositionen)));
        return auftrag;
    }
}
