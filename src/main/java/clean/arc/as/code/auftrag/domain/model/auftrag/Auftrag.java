package clean.arc.as.code.auftrag.domain.model.auftrag;

import clean.arc.as.code.auftrag.domain.model.auftrag.freigabe.Auftragsfreigabe;
import clean.arc.as.code.auftrag.domain.model.auftrag.freigabe.FreigabeStatus;
import clean.arc.as.code.auftrag.domain.model.auftrag.freigabe.FreigabeStatusEnum;
import clean.arc.as.code.auftrag.domain.model.auftrag.position.Auftragsposition;
import clean.arc.as.code.auftrag.domain.model.auftrag.status.Auftragsstatus;
import clean.arc.as.code.auftrag.domain.model.auftrag.status.AuftragsstatusEnum;
import clean.arc.as.code.auftrag.domain.model.auftrag.zeit.Gesamtzeit;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter

public class Auftrag {
    private Auftragsnummer auftragsnummer;
    private Erstellungsdatum erstellungsdatum;
    private List<Auftragsposition> auftragspositionen;
    private Auftragsfreigabe auftragsfreigabe;
    private Auftragsstatus auftragsstatus;
    private Gesamtzeit gesamtzeit;

    public Auftrag(Auftragsnummer auftragsnummer, Erstellungsdatum erstellungsdatum, List<Auftragsposition> auftragspositionen) {
        this.auftragsnummer = auftragsnummer;
        this.erstellungsdatum = erstellungsdatum;
        this.auftragspositionen = auftragspositionen;
        checkMandatoryProperties(auftragsnummer, erstellungsdatum, auftragspositionen);
    }

    public Auftrag(Auftragsnummer auftragsnummer, Erstellungsdatum erstellungsdatum, Auftragsstatus auftragsstatus, List<Auftragsposition> auftragspositionen) {
        this(auftragsnummer, erstellungsdatum, auftragspositionen);
        this.auftragsstatus = auftragsstatus;
        checkAuftragsstatus();
    }

    public void auftragFreigeben() {
        this.auftragsfreigabe = new Auftragsfreigabe(
                new FreigabeStatus(FreigabeStatusEnum.GENEHMIGT.toString()));
    }

    public void auftragStarten() {
        if (this.auftragsfreigabe.isFreigegeben()) {
            this.auftragsstatus = new Auftragsstatus(AuftragsstatusEnum.GESTARTET);
        } else {
            throw new IllegalStateException("Auftrag ist nicht freigegeben und kann nicht gestartet werden!");
        }
    }

    public void calculateGesamtzeit() {
        this.gesamtzeit = new Gesamtzeit(calculateGesamtzeitValue());
    }

    private double calculateGesamtzeitValue() {
        return auftragspositionen.stream()
                .map(auftragsposition -> auftragsposition.zeitbedarf().value()).collect(Collectors.toList())
                .stream().mapToDouble(Double::doubleValue).sum();
    }

    private void checkMandatoryProperties(Auftragsnummer auftragsnummer, Erstellungsdatum erstellungsdatum, List<Auftragsposition> auftragspositionen) {
        if (auftragsnummer == null || erstellungsdatum == null || auftragspositionen == null) {
            throw new IllegalStateException("Die notwendigen Eigenschaften für die Objekterzeugung sind nicht valide.");
        }
    }

    private void checkAuftragsstatus() {
        if (auftragsstatus == null) {
            throw new IllegalStateException("Auftragsstatus darf nich NULL sein");
        }
    }

    public void addAuftragsposition(Auftragsposition auftragsposition) {
        this.auftragspositionen.add(auftragsposition);
    }
}
