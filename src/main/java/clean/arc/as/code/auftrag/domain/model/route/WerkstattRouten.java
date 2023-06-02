package clean.arc.as.code.auftrag.domain.model.route;

import java.util.Set;

public record WerkstattRouten(String auftragsnummer, Set<WerkstattRoute> werkstattRouten) {
    public WerkstattRouten {
        if (auftragsnummer == null || werkstattRouten == null) {
            throw new IllegalStateException("Notwendige Eigenschaften sind null");
        }
    }

}
