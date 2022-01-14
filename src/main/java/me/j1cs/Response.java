package me.j1cs;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.TypeHint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
@TypeHint(
        typeNames = {"me.jics.Response$ResponseBuilder"},
        accessType = {TypeHint.AccessType.ALL_DECLARED_CONSTRUCTORS, TypeHint.AccessType.ALL_DECLARED_FIELDS, TypeHint.AccessType.ALL_DECLARED_METHODS}
)
@Introspected
public final class Response {
    private final String name;
}
