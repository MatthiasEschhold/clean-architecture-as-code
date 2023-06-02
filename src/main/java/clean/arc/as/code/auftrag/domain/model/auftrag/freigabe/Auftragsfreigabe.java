package clean.arc.as.code.auftrag.domain.model.auftrag.freigabe;

import lombok.Getter;

@Getter
public class Auftragsfreigabe {

    FreigabeStatus freigabeStatus;
    Ablehungsgrund ablehnungsgrund;

    public Auftragsfreigabe(FreigabeStatus freigabeStatus) {
        this.freigabeStatus = freigabeStatus;
        checkMandatoryFields();
        peformAblehnungsgrundRule();
    }


    public Auftragsfreigabe(FreigabeStatus freigabeStatus, Ablehungsgrund ablehnungsgrund) {
        this.freigabeStatus = freigabeStatus;
        this.ablehnungsgrund = ablehnungsgrund;
        checkMandatoryFields();
        peformAblehnungsgrundRule();
    }

    private void peformAblehnungsgrundRule() {
        if (freigabeStatus.isAbgelehnt() && ablehnungsgrund == null) {
            throw new IllegalStateException("Ein abglehnter Auftrag benötigt einen Ablehnungsgrund!");
        }
    }

    private void checkMandatoryFields() {
        if (freigabeStatus == null) {
            throw new IllegalStateException("Freigabestatus darf nicht NULL sein!");
        }
    }

    public boolean isFreigegeben() {
        return freigabeStatus.isFreigegeben();
    }
}
