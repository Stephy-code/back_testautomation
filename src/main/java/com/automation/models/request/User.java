package com.automation.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @JsonProperty("name")
    public String name;

    @JsonProperty("job")
    public String job;
}
