package com.xt.api.dto.spot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowPage<T> implements Serializable {
    private Boolean hasPrev;
    private Boolean hasNext;
    private List<T> items;

    public <NEW_RESULT> FlowPage<NEW_RESULT> convert(Function<T, NEW_RESULT> mapping) {
        return items == null ?
                new FlowPage<>(hasPrev, hasNext, Collections.emptyList()) :
                new FlowPage<>(hasPrev, hasNext, items.stream().map(mapping).collect(Collectors.toList()));
    }
}
