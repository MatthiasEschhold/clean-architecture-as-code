package clean.arc.as.code.auftrag.adapter.out.wfengine;

import clean.arc.as.code.auftrag.domain.model.route.WerkstattRouten;
import clean.arc.as.code.auftrag.usecase.out.SaveWerkstattRouten;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class WerkstattRouteWfEngineAdapter implements SaveWerkstattRouten {

    final WorkflowEngineMock workflowEngine;

    @Override
    public void save(WerkstattRouten werkstattRouten) {
        workflowEngine.addWorkflowProperty(
                werkstattRouten.auftragsnummer(),
                werkstattRouten.werkstattRouten().stream()
                        .map(r -> r.value()).collect(Collectors.toSet()));
    }
}
