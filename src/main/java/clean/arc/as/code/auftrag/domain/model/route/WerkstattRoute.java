package clean.arc.as.code.auftrag.domain.model.route;

public record WerkstattRoute(String value) {
    public WerkstattRoute {
        if (value == null) {
            throw new IllegalStateException("WerkstattRoute darf nicht NULL sein");
        }
    }
}
