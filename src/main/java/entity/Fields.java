package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fields implements Comparable<Fields> {

    private int fieldId;
    private String fieldLink;
    private String fieldRus;

    public Fields(String fieldLink, String fieldRus) {
        this.fieldLink = fieldLink;
        this.fieldRus = fieldRus;
    }

    @Override
    public int compareTo (Fields fieldItem) {
        return this.fieldId - fieldItem.getFieldId();
    }
}
