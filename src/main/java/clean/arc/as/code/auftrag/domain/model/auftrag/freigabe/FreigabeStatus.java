package clean.arc.as.code.auftrag.domain.model.auftrag.freigabe;

public record FreigabeStatus(String value) {
    public FreigabeStatus {
        if (null == FreigabeStatusEnum.valueOf(value)) {
            throw new IllegalStateException("Genehmigungsstatus nicht im erlaubten Wertebereich!");
        }
    }

    public boolean isAbgelehnt() {
        return FreigabeStatusEnum.ABGELEHNT.equals(getEnumValue());
    }

    public boolean isFreigegeben() {
        return FreigabeStatusEnum.GENEHMIGT.equals(getEnumValue());
    }

    private FreigabeStatusEnum getEnumValue() {
        return FreigabeStatusEnum.valueOf(value);
    }
}
