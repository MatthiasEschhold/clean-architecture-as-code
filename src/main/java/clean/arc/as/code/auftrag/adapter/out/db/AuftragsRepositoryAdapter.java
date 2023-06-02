package clean.arc.as.code.auftrag.adapter.out.db;

import clean.arc.as.code.auftrag.domain.model.auftrag.Auftrag;
import clean.arc.as.code.auftrag.usecase.out.SaveAuftrag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuftragsRepositoryAdapter implements SaveAuftrag {

    final AuftragToAuftragDbEntityMapper mapper;

    @Override
    public Auftrag save(Auftrag auftrag) {
        var dbEntity = mapper.mapAuftragToAuftragDbEntity(auftrag);
        return mapper.mapAuftragDbEntityToAuftrag(saveDbEntity(dbEntity));
    }

    /**
     * using jdbc template, spring jdbc or jpa repository
     */
    private AuftragDbEntity saveDbEntity(AuftragDbEntity dbEntity) {
        //... add technical vendor specific storage code here
        return dbEntity;
    }
}
