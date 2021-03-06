package org.openmrs.module.bahmniemrapi.drugogram.contract;

import org.openmrs.module.emrapi.encounter.domain.EncounterTransaction;

import java.util.*;

public class TreatmentRegimen {
    private Set<EncounterTransaction.Concept> headers = new LinkedHashSet<>();
    private SortedSet<RegimenRow> rows = new TreeSet<>(new RegimenRow.RegimenComparator());

    public Set<EncounterTransaction.Concept> getHeaders() {
        return headers;
    }

    public void setHeaders(Set<EncounterTransaction.Concept> headers) {
        this.headers = headers;
    }

    public SortedSet<RegimenRow> getRows() {
        return rows;
    }

    public void setRows(SortedSet<RegimenRow> rows) {
        this.rows.addAll(rows);
    }

    public void addRow(Date startDate) {
        for (RegimenRow row : rows) {
            if(row.getDate().equals(startDate)){
                return;
            }
        }
        rows.add(new RegimenRow(startDate));
    }
}
