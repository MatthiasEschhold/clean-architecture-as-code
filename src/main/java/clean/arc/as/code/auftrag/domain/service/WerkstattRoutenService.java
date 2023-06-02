package clean.arc.as.code.auftrag.domain.service;

import clean.arc.as.code.auftrag.domain.model.auftrag.position.Auftragsposition;
import clean.arc.as.code.auftrag.domain.model.route.WerkstattRoute;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WerkstattRoutenService {
    public Set<WerkstattRoute> determineWerkstattRouten(List<Auftragsposition> auftragspositionen) {
        Set<WerkstattRoute> werkstattRouten = new HashSet<>();
        auftragspositionen.stream().forEach(p -> werkstattRouten.add(new WerkstattRoute(p.typ().value().toString())));
        return werkstattRouten;
    }
}
